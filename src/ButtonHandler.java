import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.metal.MetalButtonUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class ButtonHandler implements MouseListener, ActionListener {
	private static final int NUM_MINES = 50;
	private static final int size = 16;
	private int row;
	private int col;
	private MineGrid grid;
	private static int success = 0;

	public ButtonClass[][] buttonInfoX;
	public ButtonClass[][] buttonInfoY;

	ImageIcon img_flag;
	ImageIcon img_mine;
	ImageIcon img_empty;
	ImageIcon img_sad;
	ImageIcon img_xmay�n;
	ImageIcon img_shock = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\surpriz.jpg");
	ImageIcon img_happy = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\happy2.png");

	public ButtonInfo msg;
	// private KalanMineSay�s� kms;
	private Font font;
	// private GUI gui;

	public ButtonHandler(int x, int y, MineGrid g) {
		row = x;
		col = y;
		grid = g;

	}

	public void actionPerformed(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		msg = new ButtonInfo();

		img_flag = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\flag.png");
		img_mine = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\mayin.png");
		img_empty = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\empty.png");
		img_xmay�n = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\xmayin.png");
		img_sad = new ImageIcon("C:\\Users\\eceka\\eclipse-workspace\\project02-minesweeper-project02\\project02-minesweeper-project02\\sad.png");

		ButtonClass button = (ButtonClass) e.getSource();

		if (button.isOpen() == false) {
			if (e.getButton() == 1 && !button.isFlag()) { // sol t�klan�rsa

				if (grid.isMine(row, col)) {
					button.setIcon(img_mine);
					GUI.setFace(img_sad);
					GUI.time.stop();
					JOptionPane.showMessageDialog(null, "   GAME OVER  !!!");

					for (int i = 0; i < size; i++) {
						for (int k = 0; k < size; k++) {
							msg.getButtonInfoY()[i][k].setOpen(true);
							if (grid.getCellContent(i, k) == -1) {
								open(i, k);
								button.setBackground(Color.red);

							}

						}
					}
					for (int i = 0; i < size; i++) {
						for (int k = 0; k < size; k++) {

							if (grid.getCellContent(i, k) != -1 && msg.getButtonInfoY()[i][k].isFlag()) {
								msg.getButtonInfoY()[i][k].setIcon(img_xmay�n);
							}

						}

					}

				} else {
					if (e.getSource() instanceof ButtonClass) {
						ButtonClass[][] buttons = msg.getButtonInfoY();

						if (grid.getCellContent(row, col) == 0) {
							clear(row, col);
						} else {
							open(row, col);
						}

						msg.setButtonInfoY(buttons);

					}
				}
				button.setLeftCick(true);

			} else if (e.getButton() == 3)

			{ // sa� t�klan�rsa

				if (!button.isFlag()) {
					button.setIcon(img_flag);

					button.setFlag(true);
					// kms.decreaseNum_of_mines();
					// kms.decreaseNum_of_mines();
					Counter.decreaseNum_of_mines();
					if (grid.isMine(row, col)) {
						success = success + 1;
						check(success);
						System.out.println(success + "success++");
					}

				} else {
					button.setIcon(null);
					button.setFlag(false);
					// kms.increaseNum_of_mines();
					Counter.increaseNum_of_mines();
					if (grid.isMine(row, col)) {
						success = success - 1;
						System.out.println(success + "success--");
						check(success);
					}
				}

			} else if (e.getButton() == 2) { // orta click -- debugging
			}
		}

	}

	public void check(int success) {
		if (success == NUM_MINES) {
			JOptionPane.showMessageDialog(null, "   You are a genius  !!!");
		} else {

		}

	}

	public void open(int i, int j) {
		try {

			font = Font.createFont(Font.TRUETYPE_FONT, new File("mine-sweeper.ttf")).deriveFont(12f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

			ge.registerFont(font);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}

		msg = new ButtonInfo();
		try {

			if (grid.getCellContent(i, j) == -1) {
				msg.getButtonInfoY()[i][j].setIcon(img_mine);
				msg.getButtonInfoY()[i][j].setOpen(true);
				// msg.getButtonInfoY()[i][j].setEnabled(false);
			} else if (grid.getCellContent(i, j) == 0) {
				msg.getButtonInfoY()[i][j].setIcon(img_empty);
				msg.getButtonInfoY()[i][j].setBackground(new Color(160, 160, 160));

				msg.getButtonInfoY()[i][j].setOpen(true);
				msg.getButtonInfoY()[i][j].setEnabled(false);
			} else {
				msg.getButtonInfoY()[i][j].setFont(font);
				msg.getButtonInfoY()[i][j].setText((String.valueOf(grid.getCellContent(i, j))));
				if (grid.getCellContent(i, j) == 1) {
					msg.getButtonInfoY()[i][j].setForeground(Color.blue);
					msg.getButtonInfoY()[i][j].setEnabled(false);
					msg.getButtonInfoY()[i][j].setUI(new MetalButtonUI() {
						protected Color getDisabledTextColor() {
							return Color.blue;
						}
					});
				} else if (grid.getCellContent(i, j) == 2) {
					msg.getButtonInfoY()[i][j].setForeground(new Color(50, 185, 50));
					msg.getButtonInfoY()[i][j].setEnabled(false);
					msg.getButtonInfoY()[i][j].setUI(new MetalButtonUI() {

						protected Color getDisabledTextColor() {
							return new Color(50, 185, 50);
						}
					});
				} else if (grid.getCellContent(i, j) == 3) {
					msg.getButtonInfoY()[i][j].setForeground(Color.red);
					msg.getButtonInfoY()[i][j].setEnabled(false);
					msg.getButtonInfoY()[i][j].setUI(new MetalButtonUI() {
						protected Color getDisabledTextColor() {
							return Color.red;
						}
					});
				} else if (grid.getCellContent(i, j) == 4)

				{
					msg.getButtonInfoY()[i][j].setForeground(new Color(148, 0, 211));
					msg.getButtonInfoY()[i][j].setEnabled(false);
					msg.getButtonInfoY()[i][j].setUI(new MetalButtonUI() {
						protected Color getDisabledTextColor() {
							return new Color(148, 0, 211);
						}
					});
				} else if (grid.getCellContent(i, j) == 5) {
					msg.getButtonInfoY()[i][j].setForeground(Color.yellow);
					msg.getButtonInfoY()[i][j].setEnabled(false);
					msg.getButtonInfoY()[i][j].setUI(new MetalButtonUI() {
						protected Color getDisabledTextColor() {
							return Color.YELLOW;
						}
					});
				} else {
					msg.getButtonInfoY()[i][j].setForeground(Color.CYAN);
					msg.getButtonInfoY()[i][j].setEnabled(false);
					msg.getButtonInfoY()[i][j].setUI(new MetalButtonUI() {
						protected Color getDisabledTextColor() {
							return Color.cyan;
						}
					});
				}
				msg.getButtonInfoY()[i][j].setOpen(true);

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("Hata: ArrayIndexOutOfBoundsException ");
		}
	}

	public void clear(int i, int j) {
		msg = new ButtonInfo();
		ButtonClass[][] buttons = msg.getButtonInfoY();

		if (i < size && j < size && i >= 0 && j >= 0 && !buttons[i][j].isOpen()) { // isInsideGrid methodu var
			open(i, j);
			if (grid.getCellContent(i - 1, j - 1) == 0) { // sol �st k��e
				clear(i - 1, j - 1);
				if (grid.getCellContent(i - 2, j - 2) != 0 && grid.getCellContent(i - 2, j - 2) != -1) {
					open(i - 2, j - 2);
				}
			}
			if (grid.getCellContent(i - 1, j) == 0) { // �st
				clear(i - 1, j);
				open(i - 2, j - 1);
				open(i - 2, j);
				open(i - 2, j + 1);
			}
			if (grid.getCellContent(i - 1, j + 1) == 0) { // sa� �st k��e
				clear(i - 1, j + 1);
				if (grid.getCellContent(i - 2, j + 2) != 0 && grid.getCellContent(i - 2, j + 2) != -1) {
					open(i - 2, j + 2);
				}
			}
			if (grid.getCellContent(i, j - 1) == 0) { // sol yan
				clear(i, j - 1);
				if (grid.getCellContent(i - 1, j - 2) != 0 && grid.getCellContent(i - 1, j - 2) != -1) {
					open(i - 1, j - 2);
				}
				if (grid.getCellContent(i, j - 2) != 0 && grid.getCellContent(i, j - 2) != -1) {
					open(i, j - 2);
				}
				if (grid.getCellContent(i + 1, j - 2) != 0 && grid.getCellContent(i + 1, j - 2) != -1) {
					open(i + 1, j - 2);
				}
			}
			if (grid.getCellContent(i, j + 1) == 0) { // sa� yan
				clear(i, j + 1);
				if (grid.getCellContent(i - 1, j + 2) != 0 && grid.getCellContent(i - 1, j + 2) != -1) {
					open(i - 1, j + 2);
				}
				if (grid.getCellContent(i, j + 2) != 0 && grid.getCellContent(i, j + 2) != -1) {
					open(i, j + 2);
				}
				if (grid.getCellContent(i + 1, j + 2) != 0 && grid.getCellContent(i + 1, j + 2) != -1) {
					open(i + 1, j + 2);
				}

			}
			if (grid.getCellContent(i + 1, j - 1) == 0) { // sol alt k��e
				clear(i + 1, j - 1);
				if (grid.getCellContent(i + 2, j - 2) != 0 && grid.getCellContent(i + 2, j - 2) != -1) {
					open(i + 2, j - 2);
				}
			}
			if (grid.getCellContent(i + 1, j) == 0) { // alt
				clear(i + 1, j);
				if (grid.getCellContent(i + 2, j - 1) != 0 && grid.getCellContent(i + 2, j - 1) != -1) {
					open(i + 2, j - 1);
				}
				if (grid.getCellContent(i + 2, j) != 0 && grid.getCellContent(i + 2, j) != -1) {
					open(i + 2, j);
				}
				if (grid.getCellContent(i + 2, j + 1) != 0 && grid.getCellContent(i + 2, j + 1) != -1) {
					open(i + 2, j + 1);
				}
			}
			if (grid.getCellContent(i + 1, j + 1) == 0) { // sa� alt k��e
				clear(i + 1, j + 1);
				if (grid.getCellContent(i + 2, j + 2) != 0 && grid.getCellContent(i + 2, j + 2) != -1) {
					open(i + 2, j + 2);
				}
			}
			if ((grid.getCellContent(i + 1, j + 1) != 0) && (grid.getCellContent(i, j - 1) != 0)
					&& (grid.getCellContent(i + 1, j) != 0) && (grid.getCellContent(i + 1, j - 1) != 0)
					&& (grid.getCellContent(i, j + 1) != 0) && (grid.getCellContent(i - 1, j + 1) != 0)
					&& (grid.getCellContent(i - 1, j) != 0) && (grid.getCellContent(i - 1, j - 1) != 0)
					&& (grid.getCellContent(i, j) == 0)) {
				open(i + 1, j + 1);
				open(i + 1, j);
				open(i + 1, j - 1);

				open(i - 1, j - 1);
				open(i - 1, j);
				open(i - 1, j + 1);

				open(i, j + 1);
				// open(i, j);
				open(i, j - 1);
			}
			if ((grid.getCellContent(i, j - 1) != 0) && (grid.getCellContent(i, j + 1) != 0)
					&& (grid.getCellContent(i - 1, j + 1) != 0) && (grid.getCellContent(i - 1, j) != 0)
					&& (grid.getCellContent(i - 1, j - 1) != 0) && (grid.getCellContent(i, j) == 0)) {

				open(i - 1, j - 1);
				open(i - 1, j);
				open(i - 1, j + 1);

				open(i, j + 1);

				open(i, j - 1);
			}
			if ((grid.getCellContent(i + 1, j + 1) != 0) && (grid.getCellContent(i, j - 1) != 0)
					&& (grid.getCellContent(i + 1, j) != 0) && (grid.getCellContent(i + 1, j - 1) != 0)
					&& (grid.getCellContent(i, j + 1) != 0) && (grid.getCellContent(i, j) == 0)) {
				open(i + 1, j + 1);
				open(i + 1, j);
				open(i + 1, j - 1);

				open(i, j + 1);

				open(i, j - 1);
			}
			if ((grid.getCellContent(i + 1, j + 1) != 0) && (grid.getCellContent(i + 1, j) != 0)
					&& (grid.getCellContent(i, j + 1) == 0) && (grid.getCellContent(i - 1, j + 1) != 0)
					&& (grid.getCellContent(i - 1, j) != 0) && (grid.getCellContent(i, j) == 0)) {

				open(i + 1, j + 1);
				open(i + 1, j);

				open(i - 1, j);
				open(i - 1, j + 1);

			}
			if ((grid.getCellContent(i, j - 1) == 0) && (grid.getCellContent(i + 1, j) != 0)
					&& (grid.getCellContent(i + 1, j - 1) != 0) && (grid.getCellContent(i - 1, j) != 0)
					&& (grid.getCellContent(i - 1, j - 1) != 0) && (grid.getCellContent(i, j) == 0)) {

				open(i + 1, j - 1);
				open(i + 1, j);

				open(i - 1, j);
				open(i - 1, j - 1);

			}
			if ((grid.getCellContent(i + 1, j + 1) != 0) && (grid.getCellContent(i, j - 1) != 0)
					&& (grid.getCellContent(i + 1, j) == 0) && (grid.getCellContent(i + 1, j - 1) != 0)
					&& (grid.getCellContent(i, j + 1) != 0) && (grid.getCellContent(i - 1, j + 1) != 0)
					&& (grid.getCellContent(i - 1, j) == 0) && (grid.getCellContent(i - 1, j - 1) != 0)
					&& (grid.getCellContent(i, j) == 0)) {

				open(i, j + 1);
				// open(i, j);
				open(i, j - 1);
			}

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GUI.setFace(img_shock);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		GUI.setFace(img_happy);

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "ButtonHandler buttonInfo=" + Arrays.toString(buttonInfoX);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
