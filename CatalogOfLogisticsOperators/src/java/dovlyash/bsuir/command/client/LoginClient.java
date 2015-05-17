
package dovlyash.bsuir.command.client;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.dao.LogoperatorDAO;
import dovlyash.bsuir.data.entity.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoginClient implements Command {
	private String page;
		
	public LoginClient() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                ClientDAO cldao = new ClientDAO();
                LogoperatorDAO lgdao = new LogoperatorDAO();
                int clientId=0;
                int logoperatorId=0;
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
                        clientId = cldao.readByLogin((String)requestMap.get("clientLogin"),(String)requestMap.get("clientPassword"));
                        logoperatorId = lgdao.readByLogin((String)requestMap.get("clientLogin"),(String)requestMap.get("clientPassword"));
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(clientId==0 && logoperatorId==0) {
			page = "";
		} else {
			hash.put("clientId", clientId);
                        hash.put("logoperatorId", logoperatorId);
			page = "index.jsp";
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
		list.add("clientId");
                list.add("logoperatorId");
		return list;
	}

}

