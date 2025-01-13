package endlink.qa.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import endlink.qa.utils.Constants;

public class BaseClass {
	

	public static WebDriver driver;
    public static Logger log;

	@Parameters({ "browser" }) // We are passing browser name from testng.xml as parameter
	@BeforeTest
	public void beforeTestMethod(String browser) {

		log = LogManager.getLogger(this.getClass());   
		//This line initializes a Logger instance for current class - Takes class dynamically
		// We can use log.info or log.dubug.  Choose log levels strategically - for any line needs logging


		log.info("Before driver setup");
		DriverManager.setupDriver(browser);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}



	@AfterSuite
	public void afterMethodMethod() {

       // DriverManager.quitDriver();
	}

	// This method is to store screenshots in the screenshots folder in the project directory and get path for reports
	public String captureScreen (String tname) throws IOException {
		
        
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp to differentiate the each screenshot 
        String screenshotName = tname + "_" + timeStamp + ".png";
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName;
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(screenshotPath);

		String path = destinationFile.getAbsolutePath();
        
        FileUtils.copyFile(screenshot, destinationFile);
		System.out.println(path);
        return path; //Returns the path of the screenshot
}


}
