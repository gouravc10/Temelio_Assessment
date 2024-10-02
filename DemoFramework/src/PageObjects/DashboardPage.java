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

public class DashboardPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(50));
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
	
	@FindBy(xpath = "//div[contains(text(),'//*[contains(text(),'Admin Settings')]')]")
	WebElement adminSettingOpt;
	public void adminSettingOpt() {
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Team Settings')]")));
		
	jse.executeScript("arguments[0].click();", adminSettingOpt);
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
	
	
	public void scrollToText(String txt) {
		WebElement texttag = driver.findElement(By.xpath("//*[contains(text(),'"+ txt +"')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", texttag);
	
	}
	
	public void clicktagToggleBtn(String txt) {
		String locator = "//span[contains(text(),'"+txt+"')]/parent::span//label[contains(@class, 'chakra-switch')]";
		driver.findElement(By.xpath(locator)).click();
	}
	
	

	public void doubleClickclimatetxt(String txt) {
		
		WebElement texttag = driver.findElement(By.xpath("//*[contains(text(),'"+ txt +"')]"));
		
			Actions act = new Actions(driver);
		
		act.doubleClick(texttag).perform();
		
		
	}
	
	@FindBy(xpath = "//p[contains(text(),'Custom Program Areas')]/parent::h2/parent::div/div/div/input")
	WebElement blankprogramtxtbox;
	public void editTagtxtbox(String currentValue, String newValue) {
//		String locator = "//*[@value='"+currentValue+"']";z
//		driver.findElement(By.xpath(locator)).clear();
		blankprogramtxtbox.sendKeys(Keys.CONTROL+ "a");
		blankprogramtxtbox.sendKeys(newValue + Keys.ENTER);
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
	
	@FindBy(name = "title")
	WebElement addtitleOfNewUser;
	public void addTitleNewUser(String title) {
		addtitleOfNewUser.sendKeys(title);
	}
	
//	@FindBy(name = "title")
//	WebElement addtitleOfNewUser;
//	public void addTitleNewUser(String title) {
//		addtitleOfNewUser.sendKeys(title);
//	}
//	
	
//	@FindBy(name = "title")
//	WebElement addtitleOfNewUser;
//	public void addTitleNewUser(String title) {
//		addtitleOfNewUser.sendKeys(title);
//	}
//	
//	
	
	
}
