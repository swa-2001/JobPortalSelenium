package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import TestComponents.BaseTest;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.BrowseJobsPage;

public class HomePageTest extends BaseTest {
	//WebDriver driver = new ChromeDriver();
	LoginPage loginpage;
	
//	@BeforeMethod
//	public void login() {
//		LoginPage page = launchApp();
//		homepage = page.signin("demo@jobportal.com","demo123",driver);
//		
//	}

	@Test
	public void featured_jobs_list() {
//		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
		
//		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
//		driver.findElement(By.id("signin-email")).sendKeys("demo@jobportal.com");
//		driver.findElement(By.id("signin-password")).sendKeys("demo123");
//		driver.findElement(By.id("btn-signin")).click();
		loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		loginpage.signin("demo@jobportal.com","demo123");
		List<String> names=homepage.featured_jobs_list_name();
		System.out.println(names);
	}
	
	@Test(groups = "runthis")
	public void quick_job_search_by_location() {
		loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.signin("demo@jobportal.com","demo123");
		homepage.quick_search_location("New York");
		BrowseJobsPage browseJobsPage=homepage.click_search_jobs();
	}
	
	@Test(groups = "runthis")
	public void quick_job_search_by_title() {
		loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.signin("demo@jobportal.com","demo123");
		homepage.quick_search_title("Software");
		BrowseJobsPage browseJobsPage=homepage.click_search_jobs();
	}
	
	@Test
	public void quick_job_search_by_type() {
		loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.signin("demo@jobportal.com","demo123");
		homepage.quick_search_type("Full-time");
		BrowseJobsPage browseJobsPage=homepage.click_search_jobs();
	}
	
}

