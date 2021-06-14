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
	private static final int nom = 50;
	private static int num_of_mines = 50;
	private Font sevendigitsfont;
	private static JLabel label = new JLabel("0"+String.valueOf(num_of_mines));
	

	public static void increaseNum_of_mines() {
		num_of_mines = num_of_mines + 1;
		
		label.setText("0"+String.valueOf(num_of_mines));
		//System.out.println(str);
	}

	public static void decreaseNum_of_mines() {
		num_of_mines = num_of_mines - 1;
		
		label.setText("0"+String.valueOf(num_of_mines) );
		//System.out.println(str);
	}
	public static String getNum_of_mines() {
        return String.valueOf(num_of_mines);
    }
	public Counter() {
		super();

		try {
			
			sevendigitsfont = Font.createFont(Font.TRUETYPE_FONT, new File("Seven Segment.ttf")).deriveFont(55f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
			ge.registerFont(sevendigitsfont);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}

		setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.red));
		setBackground(Color.black);

		label.setForeground(Color.red);
		label.setFont(sevendigitsfont);
		
		label.setText("0"+String.valueOf(num_of_mines));
		//System.out.println(label.getText());

		add(label);
		
	}
	public static int restart() {
		num_of_mines = nom;
		//System.out.println("kalandan restart" + num_of_mines);
		return num_of_mines;
	}

}
