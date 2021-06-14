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
	private static final int NUM_MINES = 15;
	private static final int size = 20;
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
	ImageIcon img_shock = new ImageIcon("surpriz.jpg");
	ImageIcon img_happy = new ImageIcon("happy2.png");

	public ButtonInfo msg;
	// private KalanMineSay�s� kms;
	private Font font;
	// private GUI gui;

	public ButtonHandler(int x, int y, MineGrid g) {
		row = x;
		col = y;
		grid = g;
		// buttonInfoX = new ButtonClass [x][y];
	}

	public void actionPerformed(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		msg = new ButtonInfo();
		// kms = new KalanMineSay�s�();
		// gui = new GUI();

		img_flag = new ImageIcon("flag.png");
		img_mine = new ImageIcon("mayin.png");
		img_empty = new ImageIcon("empty.png");
		img_xmay�n = new ImageIcon("xmay�n.png");
		img_sad = new ImageIcon("sad.png");

		ButtonClass button = (ButtonClass) e.getSource();

		// System.out.println(e.getButton());

		if (button.isLeftClicked() == false) {
			if (e.getButton() == 1 && !button.isFlag()) { // sol t�klan�rsa

				if (grid.isMine(row, col)) {
					button.setIcon(img_mine);
					GUI.setFace(img_sad);
					GUI.time.stop();
					JOptionPane.showMessageDialog(null, "   GAME OVER  !!!");
					
					for (int i = 0; i <= size; i++) {
						for (int k = 0; k <= size; k++) {
							if (button.isFlag() && grid.getCellContent(i, k) == - 1) {
									button.setIcon(img_xmay�n);
									System.out.println("olllol");
									 button.setEnabled(true);
				}else if (button.isFlag()){
					System.out.println("tersi");
				}
						}}
					
					for (int i = 0; i <= size; i++) {
						for (int k = 0; k <= size; k++) {
							if (grid.getCellContent(i, k) == -1) {
								open(i, k);
								button.setBackground(Color.red);
							}
							// button.setEnabled(false);
							// msg.getButtonInfoY()[i][k].setEnabled(false);
						}
					}
					for (int i = 0; i < size; i++) {
						for (int k = 0; k < size; k++) {
						
							
							if (grid.getCellContent(i, k) == 1) {
								//msg.getButtonInfoY()[i][k].setForeground(Color.BLUE);
								msg.getButtonInfoY()[i][k].setUI(new MetalButtonUI() {
								    protected Color getDisabledTextColor() {
								        return Color.blue;
								    }
								});
								msg.getButtonInfoY()[i][k].setEnabled(false);
							}if (grid.getCellContent(i, k) == 2) {
								//msg.getButtonInfoY()[i][k].setForeground(Color.BLUE);
								msg.getButtonInfoY()[i][k].setUI(new MetalButtonUI() {
								    protected Color getDisabledTextColor() {
								        return new Color(50, 185, 50);
								    }
								});
								msg.getButtonInfoY()[i][k].setEnabled(false);	
							}if (grid.getCellContent(i, k) == 3) {
								//msg.getButtonInfoY()[i][k].setForeground(Color.BLUE);
								msg.getButtonInfoY()[i][k].setUI(new MetalButtonUI() {
								    protected Color getDisabledTextColor() {
								        return Color.red;
								    }
								});
								msg.getButtonInfoY()[i][k].setEnabled(false);	
							}if (grid.getCellContent(i, k) == 4) {
								//msg.getButtonInfoY()[i][k].setForeground(Color.BLUE);
								msg.getButtonInfoY()[i][k].setUI(new MetalButtonUI() {
								    protected Color getDisabledTextColor() {
								        return new Color(148, 0, 211);
								    }
								});
								msg.getButtonInfoY()[i][k].setEnabled(false);	
							}if (grid.getCellContent(i, k) == 5) {
								//msg.getButtonInfoY()[i][k].setForeground(Color.BLUE);
								msg.getButtonInfoY()[i][k].setUI(new MetalButtonUI() {
								    protected Color getDisabledTextColor() {
								        return Color.YELLOW;
								    }
								});
								msg.getButtonInfoY()[i][k].setEnabled(false);	
							}						
							// msg.getButtonInfoY()[i][k].setContentAreaFilled(true);
						}
					}
					
					// System.exit(0);
				} else {
					if (e.getSource() instanceof ButtonClass) {
						ButtonClass[][] buttons = msg.getButtonInfoY();
						// buttons[row][col].setBackground(Color.red);

						// button = (JButton) e.getSource();
						/*
						 * open(row, col); open(row-1,col-1); open(row+1,col+1); open(row-1,col+1);
						 * open(row+1,col-1); open(row - 1, col); open(row + 1, col); open(row, col +
						 * 1); open(row, col - 1);
						 */

						if (grid.getCellContent(row, col) == 0) {
							clear(row, col);
						} else {
							open(row, col);
						}

						msg.setButtonInfoY(buttons);
						// button.setEnabled(false);
						// System.out.println(e.getButton());
					}
				}
				button.setLeftCick(true);
			} else if (e.getButton() == 3) { // sa� t�klan�rsa

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
}
