package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.DashboardPage;
import PageObjects.LoginPageTemelio;
import PageObjects.TeamSettingPage;
import Utils.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.WebDriver;


public class UserCreationTest extends BrowserConfiguration{
String newUserEmail = "imgolabc+auto1@gmail.com";

	
	
//	@Test
//	void logoTest() {
//		LoginPageTemelio lgn = new LoginPageTemelio(driver);
//		lgn.islogoDisplayed();
//		
//		
//	}
   
	@Test
	void createNewUser() throws InterruptedException {
		LoginPageTemelio lgn = new LoginPageTemelio(driver);
		DashboardPage dash = new DashboardPage(driver);
		TeamSettingPage teamPage = new TeamSettingPage(driver);
		
		
		lgn.loginWithUser("imgolabc+temelio@gmail.com", "Test@123");
		dash.clicksettingMenu();
		dash.goTOteamSettingOpt();
		teamPage.clickaddTeamMemberBtn();
		teamPage.addNameOfNewUser("New user");
		teamPage.addEmailNewUser("email");
		teamPage.addTitleNewUser("titletest");
		teamPage.SelectRoleFromDropdown("Admin"); //Admin , User
		teamPage.clickCreateBtn();
		if(teamPage.verify_invalidMailErrorMsg()) {
			teamPage.clearEmailNewUser();
			teamPage.addEmailNewUser(newUserEmail);
		}
		teamPage.clickCreateBtn();
//		teamPage.DeleteUser("TESTNAME");
		
		
//		teamPage.verify_ThisfieldisrequiredErrorMsg();
		
		//Verify email validation
		//mandatory fields
	}
	
	
}
