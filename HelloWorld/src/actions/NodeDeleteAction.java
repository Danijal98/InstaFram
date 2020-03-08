package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import commandPattern.DeleteNodeCommand;
import exceptions.MyExceptions;
import model.Cvor;
import model.Kompanija;
import model.Workspace;
import utilities.Baza;
import utilities.UserType;
import view.FirstView;
import view.MyJTree;
import view.MyWorkSpace1;
import view.MyWorkSpace2;

public class NodeDeleteAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (Baza.getInstance().getUser().getUserType().equals(UserType.USER)) {
			JOptionPane.showMessageDialog(FirstView.getInstance(), "Samo admin moze da koristi ove funkcije",
					"Upozorenje!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		Object[] options = { "Yes", "Cancel" };
		Object obj = MyJTree.getSelected();

		if (obj instanceof Workspace) {
			Workspace cvor = (Workspace) obj;
			int answer = JOptionPane.showOptionDialog(FirstView.getInstance(),
					"Da li ste sigurni da zelite da obrisete ceo Workspace?", "Upozorenje",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (answer == 0) {
				cvor.getCvorovi().clear();
			}
		} else {
			Cvor cvor = (Cvor) obj;
			if (cvor == null) {
//				JOptionPane.showMessageDialog(FirstView.getInstance(), "Niste izabrali nijedan cvor!", "Upozorenje!",
//						JOptionPane.WARNING_MESSAGE);
				MyExceptions.nijeIzabrano("Niste izabrali nijedan cvor!", "Upozorenje!");
			} else {
				String poruka = "Da li ste sigurni da zelite da obrisete " + cvor.getIme() + "\nKoji ima "
						+ cvor.getDeca().size() + " dece i " + countLeafs(cvor) + " listova";
				int answer = JOptionPane.showOptionDialog(FirstView.getInstance(), poruka, "Upozorenje",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				if (answer == 0) {
					if (cvor.getParent() == null) {
						FirstView.getInstance().getWorkspaceModel().deleteCvor((Kompanija) cvor);
						DeleteNodeCommand dnc = new DeleteNodeCommand(cvor);
						FirstView.getInstance().getCommandManager().addCommand(dnc);
					} else {
						Cvor parent = cvor.getRoditelj();
						parent.getDeca().remove(cvor);
						DeleteNodeCommand dnc = new DeleteNodeCommand(cvor);
						FirstView.getInstance().getCommandManager().addCommand(dnc);
					}
				}
			}
		}
		ActionManager.getInstance().getClose().actionPerformed(null);
		SwingUtilities.updateComponentTreeUI(FirstView.getInstance().getMyJTree());
		Baza.setChanged(true);
	}

	private int countLeafs(Object obj) {
		Baza.getInstance().setNumOfleafs(0);
		if (obj instanceof Cvor) {
			Cvor cvor = (Cvor) obj;
			Baza.getInstance().findAllLeafs(cvor.getDeca());
		}
		return Baza.getInstance().getNumOfleafs();
	}

}
