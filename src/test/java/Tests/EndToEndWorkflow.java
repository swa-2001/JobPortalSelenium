package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BrowseJobsPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyApplicationsAllTabPage;
import TestComponents.BaseTest;

public class EndToEndWorkflow extends BaseTest {
	LoginPage loginpage;
	
	@Test(dataProvider = "getData")
	public void endtoend(HashMap<String,String> input) {   //This test alone will run twice 
		String title1="Senior Software Engineer"; // once with first job title
		String title2="Product Manager";			// second times with another job title
		String comp1="Tech Solutions Inc";
		String comp2="Innovation Labs";
		loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.signin("demo@jobportal.com","demo123");
		BrowseJobsPage browsejobspage = homepage.click_browse_jobs_tab();
		browsejobspage.apply_job(input.get("jobtitle"),input.get("Companyname"));
		MyApplicationsAllTabPage applicationstab=homepage.click_my_applications_tab();
		List<String> applications = applicationstab.myapplications();
		Assert.assertEquals(input.get("jobtitle"), applications.get(0));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
//		Object[][] obj=new Object[2][2];
//		obj[0][0]= "Senior Software Engineer";
//		obj[0][1]="Tech Solutions Inc";
//		obj[1][0] = "Product Manager";
//		obj[1][1]="Innovation Labs";
//		return obj;
		
		List<HashMap<String,String>> data = getJsonDatafile(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\ApplyJobs.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
