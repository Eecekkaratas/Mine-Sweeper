import components.Counter;
import components.Time;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TopPanel extends JPanel  {

	private static JButton face;

	public static void setFace(ImageIcon sad) {
		face.setIcon(sad);

	}

	public static Time time = new Time();
	Counter kms = new Counter();

	ImageIcon img;
	ImageIcon img_happy;



	public TopPanel(Game game) {
		JPanel jp = new JPanel();
		time.start();

		img = new ImageIcon("indir.jpg");
		img_happy = new ImageIcon("happy.jpg");


		Border loweredLevel = BorderFactory.createLoweredBevelBorder();

		jp.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		jp.setBorder(loweredLevel);
		setBorder(loweredLevel);
		jp.setLayout(new GridLayout(1, 3));
		//jp.setBorder(BorderFactory.createLineBorder(Color.gray));

		jp.setBackground(Color.LIGHT_GRAY);

		JPanel jp2 = new JPanel();
		jp2.setBackground(Color.LIGHT_GRAY);
		face = new JButton(img_happy);
		face.setBackground( new Color(185, 185, 185));
		face.setBorder(BorderFactory.createRaisedBevelBorder());
		jp2.add(face);
		jp.add(kms, BorderLayout.WEST);

		jp.add(new JLabel("       "));

		jp.add(jp2);
		add(new JLabel("       "), BorderLayout.NORTH);
		add(new JLabel("       "), BorderLayout.SOUTH);

		jp.add(new JLabel("       "));
		add(new JLabel("       "), BorderLayout.WEST);
		add(new JLabel("       "), BorderLayout.EAST);

		jp.add(time);

		add(jp);

		face.addActionListener(m -> {
			//removeAll();
			time = new Time();
			// time.restart();
			Counter.restart();
			game.restart();


		});

	}

}