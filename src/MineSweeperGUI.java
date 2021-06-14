import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MineSweeperGUI extends JPanel {

	private MineGrid grid;
	private int numRows;
	private int numCols;
	ButtonInfo msg;
	ButtonClass[][] buttonInfoY;
	

	public MineSweeperGUI(int numRows, int numCols, int numMines) {
		
		
		grid = new MineGrid(numRows, numCols, numMines);

		setLayout(new GridLayout(numRows, numCols));
		//setBorder(BorderFactory.createRaisedBevelBorder());
		setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				ButtonClass button = new ButtonClass();
				add(button);
				
				ButtonHandler bth = new ButtonHandler(i, j, grid);
				button.addMouseListener(bth);

				

				

			}

		}
		
	}