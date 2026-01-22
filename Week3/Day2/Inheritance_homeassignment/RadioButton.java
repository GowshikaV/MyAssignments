package week3.day2;

public class RadioButton extends Button {
	
	public void selectRadioButton() {
		
		System.out.println("Radio Button class");
		
	}
	
	public static void main(String[] args) {
		RadioButton radio = new RadioButton();
		radio.click();
		radio.setText("Radio class");
		radio.submit();
		radio.selectRadioButton();
	}

}
