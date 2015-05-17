
package dovlyash.bsuir.command.request;
import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.RequestDAO;
import dovlyash.bsuir.data.entity.Request;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteRequest implements Command {
    private String page;
		
	public DeleteRequest() {
		super();
		page = null;
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
            HashMap<String, Object> hash = new HashMap<String, Object>();
        try {
            int requestId = Integer.valueOf((String)requestMap.get("idRequest"));
            int logoperatorId = Integer.valueOf((String)requestMap.get("idLogoperator"));
            RequestDAO rdao = new RequestDAO();
            rdao.delete(requestId);
            List<Request> requestList = new ArrayList();
            requestList = rdao.readByLogoperatorId(logoperatorId);
            hash.put("requestList", requestList);
            hash.put("logoperatorId", logoperatorId);
            page = "viewRequest.jsp";           
        } catch (SQLException ex) {
            Logger.getLogger(MakeRequest.class.getName()).log(Level.SEVERE, null, ex);
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
		list.add("logoperatorId");
                list.add("requestList");
		return list;
	}

}
