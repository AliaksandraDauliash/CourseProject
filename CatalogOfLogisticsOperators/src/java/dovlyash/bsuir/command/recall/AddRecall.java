
package dovlyash.bsuir.command.recall;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.dao.LogoperatorDAO;
import dovlyash.bsuir.data.dao.RecallDAO;
import dovlyash.bsuir.data.entity.Client;
import dovlyash.bsuir.data.entity.Logoperator;
import dovlyash.bsuir.data.entity.Recall;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddRecall implements Command{
    private String page;
		
	public AddRecall() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                RecallDAO rcdao = new RecallDAO();
                List<Recall> recallList = new ArrayList();
		Recall recall = new Recall();
                LogoperatorDAO lgdao = new LogoperatorDAO();
                Logoperator logoperator = new Logoperator();
                ClientDAO cldao = new ClientDAO();
                Client client = new Client();
                int clientId = Integer.valueOf((String)requestMap.get("idClient"));
                int logoperatorId = Integer.valueOf((String)requestMap.get("idLogoperator"));
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
                        
			recall.setText((String)requestMap.get("recallText")); 
			logoperator = lgdao.readById(logoperatorId);
                        recall.setLogoperator(logoperator);
                        client = cldao.readById(clientId);
                        recall.setClient(client);
                        rcdao.create(recall);
			recallList = rcdao.readByLogoperatorId(logoperatorId);
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(recallList.isEmpty()) {
			page = "";
		} else {
			hash.put("recallList", recallList);
                        hash.put("clientId", clientId);
                        hash.put("logoperatorId", logoperatorId);
			page = "viewRecall.jsp";
		}
		return hash;
	}

	@Override
	public String responsePage() {
		return page;
	}

	@Override
	public List<String> atributeName() {
		List<String> list = new ArrayList();
		list.add("recallList");
                list.add("clientId");
                list.add("logoperatorId");
		return list;
	}

}
