
package dovlyash.bsuir.command.request;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.dao.RequestDAO;
import dovlyash.bsuir.data.entity.Client;
import dovlyash.bsuir.data.entity.Request;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewRequest implements Command{
  private String page;
		
	public ViewRequest() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                int logoperatorId =0;
                RequestDAO rdao = new RequestDAO();
                List<Request> requestList = new ArrayList();
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
                    logoperatorId = Integer.valueOf((String)requestMap.get("idLogoperator"));
                    requestList = rdao.readByLogoperatorId(logoperatorId);
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(logoperatorId==0) {
			page = "";
		} else {
			hash.put("requestList", requestList);
                        hash.put("logoperatorId", logoperatorId);
			page = "viewRequest.jsp";
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
		list.add("requestList");
                list.add("logoperatorId");
		return list;
	}

}
