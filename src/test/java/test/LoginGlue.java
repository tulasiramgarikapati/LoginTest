package test;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utility.TestUtility;

public class LoginGlue 
{
	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public TestUtility tu;
	public Scenario s;
	public WebDriverWait wait;
	public ExtentReports er;
	public ExtentTest et;
	
	
	@Before
	public void method(Scenario s)
	{
		this.s=s;
		tu=new TestUtility();
		
		er = new ExtentReports("C:\\Users\\tulas\\eclipse-workspace\\LoginTest\\testlogin.html",true);
		et = er.startTest("Login page test");
	}
	
	@After
	public void method99()
	{
		er.endTest(et);
		er.flush();
	}
	
	@Given("^launch site using chromebrowser$")
	public void method1() throws InterruptedException
	{
		driver = tu.openBrowser();
		tu.launchSite(driver, "http://localhost:8080/LoginDev/");
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		//Thread.sleep(5000);
		//Create Wait Object
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(lp.uid));
	}
	@When("^enter \"(.*)\" as username$")
	public void menthod2(String x) throws InterruptedException
	{
		lp.uidfill(x);
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(lp.next));
	}
	
	@And("^enter \"(.*)\" as password$")
	public void menthod3(String x) throws InterruptedException
	{
		lp.pwdfill(x);
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(lp.next));
	}
	
	@And("^click submit$")
	public void method4() throws InterruptedException
	{
		lp.next.click();
		//Thread.sleep(5000);
	}
	
	@When("^close site$")
	public void menthod6()
	{
		tu.closeSite(driver);
	}
	
	@Then("^validate output for \"(.*)\" as critiria$")
	public void method5(String c) throws IOException
	{
		try
		{
			if(c.equalsIgnoreCase("bothblank") && lp.blankuid.isDisplayed()) 
			{
				et.log(LogStatus.PASS, "Blank username and password test passed");
				s.log("Blank username and password test passed");
			}
			else if(c.equalsIgnoreCase("uidblank") && lp.blankuid.isDisplayed())
			{
				et.log(LogStatus.PASS, "Blank username test passed");
				s.log("Blank username test passed");
			}
			else if(c.equalsIgnoreCase("pwdblank") && lp.blankpwd.isDisplayed())
			{
				et.log(LogStatus.PASS, "Blank password test passed");
				s.log("Blank password test passed");
			}
			else if(c.equalsIgnoreCase("invalid") && lp.invalid.isDisplayed())
			{
				et.log(LogStatus.PASS, "Invalid credentials test passed");
				s.log("Invalid credentials test passed");
			}
			else if(c.equalsIgnoreCase("valid") && hp.successtext.isDisplayed())
			{
				et.log(LogStatus.PASS, "Valid credentials test passed");
				s.log("Valid credentials test passed");
			}
			else
			{
				String fname = tu.pageScreenShot(driver);
				et.log(LogStatus.FAIL, et.addScreenCapture(fname)+"Test Failed");
				
				byte[] b = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.attach(b, "image/png", "report");
				Assert.fail();
			}
		}
		catch(Exception e)
		{
			String fname = tu.pageScreenShot(driver);
			et.log(LogStatus.FAIL, et.addScreenCapture(fname)+e.getMessage());
			
			byte[] b = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Assert.fail();
		}
	}
}
