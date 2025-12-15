package PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class MyApplicationsAllTabPage extends AbstractComponents{
	WebDriver driver;
	public MyApplicationsAllTabPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By applications_list = By.id("applications-list");
	private By application_status = By.id(".status-badge");
	
	public List<String> myapplications(){
		WebElement applicationList= driver.findElement(applications_list);
		List<WebElement> applications= applicationList.findElements(By.cssSelector(".job-card .job-info h3"));
		List<String> applicationTitles=applications.stream().map(w->w.getText()).collect(Collectors.toList());
		return applicationTitles;
	}
	
}

