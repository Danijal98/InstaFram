package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import utilities.Baza;
import utilities.UserType;
import view.FirstView;
import view.MyAddDialog;

public class OpenAddDialog extends AbstractAction{
	
	MyAddDialog newAddDialog;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Baza.getInstance().getUser().getUserType().equals(UserType.USER)) {
			JOptionPane.showMessageDialog(FirstView.getInstance(), "Samo admin moze da koristi ove funkcije", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		newAddDialog = new MyAddDialog(FirstView.getInstance());
	}

	public MyAddDialog getNewAddDialog() {
		return newAddDialog;
	}

	public void setNewAddDialog(MyAddDialog newAddDialog) {
		this.newAddDialog = newAddDialog;
	}
	

}
