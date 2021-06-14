import java.awt.Color;

import javax.swing.JFrame;

public class MineSweeper {
	
	private static final int NUM_MINES = 15;
	private static final int size = 20;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Mine Sweeper | # of mines: " + NUM_MINES);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(600, 650);
		
		frame.setVisible(true);
	}

}
