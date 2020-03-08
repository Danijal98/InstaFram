package view_installation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import actions.ActionManager;
import model.Parametar;
import utilities.LookType;
import utilities.ParametarType;
import view.FirstView;

public class InstallationWizard extends JFrame {

	private int currentCard = 1;
	private CardLayout cardLayout;
	private ArrayList<JPanel> panels = new ArrayList<>();
	private ArrayList<Parametar> parametri = new ArrayList<>();
	private JCheckBox shortcutCheckBox;
	private boolean shortCut = false;
	private JCheckBox launchAfterCheckBox;
	private boolean launchAfter = false;
	
	public InstallationWizard(ArrayList<Parametar> parametars, ArrayList<Parametar> parametarsHelp) {
		this.parametri = parametars;
		setTitle("Installation Wizard");
		setSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		
		JPanel cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);

		int cardSize = (parametri.size() % 2 == 0) ? parametri.size()/2 : parametri.size()/2+1;
		int currParam = 0;
		
		for(int i = 1;i<=cardSize;i++) {
			JPanel jp = new JPanel();
			jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
			int j = 0;
			try {
				for(j=currParam;j<currParam+2;j++) {
					if(parametri.get(j).getType().equals(ParametarType.NAZIV)) {
						jp.add(nazivPanel(parametri.get(j)));
					}else if(parametri.get(j).getType().equals(ParametarType.AUTOR)) {
						jp.add(autorPanel(parametri.get(j)));
					}else if(parametri.get(j).getType().equals(ParametarType.USLOVI_KORISCENJA)){
						jp.add(usloviPanel(parametri.get(j)));
					}else if(parametri.get(j).getType().equals(ParametarType.DESKTOP_SHORTCUT)) {
						jp.add(shortcutPanel(parametri.get(j)));
					}else if(parametri.get(j).getType().equals(ParametarType.LAUNCH_AFTER)) {
						jp.add(launchAfterPanel(parametri.get(j)));
					}
				}
			} catch (Exception e) {
			}
			currParam = j;
			cardPanel.add(jp, "" + i);
		}
		
		for(Parametar param: parametarsHelp) {
			try {
				if(param.getType().equals(ParametarType.LOGO)) {
					this.setIconImage(new ImageIcon(param.getStr()).getImage());
				}else if(param.getType().equals(ParametarType.LOOK_AND_FEEL)) {
					if(param.getStr().equals(LookType.Metal.toString())) {
						UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
						SwingUtilities.updateComponentTreeUI(this);
					}else if(param.getStr().equals(LookType.Motif.toString())) {
						UIManager.setLookAndFeel ("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
						SwingUtilities.updateComponentTreeUI(this);
					}else if(param.getStr().equals(LookType.Nimbus.toString())) {
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
						SwingUtilities.updateComponentTreeUI(this);
					}else if(param.getStr().equals(LookType.Windows.toString())) {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						SwingUtilities.updateComponentTreeUI(this);
					}
				}
			} catch (Exception e) {
				System.out.println("Ikonica ne postoji ili look and feel zeza");
			}
		}
		
		JPanel buttonPanel = new JPanel();
		
		JButton btnNext = new JButton("Next");
		JButton btnPrevious = new JButton("Previous");
		JButton btnFinish = new JButton("Finish");
		
		buttonPanel.add(btnPrevious);
		buttonPanel.add(btnNext);
		buttonPanel.add(btnFinish);
		btnFinish.setEnabled(false);
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentCard < cardSize) {
					currentCard++;
					cardLayout.show(cardPanel, "" + (currentCard));
				}
				if(currentCard < cardSize) {
					btnFinish.setEnabled(false);
				}else {
					btnFinish.setEnabled(true);
				}
			}
		});
		
		btnPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentCard > 1) {
					currentCard--;
					cardLayout.show(cardPanel, "" + (currentCard));
				}
				if(currentCard < cardSize) {
					btnFinish.setEnabled(false);
				}else {
					btnFinish.setEnabled(true);
				}
			}
		});
		
		btnFinish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InstallationProcessBar processBar = new InstallationProcessBar();
				processBar.setShortCut(InstallationWizard.this.isShortCut());
				processBar.setLaunchAfter(InstallationWizard.this.isLaunchAfter());
				InstallationWizard.this.dispose();
			}
		});
		
		getContentPane().add(cardPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				InstallationWizard.this.dispose();
				SwingUtilities.updateComponentTreeUI(FirstView.getInstance());
			}
		});
		
	}
	
	public JPanel nazivPanel(Parametar param) {
		JPanel jPanel = new JPanel();
		jPanel.add(new Label("Naziv: " + param.getStr()));
		return jPanel;
	}
	
	public JPanel autorPanel(Parametar param) {
		JPanel jPanel = new JPanel();
		jPanel.add(new Label("Autor: " + param.getStr()));
		return jPanel;
	}
	
	public JPanel usloviPanel(Parametar param) {
		JPanel jPanel = new JPanel();
		jPanel.add(new Label("Uslovi: " + param.getOpis()));
		return jPanel;
	}
	
	public JPanel shortcutPanel(Parametar param) {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 2, 2, 2);
		
		JLabel lb_naziv = new JLabel("Desktop Shortcut: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		jPanel.add(lb_naziv,gbc);
		shortcutCheckBox = new JCheckBox();
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		jPanel.add(shortcutCheckBox,gbc);
		
		shortcutCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shortCut = !shortCut;
			}
		});
		
		return jPanel;
	}
	
	public JPanel launchAfterPanel(Parametar param) {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 2, 2, 2);
		
		JLabel lb_naziv = new JLabel("Launch After?: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		jPanel.add(lb_naziv,gbc);
		launchAfterCheckBox = new JCheckBox();
		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 0;
		jPanel.add(launchAfterCheckBox,gbc);
		
		launchAfterCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				launchAfter = !launchAfter;
			}
		});
		
		return jPanel;
	}

	public ArrayList<Parametar> getParametri() {
		return parametri;
	}

	public void setParametri(ArrayList<Parametar> parametri) {
		this.parametri = parametri;
	}

	public ArrayList<JPanel> getPanels() {
		return panels;
	}

	public void setPanels(ArrayList<JPanel> panels) {
		this.panels = panels;
	}

	public boolean isShortCut() {
		return shortCut;
	}

	public void setShortCut(boolean shortCut) {
		this.shortCut = shortCut;
	}

	public boolean isLaunchAfter() {
		return launchAfter;
	}

	public void setLaunchAfter(boolean launchAfter) {
		this.launchAfter = launchAfter;
	}
	
}
