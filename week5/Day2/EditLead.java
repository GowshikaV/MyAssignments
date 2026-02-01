package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecificMethod{

	@Test
	public void editLead() throws InterruptedException {

			
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Company");
			driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("gowshika");
			driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Viswanathan");
			driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("gowsh");
			driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Devops");
			driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Funtional Testing");
			driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("testleaf@gmail.com");
			WebElement opt = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
			Select option = new Select(opt);
			option.selectByVisibleText("New York");
			driver.findElement(By.xpath("//input[@name='submitButton']")).click();
			driver.findElement(By.linkText("Edit")).click();
			driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']"))
					.sendKeys("Very Important Note");
			driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
			driver.findElement(
					By.xpath("//div[@class='fieldgroup-body']//tbody[1]/tr[12]/td/following-sibling::td/input"))
					.click();

			// Get Title of the page
			String title = driver.getTitle();
			System.out.println(title);

			

	}

}
