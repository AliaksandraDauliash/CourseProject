
package dovlyash.bsuir.command.request;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.dao.LogoperatorDAO;
import dovlyash.bsuir.data.dao.LogoperatorServiceDAO;
import dovlyash.bsuir.data.entity.LogoperatorService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpenRequestPage implements Command{
 private String page;
		
	public OpenRequestPage() {
		super();
		page = null;
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
                int clientId = Integer.valueOf((String)requestMap.get("idClient"));
                int logoperatorId = Integer.valueOf((String)requestMap.get("idLogoperator"));
                LogoperatorServiceDAO lgsdao = new LogoperatorServiceDAO();
                List<LogoperatorService> logoperatorServiceList = new ArrayList();
     try {
         logoperatorServiceList = lgsdao.readByLogoperatorId(logoperatorId);
     } catch (SQLException ex) {
         Logger.getLogger(OpenRequestPage.class.getName()).log(Level.SEVERE, null, ex);
     }
                        hash.put("logoperatorServiceList",logoperatorServiceList );
			hash.put("logoperatorId", logoperatorId);
                        hash.put("clientId", clientId);
			page = "makeRequest.jsp";
		return hash;
	}

	@Override
	public String responsePage() {
		return page;
	}

	@Override
	public List<String> atributeName() {
		List<String> list = new ArrayList();
		list.add("logoperatorId");
                list.add("clientId");
                list.add("logoperatorServiceList");
		return list;
	}

}
