import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
	private int row,col;
	private MineGrid grid;
	
	public ButtonHandler(int x,int y, MineGrid g){
		row=x;
		col=y;
		grid=g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(grid.isMine(row, col)) {
			JOptionPane.showMessageDialog(null, "OOOPS!!");
			System.exit(0);
		}else {
			//get the number from MineGrid(row,col)
			// display is on the button
			if (e.getSource() instanceof JButton) {
				JButton button =(JButton)e.getSource();
				button.setText(String.valueOf(grid.getCellContent(row, col)));
			}
			
		}

	}

}