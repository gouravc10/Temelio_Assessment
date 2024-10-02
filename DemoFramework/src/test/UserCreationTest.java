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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@Listeners(TestListener.class)
public class UserCreationTest extends BrowserConfiguration{
String newUserEmail = "imgolabc+auto1@gmail.com";

	

//Old-Code
//	@Test
	void createNewUser() throws InterruptedException {
		LoginPageTemelio lgn = new LoginPageTemelio(driver);
		DashboardPage dash = new DashboardPage(driver);
		TeamSettingPage teamPage = new TeamSettingPage(driver);
		
		getURL("https://app-dev.trytemelio.com/");
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
	@Test
	void tagToggleEdit() throws InterruptedException {
		LoginPageTemelio lgn = new LoginPageTemelio(driver);
		DashboardPage dash = new DashboardPage(driver);
		TeamSettingPage teamPage = new TeamSettingPage(driver);
		
		getURL("https://app-dev.trytemelio.com/foundation/c191396d-d720-4eb0-b779-7fe369f4e09a/settings/admin");
		lgn.loginWithUser("imgolabc+temelio@gmail.com", "Test@123");
		
		//Provide the String = text we want to target, ig there's any other tag, we only need to change the script here
		String textToClick = "climate";
		
		//Driver will scroll to the particular tag
		dash.scrollToText(textToClick);
		
		//it will click on a toggle button of a particular tag
		dash.clicktagToggleBtn(textToClick);
		
		//it will double click on the text to edit
		dash.doubleClickclimatetxt(textToClick);
		
		//we will add the updated text and press enter
		dash.editTagtxtbox(textToClick,"Climate "+ Math.random()+ Keys.ENTER);
		
		
	
	}
}
