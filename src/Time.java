import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Time extends JPanel implements ActionListener, MouseListener {
	private static final int NUM_MINES = 15;
	private static final int size = 20;

	private Font sevendigitsfont;

	ImageIcon img;
	ImageIcon img2;

	int elapsedTime = 0;
	int seconds = 0;

	JLabel label3 = new JLabel("", SwingConstants.LEFT); // süre

	public Time() {
		super();

		try {

			sevendigitsfont = Font.createFont(Font.TRUETYPE_FONT, new File("Seven Segment.ttf")).deriveFont(55f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

			ge.registerFont(sevendigitsfont);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}

		Color mavi = new Color(0, 0, 60);
		Color gri = new Color(200, 200, 200);
		img = new ImageIcon("indir.jpg");
		img2 = new ImageIcon("happy2.png");

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.red));
		setBackground(Color.black);

		label3.setPreferredSize(new Dimension(50, 50));
		label3.setForeground(Color.red);
		label3.setFont(sevendigitsfont);

		add(label3, BorderLayout.CENTER);

	}

	boolean started = false;
	String seconds_string = String.format("%02d", seconds);

	Timer timer = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			elapsedTime = elapsedTime + 1000;
			seconds = (elapsedTime / 1000);
			seconds_string = String.format("%03d", seconds);

			label3.setText(getSeconds());

		}

	});

	void start() {
		timer.start();
	}

	void stop() {
		timer.stop();

	}

	public void restart() {
		// timer.restart();
		timer.stop();
		this.seconds = 0;
		timer.start();
	}

	public int getTime() {
		return seconds;
	}

	public String getSeconds() {
		return seconds_string;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
