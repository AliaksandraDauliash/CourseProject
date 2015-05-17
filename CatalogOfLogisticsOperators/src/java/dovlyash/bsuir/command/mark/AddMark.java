
package dovlyash.bsuir.command.mark;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.dao.LogoperatorDAO;
import dovlyash.bsuir.data.dao.MarkDAO;
import dovlyash.bsuir.data.dao.RecallDAO;
import dovlyash.bsuir.data.entity.Client;
import dovlyash.bsuir.data.entity.Logoperator;
import dovlyash.bsuir.data.entity.Mark;
import dovlyash.bsuir.data.entity.Recall;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AddMark implements Command{
    private String page;
		
	public AddMark() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                MarkDAO mdao = new MarkDAO();
                List<Mark> markList = new ArrayList();
                List<Recall> recallList = new ArrayList();
                RecallDAO rcdao = new RecallDAO();
		Mark mark = new Mark();
                LogoperatorDAO lgdao = new LogoperatorDAO();
                Logoperator logoperator = new Logoperator();
                ClientDAO cldao = new ClientDAO();
                Client client = new Client();
                int clientId = Integer.valueOf((String)requestMap.get("idClient"));
                int logoperatorId = Integer.valueOf((String)requestMap.get("idLogoperator"));
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {      
			mark.setValue(Integer.valueOf((String)requestMap.get("markSelect"))); 
			logoperator = lgdao.readById(logoperatorId);
                        mark.setLogoperator(logoperator);
                        client = cldao.readById(clientId);
                        mark.setClient(client);
                        mdao.create(mark);
                        markList = mdao.readByLogoperatorId(logoperatorId);
                        recallList = rcdao.readByLogoperatorId(logoperatorId);
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(markList.isEmpty()) {
			page = "";
		} else {
                        hash.put("clientId", clientId);
                        hash.put("logoperatorId", logoperatorId);
                        hash.put("markList", markList);
                        hash.put("recallList", recallList);
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
                list.add("markList");
                list.add("recallList");
		return list;
	}

}
