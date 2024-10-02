package Utils;

import java.io.File;
import java.io.IOException;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.UserCreationTest;



public class TestListener implements ITestListener {
	WebDriver driver=null;
	String filePath = "src/Utils/Failed ScreenShots";
    @Override
    public void onTestFailure(ITestResult result) {
    	
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver)context.getAttribute("driver");
        if(driver == null)
        	System.out.println("null");
        else
        	System.out.println("Not null");
        
    	takeScreenShot(methodName, driver);
    }
    
    public void takeScreenShot(String methodName, WebDriver driver) {
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       
            try {
				
            	FileHandler.copy(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Screensho savein in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  