import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

public class MineSweeper {

	private static final int NUM_MINES = 50;
	private static final int size = 16;

	public static void main(String[] args) {
		
		
		Game ms = new Game(NUM_MINES);
		
		MenuBar menubar = new MenuBar();
		ImageIcon img;

		img = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\indir.jpg");
		
				
		JFrame frame = new JFrame("\"Mine Sweeper | # of mines: " + NUM_MINES);
		frame.setIconImage(img.getImage());
		
		frame.setJMenuBar(menubar);
	
		JPanel jp = new JPanel ();
		jp.setLayout(new BorderLayout());
		ms.setBorder(BorderFactory.createLoweredBevelBorder());
		jp.add(ms,BorderLayout.CENTER);
		jp.setBorder(new EmptyBorder(10,10,10,10));
		jp.setBackground(Color.LIGHT_GRAY);
		frame.add(jp,BorderLayout.CENTER);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setSize(550, 600);
		//System.out.println(frame.getSize());
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
