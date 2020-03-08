package view_installation;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileSystemView;

import utilities.Baza;

public class InstallationProcessBar extends JFrame {

	private JProgressBar progressBar;
	private JButton btnCancel;
	private JButton btnInstall;
	private boolean shortCut = false;
	private boolean launchAfter = false;
	
	public InstallationProcessBar() {
		setTitle("Installation Wizard");
		setSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setVisible(true);

		JPanel panelUp = new JPanel();
		JPanel panelDown = new JPanel();
		JPanel panelText = new JPanel();
		progressBar = new JProgressBar();
		btnCancel = new JButton("Cancel");
		btnInstall = new JButton("Install");
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);

		panelText.add(new JLabel("Instalacija je u toku..."));
		panelUp.add(progressBar);
		panelDown.add(btnInstall);
		panelDown.add(btnCancel);
		panelText.setVisible(false);

		add(panelText, BorderLayout.NORTH);
		add(panelUp, BorderLayout.CENTER);
		add(panelDown, BorderLayout.SOUTH);

		btnInstall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 btnCancel.setEnabled(false);
				 panelText.setVisible(true);
				 ProgressWorker pw = new ProgressWorker();
                 pw.addPropertyChangeListener(new PropertyChangeListener() {

                     @Override
                     public void propertyChange(PropertyChangeEvent evt) {
                         String name = evt.getPropertyName();
                         if (name.equals("progress")) {
                             int progress = (int) evt.getNewValue();
                             progressBar.setValue(progress);
                             repaint();
                         } else if (name.equals("state")) {
                             SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
                             switch (state) {
                                 case DONE:
                                     btnCancel.setEnabled(true);
                                     break;
                             }
                         }
                     }

                 });
                 installFile();
                 pw.execute();
             }
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InstallationProcessBar.this.dispose();
				if(shortCut)
               	 makeShortcut();
                if(launchAfter)
               	 launchAfter();
			}
		});

	}
	
	private void makeShortcut() {
		PrintStream ps = null;
		try {
			String path = FileSystemView.getFileSystemView().getHomeDirectory().toString() + File.separator + "instalacija.txt";
			ps = new PrintStream(new File(path));
			ps.print("https://i.imgur.com/9XhnK5v.jpg" + "  :D");
			ps.close();
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		}
	}
	
	private void launchAfter() {
		File f = new File(Baza.getFILE_PATH_INSTALL());
		Desktop ds = null;
		if(Desktop.isDesktopSupported()) {
			ds = Desktop.getDesktop();
		}
		try {
			ds.open(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void installFile() {
		File file = new File(Baza.getFILE_PATH_INSTALL());
		PrintStream ps = null;
		try {
			ps = new PrintStream(file);
			ps.print("https://i.imgur.com/9XhnK5v.jpg" + ":D");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateBar(int newValue) {
		progressBar.setValue(newValue);
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
