package actions;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.Cvor;
import model.WorkspaceModel;
import utilities.Baza;
import view.FirstView;


public class Exit extends WindowAdapter{
	
	//TODO

	@Override
	public void windowClosing(WindowEvent e) {
		// Ask for confirmation before terminating the program.
		if(!Baza.isChanged()) {
			int option = JOptionPane.showConfirmDialog(FirstView.getInstance(), "Da li ste sigurni da želite da napustite program?",
	        		"Close Confirmation", 
	                JOptionPane.YES_NO_OPTION, 
	                JOptionPane.QUESTION_MESSAGE);
	        if (option == JOptionPane.YES_OPTION) {
	        	System.exit(0);
	        }
		}else {
			int option = JOptionPane.showConfirmDialog(FirstView.getInstance(),
					"Izvrsene su neke izmene, da li zelite da ih sacuvate pre napustanja programa?");
			if(option == JOptionPane.YES_OPTION) {
				if(Baza.getFILE_PATH_SAVE() == null) {
					Baza.getInstance().saveAs(true, WorkspaceModel.getWorkspace());
				}else {
					Baza.getInstance().saveAs(false, WorkspaceModel.getWorkspace());
				}
				System.exit(0);
			}else if(option == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}
	}
	
}