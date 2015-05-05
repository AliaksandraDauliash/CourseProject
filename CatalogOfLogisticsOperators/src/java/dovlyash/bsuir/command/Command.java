
package dovlyash.bsuir.command;

import java.util.ArrayList;
import java.util.HashMap;

public interface Command {
	public HashMap<String, Object> execute(HashMap<String, Object> requestMap);
	public String responsePage();
	public ArrayList<String> atributeName();

}
