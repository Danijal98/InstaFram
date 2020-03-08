package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import model.Cvor;
import model.User;
import model.Workspace;
import model.WorkspaceModel;
import view.FirstView;

public class Baza {
	
	private static Baza instance;
	private static String FILE_PATH_SAVE = null;
	private static String FILE_PATH_INSTALL = null;
	private int numOfleafs=0;
	private User user;
	
	/**
	 * Prati promene programa
	 */
	private static boolean changed = false;
	
	
	/**
	 * Rekurzivno trazi listove
	 * @param lista - prosledjena lista cvora
	 * @return void - azurira promenljivu numOfleafs u klasi Baza
	 */
	public void findAllLeafs(ArrayList<Cvor> lista) {
		for(Cvor c: lista) {
			if(c.isLeaf())
				numOfleafs++;
			if(c.getDeca().size()==0) continue;
			findAllLeafs(c.getDeca());
		}
	}
	
	/**
	 * Cuva trenutno stanje u txt formatu koristeci Serializable
	 * @param yes_for_saveAs - true za biranje posebne lokacije, false za default lokaciju koja je poslednji put izabrana
	 */
	public void saveAs(boolean yes_for_saveAs, Object object) {
		ObjectOutputStream stream;
		File file = null;
		String workingDir = System.getProperty("user.dir");
		
		if(!yes_for_saveAs) {
			file = new File(FILE_PATH_SAVE);
		}else {
			JFileChooser fileChooser = new JFileChooser(workingDir);
			fileChooser.setFileFilter(new MyFileFilter());
			fileChooser.showOpenDialog(null);
			file = fileChooser.getSelectedFile();
			if(file != null)
				FILE_PATH_SAVE = file.toString();
		}
		try {
			stream = new ObjectOutputStream(new FileOutputStream(file));
			cuvanje(stream, object);
			stream.close();
			System.out.println("Fajl uspesno sacuvan");
		} catch (Exception e) {
			System.err.println("Greska u cuvanju fajla");
		}
		
		changed = false;
	}
	
	public void export(Object obj) {
		File file = null;
		ObjectOutputStream stream;
		String workingDir = System.getProperty("user.dir");
		
		JFileChooser fileChooser = new JFileChooser(workingDir);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("Folder instalacije");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.showOpenDialog(null);
		
		file = fileChooser.getSelectedFile();
		
		if(file == null) {
			System.out.println("Nije izabrana putanja");
			return;
		}
		
		String path = file.getAbsolutePath()+"\\NoviFolder";
		new File(path).mkdirs();
		FILE_PATH_INSTALL = path + "\\instalirano.txt";

		try {
			stream = new ObjectOutputStream(new FileOutputStream(new File(path+"\\Proizvod")));
			cuvanje(stream, obj);
			stream.close();
			System.out.println("Fajl uspesno exportovan");
		} catch (Exception e) {
			System.err.println("Greska u exportovanju fajla");
		}
		
	}
	
	/**
	 * Cuva objekat u fajl koristeci Serializable
	 * @param stream - stream koji ce se koristiti
	 * @param object - objekat za cuvanje
	 */
	public void cuvanje(ObjectOutputStream stream, Object object) {
		try {
			stream.writeObject(object);
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	/**
	 * Ucitavanje iz txt fajla koji je napravljen pomocu Serializable
	 */
	public void LoadFromFile() {
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
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (NullPointerException e) {
			System.err.println("Fajl nije izabran!");
			return;
		}
		
		Workspace workspace = null;
		
		try {
			workspace = (Workspace) os.readObject();
			os.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		WorkspaceModel.setWorkspace(workspace);
		FirstView.getInstance().getWorkspaceModel().updateRoot();
		FirstView.getInstance().getWorkspaceModel().reload();
		FILE_PATH_SAVE = file.toString();
		changed = true;
	}
	
	public int getNumOfleafs() {
		return numOfleafs;
	}

	public void setNumOfleafs(int numOfleafs) {
		this.numOfleafs = numOfleafs;
	}

	public static Baza getInstance() {
		if(instance == null)
			instance = new Baza();
		return instance;
	}

	public static String getFILE_PATH_SAVE() {
		return FILE_PATH_SAVE;
	}

	public static void setFILE_PATH_SAVE(String fILE_PATH_SAVE) {
		FILE_PATH_SAVE = fILE_PATH_SAVE;
	}

	public static boolean isChanged() {
		return changed;
	}

	public static void setChanged(boolean changed) {
		Baza.changed = changed;
	}

	public User getUser() {
		return user;
	}

	public static String getFILE_PATH_INSTALL() {
		return FILE_PATH_INSTALL;
	}

	public static void setFILE_PATH_INSTALL(String fILE_PATH_INSTALL) {
		FILE_PATH_INSTALL = fILE_PATH_INSTALL;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
