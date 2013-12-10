package bellbutton;

import static bellbutton.UtilsConstants.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAgent extends AbstractInitializer 
{
	@Test
	public void testAgentLogin() throws InterruptedException
	{
		driver0.get(AG_MAINLOGINURL);
		logger.info("Checking current Agent URL...");
		
		try
		{
			assertEquals(AG_MAINLOGINURL, driver0.getCurrentUrl());
			logger.info("Agent URL check passed");
		}
		catch (Error e) 
		{	
			logger.info(" >>>> Exception caught <<<< " + e.getMessage());
		}
		
		byIdCheckIfControlIsDisplayed(driver0, AG_LOGINBTN1);
		
		driver0.findElement(By.id(AG_LOGINBTN1)).click();
		
		wait = new WebDriverWait(driver0, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AG_EMAILINPUT)));
		
		driver0.get(AG_LOGINFORMURL);
		logger.info("Checking Agent URL with login form...");
		
		try
		{
			assertEquals(AG_LOGINFORMURL, driver0.getCurrentUrl());
			logger.info("Agent login form URL check passed");
		}
		catch (Error e) 
		{	
			logger.info(" >>>> Exception caught <<<< " + e.getMessage());
		}
		
		byIdCheckIfControlIsDisplayed(driver0, AG_EMAILINPUT);
		byIdCheckIfFieldIsEditable(driver0, AG_EMAILINPUT);
	
		byIdCheckIfControlIsDisplayed(driver0, AG_PASSINPUT);
		byIdCheckIfFieldIsEditable(driver0, AG_PASSINPUT);
		
		byIdCheckIfControlIsDisplayed(driver0, AG_LOGINBTN2);
		
		WebElement AG_EmailInput = driver0.findElement(By.id("email"));
		WebElement AG_PassInput  = driver0.findElement(By.id(AG_PASSINPUT));
		WebElement AG_LoginBtn2  = driver0.findElement(By.id(AG_LOGINBTN2));
		WebElement AG_LoginError = driver0.findElement(By.id(AG_LOGINERROR));
		
		//TestCase - attempt to login with no credentials inserted
		AG_LoginBtn2.click();		
		checkErrorMessage(driver0, AG_LoginError);
		reloadLoginUrl();
		
		//TestCase - attempt to login only with username
		AG_EmailInput.click(); 
		AG_EmailInput.clear();
		AG_EmailInput.sendKeys("invalidusername");
		AG_LoginBtn2.click();
		checkErrorMessage(driver0, AG_LoginError);
		reloadLoginUrl();
		
		//TestCase - attempt to login only with password
		AG_PassInput.click();
		AG_PassInput.clear();
		AG_PassInput.sendKeys("password");
		AG_LoginBtn2.click();
		checkErrorMessage(driver0, AG_LoginError);
		reloadLoginUrl();
		
		//TestCase - attempt to login with wrong credentials for both fields
		AG_EmailInput.click();
		AG_EmailInput.clear();
		AG_EmailInput.sendKeys("maciupiciu");
		AG_PassInput.click();
		AG_PassInput.clear();
		AG_PassInput.sendKeys("quehoraes");
		checkErrorMessage(driver0, AG_LoginError);
		reloadLoginUrl();
		
		//TestCase - attempt to login with proper credentials
		AG_EmailInput.click();
		AG_EmailInput.clear();
		AG_EmailInput.sendKeys("firstname.lastname@gmail.com");
		AG_PassInput.click();
		AG_PassInput.clear();
		AG_PassInput.sendKeys("SecredPassword123");
	}
}
