package PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	private By active_jobs=By.id("hero-jobs-count");
	private By companies = By.id("hero-companies-count");
	private By candidate_count=By.id("hero-candidates-count");
	private By search_keyword = By.id("home-search-keyword");
	private By job_location = By.id("home-search-location");
	private By job_type = By.id("home-search-type");
	private By filtered_jobs_list=By.id("featured-jobs");
	private By featured_jobs_list =By.id("featured-jobs");// #featured-jobs.job-card.job-info h3
	private By search_jobs_btn = By.id("btn-home-search");															// .job-card .job-info h3
	
	public List<String> featured_jobs_list_name(){
		WebElement featured_list = driver.findElement(featured_jobs_list);
		List<WebElement> names = featured_list.findElements(By.cssSelector(".job-card .job-info h3"));
		List<String> job_names = names.stream().map(w->w.getText()).collect(Collectors.toList());
		return job_names;
	}
	
	public void quick_search_title(String title) {
		driver.findElement(search_keyword).sendKeys(title);
	}
	public void quick_search_location(String loc) {
		Select select = new Select(driver.findElement(job_location));
		List<WebElement> options=select.getOptions();
		List<WebElement> option = options.stream().filter(w->w.getText().equals(loc)).collect(Collectors.toList());
		option.get(0).click();
	}
	public void quick_search_type(String job_type_option) {
		Select select = new Select (driver.findElement(job_type));
		List<WebElement> types=select.getOptions();
		List<WebElement> type=types.stream().filter(w->w.getText().equals(job_type_option)).collect(Collectors.toList());
		type.get(0).click();
	}
	public BrowseJobsPage click_search_jobs() {
		driver.findElement(search_jobs_btn).click();
		BrowseJobsPage browseJobsPage= new BrowseJobsPage(driver);
		return browseJobsPage;
	}

}
