package PageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

public class TeamSettingPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	
	
	public TeamSettingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		jse = (JavascriptExecutor)driver;
		
	}
	
	
	@FindBy(xpath = "//button[@aria-label='Open entity switcher']")
	WebElement settingMenuArrow;
	public void clicksettingMenu() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Open entity switcher']")));
		settingMenuArrow.click();
		
	}
	@FindBy(xpath = "//div[contains(text(),'Team Settings')]")
	WebElement teamSettingOpt;
	public void goTOteamSettingOpt() {
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Team Settings')]")));
		
	jse.executeScript("arguments[0].click();", teamSettingOpt);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Settings')]")
	WebElement SettingOpt;
	public void clickSettingOpt() {
		SettingOpt.click();
	}
	
	@FindBy(xpath = "//button[contains(text(),'Add Team Member +')]")
	WebElement addTeamMemberBtn;
	public void clickaddTeamMemberBtn() {
		addTeamMemberBtn.click();
	}
	
	@FindBy(name = "displayName")
	WebElement addNameOfNewUser;
	public void addNameOfNewUser(String name) {
		addNameOfNewUser.sendKeys(name);
	}
	
	@FindBy(name = "email")
	WebElement addemailOfNewUser;
	public void addEmailNewUser(String email) {
		addemailOfNewUser.sendKeys(email);
	}
	public void clearEmailNewUser() {
		addemailOfNewUser.clear();
	}
	
	@FindBy(name = "title")
	WebElement addtitleOfNewUser;
	public void addTitleNewUser(String title) {
		addtitleOfNewUser.sendKeys(title);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Please pick one...')]/parent::div/parent::div//input")
	WebElement clickRoleDropdown;
	public void SelectRoleFromDropdown(String role) {
//		jse.executeScript("arguments[0].click();", clickRoleDropdown);
		clickRoleDropdown.click();
		clickRoleDropdown.sendKeys(role + Keys.ENTER);
		
	}

	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	public void clickcancelBtn() {
		cancelBtn.click();
	}
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement CreateBtn;
	public void clickCreateBtn() {
		CreateBtn.click();
	}
	
	@FindBy(xpath = "//div[contains(text(),'Invalid email')]")
	WebElement invalidMailErrorMsg;
	public boolean verify_invalidMailErrorMsg() {
		return invalidMailErrorMsg.isDisplayed();
	}
	

	@FindBy(xpath = "//div[contains(text(),'This field is required.')]")
	WebElement ThisfieldisrequiredErrorMsg;
	public boolean verify_ThisfieldisrequiredErrorMsg() {
		return invalidMailErrorMsg.isDisplayed();
	}
	
	
	//div[contains(text(),'Automation test user')]/parent::div/parent::div/parent::div//*[contains(text(),'Delete')]
	
	public void DeleteUser(String userEMail) throws InterruptedException {
				String locator = "//div[contains(text(),'"+userEMail+"')]/parent::div/parent::div/parent::div//*[contains(text(),'Delete')]";
		driver.findElement(By.xpath(locator)).click();
	}
	
	
	
}
