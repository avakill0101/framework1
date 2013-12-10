package TestingExamples;

import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;
import mx4j.log.Logger;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsLiveMail extends TestCase
{
	public final static String baseUrl = "https://mail.live.com";
	public WebDriver driver;
	
	@After
	public void tearDown() throws Exception
	{
		driver.close();
	}
	
	private boolean existsElement(String id) 
	{
	    try 
	    {
	        driver.findElement(By.id(id));
	    }
	    catch (NoSuchElementException e) 
	    {
	        return false;
	    }
	    return true;
	}
	
	@Test
	public void testMata() throws Exception
	{
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement forgotPassBtn = driver.findElement(By.id("idA_PWD_ForgotPassword"));
		forgotPassBtn.click();
		
		//WebElement signUpBtn = driver.findElement(By.id("idA_SignUp"));
		
		try
		{
			assertTrue(driver.findElement(By.id("idA_SignUp")).isDisplayed());
		}
		catch (NoSuchElementException e )
		{
			driver.close();
			driver.quit();
		}
		
		
		
	}
	

}
