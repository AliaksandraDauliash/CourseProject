
package dovlyash.bsuir.command.logoperator;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.LogoperatorDAO;
import dovlyash.bsuir.data.dao.LogoperatorServiceDAO;
import dovlyash.bsuir.data.dao.ServiceDAO;
import dovlyash.bsuir.data.entity.Logoperator;
import dovlyash.bsuir.data.entity.LogoperatorService;
import dovlyash.bsuir.data.entity.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewLogoperatorProfile implements Command{
    private String page;
		
	public ViewLogoperatorProfile() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                List<Logoperator> logoperatorList = new ArrayList();
                List<LogoperatorService> logoperatorServiceList = new ArrayList();
                LogoperatorDAO lgdao = new LogoperatorDAO();
                LogoperatorServiceDAO lgsdao= new LogoperatorServiceDAO();
                List<Service> serviceList = new ArrayList();
                ServiceDAO sdao = new ServiceDAO();
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
                        logoperatorList.add(lgdao.readById(Integer.valueOf((String)requestMap.get("idLogoperator"))));
                        logoperatorServiceList = lgsdao.readByLogoperatorId(Integer.valueOf((String)requestMap.get("idLogoperator")));
                        serviceList = sdao.read();
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(logoperatorList==null) {
			page = "";
		} else {
			hash.put("logoperatorList", logoperatorList);
                        hash.put("logoperatorServiceList", logoperatorServiceList);
                        hash.put("serviceList", serviceList);
			page = "viewLogoperatorProfile.jsp";
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
		list.add("logoperatorList");
                list.add("serviceList");
                list.add("logoperatorServiceList");
		return list;
	}

}