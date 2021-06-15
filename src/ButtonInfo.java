public class ButtonInfo {
	private static final int size = 16;
	private static ButtonClass[][] buttonInfoY = new ButtonClass[size][size];
	private int num_of_mines = 40;
	
	public ButtonClass[][] getButtonInfoY() {
		return buttonInfoY;
	}

	public void setButtonInfoY(ButtonClass[][] buttonInfoY) {
		this.buttonInfoY = buttonInfoY;
	}

	public ButtonInfo() {

	}

	

}