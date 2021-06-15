import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class MenuBar extends JMenuBar  {
	private static final int size = 16;
	static MineSweeperGUI msg;
	Game game;
	public MenuBar() {
		super();
		
	JMenuBar mb = new JMenuBar();
	JMenu x = new JMenu("Game");
	JMenu h = new JMenu("Help");
	JMenuItem m1 = new JMenuItem("Easy");
	m1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent m) {
			int easy_size = 5;
			int easy_mine = 20;
			Game game = new Game(easy_mine);
			
			MenuBar menubar = new MenuBar();
			ImageIcon img;

			img = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper\\indir.jpg");
			
			
			JFrame frame = new JFrame("Mine Sweeper | # of mines: " + easy_mine);
			frame.setIconImage(img.getImage());
			
			frame.setJMenuBar(menubar);
		
			frame.add(game);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBackground(Color.LIGHT_GRAY);
			frame.setSize(550, 600);
			
			//frame.setResizable(false);
			frame.setVisible(true);
			
			
		}});

		
	JMenuItem m2 = new JMenuItem("Intermediate");
	
	JMenuItem m3 = new JMenuItem("Difficult");
	m3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent m) {
			int hard_size = 22;
			int hard_mine = 100;
			
			Game game = new Game(hard_mine);
			
			MenuBar menubar = new MenuBar();
			ImageIcon img;

			img = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper\\indir.jpg");
			
					
			JFrame frame = new JFrame("Mine Sweeper | # of mines: " + hard_mine + "  Difficult mode");
			frame.setIconImage(img.getImage());
			
			frame.setJMenuBar(menubar);
		
			JPanel jp = new JPanel ();
			jp.setLayout(new BorderLayout());
			game.setBorder(BorderFactory.createLoweredBevelBorder());
			jp.add(game,BorderLayout.CENTER);
			jp.setBorder(new EmptyBorder(10,10,10,10));
			jp.setBackground(Color.LIGHT_GRAY);
			frame.add(jp,BorderLayout.CENTER);
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBackground(Color.LIGHT_GRAY);
			frame.setSize(550, 600);
			//System.out.println(frame.getSize());
			frame.setResizable(false);
			frame.setVisible(true);
			
			
		}});
	
	JMenuItem m4 = new JMenuItem("How to play?");
	m4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				ImageIcon how = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper\\howtoplay.jpeg");
		
				JFrame jf = new JFrame("Nasýl Oynanýr ?");
				
				//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.add(new JLabel(how));
				jf.setSize(1200, 600);
				jf.setVisible(true);
		 
	}});
	JMenuItem m5 = new JMenuItem("For More Information");
	m5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Runtime rt = Runtime.getRuntime();
			String url = "http://www.minesweeper.info/";
			try {
				rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}});
		
	 add(x);
	 x.add(m1);
	 x.add(m2);
	 x.add(m3);
	 add(h);
	 h.add(m4);
	 h.add(m5);
	 

}
}