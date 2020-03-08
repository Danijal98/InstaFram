package listeners;

import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.Modul;
import model.Parametar;
import model.Proizvod;
import view.FirstView;
import view.MyJTree;
import view.MyPopUpMenu;

public class PopClickListener extends MouseAdapter{
	
	@Override
	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

	@Override
    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
    	Object selectedNode = MyJTree.getSelected();
    	ArrayList<Object> selectedNodes = MyJTree.getSelectedNodes();
    	if(selectedNodes == null)
    		return;
    	boolean flag = true;
    	for(Object node: selectedNodes) {
    		if(!(node instanceof Parametar)) {
    			flag = false;
    			break;
    		}
    	}
        MyPopUpMenu menu = new MyPopUpMenu();
        if(flag == false) {
        	menu.getCopy().setEnabled(false);
        	menu.getCut().setEnabled(false);
        }
        Transferable clipboardContent = FirstView.getInstance().getClipboard().getContents(FirstView.getInstance());
        if(clipboardContent == null || (!(selectedNode instanceof Proizvod) && !(selectedNode instanceof Modul) && !(selectedNode instanceof Parametar))) {
        	menu.getPaste().setEnabled(false);
        }
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
	
}
