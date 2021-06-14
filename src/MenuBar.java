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
	private static final int size = 20;
	static MineSweeperGUI msg;
	
	public MenuBar() {
		super();
		
	JMenuBar mb = new JMenuBar();
	JMenu x = new JMenu("Game");
	JMenu h = new JMenu("Help");
	JMenuItem m1 = new JMenuItem("Easy");
		
	JMenuItem m2 = new JMenuItem("Intermediate");
	
	JMenuItem m3 = new JMenuItem("Difficult");
	
	JMenuItem m4 = new JMenuItem("How to play?");
	m4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				ImageIcon how = new ImageIcon("howtoplay.jpeg");
		
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