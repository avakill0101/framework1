package TestingExamples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;


public class TrashMail extends TestCase
{
	public final static String tmUrl = "http://www.trash-mail.com/";
	public final static String tmTitle = "atrash-mail.com | Die Wegwerf-Email-Adresse | Email anonym empfangen";
	
	//locators
	public final static String EMAIL = "mail";
	public final static String SUBMIT = "submit";
	public final static String NOMAIL = "nomail";
	public final static String SUBJECT = "//*[@id='left']/a";
	public final static String CONTENT = "mail_content";
	public String mailContent;
	
	private WebDriver driver;
	private WebDriver driver0;
	private WebDriverWait wait;
	
	@Before
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C://Libraries//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}
	
	@After
	public void tearDown() throws Exception
	{
		driver.close();	
	}
		
	@Test
	public void testTrashMail() throws Exception
	{
		driver.get(tmUrl);
		
		assertTrue(driver.findElement(By.name(EMAIL)).isDisplayed());
		assertTrue(driver.findElement(By.name(EMAIL)).isEnabled());
		driver.findElement(By.name(EMAIL)).clear();
		driver.findElement(By.name(EMAIL)).sendKeys("bbagent1");
		
		assertTrue(driver.findElement(By.name(SUBMIT)).isDisplayed());
		driver.findElement(By.name(SUBMIT)).click();
		
		//assertTrue(driver.findElement(By.className(NOMAIL)).isDisplayed());
		
		assertTrue(driver.findElement(By.xpath(SUBJECT)).isDisplayed());
		driver.findElement(By.xpath(SUBJECT)).click();
		
		assertTrue(driver.findElement(By.className(CONTENT)).isDisplayed());
		mailContent = driver.findElement(By.className(CONTENT)).getText();
		
		String link = parse(mailContent);
		System.out.println(link);
		
	}
	
	public static String parse(String text)
	{
        String regex = "\\(?\\b(https://|www[.])[-A-Za-z0-z+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) 
        {
            return matcher.group();
        }
        return null;
    }

	
//	public void mailPoll(WebDriver driver) throws InterruptedException
//	{
//		WebElement tmRefreshBtn = driver.findElement(By.name("submit"));
//		//assertTrue(tmRefreshBtn.isDisplayed());
//		
//		WebElement noMail = driver.findElement(By.className("nomail"));
//		String noMailMsg = noMail.getText();
//		
//		do
//		{
//			wait = new WebDriverWait(driver, 5);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
//			tmRefreshBtn.click();
//			Thread.sleep(5000);
//		}
//		while(noMailMsg != null);
//	}
//	
//	public void mailBody(WebDriver driver)
//	{
//		WebElement mailBody = driver.findElement(By.className("mail_content"));
//		WebElement mailLink = driver.findElement(By.className("post"));
//		boolean ItIs = mailLink.isDisplayed();
//		System.out.println(ItIs);
//		//assertTrue(mailBody.isDisplayed());
//		String mailStream = mailBody.getText();
//		System.out.println(mailStream);
//	}
}
