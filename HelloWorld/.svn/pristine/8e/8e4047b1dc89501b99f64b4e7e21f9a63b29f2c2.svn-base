package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.MyWorkSpace1;
import view.MyWorkSpace2;

public class Close extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MyWorkSpace2.getInstance().getLabelPane().setVisible(false);
		MyWorkSpace1.getInstance().getTextArea().setText("");
		MyWorkSpace1.getInstance().getTextArea().setEditable(false);
	}

}
