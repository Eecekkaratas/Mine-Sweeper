package components;

import javax.swing.*;
import java.awt.*;

public class Time extends JPanel  {

	ImageIcon img;
	ImageIcon img2;

	int elapsedTime = 0;
	int seconds = 0;

	JLabel label3 = new JLabel("", SwingConstants.LEFT); // süre

	public Time() {
		super();

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		ge.registerFont(new Font(Font.SERIF,Font.BOLD,18));

		img = new ImageIcon("indir.jpg");
		img2 = new ImageIcon("happy2.png");

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.red));
		setBackground(Color.black);

		
		label3.setForeground(Color.red);
		label3.setFont(new Font(Font.SERIF,Font.BOLD,18));

		add(label3, BorderLayout.CENTER);

	}

	String seconds_string = String.format("%02d", seconds);

	Timer timer = new Timer(1000, e -> {
		elapsedTime = elapsedTime + 1000;
		seconds = (elapsedTime / 1000);
		seconds_string = String.format("%03d", seconds);

		label3.setText(getSeconds());

	});

	public void start() {
		timer.start();
	}

	public void stop() {
		timer.stop();

	}

	public String getSeconds() {
		return seconds_string;
	}



}
