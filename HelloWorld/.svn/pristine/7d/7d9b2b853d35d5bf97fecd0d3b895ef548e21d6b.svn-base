package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actions.ActionManager;
import actions.Exit;


public class MyMenuBar extends JMenuBar{

	public MyMenuBar() {
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenu viewMenu = new JMenu("View");
		viewMenu.setMnemonic(KeyEvent.VK_V);
		JMenu toolsMenu = new JMenu("Tools");
		toolsMenu.setMnemonic(KeyEvent.VK_T);
		
		this.add(fileMenu);
		this.add(viewMenu);
		this.add(toolsMenu);
		
		JMenuItem mNew = new JMenuItem("mNew");
		mNew.setMnemonic(KeyEvent.VK_N);
		fileMenu.add(mNew);
		mNew.addActionListener(ActionManager.getInstance().getOpenAddDialog());
		
		fileMenu.addSeparator();
		
		JMenuItem mOpen = new JMenuItem("mOpen");
		JMenuItem mClose = new JMenuItem("mClose");
		JMenuItem mSwitch = new JMenuItem("mSwitch");
		
		fileMenu.add(mOpen);
		mOpen.addActionListener(ActionManager.getInstance().getLoad());
		fileMenu.add(mClose);
		mClose.addActionListener(ActionManager.getInstance().getNodeDeleteAction());
		fileMenu.add(mSwitch);
		
		fileMenu.addSeparator();
		
		JMenuItem mSave = new JMenuItem("mSave");
		JMenuItem mSaveAs = new JMenuItem("mSaveAs");
		
		fileMenu.add(mSave);
		mSave.addActionListener(ActionManager.getInstance().getSave());
		fileMenu.add(mSaveAs);
		mSaveAs.addActionListener(ActionManager.getInstance().getSaveAs());
		
		fileMenu.addSeparator();
		
		JMenu mExport = new JMenu("mExport");
		JMenu mImport = new JMenu("mImport");
		
		JMenuItem mExpToPdf = new JMenuItem("mExpToPdf");
		JMenuItem mExpToMsExcell = new JMenuItem("mExpToMsExcell");
		JMenuItem mExpToMsWord = new JMenuItem("mExpToMsWord");
		
		JMenuItem mImpToPdf = new JMenuItem("mImpToPdf");
		JMenuItem mImpToMsExcell = new JMenuItem("mImpToMsExcell");
		JMenuItem mImpToMsWord = new JMenuItem("mImpToMsWord");
		
		mExport.add(mExpToPdf);
		mExport.add(mExpToMsExcell);
		mExport.add(mExpToMsWord);
		
		mImport.add(mImpToPdf);
		mImport.add(mImpToMsExcell);
		mImport.add(mImpToMsWord);
		
		fileMenu.add(mExport);
		fileMenu.add(mImport);
		
		fileMenu.addSeparator();
		
		JMenuItem mAboutDialog = new JMenuItem("About");
		
		fileMenu.add(mAboutDialog);
		
		mAboutDialog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDialog aboutDialog = new AboutDialog();
				aboutDialog.setVisible(true);
			}
		});
		
		fileMenu.addSeparator();
		
		JMenuItem mExit = new JMenuItem("mExit");
		fileMenu.add(mExit);
	}
	
}
