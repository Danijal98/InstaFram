package model;

import utilities.ModelType;

public class Proizvod extends Cvor{

	public Proizvod(Cvor roditelj, String ime, String opis) {
		super(roditelj, ime, opis);
	}

	@Override
	public void addCvor(Cvor cvor, ModelType modelType) {
		this.getDeca().add(cvor);
		if(modelType.equals(ModelType.MODUL)) {
			if(cvor.getIme().equals(""))
				cvor.setIme("Modul " + this.getDeca().size());
			else
				cvor.setIme(cvor.getIme());
		}else {
			if(cvor.getIme().equals(""))
				cvor.setIme("Parametar " + this.getDeca().size());
			else
				cvor.setIme(cvor.getIme());
		}
	}

	@Override
	public void addCvor(Cvor cvor) {}


}
