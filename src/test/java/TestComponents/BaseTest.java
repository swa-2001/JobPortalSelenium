package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
//		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
	}
	
	
	@AfterMethod
	public void teardown() {
		if(driver!=null){
			driver.quit();
		}
	}
}
