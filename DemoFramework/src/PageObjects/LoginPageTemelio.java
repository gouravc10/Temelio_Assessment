package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageTemelio {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	
	
	public LoginPageTemelio(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		jse = (JavascriptExecutor)driver;
		
	}
	
	@FindBy(className = "chakra-image")
	WebElement logo;
	public boolean islogoDisplayed() {
		
		return logo.isDisplayed();
	}
	@FindBy(id = "username")
	WebElement emailTextBox ;
	public void enterEmailId(String userName) {
		emailTextBox.sendKeys(userName);
		
		
	}
	@FindBy(id = "password")
	WebElement passwordTextBox ;
	public void EnterPassword(String password) {
		passwordTextBox.sendKeys(password);	
	}
	
	@FindBy(id = "signin-button")
	WebElement signInBtn ;
	public void clicksignInBtn() {
		signInBtn.click();
		
	}
	
	public void loginWithUser(String email, String password) {
		enterEmailId(email);
		EnterPassword(password);
		clicksignInBtn();
		
	}
	
//	
//	@FindBy(xpath = "//button[@aria-label='Open entity switcher']")
//	WebElement settingMenuArrow;
//	public void clicksettingMenu() {
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Open entity switcher']")));
//		settingMenuArrow.click();
//		
//	}
//	@FindBy(xpath = "//div[contains(text(),'Team Settings')]")
//	WebElement teamSettingOpt;
//	public void goTOteamSettingOpt() {
////	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Team Settings')]")));
//		
//	jse.executeScript("arguments[0].click();", teamSettingOpt);
//	}
//	
//	@FindBy(xpath = "//div[contains(text(),'Settings')]")
//	WebElement SettingOpt;
//	public void clickSettingOpt() {
//		SettingOpt.click();
//	}
//	
//	@FindBy(xpath = "//button[contains(text(),'Add Team Member +')]")
//	WebElement addTeamMemberBtn;
//	public void clickaddTeamMemberBtn() {
//		addTeamMemberBtn.click();
//	}
//	
//	@FindBy(name = "displayName")
//	WebElement addNameOfNewUser;
//	public void addNameOfNewUser(String name) {
//		addNameOfNewUser.sendKeys(name);
//	}
//	
//	@FindBy(name = "email")
//	WebElement addemailOfNewUser;
//	public void addEmailNewUser(String email) {
//		addemailOfNewUser.sendKeys(email);
//	}
//	
//	@FindBy(name = "title")
//	WebElement addtitleOfNewUser;
//	public void addTitleNewUser(String title) {
//		addtitleOfNewUser.sendKeys(title);
//	}
	
//	@FindBy(name = "title")
//	WebElement addtitleOfNewUser;
//	public void addTitleNewUser(String title) {
//		addtitleOfNewUser.sendKeys(title);
//	}
//	
	
	
	
	
}
