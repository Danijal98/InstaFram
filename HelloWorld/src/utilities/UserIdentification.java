package utilities;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import model.User;

public class UserIdentification {
	
	private static UserIdentification instance;
	private HashMap<String, User> hashMap;
	private static final String FILE_PATH = "users_data.txt";
	
	private UserIdentification() {
		hashMap = new HashMap<>();
		loadFile();
	}
	
	public static UserIdentification getInstance() {
		if(instance == null)
			instance = new UserIdentification();
		return instance;
	}
	
	private void loadFile() {
		ObjectInputStream stream;
		File file = new File(FILE_PATH);
		
		try {
			stream = new ObjectInputStream(new FileInputStream(file));
			hashMap = (HashMap<String, User>)stream.readObject();
		} catch (EOFException e) {
			System.err.println("Fajl je prazan");
			return;
		} catch (Exception e) {
			System.err.println("Greska u ucitavanju korisnika!");
			e.printStackTrace();
			return;
		}
		
	}
	
	public void saveFile() {
		ObjectOutputStream stream;
		File file;
		
		try {
			file = new File(FILE_PATH);
			stream = new ObjectOutputStream(new FileOutputStream(file));
			stream.writeObject(hashMap);
		} catch (FileNotFoundException e) {
			System.err.println("Fajl users_data.txt nije pronadjen!");
		} catch (Exception e) {
			System.err.println("Greska u cuvanju korisnika!");
			e.printStackTrace();
		}
		
	}

	public HashMap<String, User> getHashMap() {
		return hashMap;
	}

}
