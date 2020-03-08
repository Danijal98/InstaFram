package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;


public class Workspace implements TreeNode, Serializable{
	//TODO zameniti sa Cvor
	
	private ArrayList<Cvor> kompanije = new ArrayList<>();
	
	public Workspace() {
		super();
	}
	
	@Override
	public boolean getAllowsChildren() {
		return false;
	}
	
	@Override
	public Enumeration children() {
		return (Enumeration<Kompanija>) kompanije;
	}
	
	@Override
	public TreeNode getChildAt(int childIndex) {
		return getProject(childIndex);
	}
	
	@Override
	public int getChildCount() {
		return getProjectsCount();
	}
	
	@Override
	public int getIndex(TreeNode node) {
		return getProjectIndex((Kompanija) node);
	}
	
	@Override
	public TreeNode getParent() {
		return null;
	}
	
	@Override
	public boolean isLeaf() {
		return false;
	}
	
	public void deleteCvor(Kompanija node) {
        kompanije.remove(node);
    }
	
	public void addCvor(Kompanija node){
		kompanije.add(node);
		if(node.getIme().equals(""))
			node.setIme("Kompanija "+kompanije.size());
		else
			node.setIme(node.getIme());
	}
	
	public Cvor getProject(int index) {
		return kompanije.get(index);
	}	
	
	public int getProjectIndex(Kompanija project) {
		return kompanije.indexOf(project);
	}
	
	public int getProjectsCount() {
		return kompanije.size();
	}
	
	@Override
	public String toString() {
		return "Workspace";
	}
	
	public ArrayList<Cvor> getCvorovi() {
		return kompanije;
	}
	
	public void setCvorovi(ArrayList<Cvor> cvorovi) {
		this.kompanije = cvorovi;
	}
	
}