
package dovlyash.bsuir.command.client;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.entity.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AddClient implements Command {
	private String page;
		
	public AddClient() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                ClientDAO cldao = new ClientDAO();
                List<Client> clientList = new ArrayList();
		Client client = new Client();
		HashMap<String, Object> hash = new HashMap<String, Object>();
                int clientId = 0;
                String name=null, phone=null, email=null, login;
                boolean flag = false;
		try { 
                        name = (String)requestMap.get("clName");
                        phone = (String)requestMap.get("clPhone");
                        email = (String)requestMap.get("clMail");
                        login = (String)requestMap.get("clLogin");
                        clientList = cldao.read();
                        for (Iterator iterator
                  = clientList.iterator(); iterator.hasNext();) {
                    Client cl = (Client) iterator.next();
                    if(cl.getLogin().equals(login))
                     flag = true;
                }
                        if(!flag){
                            client.setName((String)requestMap.get("clName"));
			client.setPhone((String)requestMap.get("clPhone"));
                        client.setEmail((String)requestMap.get("clMail")+(String)requestMap.get("mailSelect"));
                        client.setLogin((String)requestMap.get("clLogin"));
                        client.setPassword((String)requestMap.get("clPassword"));
			cldao.create(client);
			clientList = cldao.read();
                        clientId = clientList.get(clientList.size()-1).getId();}
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(flag) {
                        hash.put("flag", flag);
                        hash.put("name", name);
                        hash.put("phone", phone);
                        hash.put("email", email);
			page = "registration.jsp";
		} else {
			hash.put("clientId", clientId);
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
                list.add("name");
                list.add("phone");
                list.add("email");
                list.add("flag");
		return list;
	}

}
