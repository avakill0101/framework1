package bellbutton;

import org.junit.Test;
import org.openqa.selenium.By;

public class GCPLogin extends AbstractInitializer 
{
	//static locators
	public final static String GCPURL = "https://logint2.idm.toon.sul.t-online.de/media-store";
	public final static String LOGINBTN1 = "authButton";
	public final static String LOGINBTN2 = "//*[@id='login-form']/fieldset/div[3]/button";
	public final static String ERRORMSG = "help-block";
	public final static String CANCELBTN = "//*[@id='login-form']/fieldset/div[3]/a";
	public final static String EMAILFIELD = "email";
	public final static String PASSFIELD = "passwd";
	
	
	@Test
	public void testGCPLogin() throws InterruptedException
	{
		driver0.get(GCPURL);
		
		//attempt to login with no credentials
		checkAndClickLoginToForm();				
		checkAndClickFormLogin();		
		checkErrMsgThenClickBack(); 
		
		//attempt to login only with username
		checkAndClickLoginToForm();
		checkAndTypeTheUsername();	
		checkAndClickFormLogin();
		checkErrMsgThenClickBack();
		
		//attempt to login only with password
		checkAndClickLoginToForm();
		checkAndTypeThePassword();
		checkAndClickFormLogin();
		checkErrMsgThenClickBack();
		
		//attempt to login with wrong credentials
		checkAndClickLoginToForm();
		checkAndTypeTheUsername();
		checkAndTypeThePassword();
		checkAndClickFormLogin();
		checkErrMsgThenClickBack();
			
	}


	public void checkAndTypeThePassword() {
		assertTrue(driver0.findElement(By.id(PASSFIELD)).isDisplayed());
		assertTrue(driver0.findElement(By.id(PASSFIELD)).isEnabled());
		driver0.findElement(By.id(PASSFIELD)).sendKeys("aninterestingpassword512");
	}


	public void checkAndTypeTheUsername() {
		assertTrue(driver0.findElement(By.id(EMAILFIELD)).isDisplayed());
		assertTrue(driver0.findElement(By.id(EMAILFIELD)).isEnabled());
		driver0.findElement(By.id("email")).sendKeys("MaciuPiciu_Dorel@gmail.com");
	}


	public void checkErrMsgThenClickBack() throws InterruptedException {
		assertTrue(driver0.findElement(By.className(ERRORMSG)).isDisplayed());
		Thread.sleep(1000);
		assertTrue(driver0.findElement(By.xpath(CANCELBTN)).isDisplayed());
		driver0.findElement(By.xpath(CANCELBTN)).click();
	}


	public void checkAndClickFormLogin() {
		assertTrue(driver0.findElement(By.xpath(LOGINBTN2)).isDisplayed());
		driver0.findElement(By.xpath(LOGINBTN2)).click();
	}


	public void checkAndClickLoginToForm() {
		assertTrue(driver0.findElement(By.id(LOGINBTN1)).isDisplayed());
		driver0.findElement(By.id(LOGINBTN1)).click();
	}
}


//driver0.findElement(By.id("email")).sendKeys("text");
//logger.info(driver0.findElement(By.className(ERRORMSG)).isDisplayed());