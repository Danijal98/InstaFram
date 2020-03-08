package utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.JLabel;
import javax.swing.Timer;

public class Time extends JLabel{
	
	public Time() {
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		ActionListener timeListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Date date = new Date();
				String time1 = timeFormat.format(date);
				setText(time1);
			}
		};
		
		Timer timer = new Timer(1000,timeListener);
		timer.setInitialDelay(0);
		timer.start();
	}
}