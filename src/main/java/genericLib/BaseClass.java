package genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// declare globally

	public WebDriver driver;
	public PropertyFile pdata = new PropertyFile();


	public WebDriverDriverUtilies driverutilies = new WebDriverDriverUtilies();
@Parameters({"Browsers"})
	@BeforeMethod

	public void openApp(String browser) throws IOException {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(pdata.getPropertyfiledata("url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}


	@AfterMethod

	public void CloseApp(ITestResult result) throws IOException {

	int status = result.getStatus();
	String name = result.getName();
	if(status==2) {

	  Screenshot s = new Screenshot();
	  s.getPhoto(driver, name);
	}


	driver.quit();

	}






}
