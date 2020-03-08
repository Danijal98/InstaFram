package model;

import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import commandPattern.AddNodeCommand;
import observable.MessageObservable;
import utilities.Baza;
import utilities.ModelType;
import view.FirstView;

abstract public class Cvor extends MessageObservable implements TreeNode, Serializable{
	
	private Cvor roditelj;
	private String str_roditelj;
	private String ime;
	private String opis;
	private ArrayList<Cvor> deca = new ArrayList<>();
	

	public Cvor(Cvor roditelj, String ime, String opis) {
		this.roditelj = roditelj;
		this.ime = ime;
		this.opis = opis;
	}
	
	public Cvor(Cvor cvor) {
		roditelj = cvor.getRoditelj();
		ime = new String(cvor.getIme());
		opis = new String(cvor.getOpis());
	}
	
	abstract public void addCvor(Cvor cvor);
	abstract public void addCvor(Cvor cvor, ModelType modelType);
	
	public void deleteCvor(Cvor cvor) {
		deca.remove(cvor);
	}
	
	@Override
	public Enumeration<Cvor> children() {
		return (Enumeration<Cvor>)deca;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return deca.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return deca.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return deca.indexOf((Cvor)node);
	}

	@Override
	public TreeNode getParent() {
		return roditelj;
	}

	@Override
	public boolean isLeaf() {
		if(deca.size()==0)
			return true;
		return false;
	}

	public Cvor getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(Cvor roditelj) {
		this.roditelj = roditelj;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
		setChanged();
		notifyObservers(opis);
		Baza.setChanged(true);
	}
	
	@Override
	public String toString() {
		return ime;
	}

	public ArrayList<Cvor> getDeca() {
		return deca;
	}

	public void setDeca(ArrayList<Cvor> deca) {
		this.deca = deca;
	}
	
	public String getStr_roditelj() {
		return str_roditelj;
	}

	public void setStr_roditelj(String str_roditelj) {
		this.str_roditelj = str_roditelj;
	}
	
	public void paste(Transferable clipboardContent) {
		
		if((clipboardContent != null) && (clipboardContent.isDataFlavorSupported(ParametersElementsSelection.elementFlavor))) {
			try {
				ArrayList<Parametar> parametri = (ArrayList<Parametar>)clipboardContent.getTransferData(ParametersElementsSelection.elementFlavor);
				for(Parametar parametar: parametri) {
					Parametar tmp = new Parametar((Parametar)parametar, parametar.getType());
					tmp.setRoditelj(this);
					if(this instanceof Parametar) {
						this.getRoditelj().getDeca().add(new Parametar(tmp, tmp.getType()));
					}else {
						Parametar p = new Parametar(tmp, tmp.getType());
						deca.add(p);
						AddNodeCommand anc = new AddNodeCommand(p);
						FirstView.getInstance().getCommandManager().addCommand(anc);
					}
				}
			} catch (UnsupportedFlavorException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Cvor) && obj == null) return false;
		Cvor cvor = (Cvor)obj;
		if(cvor.getIme().equals(this.getIme())) return true;
		else return false;
	}

}
