package view;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Kompanija;
import model.Modul;
import model.Parametar;
import model.Proizvod;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer{

	public WorkspaceTreeCellRendered() {
		super();
	}
	
	public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
                

           if(value instanceof Kompanija) {
        	   setIcon(new ImageIcon("res/company.png"));
           }else if(value instanceof Proizvod) {
        	   setIcon(new ImageIcon("res/product.png"));
           }else if(value instanceof Modul) {
        	   setIcon(new ImageIcon("res/modul.png"));
           }else if(value instanceof Parametar) {
        	   setIcon(new ImageIcon("res/parameter.png"));
           }
           
          return this;
	}
	
}
