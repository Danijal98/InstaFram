package actions;

import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import model.Cvor;
import utilities.Baza;
import view.FirstView;
import view.MyJTree;

public class Paste extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		Transferable clipboardContent = FirstView.getInstance().getClipboard().getContents(FirstView.getInstance());
		((Cvor)MyJTree.getSelected()).paste(clipboardContent);
		SwingUtilities.updateComponentTreeUI(FirstView.getInstance().getMyJTree());
		Baza.setChanged(true);
	}

}
