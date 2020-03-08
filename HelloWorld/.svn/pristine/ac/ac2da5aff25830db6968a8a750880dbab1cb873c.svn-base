package view_login;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.User;
import utilities.Baza;
import utilities.UserIdentification;
import view.FirstView;

public class LogIn extends JFrame {
	
	private static LogIn instance;
	private JLabel label;
	private JTextField tf_username;
	private JPasswordField tf_password;
	private JButton btnLogIn;
	private JButton btnRegister;
	
	private LogIn() {
		setTitle("Log In");
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2,2,2,2);
		JLabel nameLabel = new JLabel("Username:");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(nameLabel,gbc);
		tf_username = new JTextField(10);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(tf_username,gbc);
		JLabel descLabel = new JLabel("Password:");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(descLabel,gbc);
		tf_password = new JPasswordField(10);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(tf_password,gbc);
		JLabel spacer = new JLabel(" ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(spacer,gbc);
		btnLogIn = new JButton("Log In");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(btnLogIn,gbc);
		btnRegister = new JButton("Register");
		gbc.gridx = 1;
		gbc.gridy = 3;
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
		
		//btn actions
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
				LogIn.this.setVisible(false);
			}
		});
		
		btnLogIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkAllFields()) {
					String username = tf_username.getText().trim();
					User user = null;
					user = UserIdentification.getInstance().getHashMap().get(String.valueOf(tf_password.getPassword()));
					if(user == null) {
						errorMessage();
						System.out.println("user == null");
					}else {
						if(!user.getUsername().equals(username)) {
							errorMessage();
							System.out.println("nije dobar username za sifru");
						}else {
							LogIn.this.dispose();
							Baza.getInstance().setUser(user);
							FirstView.getInstance().setVisible(true);
						}
					}
				}else {
					JOptionPane.showMessageDialog(LogIn.this, "Niste popunili sva polja!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
	}
	
	private void errorMessage() {
		JOptionPane.showMessageDialog(LogIn.this, "Username ili password nije dobar!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
	}
	
	private boolean checkAllFields() {
		if(tf_username.getText().isEmpty() || String.valueOf(tf_password.getPassword()).isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static LogIn getInstance() {
		if(instance == null)
			instance = new LogIn();
		return instance;
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

}
