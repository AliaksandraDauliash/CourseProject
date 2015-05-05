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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindLogoperator implements Command {
	private LogoperatorDAO lgdao;
        private LogoperatorServiceDAO lgsdao;
        private ServiceDAO sdao;
        private List<Service> serviceList;
	private List<Logoperator> logoperatorList;
        private List<LogoperatorService> logoperatorServiceList;
	private String page;
		
	public FindLogoperator() {
		super();
		lgdao = new LogoperatorDAO();
                lgsdao = new LogoperatorServiceDAO();
                sdao = new ServiceDAO();
                serviceList = new ArrayList<Service>();
                logoperatorList = new ArrayList<Logoperator>();
                logoperatorServiceList = new ArrayList<LogoperatorService>();
		page = null;
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
            try {
                String name = (String)requestMap.get("logName");
                String service = (String)requestMap.get("serviceSelect");
                List lgList = new ArrayList<Logoperator>();
                if(!name.equals(""))
                logoperatorList = lgdao.readByName(name);
                else logoperatorList = lgdao.read();
                if(!service.equals("all")){ 
                logoperatorServiceList = lgsdao.readByServiceName(service);
                for (Iterator iterator
                  = logoperatorList.iterator(); iterator.hasNext();) {
                    int k=0;
                Logoperator log = (Logoperator) iterator.next();
                System.out.println(log.getName());
                for (Iterator iterator1
                  = logoperatorServiceList.iterator(); iterator1.hasNext();) {
                    LogoperatorService lse = (LogoperatorService) iterator1.next();
                    System.out.println(lse.getService().getName());
                    System.out.println(lse.getLogoperator().getId());
                    System.out.println(log.getId());
                if(lse.getLogoperator().getId()==log.getId())
                   k++;
                }
                if(k!=0)
                    lgList.add(log);
            }
                logoperatorList = lgList;
                logoperatorServiceList = lgsdao.read();
                }  
            } catch (SQLException ex) {
                Logger.getLogger(ViewLogoperator.class.getName()).log(Level.SEVERE, null, ex);
            }
		if(logoperatorList.isEmpty()) {
                    System.out.println("empty");
			page = "viewLogoperator.jsp";
		} else {
			hash.put("logoperatorList", logoperatorList);
                        hash.put("logoperatorServiceList", logoperatorServiceList);
			page = "viewLogoperator.jsp";
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
                list.add("logoperatorServiceList");
		return list;
	}

}
