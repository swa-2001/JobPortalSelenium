package PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponents;

public class BrowseJobsPage extends AbstractComponents {
	WebDriver driver;
	public BrowseJobsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	private By page_title = By.cssSelector("#page-jobs h2");
	private By all_jobs_list = By.id("all-jobs-list");
	private By job_card = By.cssSelector("#all-jobs-list .job-card");
	private By job_title = By.cssSelector("#all-jobs-list .job-card .job-info h3");
	private By company_name =By.cssSelector("#all-jobs-list .job-card .job-info .company-name");
	private By apply_btn = By.cssSelector("#all-jobs-list .job-card .job-actions .btn-apply");
	private By save_btn =By.cssSelector("#all-jobs-list .job-card .job-actions .btn-save");
	private By message_box=By.id("message-box");
	
	
	
	public int no_of_jobs_list() {
		List<WebElement> jobs = driver.findElements(job_card);
		return jobs.size();
	}
	
	public void apply_job(String job_title_parameter,String company_name_parameter) {
		List<WebElement> jobcards=driver.findElements(job_card);
		WebElement correctJobCard = jobcards.stream().filter(
				card->{
					String title=card.findElement(By.cssSelector(".job-info h3")).getText();
					String company = card.findElement(By.cssSelector(".company-name")).getText();
					return title.equals(job_title_parameter)&& company.equals(company_name_parameter);
				}).findFirst().orElseThrow(()->new RuntimeException("Job not found"));
		WebElement applyButton = correctJobCard.findElement(By.cssSelector(".btn-apply"));
		applyButton.click();
		Wait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(message_box)));
	}
	public void apply_for_job_twice(String job_title_parameter,String company_name_parameter) {
		List<WebElement> jobcards=driver.findElements(job_card);
		WebElement correctJobCard = jobcards.stream().filter(
				card->{
					String title=card.findElement(By.cssSelector(".job-info h3")).getText();
					String company = card.findElement(By.cssSelector(".company-name")).getText();
					return title.equals(job_title_parameter)&& company.equals(company_name_parameter);
				}).findFirst().orElseThrow(()->new RuntimeException("Job not found"));
		WebElement applyButton = correctJobCard.findElement(By.cssSelector(".btn-apply"));
		applyButton.click();
		applyButton.click();
		Wait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(message_box)));
	}
	
	public String getMessage() {
		return driver.findElement(message_box).getText();
	}
	
}
