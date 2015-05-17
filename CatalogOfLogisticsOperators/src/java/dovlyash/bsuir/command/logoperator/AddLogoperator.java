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
import java.util.Iterator;
import java.util.List;

public class AddLogoperator implements Command {
	private String page;
		
	public AddLogoperator() {
		super();
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
            int logoperatorId=0;
                LogoperatorDAO lgdao = new LogoperatorDAO();
                List<Logoperator> logoperatorList = new ArrayList();
		Logoperator logoperator = new Logoperator();
                LogoperatorService logserv = new LogoperatorService();
                LogoperatorServiceDAO lgsdao = new LogoperatorServiceDAO();
                ServiceDAO sdao = new ServiceDAO();
		HashMap<String, Object> hash = new HashMap<String, Object>();
                String name=null, phone=null, email=null, adress=null,description=null,contact=null, login;
                boolean flag = false;
		try {
                        name = (String)requestMap.get("logName");
                        phone = (String)requestMap.get("logPhone");
                        email = (String)requestMap.get("logMail");
                        adress = (String)requestMap.get("logAdress");
                        description = (String)requestMap.get("logDescription");
                        contact = (String)requestMap.get("logContactName");
                        login = (String)requestMap.get("logLogin");
                        logoperatorList = lgdao.read();
                        for (Iterator iterator
                  = logoperatorList.iterator(); iterator.hasNext();) {
                    Logoperator lg = (Logoperator) iterator.next();
                    if(lg.getLogin().equals(login))
                     flag = true;
                }
                        if(!flag){
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
                        logoperator = logoperatorList.get(logoperatorList.size()-1);
                        logoperatorId = logoperator.getId();
                        }
                }
		catch (SQLException e) {
			e.printStackTrace();
		}	
               if(flag) {
                        hash.put("flag", flag);
                        hash.put("name", name);
                        hash.put("phone", phone);
                        hash.put("email", email);
                        hash.put("adress", adress);
                        hash.put("description", description);
                        hash.put("contact", contact);
			page = "addLogoperator.jsp";
		} else {
			hash.put("logoperatorId", logoperatorId);
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
                list.add("name");
                list.add("phone");
                list.add("email");
                list.add("flag");
                list.add("adress");
                list.add("description");
                list.add("contact");
		list.add("logoperatorId");
		return list;
	}

}
