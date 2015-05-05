
package dovlyash.bsuir.command.client;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.entity.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddClient implements Command {
	private ClientDAO cldao;
	private List<Client> clientList;
	private String page;
        private Client client;
		
	public AddClient() {
		super();
		cldao = new ClientDAO();
                clientList = new ArrayList<Client>();
		client = new Client();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
                        
			client.setName((String)requestMap.get("clName"));
			client.setPhone((String)requestMap.get("clPhone"));
                        client.setEmail((String)requestMap.get("clMail")+(String)requestMap.get("mailSelect"));
                        client.setLogin((String)requestMap.get("clLogin"));
                        client.setPassword((String)requestMap.get("clPassword"));
			cldao.create(client);
			clientList = cldao.read();
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(clientList.isEmpty()) {
			page = "";
		} else {
			hash.put("clientList", clientList);
			page = "index.jsp";
		}
		return hash;
	}

	@Override
	public String responsePage() {
		return page;
	}

	@Override
	public ArrayList<String> atributeName() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("clientList");
		return list;
	}

}
