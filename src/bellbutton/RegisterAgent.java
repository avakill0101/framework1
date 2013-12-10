package bellbutton;

import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterAgent extends AbstractInitializer
{
	private WebDriver driver;
	private String bellbuttonUrl = "http://bellbutton.com:10070/";
	public final static String CPBTN = "contractualPartnerLink";

	@Test
	public void testContractualPartner()
	{
		
		driver.get(bellbuttonUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals(bellbuttonUrl, driver.getCurrentUrl());
		
		//Contactual partner link from main page
		WebElement cpBtn = driver.findElement(By.id(CPBTN));
		assertTrue(cpBtn.isDisplayed());
		
		String cpBtnExpectedCaption = "Contractual partner";
		assertEquals(cpBtnExpectedCaption, cpBtn.getText());
		
		cpBtn.click();
		
		String cpExpectedLink = "http://bellbutton.com:10070/#contractual-partner";
		assertEquals(cpExpectedLink, driver.getCurrentUrl());
		
		//register a new agent button from the contractual partner page
		WebElement regNewAgentBtn = driver.findElement(By.id("register-agent-btn"));
		assertTrue(regNewAgentBtn.isDisplayed());
		
		String regNewAgentExpectedCaption = "Register new agent";
		assertEquals(regNewAgentExpectedCaption, regNewAgentBtn.getText());
		
		regNewAgentBtn.click();
		
		//now working inside the registration form
		
		WebElement agentInputBox = driver.findElement(By.xpath("//*[@id='register-agent-form']/input"));
		assertTrue(agentInputBox.isDisplayed());
		assertTrue(agentInputBox.isEnabled());
		agentInputBox.sendKeys("asdasdadsasda");
		
		WebElement sendInvitationBtn = driver.findElement(By.id("send-btn"));
		assertTrue(sendInvitationBtn.isDisplayed());
		String sendInvitationExpectedCaption = "Send invitation";
		assertEquals(sendInvitationExpectedCaption, sendInvitationBtn.getText());
		
		WebElement cancelBtn = driver.findElement(By.id("cancel-btn"));
		assertTrue(cancelBtn.isDisplayed());
		String cancelExpectedCaption = "Cancel";
		assertEquals(cancelExpectedCaption, cancelBtn.getText());
		
		//empty input box test
		sendInvitationBtn.click();
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id='register-agent-form']/span"));
		String errInvalidMsgText = "Email is not valid.";
		assertEquals(errInvalidMsgText, errorMsg.getText());
		
		agentInputBox.clear();
		sendInvitationBtn.click();
		String errEmptyMsgText = "Email field is empty.";
		assertEquals(errEmptyMsgText, errorMsg.getText());
		
		cancelBtn.click();
		assertEquals(regNewAgentExpectedCaption, regNewAgentBtn.getText());
				
		
	}
	
}
