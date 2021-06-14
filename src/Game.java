import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Game extends JPanel {
	private static final int NUM_MINES = 15;
	private static final int orta_size = 20;
	private static final int kolay_size = 15;
	private static final int zor_size = 15;

	public Game(int num) {
		// super();
		setLayout(new BorderLayout());
		// MenuBar menubar = new MenuBar();
		ImageIcon img;
		ImageIcon img2;

		Color mavi = new Color(0, 0, 60);
		Color gri = new Color(200, 200, 200);
		img = new ImageIcon("indir.jpg");
		img2 = new ImageIcon("happy2.png");

		GUI gui = new GUI(this);// , new KalanMineSayýsý()
		gui.setBackground(Color.LIGHT_GRAY);
		MineSweeperGUI msg = new MineSweeperGUI(orta_size,orta_size,num);
		msg.setBorder(BorderFactory.createLoweredBevelBorder());

		add(gui, BorderLayout.NORTH);

		msg.setLayout(new GridLayout(orta_size, orta_size));

		JPanel top = new JPanel();
		top.setBackground(Color.LIGHT_GRAY);
		JPanel bottom = new JPanel();
		top.setLayout(new BorderLayout());
		bottom.setLayout(new BorderLayout());
		bottom.setBackground(Color.LIGHT_GRAY);
		setBorder(BorderFactory.createLineBorder(Color.gray));

		add(msg, BorderLayout.CENTER);

	}
}