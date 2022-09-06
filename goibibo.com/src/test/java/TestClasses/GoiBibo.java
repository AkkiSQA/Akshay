package TestClasses;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoiBibo {
	
	 public void login ()
	   {
	   	WebDriverManager.chromedriver().setup();
	   	driver=new ChromeDriver();
	   	driver.manage().window().maximize();
	   	driver.get("https://www.goibibo.com/");
	   	test.log(LogStatus.PASS,"login page loaded successfully");
	   }

	   public static String capture(WebDriver driver) throws IOException 
	   {
	   	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	   	File Dest = new File(".//target//ExtentReports//screenshots//" + System.currentTimeMillis()+ ".png");
	   	String errflpath = Dest.getAbsolutePath();
	   	FileUtils.copyFile(scrFile, Dest);
	       return errflpath;
	   }
	
	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	 Date date=new Date();
	 SimpleDateFormat sd= new SimpleDateFormat("dd_MM_yyyy");
	String icNames;
	
	@BeforeTest
	public void launchBrowser()  
	        {
			  
			  report=new ExtentReports("Verification" + sd.format(date) + ".html" );
			  test=report.startTest("Verification");
			  System.out.println("ExtentReport");
		    }

	 @BeforeClass
     public void loginGlobaldata ()
     {
  	   GoiBibo t = new GoiBibo();
          t.login();
     }
	 
	 
	 @Test (priority=1)	
     public void hotel ()  throws IOException
     {		      
     if(driver.findElements(By.xpath("(//a[@href='/hotels/'])[1]")).size()>0)
           {
  	   try
			 {    		   			 
  	   WebElement hotels = driver.findElement(By.xpath("(//a[@href='/hotels/'])[1]"));
  	   hotels.click();   
  	 
   
  	   
		   test.log(LogStatus.PASS,"hotel page loaded successfully");  		  
     }
  	   catch(Exception co)
			{
					 test.log(LogStatus.FAIL, "page failed to  load ");
					 test.log(LogStatus.INFO, co.getMessage());
					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "hotel page failed to  load ");	
				}
			 }
			else
			{
				     test.log(LogStatus.FAIL, "hotel page  page not available");				
			}
		}
               
	 @Test (priority=2)	
     public void hoteldelhi ()  throws IOException
     {		      
     if(driver.findElements(By.xpath("//input[@data-testid='home-autosuggest-input']")).size()>0)
           {
  	   try
			 {    		
  		   Thread.sleep(4000);
  		   
  	   WebElement radio=driver.findElement(By.xpath("//input[@type='radio']"));
  	   radio.click();
  		   
  	   WebElement search2 = driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']"));
  	   search2.sendKeys("Delhi");

  	   
  	   Thread.sleep(4000);
  	   
  	   Actions act=new Actions(driver);
  	   act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
  	   
  	   
		   test.log(LogStatus.PASS,"delhi hotel page search loaded successfully");  
		   Thread.sleep(9000);
		   WebElement search1 = driver.findElement(By.xpath("//button[text()='Search']"));
  	   search1.click(); 
		   
     }
  	   catch(Exception co)
			{
					 test.log(LogStatus.FAIL, "page failed to  load ");
					 test.log(LogStatus.INFO, co.getMessage());
					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "hotel page failed to  load ");	
				}
			 }
			else
			{
				     test.log(LogStatus.FAIL, "hotel page  page not available");				
			}
		}
	 @Test (priority=3)
 	public void Calender() {
 	
 	   WebElement datePick=driver.findElement(By.xpath("//h4[contains(@class,'CheckInDate')]"));
 	   datePick.click();
 	   
 	   WebElement checkin=driver.findElement(By.xpath("//*[@data-testid=\"date_5_8_2022\"]"));
 	   checkin.click();
 	   
 	   WebElement checkout=driver.findElement(By.xpath("//*[@data-testid=\"date_7_8_2022\"]"));
 	   checkout.click();
 	
 	   WebElement Search=driver.findElement(By.xpath("//button[text()='Search']"));
 	   Search.click();
 	   
 	  // List<WebElement>dynamicList=driver.findElement(By)  
    }
	
	 @Test (priority=4)
 	public void Hotels() throws InterruptedException {
 		
 	
 		Thread.sleep(10000); 
 		
 		WebElement vegashotel=driver.findElement(By.xpath("//h4[text()=\"Hotel The Vegas\"]"));
 		vegashotel.click();	
 	}
	 
	  @AfterMethod
	   	public void back () throws InterruptedException {
	       Thread.sleep(1000);	 
	       }
	       
	       @AfterClass
	       public void logout() throws InterruptedException{
	     //  	System.out.println("logout");
	      // 	WebElement logout = driver.findElement(By.xpath("//a[@href='/Login/Logout']"));
	     //  	logout.click();	
	       }
	       
	        @AfterTest
	        public void closeBrawser() {
	    	System.out.println("close Browser");
	    	report.endTest(test);
	      	report.flush();
	   	 	
	   }
	  
}

