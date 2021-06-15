package components;

import javax.swing.*;
import java.awt.*;

public class Counter extends JPanel {
	private static final int nom = 40;
	private static int num_of_mines = 40;
	private static final JLabel label = new JLabel("0"+ num_of_mines);
	

	public static void increaseNum_of_mines() {
		num_of_mines = num_of_mines + 1;
		
		label.setText("0"+ num_of_mines);
	}

	public static void decreaseNum_of_mines() {
		num_of_mines = num_of_mines - 1;
		
		label.setText("0"+ num_of_mines);
	}

	public Counter() {
		super();

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		ge.registerFont(new Font(Font.SERIF,Font.BOLD,18));

		setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.red));
		setBackground(Color.black);

		label.setForeground(Color.red);
		label.setFont(new Font(Font.SERIF,Font.BOLD,18));
		
		label.setText("0"+ num_of_mines);

		add(label);
		
	}
	public static void restart() {
		num_of_mines = nom;
	}

}
