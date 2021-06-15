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

	private static final int NUM_MINES = 40;
	private static final int size = 16;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Mine Sweeper | # of mines: " + NUM_MINES);
		Game ms = new Game(NUM_MINES);
		
		MenuBar menubar = new MenuBar(ms,frame);
		ImageIcon img;

		img = new ImageIcon("indir.jpg");
		
				
		
		frame.setIconImage(img.getImage());
		
		frame.setJMenuBar(menubar);
	
		frame.add(ms);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setSize(550, 600);
		
		//frame.setResizable(false);
		frame.setVisible(true);

	}

}
