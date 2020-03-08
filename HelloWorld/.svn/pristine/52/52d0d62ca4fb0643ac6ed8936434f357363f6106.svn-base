package view_login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import actions.ActionManager;
import model.User;
import utilities.Baza;
import utilities.UserIdentification;
import utilities.UserType;
import view.FirstView;

public class Register extends JFrame {

	private JLabel label;
	private JTextField tf_username;
	private JPasswordField tf_password;
	private JComboBox<UserType> box;
	private JButton btnRegister;
	
	public Register() {
		setTitle("Register");
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2,2,2,2);
		JLabel usernameLabel = new JLabel("Username:");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(usernameLabel,gbc);
		tf_username = new JTextField(10);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(tf_username,gbc);
		JLabel passwordLabel = new JLabel("Password:");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(passwordLabel,gbc);
		tf_password = new JPasswordField(10);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(tf_password,gbc);
		JLabel boxLabel = new JLabel("User type: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(boxLabel,gbc);
		box = new JComboBox<>();
		box.addItem(UserType.USER);
		box.addItem(UserType.ADMIN);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(box, gbc);
		JLabel spacer = new JLabel(" ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(spacer,gbc);
		btnRegister = new JButton("Register");
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(btnRegister,gbc);
		label = new JLabel("Izabrano ime vec postoji!");
		label.setForeground(Color.RED);
		label.setVisible(false);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(label,gbc);
		getContentPane().add(panel);
		setMinimumSize(new Dimension(250, 150));
		setLocationRelativeTo(null);
		setResizable(false);
		pack();
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkAllFields()) {
					User user = new User((UserType)box.getSelectedItem(), tf_username.getText().trim());
					UserIdentification.getInstance().getHashMap().put(String.valueOf(tf_password.getPassword()), user);
					UserIdentification.getInstance().saveFile();
					Register.this.dispose();
					LogIn.getInstance().getTf_username().setText(tf_username.getText());
					LogIn.getInstance().getTf_password().setText("");
					LogIn.getInstance().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(Register.this, "Niste popunili sva polja!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Register.this.dispose();
				LogIn.getInstance().setVisible(true);
			}
		});
		
	}
	
	private boolean checkAllFields() {
		if(tf_username.getText().isEmpty() || String.valueOf(tf_password.getPassword()).isEmpty()) {
			return false;
		}
		return true;
	}
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextField getTf_username() {
		return tf_username;
	}

	public void setTf_username(JTextField tf_username) {
		this.tf_username = tf_username;
	}

	public JPasswordField getTf_password() {
		return tf_password;
	}

	public void setTf_password(JPasswordField tf_password) {
		this.tf_password = tf_password;
	}

//	public JPasswordField getTf_password2() {
//		return tf_password2;
//	}
//
//	public void setTf_password2(JPasswordField tf_password2) {
//		this.tf_password2 = tf_password2;
//	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}
	
}
