package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BrowseJobsPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestComponents.BaseTest;

public class BrowseJobsTest extends BaseTest  {

	LoginPage loginpage;
	
	@Test
	public void jobs_count() {
		loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.signin("demo@jobportal.com","demo123");
		BrowseJobsPage browsejobspage = homepage.click_browse_jobs_tab();
		int count = browsejobspage.no_of_jobs_list();
		System.out.println(count);
	}
	
	@Test
	public void apply_for_job() {
		loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.signin("demo@jobportal.com","demo123");
		BrowseJobsPage browsejobspage = homepage.click_browse_jobs_tab();
		browsejobspage.apply_job("Senior Software Engineer", "Tech Solutions Inc");
		Assert.assertEquals(browsejobspage.getMessage(), "Application submitted successfully!");
		
	}
	
	@Test
	public void apply_for_job_twice() {
		loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.signin("demo@jobportal.com","demo123");
		BrowseJobsPage browsejobspage = homepage.click_browse_jobs_tab();
		browsejobspage.apply_for_job_twice("Senior Software Engineer", "Tech Solutions Inc");
		Assert.assertEquals(browsejobspage.getMessage(), "You have already applied for this position");
	}
	
}
