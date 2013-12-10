package windowLiveTesting;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.TestCase;

public abstract class Initializer extends TestCase
{
	public static WebDriver driver0;
	public static WebDriver driver1;
	public Logger logger;
	
	@Before
	public void setUp()
	{	
		logger = Logger.getLogger(getClass());
		System.setProperty("webdriver.chrome.driver", "C://Libraries//chromedriver.exe");
				
		String className = this.getClass().getSimpleName();
		
		Date date = new Date();
		String crtDate = String.format("Date/Time Execution: %tc", date );
						
		logger.info("-----------------------------------------");
		logger.info("Executing tests from class: " + className +".");
		logger.info(crtDate);
		
		driver0 = new ChromeDriver();
		//driver1 = new ChromeDriver();	
		
		driver0.manage().window().maximize();
		driver0.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown()
	{
		driver0.quit();
		driver1.quit();
	}
	
	public boolean isElementPresent(WebDriver driver0, String id) 
	{
		logger.info("Checking if element: " + id + " is present");
		try
		{
			driver0.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			if (driver0.findElements( By.id(id) ).size() != 0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch (IllegalArgumentException ei)
		{
			return false;
		}
		catch (Exception e)
		{
			logger.info(" >>> Exception caught <<< ");
			return false;
		}
	}
	
	public void byIdCheckIfControlIsDisplayed(WebDriver driver, String id)
	{
		logger.info("Checking if [" + id + "] is displayed");
		try 
		{
			assertTrue(driver.findElement(By.id(id)).isDisplayed());
			logger.info("Element [" + id + "] was found");
		}
		catch (Exception e) 
		{
			logger.info("Element: [" + id + "] was not found  <<<<<<<<<<<<<<< !! ");
			driver.quit();
		}
	}
	
	public void byNameCheckIfControlIsDisplayed(WebDriver driver, String name)
	{
		logger.info("Checking if [" + name + "] is displayed");
		try 
		{
			assertTrue(driver.findElement(By.name(name)).isDisplayed());
			logger.info("Element [" + name + "] was found");
		}
		catch (Exception e) 
		{
			logger.info("Element: [" + name + "] was not found  <<<<<<<<<<<<<<< !! ");
			driver.quit();
		}
	}
	
	public void byIdCheckIfFieldIsEditable(WebDriver driver, String id)
	{
		logger.info("Checking if [" + id + "] is editable");
		try 
		{
			assertTrue(driver.findElement(By.id(id)).isEnabled());
			logger.info("Element [" + id + "] was found");
		}
		catch (Exception e) 
		{
			logger.info("Element: [" + id + "] was not found  <<<<<<<<<<<<<<< !! ");
			driver.quit();
		}
	}
	
	public void byNameCheckIfFieldIsEditable(WebDriver driver, String name)
	{
		logger.info("Checking if [" + name + "] is editable");
		try
		{
			assertTrue(driver.findElement(By.name(name)).isEnabled());
			logger.info("Element [" + name + "] was found");
		}
		catch (Exception e)
		{
			logger.info("Element: [" + name + "] was not found  <<<<<<<<<<<<<<< !! ");
			driver.quit();
		}
	}
	
	public void asdasd(WebElement element, WebDriver driver, String name) 
	{
		WebElement inputField = driver0.findElement(By.name(name));
		String contents = inputField.getAttribute("value");
		if (contents != "")
		{
			inputField.clear();
			inputField.sendKeys("characters");
		}
		else
		{
			inputField.sendKeys("characters");
		}
	}
}
