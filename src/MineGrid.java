import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MineGrid {

	private int[][] mineInfo;
	private static final int MINE = -1;
	private int success = 0;

	ImageIcon imgflag;

	public MineGrid(int numRows, int numCols, int numMines) {
		mineInfo = new int[numRows][numCols];
		initializeCells();
		placeMines(numMines);
		setMineInformation();
	}

	public void initializeCells() {
		for (int i = 0; i < mineInfo.length; i++) {
			for (int j = 0; j < mineInfo[0].length; j++) {
				mineInfo[i][j] = 0;

			}
		}
	}

	private void placeMines(int numMines) {
		Random rand = new Random();
		for (int i = 0; i < numMines; i++) {
			int r = rand.nextInt(mineInfo.length);
			int c = rand.nextInt(mineInfo[0].length);
			if (mineInfo[r][c] != MINE) {
				mineInfo[r][c] = MINE;
			} else {
				i--;
			}
		}
	}
	
		
	
	public boolean isMine(int i, int j) {
		return mineInfo[i][j] == MINE;
	}

	public boolean isInsideGrid(int i, int j) {
		return (i >= 0 && i < mineInfo.length) && (j >= 0 && j < mineInfo[0].length);
	}

	public void incrementMineCountAt(int i, int j) {
		if (isInsideGrid(i, j) && !isMine(i, j)) {
			mineInfo[i][j]++;
		}
	}

	public int getCellContent(int i, int j) {
		try {
		return mineInfo[i][j];
		}catch(ArrayIndexOutOfBoundsException e){
			//System.out.println("SA  MÝNEGRÝD HATA: ArrayIndexOutOfBoundsException");
		}
		return -2;
	}

	public void setMineInformation() {
		for (int i = 0; i < mineInfo.length; i++) {
			for (int j = 0; j < mineInfo[0].length; j++) {
				if (mineInfo[i][j] == MINE) {
					incrementMineCountAt(i - 1, j - 1);
					incrementMineCountAt(i - 1, j);
					incrementMineCountAt(i - 1, j + 1);

					incrementMineCountAt(i, j - 1);
					incrementMineCountAt(i, j + 1);

					incrementMineCountAt(i + 1, j - 1);
					incrementMineCountAt(i + 1, j);
					incrementMineCountAt(i + 1, j + 1);

				}
			}
		}
	}
	

}
