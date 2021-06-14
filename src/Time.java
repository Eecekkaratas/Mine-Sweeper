import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Time {
	
	int elapsedTime = 0;
	int seconds = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);

	Timer timer = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			elapsedTime = elapsedTime + 1000;
			seconds = (elapsedTime / 1000);
			seconds_string = String.format("%03d", seconds);


		}

	});

	void start() {
		timer.start();
	}
}
