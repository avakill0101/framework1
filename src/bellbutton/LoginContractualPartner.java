package bellbutton;

import static bellbutton.UtilsConstants.CP_EMAILINPUT;
import static bellbutton.UtilsConstants.CP_LOGINBTN1;
import static bellbutton.UtilsConstants.CP_LOGINBTN2;
import static bellbutton.UtilsConstants.CP_LOGINERROR;
import static bellbutton.UtilsConstants.CP_LOGINFORMURL;
import static bellbutton.UtilsConstants.CP_MAINLOGINURL;
import static bellbutton.UtilsConstants.CP_PASSINPUT;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginContractualPartner extends AbstractInitializer
{
	@Test
	public void testCPLogin() throws InterruptedException
	{
		logger.info("Checking current Contractual Partner URL...");
		driver0.get(CP_MAINLOGINURL);
			
		try
		{
			assertEquals(CP_MAINLOGINURL, driver0.getCurrentUrl());
			logger.info("Contractual Partner URL check passed");
		}
		catch (Error e) 
		{	
			logger.info(" >>>> Exception caught <<<< " + e.getMessage());
			driver0.quit();
		}
		
		byIdCheckIfControlIsDisplayed(driver0, CP_LOGINBTN1);
		
		driver0.findElement(By.id(CP_LOGINBTN1)).click();
		
		wait = new WebDriverWait(driver0, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CP_EMAILINPUT)));
		
		driver0.get(CP_LOGINFORMURL);
		logger.info("Checking Contractual Partner URL with login form...");
		
		try
		{
			assertEquals(CP_LOGINFORMURL, driver0.getCurrentUrl());
			logger.info("Contractual Partner login form URL check passed");
		}
		catch (Error e) 
		{	
			logger.info(" >>>> Exception caught <<<< " + e.getMessage());
			driver0.quit();
		}
		
		byIdCheckIfControlIsDisplayed(driver0, CP_EMAILINPUT);
		byIdCheckIfFieldIsEditable(driver0, CP_EMAILINPUT);
	
		byIdCheckIfControlIsDisplayed(driver0, CP_PASSINPUT);
		byIdCheckIfFieldIsEditable(driver0, CP_PASSINPUT);
		
		byIdCheckIfControlIsDisplayed(driver0, CP_LOGINBTN2);
		
		WebElement cp_EmailInput = driver0.findElement(By.id(CP_EMAILINPUT));
		WebElement cp_PassInput  = driver0.findElement(By.id(CP_PASSINPUT));
		WebElement cp_LoginBtn2  = driver0.findElement(By.id(CP_LOGINBTN2));
		WebElement cp_LoginError = driver0.findElement(By.id(CP_LOGINERROR));
		
		//TestCase - attempt to login with no credentials inserted
		cp_LoginBtn2.click();		
		checkErrorMessage(driver0, cp_LoginError);
		reloadLoginUrl();
		
		//TestCase - attempt to login only with username
		cp_EmailInput.click(); 
		cp_EmailInput.clear();
		cp_EmailInput.sendKeys("invalidusername");
		cp_LoginBtn2.click();
		checkErrorMessage(driver0, cp_LoginError);
		reloadLoginUrl();
		
		//TestCase - attempt to login only with password
		cp_PassInput.click();
		cp_PassInput.clear();
		cp_PassInput.sendKeys("password");
		cp_LoginBtn2.click();
		checkErrorMessage(driver0, cp_LoginError);
		reloadLoginUrl();
		
		//TestCase - attempt to login with wrong credentials for both fields
		cp_EmailInput.click();
		cp_EmailInput.clear();
		cp_EmailInput.sendKeys("maciupiciu");
		cp_PassInput.click();
		cp_PassInput.clear();
		cp_PassInput.sendKeys("quehoraes");
		checkErrorMessage(driver0, cp_LoginError);
		reloadLoginUrl();
		
		//TestCase - attempt to login with proper credentials
		cp_EmailInput.click();
		cp_EmailInput.clear();
		cp_EmailInput.sendKeys("firstname.lastname@gmail.com");
		cp_PassInput.click();
		cp_PassInput.clear();
		cp_PassInput.sendKeys("SecredPassword123");
		
	}

}
