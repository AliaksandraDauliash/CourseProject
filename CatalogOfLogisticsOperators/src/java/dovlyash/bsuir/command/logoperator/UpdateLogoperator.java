
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

public class UpdateLogoperator implements Command {
    private String page;
		
	public UpdateLogoperator() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                LogoperatorDAO lgdao = new LogoperatorDAO();
                List<Logoperator> logoperatorList = new ArrayList();
                ServiceDAO sdao = new ServiceDAO();
                List<Service> serviceList = new ArrayList();
		Logoperator logoperator = new Logoperator();
                LogoperatorService logserv = new LogoperatorService();
                LogoperatorServiceDAO lgsdao = new LogoperatorServiceDAO();
                List<LogoperatorService> logoperatorServiceList = new ArrayList();
		HashMap<String, Object> hash = new HashMap<String, Object>();
                int logoperatorId = Integer.valueOf((String)requestMap.get("idLogoperator"));
		try {
                        logoperator.setId(logoperatorId);
			logoperator.setName((String)requestMap.get("logName"));
			logoperator.setAdress((String)requestMap.get("logAdress"));
                        logoperator.setPhone((String)requestMap.get("logPhone"));
                        logoperator.setEmail((String)requestMap.get("logMail")+(String)requestMap.get("mailSelect"));
                        logoperator.setContactName((String)requestMap.get("logContactName"));
                        logoperator.setDescription((String)requestMap.get("logDescription"));
                        logoperator.setLogin((String)requestMap.get("logLogin"));
                        logoperator.setPassword((String)requestMap.get("logPassword"));
			lgdao.update(logoperator);
                        lgsdao.deleteByLogoperatorId(logoperatorId);
                        logoperatorServiceList = lgsdao.readByLogoperatorId(logoperatorId);
                        String str[];
                        str = (String[])requestMap.get("logService");
                        for(int i=0;i<str.length;i++){
                        logserv.setLogoperator(logoperator);
                        logserv.setService(sdao.readByName(str[i]));
                        lgsdao.create(logserv);
                        }
			logoperatorList.add(lgdao.readById(logoperatorId));
                        logoperatorServiceList = lgsdao.readByLogoperatorId(logoperatorId);
                        serviceList = sdao.read();
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(logoperatorList.isEmpty()) {
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
