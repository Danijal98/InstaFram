package commandPattern;

import java.util.ArrayList;

import actions.ActionManager;
import view.FirstView;

public class CommandManager {
	
	private ArrayList<AbstractCommand> commands = new ArrayList<>();
	private int currentCommand = 0;
	
	public void addCommand(AbstractCommand command) {
		while(currentCommand < commands.size() && !commands.isEmpty()) {
			int topCommand = commands.size()-1;
			commands.remove(topCommand);
		}
		commands.add(command);
		currentCommand++;
	}
	
	public void doCommand() {
		if(currentCommand < commands.size()) {
			if(commands.get(currentCommand) instanceof AddNodeCommand) {
				AddNodeCommand tmp = (AddNodeCommand)commands.get(currentCommand);
				tmp.doCommand();
			}
			if(commands.get(currentCommand) instanceof DeleteNodeCommand) {
				DeleteNodeCommand tmp = (DeleteNodeCommand)commands.get(currentCommand);
				tmp.doCommand();
			}
			currentCommand++;
		}
	}
	
	public void undoCommand() {
		if(currentCommand > 0) {
			if(commands.get(currentCommand-1) instanceof AddNodeCommand) {
				AddNodeCommand tmp = (AddNodeCommand)commands.get(currentCommand-1);
				tmp.undoCommand();
			}
			if(commands.get(currentCommand-1) instanceof DeleteNodeCommand) {
				DeleteNodeCommand tmp = (DeleteNodeCommand)commands.get(currentCommand-1);
				tmp.undoCommand();
			}
			currentCommand--;
		}
	}
	

}
