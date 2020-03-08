package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Cvor;
import model.Parametar;
import utilities.Baza;
import view.FirstView;
import view.MyJTree;
import view.MyWorkSpace1;
import view.MyWorkSpace2;

public class Edit extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Cvor cvor = null;
		
		try {
			cvor = (Cvor)MyJTree.getSelected();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(FirstView.getInstance(), "Workspace ne moze da se edituje!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(cvor == null) {
			JOptionPane.showMessageDialog(FirstView.getInstance(), "Niste selektovali nijedan čvor!","Upozorenje!",JOptionPane.WARNING_MESSAGE);
		}else {
			//workspace gore init
			MyWorkSpace1.getInstance().getTextArea().setText(cvor.getOpis());
			MyWorkSpace1.getInstance().getTextArea().setEditable(true);
			MyWorkSpace1.getInstance().setCvor(cvor);
			//trazi listove
			Baza.getInstance().setNumOfleafs(0);
			Baza.getInstance().findAllLeafs(cvor.getDeca());
			int brListova = Baza.getInstance().getNumOfleafs();
			//workspace dole init
			MyWorkSpace2 workSpace2 = MyWorkSpace2.getInstance();
			workSpace2.setCvor(cvor);
			//dodavanje observera
			cvor.addObserver(workSpace2);
			workSpace2.getLb_naziv().setText("Naziv : " + cvor.getIme());
			workSpace2.getLb_br_direktnih_potomaka().setText("Broj direktnih potomaka: " + cvor.getDeca().size());
			workSpace2.getLb_sadrzaj().setText("Sadrzaj: " + cvor.getOpis());
			workSpace2.getLb_roditelj().setText("Rodtitelj: " + cvor.getRoditelj());
			workSpace2.getLb_br_listova().setText("Broj listova: " + brListova);
			if(cvor instanceof Parametar) {
				workSpace2.getLb_tip().setText("Tip parametra: " + String.valueOf(((Parametar) cvor).getType()));
				workSpace2.leftPaneParamDo();
			}else {
				workSpace2.leftPaneParamUndo();
			}
			workSpace2.getLabelPane().setVisible(true);
		}
	}
	
}
