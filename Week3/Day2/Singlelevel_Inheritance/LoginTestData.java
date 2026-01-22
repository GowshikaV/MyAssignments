package week3.day2;

public class LoginTestData extends TestData {
	
	public void enterUsername() {
		System.out.println("Enter the UserName");
	}
	
	public void enterPassword() {
		System.out.println("Enter the Password");
	}
	
	public static void main(String[] args) {
		LoginTestData data = new LoginTestData();
		data.enterCredentials();
		data.enterUsername();
		data.enterPassword();
		data.navigateToHomePage();
	}

}
