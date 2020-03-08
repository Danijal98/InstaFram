package commandPattern;

import javax.swing.SwingUtilities;

import model.Cvor;
import model.Kompanija;
import model.Modul;
import model.Parametar;
import model.Proizvod;
import model.Workspace;
import model.WorkspaceModel;
import utilities.ModelType;
import utilities.ParametarType;
import view.FirstView;

public class AddNodeCommand extends AbstractCommand{

	private Cvor cvor;
	
	public  AddNodeCommand(Cvor cvor) {
		this.cvor = cvor;
	}
	
	@Override
	public void doCommand() {
		if(cvor.getRoditelj() == null) {
			WorkspaceModel.getWorkspace().addCvor((Kompanija) cvor);
		}else if(cvor instanceof Parametar){
			if(cvor.getRoditelj() instanceof Proizvod)
				cvor.getRoditelj().addCvor((Parametar)cvor, ModelType.PARAMETER);
			else
				cvor.getRoditelj().addCvor((Parametar)cvor);
		}else if(cvor instanceof Modul) {
			cvor.getRoditelj().addCvor((Modul)cvor, ModelType.MODUL);
		}else {
			cvor.getRoditelj().addCvor(cvor);
		}
		
		SwingUtilities.updateComponentTreeUI(FirstView.getInstance().getMyJTree());
	}

	@Override
	public void undoCommand() {
		if(cvor.getRoditelj() == null) {
			WorkspaceModel.getWorkspace().deleteCvor((Kompanija) cvor);
		}else
			cvor.getRoditelj().deleteCvor(cvor);
		
		SwingUtilities.updateComponentTreeUI(FirstView.getInstance().getMyJTree());
	}

}
