package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageObjects.BrowseJobsPage;
import PageObjects.CompaniesPage;
import PageObjects.HomePage;
import PageObjects.MyApplicationsAllTabPage;
import PageObjects.ProfilePage;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver){
		this.driver = driver;
	}
	
	//header tab
	public By logout_btn = By.id("btn-logout");
	public By logged_in_username = By.id("user-name");
	//Navigation tab
	public By home_tab = By.id("nav-home");
	public By browse_jobs_tab = By.id("nav-jobs");
	public By companies_tab = By.id("nav-companies");
	public By my_applications_tab = By.id("nav-applications");
	public By profile_tab = By.id("nav-profile");

	public HomePage click_home_page() {
		driver.findElement(home_tab).click();
		HomePage homepage=new HomePage(driver);
		return homepage;
	}
	public BrowseJobsPage click_browse_jobs_tab() {
		driver.findElement(browse_jobs_tab).click();
		BrowseJobsPage browsejobspage = new BrowseJobsPage(driver);
		return browsejobspage;
	}
	public CompaniesPage click_companies_tab() {
		driver.findElement(companies_tab).click();
		CompaniesPage companiestab= new CompaniesPage(driver);
		return companiestab;
	}
	public MyApplicationsAllTabPage click_my_applications_tab() {
		driver.findElement(my_applications_tab).click();
		MyApplicationsAllTabPage applications = new MyApplicationsAllTabPage(driver);
		return applications;
	}
	
	public ProfilePage click_profile_tab() {
		driver.findElement(profile_tab).click();
		ProfilePage profilepage = new ProfilePage(driver);
		return profilepage;
	}
}
