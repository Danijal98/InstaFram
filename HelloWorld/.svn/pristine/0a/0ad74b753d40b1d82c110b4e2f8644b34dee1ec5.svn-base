package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import commandPattern.AddNodeCommand;
import model.Cvor;
import model.Kompanija;
import model.Modul;
import model.Parametar;
import model.Proizvod;
import model.Workspace;
import utilities.Baza;
import utilities.ModelType;
import utilities.ParametarType;
import utilities.UserType;
import view.FirstView;
import view.MyAddDialog;
import view.MyJTree;

public class NodeAdderAction extends AbstractAction{
	//TODO Probati bez parametra u konstruktoru
	
	MyAddDialog addDialog;
	
	public NodeAdderAction(MyAddDialog addDialog) {
		this.addDialog = addDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object cvor = MyJTree.getSelected();
		
		if(cvor instanceof Workspace) {
			Kompanija k = new Kompanija(null, addDialog.getTf_ime().getText(), addDialog.getTf_opis().getText());
			FirstView.getInstance().getWorkspaceModel().addCvor(k);
			AddNodeCommand anc = new AddNodeCommand(k);
			FirstView.getInstance().getCommandManager().addCommand(anc);
		}else if(cvor instanceof Kompanija) {
			Kompanija kompanija = (Kompanija)cvor;
			Proizvod p = new Proizvod(kompanija, addDialog.getTf_ime().getText(), addDialog.getTf_opis().getText());
			kompanija.addCvor(p);
			AddNodeCommand anc = new AddNodeCommand(p);
			FirstView.getInstance().getCommandManager().addCommand(anc);
		}else if(cvor instanceof Proizvod) {
			Proizvod proizvod = (Proizvod)cvor;
			if(addDialog.getModelType().equals(ModelType.MODUL)) {
				Modul m = new Modul(proizvod, addDialog.getTf_ime().getText(), addDialog.getTf_opis().getText());
				proizvod.addCvor(m, ModelType.MODUL);
				AddNodeCommand anc = new AddNodeCommand(m);
				FirstView.getInstance().getCommandManager().addCommand(anc);
			}else if(addDialog.getModelType().equals(ModelType.PARAMETER)) {
				Parametar p = new Parametar(proizvod, addDialog.getTf_ime().getText(), addDialog.getTf_opis().getText(), (ParametarType)addDialog.getComboBox().getSelectedItem());
				proizvod.addCvor(p, ModelType.PARAMETER);
				AddNodeCommand anc = new AddNodeCommand(p);
				FirstView.getInstance().getCommandManager().addCommand(anc);
			}
		}else if(cvor instanceof Modul) {
			Modul modul = (Modul)cvor;
			Parametar p = new Parametar(modul, addDialog.getTf_ime().getText(), addDialog.getTf_opis().getText(), (ParametarType)addDialog.getComboBox().getSelectedItem());
			modul.addCvor(p);
			AddNodeCommand anc = new AddNodeCommand(p);
			FirstView.getInstance().getCommandManager().addCommand(anc);
		}else if(cvor instanceof Parametar) {
			Parametar parametar = (Parametar)cvor;
			Cvor roditelj = parametar.getRoditelj();
			if(roditelj instanceof Modul) {
				Modul modul = (Modul)roditelj;
				Parametar p = new Parametar(modul, addDialog.getTf_ime().getText(), addDialog.getTf_opis().getText(), (ParametarType)addDialog.getComboBox().getSelectedItem());
				modul.addCvor(p);
				AddNodeCommand anc = new AddNodeCommand(p);
				FirstView.getInstance().getCommandManager().addCommand(anc);
			}else if(roditelj instanceof Proizvod) {
				Proizvod proizvod = (Proizvod)roditelj;
				Parametar p = new Parametar(proizvod, addDialog.getTf_ime().getText(), addDialog.getTf_opis().getText(), (ParametarType)addDialog.getComboBox().getSelectedItem());
				proizvod.addCvor(p, ModelType.PARAMETER);
				AddNodeCommand anc = new AddNodeCommand(p);
				FirstView.getInstance().getCommandManager().addCommand(anc);
			}
		}else {
			Kompanija k = new Kompanija(null, addDialog.getTf_ime().getText(), addDialog.getTf_opis().getText());
			FirstView.getInstance().getWorkspaceModel().addCvor(k);
			AddNodeCommand anc = new AddNodeCommand(k);
			FirstView.getInstance().getCommandManager().addCommand(anc);
		}
		SwingUtilities.updateComponentTreeUI(FirstView.getInstance().getMyJTree());
		addDialog.dispose();
		Baza.setChanged(true);
	}
	
}
