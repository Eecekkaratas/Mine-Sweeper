public class ButtonInfo {
	private static final int size = 20;
	private static ButtonClass[][] buttonInfoY = new ButtonClass[size][size];
	private int num_of_mines = 15;
	
	public ButtonClass[][] getButtonInfoY() {
		return buttonInfoY;
	}

	public void setButtonInfoY(ButtonClass[][] buttonInfoY) {
		this.buttonInfoY = buttonInfoY;
	}

	public ButtonInfo() {

	}

	

}