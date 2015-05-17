package dovlyash.bsuir.command.logoperator;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.LogoperatorDAO;
import dovlyash.bsuir.data.dao.LogoperatorServiceDAO;
import dovlyash.bsuir.data.entity.Logoperator;
import dovlyash.bsuir.data.entity.LogoperatorService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewLogoperator implements Command {

	private String page;
		
	public ViewLogoperator() {
		super();
		page = null;
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
                List<Logoperator> logoperatorList = new ArrayList();
                List<LogoperatorService> logoperatorServiceList = new ArrayList();
                LogoperatorDAO lgdao = new LogoperatorDAO();
                LogoperatorServiceDAO lgsdao= new LogoperatorServiceDAO();
		HashMap<String, Object> hash = new HashMap<String, Object>();
                int logoperatorId = 0;
            try {
                logoperatorList = lgdao.read();
                logoperatorServiceList = lgsdao.read();
            } catch (SQLException ex) {
                Logger.getLogger(ViewLogoperator.class.getName()).log(Level.SEVERE, null, ex);
            }
		if(logoperatorList.isEmpty()) {
			page = "";
		} else {
                        hash.put("logoperatorId", logoperatorId);
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
	public List<String> atributeName() {
		List<String> list = new ArrayList();
		list.add("logoperatorList");
                list.add("logoperatorId");
                list.add("logoperatorServiceList");
		return list;
	}

}

