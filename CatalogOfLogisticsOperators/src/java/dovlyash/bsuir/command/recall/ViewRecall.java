package dovlyash.bsuir.command.recall;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.MarkDAO;
import dovlyash.bsuir.data.dao.RecallDAO;
import dovlyash.bsuir.data.entity.Mark;
import dovlyash.bsuir.data.entity.Recall;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewRecall implements Command {

    private String page;

    public ViewRecall() {
        super();
        page = null;
    }

    @Override
    public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        MarkDAO mdao = new MarkDAO();
        List<Mark> markList = new ArrayList();
        try {
            List<Recall> recallList = new ArrayList();
            RecallDAO rcdao = new RecallDAO();
            int clientId = Integer.valueOf((String) requestMap.get("idClient"));
            int logoperatorId = Integer.valueOf((String) requestMap.get("idLogoperator"));
            recallList = rcdao.readByLogoperatorId(logoperatorId);
            markList = mdao.readByLogoperatorId(logoperatorId);
            hash.put("recallList", recallList);
            hash.put("clientId", clientId);
            hash.put("markList", markList);
            hash.put("logoperatorId", logoperatorId);
            page = "viewRecall.jsp";
        } catch (SQLException ex) {
            Logger.getLogger(ViewRecall.class.getName()).log(Level.SEVERE, null, ex);
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
        list.add("recallList");
        list.add("markList");
        list.add("clientId");
        list.add("logoperatorId");
        return list;
    }

}
