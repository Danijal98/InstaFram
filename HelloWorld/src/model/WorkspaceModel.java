package model;

import java.util.ArrayList;

import javax.swing.tree.DefaultTreeModel;

public class WorkspaceModel extends DefaultTreeModel{
	
	private static Workspace workspace = new Workspace();
	
	public WorkspaceModel() {
		super(workspace);
	}
	
	public ArrayList<Cvor> getCvorovi() {
        return ((Workspace)getRoot()).getCvorovi();
    }
	
	public void deleteCvor(Kompanija project) {
        ((Workspace)getRoot()).deleteCvor(project);
    }
	
	public void addCvor(Kompanija project){
		((Workspace)getRoot()).addCvor(project);
	}

	public static Workspace getWorkspace() {
		return workspace;
	}

	public static void setWorkspace(Workspace workspace) {
		WorkspaceModel.workspace = workspace;
	}
	
	/**
	 * Pozvati ovu metodu kada se promeni root workspace. Apdejtuje trenutni root Tree Modela
	 */
	public void updateRoot() {
		setRoot(workspace);
	}

}
