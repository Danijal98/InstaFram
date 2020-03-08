package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Proizvod;
import utilities.Baza;
import view.FirstView;
import view.MyJTree;

public class Export extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		Proizvod proizvod = null;
		
		try {
			proizvod = (Proizvod)MyJTree.getSelected();
		} catch (ClassCastException e2) {
			JOptionPane.showMessageDialog(FirstView.getInstance(), "Samo proizvod moze da se exportuje!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
			return;
		} catch(Exception e3) {
			System.out.println("Niste izabrali putanju!");
			return;
		}
		
		Baza.getInstance().export(proizvod);
		
	}

}
