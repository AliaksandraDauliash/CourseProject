package dovlyash.bsuir.command.logoperator;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.LogoperatorDAO;
import dovlyash.bsuir.data.dao.LogoperatorServiceDAO;
import dovlyash.bsuir.data.dao.ServiceDAO;
import dovlyash.bsuir.data.entity.Logoperator;
import dovlyash.bsuir.data.entity.LogoperatorService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddLogoperator implements Command {
	private LogoperatorDAO lgdao;
	private List<Logoperator> logoperatorList;
	private String page;
        private Logoperator logoperator;
        private LogoperatorService logserv;
        private LogoperatorServiceDAO lgsdao;
        private ServiceDAO sdao;
		
	public AddLogoperator() {
		super();
		lgdao = new LogoperatorDAO();
                logoperatorList = new ArrayList<Logoperator>();
		logoperator = new Logoperator();
                logserv = new LogoperatorService();
                lgsdao = new LogoperatorServiceDAO();
                sdao = new ServiceDAO();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		try {
                        
			logoperator.setName((String)requestMap.get("logName"));
			logoperator.setAdress((String)requestMap.get("logAdress"));
                        logoperator.setPhone((String)requestMap.get("logPhone"));
                        logoperator.setEmail((String)requestMap.get("logMail")+(String)requestMap.get("mailSelect"));
                        logoperator.setContactName((String)requestMap.get("logContactName"));
                        logoperator.setDescription((String)requestMap.get("logDescription"));
                        logoperator.setLogin((String)requestMap.get("logLogin"));
                        logoperator.setPassword((String)requestMap.get("logPassword"));
			lgdao.create(logoperator);
                        String str[];
                        str = (String[])requestMap.get("logService");
                        for(int i=0;i<str.length;i++){
                        logserv.setLogoperator(logoperator);
                        logserv.setService(sdao.readByName(str[i]));
                        lgsdao.create(logserv);
                        }
			logoperatorList = lgdao.read();
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
                if(logoperatorList.isEmpty()) {
			page = "";
		} else {
			hash.put("logoperatorList", logoperatorList);
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
		list.add("logoperatorList");
		return list;
	}

}
