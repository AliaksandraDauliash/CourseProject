
package dovlyash.bsuir.command;

import dovlyash.bsuir.command.client.AddClient;
import dovlyash.bsuir.command.logoperator.AddLogoperator;
import dovlyash.bsuir.command.logoperator.FindLogoperator;
import dovlyash.bsuir.command.logoperator.ViewLogoperator;
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
