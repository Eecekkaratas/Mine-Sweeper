package components;

import javax.swing.JButton;

public class ButtonClass extends JButton {
	private boolean flag;
	private boolean open;


	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setLeftCick() {
	}
	
	public boolean isOpen(){ // açýksa 1
		return !open;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
}
