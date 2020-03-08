package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import utilities.Baza;
import utilities.UserType;
import view.FirstView;

public class Load extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(Baza.getInstance().getUser().getUserType().equals(UserType.USER)) {
//			JOptionPane.showMessageDialog(FirstView.getInstance(), "Samo admin moze da koristi ove funkcije", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
//			return;
//		}
		Baza.getInstance().LoadFromFile();
		FirstView.getInstance().getWorkspaceModel().reload();
	}

}
