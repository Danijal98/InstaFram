package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import model.Parametar;
import model.ParametersElementsSelection;
import view.FirstView;
import view.MyJTree;

public class Copy extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO probati drugacije
		ArrayList<Object> objects = MyJTree.getSelectedNodes();
		ArrayList<Parametar> parametri = new ArrayList<>();
		for(Object obj: objects) {
			parametri.add((Parametar)obj);
		}
		ParametersElementsSelection contents = new ParametersElementsSelection(parametri);
		FirstView.getInstance().getClipboard().setContents(contents, FirstView.getInstance());
	}

}
