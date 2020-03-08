package actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.Cvor;
import model.Parametar;
import model.Proizvod;
import utilities.Baza;
import utilities.MyFileFilter;
import utilities.ParametarType;
import view.FirstView;
import view_installation.InstallationWizard;

public class Import extends AbstractAction{

	private ArrayList<Parametar> parametri;
	private ArrayList<Parametar> parametri2;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Proizvod proizvod = null;
		
		proizvod = loadProizvod();
		if(proizvod == null) {
			JOptionPane.showMessageDialog(FirstView.getInstance(), "Za instalaciju je moguce importovati samo proizvod!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		parametri = new ArrayList<>();
		parametri2 = new ArrayList<>();
		findAllParam(proizvod.getDeca());
		
		InstallationWizard installationWizard = new InstallationWizard(parametri, parametri2);
		installationWizard.setVisible(true);
	}
	
	public void findAllParam(ArrayList<Cvor> lista) {
		for(Cvor c: lista) {
			if(c.isLeaf() && (c instanceof Parametar)) {
				if(((Parametar)c).getType().equals(ParametarType.LOOK_AND_FEEL) || ((Parametar)c).getType().equals(ParametarType.LOGO))
					parametri2.add((Parametar)c);
				else
					parametri.add((Parametar)c);
			}
			if(c.getDeca().size()==0) continue;
			findAllParam(c.getDeca());
		}
	}
	
	
	private Proizvod loadProizvod() {
		File file = null;
		String workingDir = System.getProperty("user.dir");
		JFileChooser fileChooser = new JFileChooser(workingDir);
		fileChooser.setFileFilter(new MyFileFilter());
		fileChooser.showOpenDialog(null);
		file = fileChooser.getSelectedFile();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.err.println("Nije nadjen nijedan fajl");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			System.err.println("Fajl nije izabran!");
			return null;
		}
		
		Proizvod proizvod = null;
		
		try {
			proizvod = (Proizvod) os.readObject();
			os.close();
		} catch (Exception e) {
			System.err.println("Greska kod import ucitavanja fajla");
			e.printStackTrace();
		}
		
		return proizvod;
	}

}
