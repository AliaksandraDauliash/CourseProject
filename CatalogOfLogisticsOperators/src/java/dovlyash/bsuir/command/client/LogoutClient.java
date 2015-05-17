
package dovlyash.bsuir.command.client;

import dovlyash.bsuir.command.Command;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogoutClient implements Command{
private String page;
		
	public LogoutClient() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
		HashMap<String, Object> hash = new HashMap();
                int clientId = 0;
                int logoperatorId = 0;
			hash.put("clientId", clientId);
                        hash.put("logoperatorId", logoperatorId);
			page = "index.jsp";
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