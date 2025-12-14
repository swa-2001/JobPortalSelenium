package TestComponents;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

import PageObjects.LoginPage;

public class BaseTest {
	public WebDriver driver;
	LoginPage page;
	
//	public WebDriver initializeDriver() {
//		driver=new ChromeDriver();
//		return driver;
//	}
//	
//	
//	@BeforeMethod(alwaysRun=true)
//	public LoginPage launchApp() {
//		driver=initializeDriver();
//		page=new LoginPage(driver);
//		page.firstpage(driver);
//		return page;
//	}

	@BeforeMethod(alwaysRun=true)    //When specifying groups in testng.xml file, it will not consider this because it does not 
	public void setup() {				// have group, so we have to specify this attribute
		driver = new ChromeDriver();
//		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
	}
	
	public String getScreenshot(String testname,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//reports//"+testname+"//.png"));
		return System.getProperty("user.dir")+"//reports//"+testname+"//.png";
	}
	
	
	@AfterMethod(alwaysRun=true) //When specifying groups in testng.xml file, it will not consider this because it does not 
	public void teardown() {		// have group, so we have to specify this attribute
		if(driver!=null){
			driver.quit();
		}
	}
}
