import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;


public class MenuBar extends JMenuBar  {
	public MenuBar(Game game,JFrame frame) {
		super();

		JMenu x = new JMenu("Game");
	JMenu h = new JMenu("Help");
	JMenuItem easyMode = new JMenuItem("Easy");
	easyMode.addActionListener(click ->updateFrameWindow(frame,game,20,"Mine Sweeper | # of mines: " + 20+""));

	JMenuItem intermediateMode = new JMenuItem("Intermediate");

	JMenuItem difficultMode = new JMenuItem("Difficult");
	difficultMode.addActionListener(click ->updateFrameWindow(frame,game,100,"Mine Sweeper | # of mines: " + 100+""));
	
	JMenuItem m4 = new JMenuItem("How to play?");


	m4.addActionListener(m -> {
		ImageIcon how = new ImageIcon("howtoplay.jpeg");

		JFrame jf = new JFrame("Nasýl Oynanýr ?");

		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new JLabel(how));
		jf.setSize(1200, 600);
		jf.setVisible(true);

});
	JMenuItem m5 = new JMenuItem("For More Information");
	m5.addActionListener(e -> {
		Runtime rt = Runtime.getRuntime();
		String url = "https://www.minesweeper.info/";
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	});
		
	 add(x);
	 x.add(easyMode);
	 x.add(intermediateMode);
	 x.add(difficultMode);
	 add(h);
	 h.add(m4);
	 h.add(m5);
	 

}
private void updateFrameWindow(JFrame frame,JPanel panel,int num,String title){
	frame.remove(panel);
	frame.setTitle(title);
	frame.add(new Game(num));
	frame.revalidate();
	frame.repaint();

}
}