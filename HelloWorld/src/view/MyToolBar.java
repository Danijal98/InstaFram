package view;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import actions.ActionManager;

public class MyToolBar extends JToolBar{
	

	public MyToolBar() {
		JButton jBtnNew = new JButton();
		JButton jBtnOpen = new JButton();
		JButton jBtnClose = new JButton();
		JButton jBtnEdit = new JButton();
		JButton jBtnSave = new JButton();
		JButton jBtnSaveAs = new JButton();
		JButton jBtnExit = new JButton();
		JButton jBtnUndo = new JButton();
		JButton jBtnRedo = new JButton();
		JButton jBtnImport = new JButton();
		JButton jBtnExport = new JButton();
	
		this.add(jBtnNew);
		jBtnNew.addActionListener(ActionManager.getInstance().getOpenAddDialog());
		jBtnNew.setIcon(new ImageIcon("res/new.png"));
		jBtnNew.setToolTipText("New");
		this.add(jBtnOpen);
		jBtnOpen.addActionListener(ActionManager.getInstance().getLoad());
		jBtnOpen.setIcon(new ImageIcon("res/open.png"));
		jBtnOpen.setToolTipText("Open");
		this.add(jBtnClose);
		jBtnClose.addActionListener(ActionManager.getInstance().getNodeDeleteAction());
		jBtnClose.setIcon(new ImageIcon("res/close.png"));
		jBtnClose.setToolTipText("Close");
		this.add(jBtnEdit);
		jBtnEdit.addActionListener(ActionManager.getInstance().getEdit());
		jBtnEdit.setIcon(new ImageIcon("res/edit.png"));
		jBtnEdit.setToolTipText("Edit");
		
		this.addSeparator();
		
		this.add(jBtnUndo);
		jBtnUndo.addActionListener(ActionManager.getInstance().getUndo());
		jBtnUndo.setIcon(new ImageIcon("res/undo.png"));
		jBtnUndo.setToolTipText("Undo");
		this.add(jBtnRedo);
		//TODO
		jBtnRedo.addActionListener(ActionManager.getInstance().getRedo());
		jBtnRedo.setIcon(new ImageIcon("res/redo.png"));
		jBtnRedo.setToolTipText("Redo");
		this.addSeparator();
		
		this.add(jBtnSave);
		jBtnSave.addActionListener(ActionManager.getInstance().getSave());
		jBtnSave.setIcon(new ImageIcon("res/save.png"));
		jBtnSave.setToolTipText("Save");
		this.add(jBtnSaveAs);
		jBtnSaveAs.addActionListener(ActionManager.getInstance().getSaveAs());
		jBtnSaveAs.setIcon(new ImageIcon("res/saveAs.png"));
		jBtnSaveAs.setToolTipText("Save As");
		
		this.addSeparator();
		
		this.add(jBtnExit);
		jBtnExit.addActionListener(ActionManager.getInstance().getClose());
		jBtnExit.setIcon(new ImageIcon("res/exit.png"));
		jBtnExit.setToolTipText("Exit");
		
		this.add(Box.createHorizontalGlue());
		
		this.add(jBtnImport);
		//TODO
		jBtnImport.addActionListener(ActionManager.getInstance().getImportAction());
		jBtnImport.setIcon(new ImageIcon("res/import.png"));
		jBtnImport.setToolTipText("Import");
		this.add(jBtnExport);
		jBtnExport.addActionListener(ActionManager.getInstance().getExport());
		jBtnExport.setIcon(new ImageIcon("res/export.png"));
		jBtnExport.setToolTipText("Export");
		
		this.addSeparator();
		
		setFloatable(true);
		setRollover(true);
	
	}
	
}
