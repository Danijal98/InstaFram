package view_param_edit;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Parametar;
import utilities.Baza;
import utilities.LookType;
import utilities.ParametarType;
import view.MyWorkSpace2;

public class ParamEditView extends JFrame{
	
	private MyWorkSpace2 workSpace = MyWorkSpace2.getInstance();
	private JPanel panel;
	private JTextField field;
	private GridBagConstraints gbc;
	private JButton btn_ok = new JButton("Ok");
	private JButton btn_cancel = new JButton("Cancel");
	private Parametar param;
	private JFileChooser fileChooser;
	private JCheckBox checkbox;
	private JComboBox<LookType> comboBox;
	
	public ParamEditView() {
		setTitle("Edit");
		param = (Parametar)workSpace.getCvor();
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 2, 2, 2);
		
		if(((Parametar)param).getType().equals(ParametarType.NAZIV)) {
			naziv();
		}else if(((Parametar)param).getType().equals(ParametarType.AUTOR)) {
			autor();
		}else if(((Parametar)param).getType().equals(ParametarType.LOGO)) {
			logo();
		}else if(((Parametar)param).getType().equals(ParametarType.USLOVI_KORISCENJA)) {
			usloviKoriscenja();
		}else if(((Parametar)param).getType().equals(ParametarType.LOOK_AND_FEEL)) {
			lookAndFeel();
		}else if(((Parametar)param).getType().equals(ParametarType.DESKTOP_SHORTCUT)) {
			desktopShortcut();
		}else if(((Parametar)param).getType().equals(ParametarType.LAUNCH_AFTER)) {
			launchAfter();
		}
		
		getContentPane().add(panel);
		setMinimumSize(new Dimension(250, 150));
		setLocationRelativeTo(null);
		pack();
	}
	
	private void naziv() {
		JLabel lb_naziv = new JLabel("Naziv: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lb_naziv,gbc);
		field = new JTextField(10);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(field,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(btn_ok,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(btn_cancel,gbc);
		
		//akcije
		btnForText();
	}

	private void autor() {
		JLabel lb_naziv = new JLabel("Autor: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lb_naziv,gbc);
		field = new JTextField(10);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(field,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(btn_ok,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(btn_cancel,gbc);
		
		btnForText();
	}
	
	private void logo() {
		JLabel lb_naziv = new JLabel("Logo: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lb_naziv,gbc);
		field = new JTextField(20);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(field,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(btn_ok,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(btn_cancel,gbc);
		JButton browse = new JButton("Browse");
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		gbc.gridy = 1;
		panel.add(browse,gbc);
		
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = null;
				fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(null);
				file = fileChooser.getSelectedFile();
				if(file!=null)
					field.setText(file.getPath());
			}
		});
		
		btnForText();
	}
	
	private void desktopShortcut() {
		JLabel lb_naziv = new JLabel("Desktop Shortcut: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lb_naziv,gbc);
		checkbox = new JCheckBox();
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(checkbox,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(btn_ok,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(btn_cancel,gbc);
		
		btnForBox();
	}
	
	private void launchAfter() {
		JLabel lb_naziv = new JLabel("Launch After?: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lb_naziv,gbc);
		checkbox = new JCheckBox();
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(checkbox,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(btn_ok,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(btn_cancel,gbc);
		
		btnForBox();
	}
	
	private void lookAndFeel() {
		JLabel lb_naziv = new JLabel("Look And Feel: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lb_naziv,gbc);
		comboBox = new JComboBox<>();
		comboBox.addItem(LookType.Metal);
		comboBox.addItem(LookType.Motif);
		comboBox.addItem(LookType.Nimbus);
		comboBox.addItem(LookType.Windows);
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(comboBox,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(btn_ok,gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(btn_cancel,gbc);
		
		btnForCombo();
	}
	
	private void usloviKoriscenja() {
		//TODO
		JLabel lb_naziv = new JLabel("Uslove koriscenja mozete uneti iznad");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lb_naziv,gbc);
	}
	
	private void btnForCombo() {
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				param.setStr(comboBox.getSelectedItem().toString());
				Baza.setChanged(true);
				ParamEditView.this.dispose();
			}
		});
		btnCancel();
	}
	
	private void btnForBox() {
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				param.setUniversal(checkbox.isSelected());
				Baza.setChanged(true);
				ParamEditView.this.dispose();
			}
		});
		
		btnCancel();
	}
	
	private void btnForText() {
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				param.setStr(field.getText());
				Baza.setChanged(true);
				ParamEditView.this.dispose();
			}
		});
		
		btnCancel();
	}
	
	private void btnCancel() {
		btn_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ParamEditView.this.dispose();
			}
		});
	}
	
}
