package Practice.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends ExtentReportDemo implements ITestListener {
	ExtentTest test;
	WebDriver driver;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	 	
	   @Override
	    public void onTestStart(ITestResult result) {
		   extent.createTest(result.getMethod().getMethodName()); 
		   
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	test.log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	       test.log(Status.FAIL,result.getThrowable() );
	       test.addScreenCaptureFromPath(null);
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Implement what should happen when a test is skipped
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Implement what should happen when a test fails but within success percentage
	    }

	    public void onFinish(ITestResult result) {
	        // Implement what should happen when the test context finishes
	    }
}
