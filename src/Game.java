import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



public class Game extends JPanel {
	private static final int NUM_MINES = 40;
	private static final int orta_size = 16;
	

	public Game(int num) {
		// super();
		setLayout(new BorderLayout());
		//setSize(new Dimension(530, 178));
		ImageIcon img;
		ImageIcon img2;

		Color mavi = new Color(0, 0, 60);
		Color gri = new Color(200, 200, 200);
		img = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\indir.jpg");
		img2 = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\happy2.png");

		GUI gui = new GUI(this);
		gui.setBackground(Color.LIGHT_GRAY);
		MineSweeperGUI msg = new MineSweeperGUI(orta_size,orta_size,num);
		msg.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JPanel jp = new JPanel();
		
		jp.setLayout(new BorderLayout());
		jp.add(gui, BorderLayout.NORTH);
		jp.setBorder(BorderFactory.createRaisedBevelBorder());
		msg.setLayout(new GridLayout(orta_size, orta_size));

		
		JPanel bottom = new JPanel();
		
		bottom.setLayout(new BorderLayout());
		bottom.setBackground(Color.LIGHT_GRAY);
		bottom.setBorder(new EmptyBorder(12,5,8,8));
		bottom.add(msg, BorderLayout.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		jp.add(bottom,BorderLayout.CENTER);
		
		jp.setBackground(Color.LIGHT_GRAY);
		
		setBorder(BorderFactory.createRaisedBevelBorder());
		add(jp,BorderLayout.CENTER);
	}

	public void restart() {
		//removeAll();
		add(new Game( NUM_MINES));
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void restart1(int num) {
		removeAll();
		add(new Game(num));
		SwingUtilities.updateComponentTreeUI(this);
	}
}
