package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TaskClass {
	WebDriver driver;

		@BeforeClass
		public void initbrowser( ){
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.trivago.in/?__wr=21&tc=102&themeId=280&sem_keyword=trivago&sem_creativeid=72636688147315&sem_matchtype=be&sem_network=o&sem_device=c&sem_campaignid=191340818&sem_adgroupid=3930406455&sem_targetid=40966707859&cipc=br&cip=9119110005&msclkid=c79f3de640461ef8531d5f0e8c1d0c46");
		
		Thread.sleep(5000);
		}
		
		@Test 
		WebElement hotel= driver.findElement(By.xpath("//label[@data-title=\"Hotel\"]"));
		hotel.click();
		
		
		
	/*	WebElement country=driver.findElement(By.xpath("//input[@name='CountryType']"));
		country.click();*/
		
		
		
		
		
		
	}

}
