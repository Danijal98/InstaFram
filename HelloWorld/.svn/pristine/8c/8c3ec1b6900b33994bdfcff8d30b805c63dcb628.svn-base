package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import model.Cvor;
import model.Parametar;
import model.ParametersElementsSelection;
import view.FirstView;
import view.MyJTree;

public class Cut extends AbstractAction{

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
		//TODO brisanje selektovanog
		for(Parametar parametar: parametri) {
			Cvor parent = parametar.getRoditelj();
    		parent.getDeca().remove(parametar);
		}
	}

}
