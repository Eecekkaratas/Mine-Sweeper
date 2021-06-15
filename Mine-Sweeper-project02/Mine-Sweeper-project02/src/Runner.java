import javax.swing.*;
import java.awt.*;

public class Runner {

	private static final int NUM_MINES = 40;

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
