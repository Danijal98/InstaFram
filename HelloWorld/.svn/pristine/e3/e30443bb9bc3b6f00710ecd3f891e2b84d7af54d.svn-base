package view;


import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import listeners.PopClickListener;
import model.Cvor;
import model.Kompanija;
import model.WorkspaceModel;

public class MyJTree extends JTree implements Scrollable{
	

	public MyJTree() {
		this.setPreferredSize(new Dimension(150, 100));
	    setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRendered());
	    setEditable(true);
	    addMouseListener(new PopClickListener());
	}
	
	public ArrayList<Cvor> getProjects() {
        return ((WorkspaceModel)getModel()).getCvorovi();
    }
	
	//TODO 
	public void deleteProject(Kompanija project) {
        ((WorkspaceModel)getModel()).deleteCvor(project);
        SwingUtilities.updateComponentTreeUI(this);
    }
	
	public void addProject(Kompanija project){
		((WorkspaceModel)getModel()).addCvor(project);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	/**
	 * @return Selektovani objekat u stablu, null ako nista nije selektovano
	 */
	public static Object getSelected() {
		TreePath path = FirstView.getInstance().getMyJTree().getSelectionPath();
		if(path != null) {
			Object obj = path.getLastPathComponent();
			return obj;
		}
		return null;
	}
	
	/**
	 * Prolazi kroz sve selektovane cvorove
	 * @return ArrayList(Object) selektovanih cvorova, ako postoje, u suprotnom null
	 */
	public static ArrayList<Object> getSelectedNodes() {
		TreePath[] treePaths = FirstView.getInstance().getMyJTree().getSelectionPaths();
		ArrayList<Object> selectedNodes = new ArrayList<>();
		if(treePaths == null)
			return null;
		for(int i=0;i<treePaths.length;i++) {
			selectedNodes.add(treePaths[i].getLastPathComponent());
		}
		return selectedNodes;
	}
	
}
