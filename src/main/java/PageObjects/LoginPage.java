package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	
	private By email_id = By.id("signin-email");
	private By pass=By.id("signin-password");
	private By remember_me = By.id("remember-me");
	private By sign_in_btn=By.id("btn-signin");
	private By sign_in_tab = By.id("tab-signin");
	private By sign_up_tab=By.id("tab-signup");
	private By sign_up_name = By.id("signup-name");
	private By sign_up_password = By.id("signup-password");
	private By sign_up_confirm_pass = By.id("signup-confirm-password");
	private By create_acc_btn = By.id("btn-signup");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public HomePage signin(String email_id_para,String password_para) {
		driver.findElement(email_id).sendKeys(email_id_para);
		driver.findElement(pass).sendKeys(password_para);
		driver.findElement(sign_in_btn).click();
		Wait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("header-logo"))));
		
		HomePage homepage = new HomePage(driver);
		return homepage;
		
		
	}

	
	public void firstpage(WebDriver driver) {
		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
	}

}
