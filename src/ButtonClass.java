import javax.swing.JButton;

public class ButtonClass extends JButton {
	private boolean flag;
	private boolean leftclick;
	private int count;
	private boolean open;
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isLeftClicked() {
		return leftclick;
	}

	public void setLeftCick(boolean leftclick) {
		this.leftclick = leftclick;
	}
	
	public boolean isOpen(){ // açýksa 1
		return open;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
}
