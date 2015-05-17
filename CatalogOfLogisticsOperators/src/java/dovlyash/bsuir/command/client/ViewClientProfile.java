
package dovlyash.bsuir.command.client;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.entity.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewClientProfile implements Command {
	private String page;
		
	public ViewClientProfile() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                ClientDAO cldao = new ClientDAO();
		List<Client> clientList = new ArrayList();
                Client client = new Client();
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
                        clientList.add(cldao.readById(Integer.valueOf((String)requestMap.get("idClient"))));
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(client==null) {
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
