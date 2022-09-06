package TestClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;


public class GoDemo {

	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	 Date date=new Date();
	 SimpleDateFormat sd= new SimpleDateFormat("dd_MM_yyyy");
	String icNames;
	
	@BeforeTest
	public void launchBrowser()  
	        {
			  
			  report=new ExtentReports("Verification_of_Goibibo" + sd.format(date) + ".html" );
			  test=report.startTest("Verification_of_Goibibo");
			  System.out.println("ExtentReport");
		    }

       @BeforeClass
       public void logingoibibo ()
       {
    	   GoDemo t = new GoDemo();
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
					 test.log(LogStatus.FAIL, "hotel page failed to  load ");
					 test.log(LogStatus.INFO, co.getMessage());
					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "hotel page failed to  load ");	
				}
			 }
			else
			{
				     test.log(LogStatus.FAIL, "hotel page not available");				
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
    	  act.moveToElement(search2).build().perform();
    	  
    	  WebElement DeIn=driver.findElement(By.xpath("//div[@class='SearchBlockUIstyles__AutoSuggestOuterWrap-sc-fity7j-0 ecbwUo']"));
    	  act.moveToElement(DeIn).click().build().perform();
    	   
  		   test.log(LogStatus.PASS,"delhi hotel name searching successfully");  
  		   Thread.sleep(9000);
  		  
  		   
       }
    	   catch(Exception co)
			{
					 test.log(LogStatus.FAIL, "delhi Name search failed to  load ");
					 test.log(LogStatus.INFO, co.getMessage());
					 test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "delhi hotel name search  failed to  load ");	
				}
			 }
			else
			{
				     test.log(LogStatus.FAIL, "delhi hotel name search not available");				
			}
		}
       
    	   
			 
    	@Test (priority=3)
    	public void Calender() 
    	{
    	
    	   WebElement datePick=driver.findElement(By.xpath("//h4[contains(@class,'CheckInDate')][1]"));
    	   datePick.click();
    	   
    	   WebElement checkin=driver.findElement(By.xpath("//*[@data-testid=\"date_5_8_2022\"]"));
    	   checkin.click();
    	   
    	   WebElement checkout=driver.findElement(By.xpath("//*[@data-testid=\"date_7_8_2022\"]"));
    	   checkout.click();
    	
    	   WebElement Search=driver.findElement(By.xpath("//button[text()='Search']"));
    	   Search.click();   	   
    	   
    	   test.log(LogStatus.PASS, "delhi all hotel search page available");	
    	   
       }
    	
    	
    	@Test (priority=4)
    	public void Hotels() throws InterruptedException {
    		
    	
    		Thread.sleep(10000); 
    		
    		WebElement firsthtl=driver.findElement(By.xpath("//*[@class=\"infinite-scroll-component \"]/div[1]"));
    		firsthtl.click();
    
    		
    	}
    	  
       
        @AfterTest
        public void closeBrawser() {
    	System.out.println("close Browser");
    	report.endTest(test);
      	report.flush();
   	 	
   }
   public void login ()
   {
   	WebDriverManager.chromedriver().setup();
   	driver=new ChromeDriver();
   	driver.manage().window().maximize();
   	driver.get("https://www.goibibo.com/");
   	test.log(LogStatus.PASS,"Goibibo Homr page loaded successfully");
   }

   public static String capture(WebDriver driver) throws IOException 
   {
   	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   	File Dest = new File(".//target//ExtentReports//screenshots//" + System.currentTimeMillis()+ ".png");
   	String errflpath = Dest.getAbsolutePath();
   	FileUtils.copyFile(scrFile, Dest);
       return errflpath;
   } }   


