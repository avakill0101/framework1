package windowLiveTesting;

import java.util.concurrent.TimeUnit;

import junit.framework.AssertionFailedError;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.find.InputFinder;

import static windowLiveTesting.WebElementConstants.*;

import org.apache.log4j.*;

public class TrashMailTest extends Initializer 
{
	@Test
	public void testWindowLive()
	{
		
		driver0.get(BASEURL1);
		driver0.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		logger.info("Check current Url..");
		try 
		{
			assertEquals(BASEURL1, driver0.getCurrentUrl());
			logger.info("Url check passed");
		}
		catch (Error e) 
		{	
			logger.info(" >>>> Exception caught <<<< " + e.getMessage());
		}
		
		byNameCheckIfControlIsDisplayed(driver0, EMAIL_INPUT);
		//byNameCheckIfFieldIsEditable(driver0, "asd");
		
		byNameCheckIfControlIsDisplayed(driver0, "submit");
		
		
		//inputField.sendKeys("characters");
		
			
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













//logger.info("Checking the page's title");
//try
//{
//	String cntTitle = driver0.getTitle();
//	assertEquals(expTitle, cntTitle);
//	logger.info("Command executed successfully");
//}
//catch (Error e)
//{
//	logger.info(" >>>> Exception caught <<<< " + e.getMessage());
//	driver0.quit();
//}