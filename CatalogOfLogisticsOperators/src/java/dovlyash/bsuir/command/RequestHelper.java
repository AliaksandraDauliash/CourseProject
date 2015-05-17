
package dovlyash.bsuir.command;

import dovlyash.bsuir.command.client.AddClient;
import dovlyash.bsuir.command.client.LoginClient;
import dovlyash.bsuir.command.client.LogoutClient;
import dovlyash.bsuir.command.client.UpdateClient;
import dovlyash.bsuir.command.client.ViewClientProfile;
import dovlyash.bsuir.command.logoperator.AddLogoperator;
import dovlyash.bsuir.command.logoperator.FindLogoperator;
import dovlyash.bsuir.command.logoperator.UpdateLogoperator;
import dovlyash.bsuir.command.logoperator.ViewLogoperator;
import dovlyash.bsuir.command.logoperator.ViewLogoperatorProfile;
import dovlyash.bsuir.command.mark.AddMark;
import dovlyash.bsuir.command.recall.AddRecall;
import dovlyash.bsuir.command.recall.ViewRecall;
import dovlyash.bsuir.command.request.DeleteRequest;
import dovlyash.bsuir.command.request.MakeRequest;
import dovlyash.bsuir.command.request.OpenRequestPage;
import dovlyash.bsuir.command.request.ViewRequest;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
    private static RequestHelper instance = null;
    private HashMap<String, Command> commands;

    private RequestHelper() {
    	commands = new HashMap<String, Command>();
        commands.put("viewLogoperator", new ViewLogoperator());
        commands.put("findLogoperator", new FindLogoperator());
        commands.put("addLogoperator", new AddLogoperator());
        commands.put("addClient", new AddClient());   
        commands.put("loginClient", new LoginClient());  
        commands.put("logoutClient", new LogoutClient());  
        commands.put("viewClientProfile", new ViewClientProfile()); 
        commands.put("updateClient", new UpdateClient()); 
        commands.put("openRequestPage", new OpenRequestPage());
        commands.put("makeRequest", new MakeRequest());
        commands.put("viewRecall", new ViewRecall());
        commands.put("addRecall", new AddRecall());
        commands.put("addMark", new AddMark());
        commands.put("viewRequest", new ViewRequest());
        commands.put("viewLogoperatorProfile", new ViewLogoperatorProfile());
        commands.put("updateLogoperator", new UpdateLogoperator());
        commands.put("deleteRequest", new DeleteRequest());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        Command command = commands.get(action);
        if (command == null) {
            System.out.println("Command null");
        }
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }

}
