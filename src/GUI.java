import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;

public class GUI extends JPanel implements ActionListener {
	private static final int NUM_MINES = 40;
	private static final int size = 16;

	private static JButton face;

	public static void setFace(ImageIcon sad) {
		face.setIcon(sad);

	}

	static Time time = new Time();
	Counter kms = new Counter(); // KALAN MAYIN SAYISI 
	Game ms;
	

	ImageIcon img;
	ImageIcon img_happy;

	

	public GUI(Game game) { 
		JPanel jp = new JPanel();
		ms = game;
		time.start();

		Color mavi = new Color(0, 0, 60);
		Color gri = new Color(238, 238, 238);
		
		img = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper\\indir.jpg");
		img_happy = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper\\happy.jpg");

		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();

		jp.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		jp.setBorder(loweredbevel);
		setBorder(loweredbevel);
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

		face.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				//removeAll();
				time = new Time();
				// time.restart();
				kms.restart();
				game.restart();
					

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}