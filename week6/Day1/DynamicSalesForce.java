package week6.day1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicSalesForce extends SalesForceBaseClass {
	
	@BeforeTest
	public void setvalue() {
		filename = "salesforce";
	}
   // @DataProvider (name = "fetchdata") 
    //public String[][] sendData () {
    	/*String [][] data = new String [3][1];
    	data [0][0] = "Name1";
    	data [1][0] = "Name2";
    	data [2][0] = "Name3" ;*/
    	//return data;
    //}
    
    
    @Test (dataProvider = "fetchdata")
	public void createEntity(String name) {
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by "+name);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String Name = driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text")).getText();
		System.out.println(Name);
		if (Name.contains(name)) {
			System.out.println("EntityName verified Successfully");
		}

	}
}
