package view;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import actions.ActionManager;
import actions.Copy;
import actions.Cut;
import actions.Paste;

public class MyPopUpMenu extends JPopupMenu{

	private JMenuItem copy;
	private JMenuItem cut;
	private JMenuItem paste;
	
	public MyPopUpMenu() {
		copy = new JMenuItem("Copy");
		copy.addActionListener(ActionManager.getInstance().getCopy());
		cut = new JMenuItem("Cut");
		cut.addActionListener(ActionManager.getInstance().getCut());
		paste = new JMenuItem("Paste");
		paste.addActionListener(ActionManager.getInstance().getPaste());
		add(copy);
		add(cut);
		add(paste);
	}

	public JMenuItem getCopy() {
		return copy;
	}

	public void setCopy(JMenuItem copy) {
		this.copy = copy;
	}

	public JMenuItem getCut() {
		return cut;
	}

	public void setCut(JMenuItem cut) {
		this.cut = cut;
	}

	public JMenuItem getPaste() {
		return paste;
	}

	public void setPaste(JMenuItem paste) {
		this.paste = paste;
	}
	
}
