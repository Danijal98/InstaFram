package view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.ActionManager;
import model.Cvor;
import model.Parametar;
import utilities.ParametarType;

public class MyWorkSpace2 extends JPanel implements Observer{
	
	private static MyWorkSpace2 instance;
	
	//levo
	private JLabel lb_naziv = new JLabel();
	private JLabel lb_sadrzaj = new JLabel();
	private JLabel lb_roditelj = new JLabel();
	private JLabel lb_br_direktnih_potomaka = new JLabel();
	private JLabel lb_br_listova = new JLabel();
	private String opis = new String();
	private Cvor cvor;
	private JPanel paneLeft = null;
	private JLabel lb_tip = new JLabel();
	private JButton btn_edit = new JButton("Edit");
	
	/**
	 * Workspace dole - sadrzi sve informacije selektovanog cvora cvora
	 */
	private MyWorkSpace2() {
		//init
		BorderLayout layout = new BorderLayout();
		paneLeft = new JPanel();
		paneLeft.setLayout(new BoxLayout(paneLeft, BoxLayout.Y_AXIS));
		setLayout(layout);
		paneLeft.add(lb_naziv);
		paneLeft.add(Box.createRigidArea(new Dimension(0, 10)));
		paneLeft.add(lb_sadrzaj);
		paneLeft.add(Box.createRigidArea(new Dimension(0, 10)));
		paneLeft.add(lb_roditelj);
		paneLeft.add(Box.createRigidArea(new Dimension(0, 10)));
		paneLeft.add(lb_br_direktnih_potomaka);
		paneLeft.add(Box.createRigidArea(new Dimension(0, 10)));
		paneLeft.add(lb_br_listova);
		paneLeft.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(paneLeft, BorderLayout.LINE_START);
		btn_edit.addActionListener(ActionManager.getInstance().getOpenParamEdit());
		
		//fonts
		lb_naziv.setFont(new Font("Serif", Font.PLAIN, 18));
		lb_sadrzaj.setFont(new Font("Serif", Font.PLAIN, 18));
		lb_roditelj.setFont(new Font("Serif", Font.PLAIN, 18));
		lb_br_direktnih_potomaka.setFont(new Font("Serif", Font.PLAIN, 18));
		lb_br_listova.setFont(new Font("Serif", Font.PLAIN, 18));
		
		paneLeft.setVisible(false);
	}
	
	public void leftPaneParamDo() {
		lb_tip.setFont(new Font("Serif", Font.PLAIN, 18));
		paneLeft.add(lb_tip);
		paneLeft.add(btn_edit);
		paneLeft.revalidate();
		paneLeft.repaint();
	}

	public void leftPaneParamUndo() {
		paneLeft.remove(lb_tip);
		paneLeft.remove(btn_edit);
		paneLeft.revalidate();
		paneLeft.repaint();
	}
	
	public static MyWorkSpace2 getInstance() {
		if(instance == null)
			instance = new MyWorkSpace2();
		return instance;
	}
	
	public JPanel getPaneLeft() {
		return paneLeft;
	}

	public void setPaneLeft(JPanel paneLeft) {
		this.paneLeft = paneLeft;
	}

	public Cvor getCvor() {
		return cvor;
	}

	public void setCvor(Cvor cvor) {
		this.cvor = cvor;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public JLabel getLb_tip() {
		return lb_tip;
	}

	public void setLb_tip(JLabel lb_tip) {
		this.lb_tip = lb_tip;
	}

	public JButton getBtn_edit() {
		return btn_edit;
	}

	public void setBtn_edit(JButton btn_edit) {
		this.btn_edit = btn_edit;
	}

	public JPanel getLabelPane() {
		return paneLeft;
	}

	public void setLabelPane(JPanel labelPane) {
		this.paneLeft = labelPane;
	}

	public JLabel getLb_naziv() {
		return lb_naziv;
	}

	public void setLb_naziv(JLabel lb_naziv) {
		this.lb_naziv = lb_naziv;
	}

	public JLabel getLb_sadrzaj() {
		return lb_sadrzaj;
	}

	public void setLb_sadrzaj(JLabel lb_sadrzaj) {
		this.lb_sadrzaj = lb_sadrzaj;
	}

	public JLabel getLb_roditelj() {
		return lb_roditelj;
	}

	public void setLb_roditelj(JLabel lb_roditelj) {
		this.lb_roditelj = lb_roditelj;
	}

	public JLabel getLb_br_direktnih_potomaka() {
		return lb_br_direktnih_potomaka;
	}

	public void setLb_br_direktnih_potomaka(JLabel lb_br_direktnih_potomaka) {
		this.lb_br_direktnih_potomaka = lb_br_direktnih_potomaka;
	}

	public JLabel getLb_br_listova() {
		return lb_br_listova;
	}

	public void setLb_br_listova(JLabel lb_br_listova) {
		this.lb_br_listova = lb_br_listova;
	}

	@Override
	public void update(Observable o, Object data) {
		opis = (String)data;
		lb_sadrzaj.setText("Sadrzaj: "+opis);
	}
	
}
