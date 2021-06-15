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
		
		Color gri = new Color(195,195,195);
		msg = new ButtonInfo();
		this.numRows = numRows;
		this.numCols = numCols;
		buttonInfoY = msg.getButtonInfoY();

		grid = new MineGrid(numRows, numCols, numMines);

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
	public void clear() {
        for (int i = 0; i < numRows; i++) {
              for (int j = 0; j < numCols; j++) {
          remove(buttonInfoY[i][j]);
        }
      }
  }
}
