package Practice.ExtentReports;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportDemo implements ITestListener {
    ExtentReports extent;
    WebDriver driver;

    @Test
    public void initDemo() {
        ExtentTest test = extent.createTest("init demo");

        // Set the system property before creating the WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\Drivers\\chromedriver-win32\\chromedriver.exe");
        
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.close();
        test.pass("Result does match");
        extent.flush();
    }

    public String getScreenshot(String testcase) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\reports\\" + testcase + ".png");
            try {
				FileUtils.copyFile(src, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        

        return System.getProperty("user.dir") + "\\reports\\" + testcase + ".png";
    }
}
