package view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Cvor;


public class MyWorkSpace1 extends JPanel{
	
	private static MyWorkSpace1 instance;
	private JTextArea textArea = new JTextArea();
	private Cvor cvor;
	
	/**
	 * Workspace gore - sadrzi toolbar i text area za edit opisa selektovanog cvora
	 */
	private MyWorkSpace1() {
		//init
//		MyToolBar myToolBar = new MyToolBar();
		this.setLayout(new BorderLayout());
//		this.add(myToolBar, BorderLayout.NORTH);
		this.add(textArea, BorderLayout.CENTER);
		textArea.setEditable(false);
	
		//osluskuje dodire tastature i tako menja tekst
		textArea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				String data = textArea.getText();
				cvor.setOpis(data);
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
	}

	public static MyWorkSpace1 getInstance() {
		if(instance == null)
			instance = new MyWorkSpace1();
		return instance;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public Cvor getCvor() {
		return cvor;
	}

	public void setCvor(Cvor cvor) {
		this.cvor = cvor;
	}

}
