package TestComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

import PageObjects.LoginPage;

public class BaseTest {
	
	
	


	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	WebDriver driver;
	LoginPage page;

	public WebDriver initializeDriver(ChromeOptions options) {
		driver=new ChromeDriver(options);
		setDriver(driver);
		return driver;
	}
	//	public static synchronized WebDriver getDriver() {
	//		return tlDriver.get();
	//	}
	//	
	//	
//	@BeforeMethod(alwaysRun=true)
//	public LoginPage launchApp() {
//		driver=initializeDriver();
//		page=new LoginPage(driver);
//		page.firstpage(driver);
//		return page;
//	}
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	public void setDriver(WebDriver driver) {
		tlDriver.set(driver);
	}

	@BeforeMethod(alwaysRun=true)    //When specifying groups in testng.xml file, it will not consider this because it does not 
	public void setup() {		// have group, so we have to specify this attribute
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = initializeDriver(options);
//		WebDriver driver = new ChromeDriver(options);
		//		driver = new ChromeDriver(options);
		//		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir")+"\\src\\main\\resources\\frontEndCode\\JobPortal.html");
//		tlDriver.set(driver);
	}

	public List<HashMap<String,String>> getJsonDatafile(String filepath) throws IOException {

		//reading json to string
		String jsonContent = 	FileUtils.readFileToString(new File(filepath)

				,StandardCharsets.UTF_8);


		//String to HashMap     Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});

		return data;

	}


	public String getScreenshot(String testname,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//reports//"+testname+"//.png"));
		return System.getProperty("user.dir")+"//reports//"+testname+"//.png";
	}


	@AfterClass(alwaysRun=true) //When specifying groups in testng.xml file, it will not consider this because it does not 
	public void teardown() {		// have group, so we have to specify this attribute
		WebDriver driver = getDriver();
		if(driver!=null){
						driver.quit();
			//			tlDriver.remove();
		}
	}
	
}
