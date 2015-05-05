
package dovlyash.bsuir.controller.servlet;

import dovlyash.bsuir.command.Command;
import dovlyash.bsuir.command.RequestHandler;
import dovlyash.bsuir.command.RequestHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ApplicationServlet", urlPatterns = {"/ApplicationServlet"})
public class ApplicationServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

    /**
     * Конструктор без параметров
     */
    public ApplicationServlet() {
        super();
    }

    /**
     * Метод инициализации сервлета
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Метод взаимодействия с запросом клиента
     *
     * @param – request запрос
     * @param – resp ответ
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(request, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)           
            throws UnsupportedEncodingException, ServletException, IOException, SQLException {;
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //открытие нового сеанса(сессии)
        HttpSession session = request.getSession(true);
        HashMap<String, Object> hashData = new HashMap<String, Object>();
        HashMap<String, Object> hash = new HashMap<String, Object>();
        ArrayList<String> list = new ArrayList<String>();
        
        RequestHandler parsingRequest = new RequestHandler();
        RequestHelper requestHelper = RequestHelper.getInstance();
        Command command = requestHelper.getCommand(request);
        hashData = parsingRequest.parse(request);
        hash = command.execute(hashData);
        list = command.atributeName();
        for (String string : list) {
            session.setAttribute(string, hash.get(string));
        }
        String page = command.responsePage();
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);


    }

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, UnsupportedEncodingException {
    try {
        processRequest(req, resp);
    } catch (SQLException ex) {
        Logger.getLogger(ApplicationServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
