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

public class ViewLogoperator implements Command {
	private LogoperatorDAO lgdao;
        private LogoperatorServiceDAO lgsdao;
        private ServiceDAO sdao;
	private List<Logoperator> logoperatorList;
        private List<LogoperatorService> logoperatorServiceList;
        private List<Service> serviceList;
	private String page;
		
	public ViewLogoperator() {
		super();
		lgdao = new LogoperatorDAO();
                lgsdao = new LogoperatorServiceDAO();
                sdao = new ServiceDAO();
                logoperatorList = new ArrayList<Logoperator>();
                logoperatorServiceList = new ArrayList<LogoperatorService>();
		page = null;
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
            try {
                logoperatorList = lgdao.read();
                logoperatorServiceList = lgsdao.read();
            } catch (SQLException ex) {
                Logger.getLogger(ViewLogoperator.class.getName()).log(Level.SEVERE, null, ex);
            }
		if(logoperatorList.isEmpty()) {
			page = "";
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

