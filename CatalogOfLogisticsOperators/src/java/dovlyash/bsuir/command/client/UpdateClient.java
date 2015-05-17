
package dovlyash.bsuir.command.client;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.entity.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateClient implements Command {
	private String page;
		
	public UpdateClient() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                ClientDAO cldao = new ClientDAO();
                List<Client> clientList = new ArrayList();
		Client client = new Client();
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
                        client.setId(Integer.valueOf((String)requestMap.get("clId")));
			client.setName((String)requestMap.get("clName"));
			client.setPhone((String)requestMap.get("clPhone"));
                        client.setEmail((String)requestMap.get("clMail")+(String)requestMap.get("mailSelect"));
                        client.setLogin((String)requestMap.get("clLogin"));
                        client.setPassword((String)requestMap.get("clPassword"));
			cldao.update(client);
			clientList.add(cldao.readById(client.getId()));
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(clientList.isEmpty()) {
			page = "";
		} else {
			hash.put("clientList", clientList);
			page = "viewClientProfile.jsp";
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
		list.add("clientList");
		return list;
	}

}

