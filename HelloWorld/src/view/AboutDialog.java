package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AboutDialog extends JFrame{
	
	public AboutDialog() {
		//init
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width/4, height/4);
		setLocationRelativeTo(null);
		BorderLayout layout = new BorderLayout();
        setLayout(layout);  
        setTitle("About");  
		JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new Label("Ime: Danijal"));
        panel.add(new Label("Prezime: Azerovic"));
        panel.add(new Label("Indeks: RN86/18"));
        this.add(panel,BorderLayout.WEST);
        
        //slika
	    JLabel jLabel = new JLabel();
	    jLabel.setIcon(new ImageIcon("res/myPic.jpg"));
	    this.add(jLabel,BorderLayout.EAST);
	    pack();
	}

}
