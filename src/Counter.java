import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Counter extends JPanel {
	private static final int nom = 15;
	private static int num_of_mines = 15;
	private Font sevendigitsfont;
	private static JLabel label = new JLabel("0" + String.valueOf(num_of_mines));

		public Counter() {
		super();

		setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.red));
		setBackground(Color.black);

		label.setForeground(Color.red);
		label.setFont(sevendigitsfont);
		
		label.setText("0"+String.valueOf(num_of_mines));
		

		add(label);
		
	}
}