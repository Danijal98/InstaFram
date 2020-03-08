package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.WorkspaceModel;
import utilities.Baza;

public class Save extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(Baza.isChanged()) {
			if(Baza.getFILE_PATH_SAVE() == null) {
				Baza.getInstance().saveAs(true, WorkspaceModel.getWorkspace());
			}else {
				Baza.getInstance().saveAs(false, WorkspaceModel.getWorkspace());
			}
		}
	}
	
}
