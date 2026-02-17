package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ReadExcel;

public class BaseClass {
	
	public ChromeDriver driver;
	public String filename;
	public String sheetname;
	
	@BeforeMethod
	public void preCondition () {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		driver = new ChromeDriver(opt);
		driver.get("http://leaftaps.com/opentaps/.");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterMethod
	public void postConditon () {
		driver.quit();
	}
	
	@DataProvider (name= "fetchdata")
	public String[][] sendData () throws IOException {
		String[][] data = ReadExcel.readData(filename, sheetname);
		return data;
	}

}
