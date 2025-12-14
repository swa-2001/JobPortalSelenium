package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
	WebDriver driver;
	public ProfilePage(WebDriver driver) {
		this.driver=driver;
	}

	private By name=By.id("profile-name");
	private By profile_title=By.id("profile-title");
	private By applications_count=By.id("profile-applications-count");
	private By saved_jobs = By.id("profile-saved-jobs");
	private By skills_list = By.id("profile-skills");
}
