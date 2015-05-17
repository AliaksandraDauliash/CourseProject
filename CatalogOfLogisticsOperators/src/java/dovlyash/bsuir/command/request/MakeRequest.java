
package dovlyash.bsuir.command.request;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.data.dao.ClientDAO;
import dovlyash.bsuir.data.dao.GoodsDAO;
import dovlyash.bsuir.data.dao.LogoperatorDAO;
import dovlyash.bsuir.data.dao.LogoperatorServiceDAO;
import dovlyash.bsuir.data.dao.RequestDAO;
import dovlyash.bsuir.data.dao.ServiceDAO;
import dovlyash.bsuir.data.entity.Client;
import dovlyash.bsuir.data.entity.Goods;
import dovlyash.bsuir.data.entity.Logoperator;
import dovlyash.bsuir.data.entity.LogoperatorService;
import dovlyash.bsuir.data.entity.Request;
import dovlyash.bsuir.data.entity.Service;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MakeRequest implements Command{
    
    private String page;
		
	public MakeRequest() {
		super();
		page = null;
	}
	
	@Override
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap) {
            HashMap<String, Object> hash = new HashMap<String, Object>();
        try {
            int clientId = Integer.valueOf((String)requestMap.get("idClient"));
            int logoperatorId = Integer.valueOf((String)requestMap.get("idLogoperator"));
            ClientDAO cldao = new ClientDAO();
            GoodsDAO gdao = new GoodsDAO();
            Goods goods = new Goods();
            goods.setName((String)requestMap.get("goodsName"));
            goods.setWeight(Double.valueOf((String)requestMap.get("goodsWeight")));
            goods.setVolume(Double.valueOf((String)requestMap.get("goodsVolume")));
            Client client = null;
            client = cldao.readById(clientId);
            goods.setClient(client);
            gdao.create(goods);
            LogoperatorDAO lgdao = new LogoperatorDAO();
            Logoperator logoperator = lgdao.readById(logoperatorId);
            String serviceName = (String)requestMap.get("serviceSelect");
            ServiceDAO sdao = new ServiceDAO();
            Service service = sdao.readByName(serviceName);
            String dat = (String)requestMap.get("requestDate");
            String str[] = dat.split("-");
            System.out.println(str[2]);
            Date date = new Date(Integer.valueOf(str[2]) - 1900 ,Integer.valueOf(str[1]),Integer.valueOf(str[0]));
            Request request = new Request();
            request.setDate(date);
            request.setGoods(goods);
            request.setLogoperator(logoperator);
            request.setService(service);
            RequestDAO rdao = new RequestDAO();
            rdao.create(request);
            hash.put("logoperatorId", logoperatorId);
            hash.put("clientId", clientId);
            page = "makeRequest.jsp";           
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
                list.add("clientId");
		return list;
	}

}
    
