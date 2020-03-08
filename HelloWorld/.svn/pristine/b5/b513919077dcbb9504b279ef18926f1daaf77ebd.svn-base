package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import utilities.Baza;
import utilities.Time;
import utilities.UserType;

public class MyStatusBar extends JPanel{
	
	LocalDateTime date = LocalDateTime.now();
	
	public MyStatusBar() {
		JLabel lb_date = new JLabel("Datum: "+date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear());
		String tipKorisnika;
		if(Baza.getInstance().getUser().getUserType().equals(UserType.USER)) {
			tipKorisnika = "Korisnik";
		}else {
			tipKorisnika = "Admin";
		}
		JLabel lb_tip = new JLabel(tipKorisnika);
		//font
		
		//dodavanje
		this.add(lb_date);
		this.add(new Label("|"));
		this.add(new Time());
		this.add(new Label("|"));
		this.add(lb_tip);
		
		//style
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	}

}
