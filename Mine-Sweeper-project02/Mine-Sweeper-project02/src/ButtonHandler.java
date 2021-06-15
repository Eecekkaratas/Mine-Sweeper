import components.ButtonClass;
import components.ButtonInfo;
import components.Counter;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class ButtonHandler implements MouseListener {
	private static final int NUM_MINES = 40;
	private static final int size = 16;
	private final int row;
	private final int col;
	private final MineGrid grid;
	private static int success = 0;

	public ButtonClass[][] buttonInfoX;

	ImageIcon img_flag;
	ImageIcon img_mine;
	ImageIcon img_empty;
	ImageIcon img_sad;
	ImageIcon img_xmayin;
	ImageIcon img_shock = new ImageIcon("surpriz.jpg");
	ImageIcon img_happy = new ImageIcon("happy.jpg");

	public ButtonInfo msg = new ButtonInfo();

	public ButtonHandler(int x, int y, MineGrid g) {
		row = x;
		col = y;
		grid = g;

	}


	@SuppressWarnings("ResultOfMethodCallIgnored")
	@Override
	public void mouseClicked(MouseEvent e) {
		img_flag = new ImageIcon("flag.png");
		img_mine = new ImageIcon("mayin.png");
		img_empty = new ImageIcon("empty.png");
		img_xmayin = new ImageIcon("xmayin.png");
		img_sad = new ImageIcon("sad.jpg");

		ButtonClass button = (ButtonClass) e.getSource();

		if (button.isOpen()) {
			if (e.getButton() == 1 && !button.isFlag()) {

				if (grid.isMine(row, col)) {
					button.setIcon(img_mine);
					TopPanel.setFace(img_sad);
					TopPanel.time.stop();
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
								msg.getButtonInfoY()[i][k].setIcon(img_xmayin);
							}
							if (grid.getCellContent(i, k) == -1 && msg.getButtonInfoY()[i][k].isFlag()) {
								msg.getButtonInfoY()[i][k].setIcon(img_flag);
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
				button.setLeftCick();

			} else if (e.getButton() == 3)

			{

				if (!button.isFlag()) {
					button.setIcon(img_flag);

					button.setFlag(true);

					Counter.decreaseNum_of_mines();
					if (grid.isMine(row, col)) {
						success = success + 1;
						check(success);
						System.out.println(success + "success++");
					}

				} else {
					button.setIcon(null);
					button.setFlag(false);
					Counter.increaseNum_of_mines();
					if (grid.isMine(row, col)) {
						success = success - 1;
						System.out.println(success + "success--");
						check(success);
					}
				}

			} else {
				e.getButton();
			}
		}

	}

	public void check(int success) {
		if (success == NUM_MINES) {
			JOptionPane.showMessageDialog(null, "   You are a genius  !!!");
		}

	}

	public void open(int i, int j) {

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		ge.registerFont(new Font(Font.SERIF,Font.BOLD,18));

		msg = new ButtonInfo();
		try {

			if (grid.getCellContent(i, j) == -1) {
				msg.getButtonInfoY()[i][j].setIcon(img_mine);
				msg.getButtonInfoY()[i][j].setOpen(true);
			} else if (grid.getCellContent(i, j) == 0) {
				msg.getButtonInfoY()[i][j].setIcon(img_empty);
				msg.getButtonInfoY()[i][j].setBackground(new Color(160, 160, 160));

				msg.getButtonInfoY()[i][j].setOpen(true);
				msg.getButtonInfoY()[i][j].setEnabled(false);
			} else {
				msg.getButtonInfoY()[i][j].setFont(new Font(Font.SERIF,Font.BOLD,18));
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
		} catch (ArrayIndexOutOfBoundsException ignored) {
		}
	}

	public void clear(int i, int j) {
		msg = new ButtonInfo();
		ButtonClass[][] buttons = msg.getButtonInfoY();

		if (i < size && j < size && i >= 0 && j >= 0 && buttons[i][j].isOpen()) { // isInsideGrid methodu var
			open(i, j);
			if (grid.getCellContent(i - 1, j - 1) == 0) { // sol üst köþe
				clear(i - 1, j - 1);
				if (grid.getCellContent(i - 2, j - 2) != 0 && grid.getCellContent(i - 2, j - 2) != -1) {
					open(i - 2, j - 2);
				}
			}
			if (grid.getCellContent(i - 1, j) == 0) { // üst
				clear(i - 1, j);
				open(i - 2, j - 1);
				open(i - 2, j);
				open(i - 2, j + 1);
			}
			if (grid.getCellContent(i - 1, j + 1) == 0) { // sað üst köþe
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
			if (grid.getCellContent(i, j + 1) == 0) { // sað yan
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
			if (grid.getCellContent(i + 1, j - 1) == 0) { // sol alt köþe
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
			if (grid.getCellContent(i + 1, j + 1) == 0) { // sað alt köþe
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
		TopPanel.setFace(img_shock);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		TopPanel.setFace(img_happy);

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



}
