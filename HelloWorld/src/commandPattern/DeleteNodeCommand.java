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
import view.FirstView;

public class DeleteNodeCommand extends AbstractCommand{

	private Object cvor;
	
	public DeleteNodeCommand(Cvor cvor) {
		this.cvor = cvor;
	}

	@Override
	public void doCommand() {
		if(cvor instanceof Workspace){
			FirstView.getInstance().getWorkspaceModel().getCvorovi().clear();
		}else if(cvor instanceof Kompanija) {
			Kompanija k = (Kompanija)cvor;
			FirstView.getInstance().getWorkspaceModel().deleteCvor(k);
		}else if(cvor instanceof Cvor){
			Cvor roditelj = ((Cvor)cvor).getRoditelj();
			roditelj.deleteCvor((Cvor)cvor);
		}
		SwingUtilities.updateComponentTreeUI(FirstView.getInstance().getMyJTree());
	}

	@Override
	public void undoCommand() {
		if(((Cvor)cvor).getRoditelj() == null) {
			WorkspaceModel.getWorkspace().addCvor((Kompanija) cvor);
		}else if(cvor instanceof Parametar){
			if(((Cvor)cvor).getRoditelj() instanceof Proizvod)
				((Cvor)cvor).getRoditelj().addCvor((Parametar)cvor, ModelType.PARAMETER);
			else
				((Cvor)cvor).getRoditelj().addCvor((Parametar)cvor);
		}else if(cvor instanceof Modul) {
			((Cvor)cvor).getRoditelj().addCvor((Modul)cvor, ModelType.MODUL);
		}else {
			((Cvor)cvor).getRoditelj().addCvor((Cvor)cvor);
		}
		
		SwingUtilities.updateComponentTreeUI(FirstView.getInstance().getMyJTree());
	}

}
