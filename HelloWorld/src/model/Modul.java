package model;

import utilities.ModelType;

public class Modul extends Cvor{

	public Modul(Cvor roditelj, String ime, String opis) {
		super(roditelj, ime, opis);
	}

	@Override
	public void addCvor(Cvor cvor) {
		this.getDeca().add(cvor);
		if(cvor.getIme().equals(""))
			cvor.setIme("Parametar " + this.getDeca().size());
		else
			cvor.setIme(cvor.getIme());
	}

	@Override
	public void addCvor(Cvor cvor, ModelType modelType) {}


}
