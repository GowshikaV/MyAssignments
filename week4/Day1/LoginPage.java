package week4.day1;

public class LoginPage extends BasePage {
	
	@Override
	public void performCommonTasks() {
		System.out.println("Perform Common tasks from Login page (Subclass)");
		super.performCommonTasks();
	}
	
	
	
	public static void main(String[] args) {
		LoginPage login = new LoginPage();
		login.clickElement();
		login.findElement();
		login.enterText();
		login.performCommonTasks();
	}
}
