package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class MyApplicationsAllTabPage extends AbstractComponents{
	WebDriver driver;
	public MyApplicationsAllTabPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By applications_list = By.id("applications-list");
	private By application_status = By.id(".status-badge");
	
	
}

