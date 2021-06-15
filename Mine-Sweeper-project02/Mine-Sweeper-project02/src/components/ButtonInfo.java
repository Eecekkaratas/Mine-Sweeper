package components;

public class ButtonInfo {
	private static final int size = 16;
	private static ButtonClass[][] buttonInfoY = new ButtonClass[size][size];

	public ButtonClass[][] getButtonInfoY() {
		return buttonInfoY;
	}

	public void setButtonInfoY(ButtonClass[][] buttonInfoY) {
		ButtonInfo.buttonInfoY = buttonInfoY;
	}

	public ButtonInfo() {

	}

	

}