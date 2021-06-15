import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Game extends JPanel {
	private static final int NUM_MINES = 40;
	private static final int orta_size = 16;
	

	public Game(int num) {
		setLayout(new BorderLayout());

		TopPanel topPanel = new TopPanel(this);
		topPanel.setBackground(Color.LIGHT_GRAY);
		GameBoard msg = new GameBoard(orta_size,orta_size,num);

		JPanel MainPanel = new JPanel(new BorderLayout());
		

		MainPanel.add(topPanel, BorderLayout.NORTH);


		
		JPanel bottom = new JPanel();

		bottom.setLayout(new BorderLayout());
		bottom.setBackground(Color.LIGHT_GRAY);
		bottom.setBorder(new EmptyBorder(12,5,8,8));
		bottom.add(msg, BorderLayout.CENTER);

		MainPanel.add(bottom,BorderLayout.CENTER);

		MainPanel.setBackground(Color.LIGHT_GRAY);

		add(MainPanel,BorderLayout.CENTER);
	}

	public void restart() {
		add(new Game( NUM_MINES));
		SwingUtilities.updateComponentTreeUI(this);
	}


}
