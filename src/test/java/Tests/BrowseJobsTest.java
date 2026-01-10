package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BrowseJobsPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;

public class BrowseJobsTest extends BaseTest  {

	// Helper method to login and navigate to Browse Jobs page
	//new comment for testing webhooks in jenkins
		private BrowseJobsPage loginAndGetBrowseJobsPage() {
			WebDriver driver = getDriver();
			LoginPage loginpage = new LoginPage(driver);
			HomePage homepage = loginpage.signin("demo@jobportal.com", "demo123");
			return homepage.click_browse_jobs_tab();
		}
	
	@Test
	public void jobs_count() {
		
		BrowseJobsPage browsejobspage = loginAndGetBrowseJobsPage();
		int count = browsejobspage.no_of_jobs_list();
		System.out.println(count);
	}
	
	@Test
	public void apply_for_job() {
		BrowseJobsPage browsejobspage = loginAndGetBrowseJobsPage();
		browsejobspage.apply_job("Senior Software Engineer", "Tech Solutions Inc");
		Assert.assertEquals(browsejobspage.getMessage(), "Application submitted successfully!");
		
	}
	
	@Test
	public void apply_for_job_twice() {
		BrowseJobsPage browsejobspage = loginAndGetBrowseJobsPage();
		browsejobspage.apply_for_job_twice("Senior Software Engineer", "Tech Solutions Inc");
		Assert.assertEquals(browsejobspage.getMessage(), "You have already applied for this position");
	}
	
}
