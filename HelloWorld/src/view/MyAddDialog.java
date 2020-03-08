package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.NodeAdderAction;
import model.Cvor;
import model.Modul;
import model.Parametar;
import model.Proizvod;
import model.Workspace;
import utilities.ModelType;
import utilities.ParametarList;
import utilities.ParametarType;

public class MyAddDialog extends JDialog {
	
	private ArrayList<String> nazivi = new ArrayList<>();
	private Object selectedNode;
	private JLabel label;
	private JTextField tf_ime;
	private JTextField tf_opis;
	private JComboBox<ParametarType> comboBox;
	private JButton btnOk;
	private JButton btnCancel;
	private ModelType modelType;
	private Frame parent;
	   
	public MyAddDialog(Frame parent) {
		super(parent,"Dodavanje Komponente",true);
		this.parent = parent;
		selectedNode = MyJTree.getSelected();
		
		if(selectedNode instanceof Modul) {
			parametarView();
			setVisible(true);
		}else if(selectedNode instanceof Proizvod){
			Object[] options = {"Parametar","Modul","Cancel"};
			int answer = JOptionPane.showOptionDialog(this, "Da li zelite da dodate Parametar ili Modul?", "Dodavanje",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
			if(answer == 0) {
				parametarView();
				modelType = ModelType.PARAMETER;
				setVisible(true);
			}else if(answer == 1) {
				mainView();
				modelType = ModelType.MODUL;
				setVisible(true);
			}else {
				MyAddDialog.this.dispose();
			}
		}else if(selectedNode instanceof Parametar) {
			parametarView();
			setVisible(true);
		}else {
			mainView();
			setVisible(true);
		}
		
	}
	
	/**
	 * Prozor koji sadrzi textField naziv i opis, button ok i cancel. 
	 * Namenjen za kompanije, proizvode i module
	 */
	private void mainView() {
		Point loc = parent.getLocation();
		setLocation(loc.x+80,loc.y+80);
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2,2,2,2);
		JLabel nameLabel = new JLabel("Ime:");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(nameLabel,gbc);
		tf_ime = new JTextField(10);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(tf_ime,gbc);
		JLabel descLabel = new JLabel("Opis:");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(descLabel,gbc);
		tf_opis = new JTextField(10);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(tf_opis,gbc);
		JLabel spacer = new JLabel(" ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(spacer,gbc);
		btnOk = new JButton("Ok");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(btnOk,gbc);
		btnCancel = new JButton("Cancel");
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(btnCancel,gbc);
		label = new JLabel("Izabrano ime vec postoji!");
		label.setForeground(Color.RED);
		label.setVisible(false);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(label,gbc);
		getContentPane().add(panel);
		setMinimumSize(new Dimension(250, 150));
		pack();
		
		viewActions();
	}
	
	/**
	 * Prozor koji sadrzi textField naziv i opis, comboBox sa tipom parametra, button ok i cancel.
	 * Namenjen za izbor parametra
	 */
	private void parametarView() {
		Point loc = parent.getLocation();
		setLocation(loc.x+80,loc.y+80);
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2,2,2,2);
		JLabel nameLabel = new JLabel("Ime Parametra:");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(nameLabel,gbc);
		tf_ime = new JTextField(10);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(tf_ime,gbc);
		JLabel descLabel = new JLabel("Opis:");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(descLabel,gbc);
		tf_opis = new JTextField(10);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(tf_opis,gbc);
		JLabel typeLabel = new JLabel("Tip parametra: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(typeLabel,gbc);
		comboBox = new JComboBox<ParametarType>();
		ParametarList list = new ParametarList();
		for(ParametarType param: list) {
			comboBox.addItem(param);
		}
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(comboBox,gbc);
		JLabel spacer = new JLabel(" ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(spacer,gbc);
		btnOk = new JButton("Ok");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(btnOk,gbc);
		btnCancel = new JButton("Cancel");
		gbc.gridx = 1;
		gbc.gridy = 5;
		panel.add(btnCancel,gbc);
		label = new JLabel("Izabrano ime vec postoji!");
		label.setForeground(Color.RED);
		label.setVisible(false);
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(label,gbc);
		getContentPane().add(panel);
		setMinimumSize(new Dimension(300, 200));
		pack();
		
		viewActions();
	}
	
	/**
	 * Proverava da li unostite ime koje vec postoji i zadaje akcije za dugme ok i cancel.
	 */
	private void viewActions() {
		//provera da li isto ime vec postoji u tom nivou
		if(selectedNode instanceof Cvor) {
			for(Cvor cvor: ((Cvor) selectedNode).getDeca()) {
				nazivi.add(cvor.getIme());
			}
		}else if(selectedNode instanceof Workspace) {
			//TODO izbrisati kada se workspace zameni sa Cvor
			for(Cvor cvor: ((Workspace) selectedNode).getCvorovi()) {
				nazivi.add(cvor.getIme());
			}
		}else if(selectedNode == null) {
			for(Cvor cvor: FirstView.getInstance().getWorkspaceModel().getCvorovi()) {
				nazivi.add(cvor.getIme());
			}
		}
		
		tf_ime.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				String ukucano = tf_ime.getText();
				if(nazivi.contains(ukucano)) {
					label.setVisible(true);
					btnOk.setEnabled(false);
				}else {
					label.setVisible(false);
					btnOk.setEnabled(true);
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
      
		//btn actions
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyAddDialog.this.dispose();
			}
		});
	    
	    btnOk.addActionListener(new NodeAdderAction(this));
	}

	public JTextField getTf_ime() {
		return tf_ime;
	}

	public void setTf_ime(JTextField tf_ime) {
		this.tf_ime = tf_ime;
	}

	public JTextField getTf_opis() {
		return tf_opis;
	}

	public void setTf_opis(JTextField tf_opis) {
		this.tf_opis = tf_opis;
	}

	public ArrayList<String> getNazivi() {
		return nazivi;
	}

	public void setNazivi(ArrayList<String> nazivi) {
		this.nazivi = nazivi;
	}

	public Object getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(Object selectedNode) {
		this.selectedNode = selectedNode;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JComboBox<ParametarType> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<ParametarType> comboBox) {
		this.comboBox = comboBox;
	}

	public Frame getParent() {
		return parent;
	}

	public void setParent(Frame parent) {
		this.parent = parent;
	}

	public ModelType getModelType() {
		return modelType;
	}

	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

}
