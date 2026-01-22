package week3.day2;

public class CheckBoxButton extends Button {
	
	public void clickCheckButton() {
		System.out.println("Check Box button class");		
	}
	
	public static void main(String[] args) {
		CheckBoxButton check = new CheckBoxButton();
		check.click();
		check.setText("CheckBox class");
		check.submit();
		check.clickCheckButton();
	}

}
