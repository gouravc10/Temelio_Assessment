package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfiguration {

	public static WebDriver driver;
	
	@BeforeTest
	void initsetup() {
//		System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe" );	
//		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
	 	driver = new ChromeDriver();
	 	
	 	
	 	
	}
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	void getURL() {
		
		driver.get("https://app-dev.trytemelio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	@BeforeMethod
	public void setDriver(ITestContext context){

	  context.setAttribute("driver", driver);
	}
//	@AfterTest
//	public void close(){
//
//	  driver.close();
//	}
//	
}
