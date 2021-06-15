import components.ButtonClass;
import components.ButtonInfo;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

	ButtonInfo msg;
	ButtonClass[][] buttonInfoY;
	

	public GameBoard(int numRows, int numCols, int numMines) {

		msg = new ButtonInfo();
		buttonInfoY = msg.getButtonInfoY();

		MineGrid grid = new MineGrid(numRows, numCols, numMines);

		setLayout(new GridLayout(numRows, numCols));
		//setBorder(BorderFactory.createRaisedBevelBorder());
		setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				ButtonClass button = new ButtonClass();
				add(button);
				button.setBackground(Color.LIGHT_GRAY);
				button.setMargin(new Insets(0, 0, 0, 0));
				button.setEnabled(true);
				ButtonHandler bth = new ButtonHandler(i, j, grid);
				button.addMouseListener(bth);
				button.setBorder(BorderFactory.createRaisedBevelBorder());

				buttonInfoY[i][j] = button;

				

			}

		}
		msg.setButtonInfoY(buttonInfoY);
	}
}
