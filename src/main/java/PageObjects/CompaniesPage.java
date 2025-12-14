package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.AbstractComponents;

public class CompaniesPage extends AbstractComponents{
	WebDriver driver;
	public CompaniesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	private By company_card_list=By.id("companies-list");
	private By company_names=By.cssSelector(".company-card h3");
	private By company_view_jobs_button = By.cssSelector(".company-card button");
	private By no_of_employees = By.cssSelector(".company-info .company-info-item:nth-child(1)");
	private By company_open_positions = By.cssSelector(".company-info .company-info-item:nth-child(2)");
	
}
