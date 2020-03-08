package model;

import utilities.ModelType;
import utilities.ParametarType;

public class Parametar extends Cvor{
	
	private ParametarType type;
	private String str;
	private boolean universal;

	public Parametar(Cvor roditelj, String ime, String opis, ParametarType type) {
		super(roditelj, ime, opis);
		this.type = type;
	}
	
	public Parametar(Cvor cvor, ParametarType type) {
		super(cvor);
		this.type = type;
	}

	@Override
	public void addCvor(Cvor cvor) {}

	public ParametarType getType() {
		return type;
	}

	public void setType(ParametarType type) {
		this.type = type;
	}

	@Override
	public void addCvor(Cvor cvor, ModelType modelType) {}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public boolean isUniversal() {
		return universal;
	}

	public void setUniversal(boolean universal) {
		this.universal = universal;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if(!(obj instanceof Parametar) && obj == null) return false;
//		Parametar parametar = (Parametar)obj;
//		if(parametar.getType().equals(this.type)) return true;
//		else return false;
//	}
	
}
