package TestingExamples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.TestCase;

import java.io.IOException;
import java.lang.Runtime;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Sweeps extends TestCase 
{
	private WebDriver driver0;
	private WebDriver driver1;
	private static Logger logger;
	
	//private String baseUrl = "https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=http://mail.yahoo.com";	
	//private String baseUrl = "http://simpl.info/getusermedia/index.html";
	private String baseUrl1 = "http://simpl.info/getusermedia/index.html";	
	private String baseUrl2 = "http://simpl.info/getusermedia/index.html";
	
	private String path = "C://Libraries//mouse_click.exe";
	private String path1 = "C://Agent//mouse_click.exe";
	
	@Before
	public void setUp()
	{	
		logger = Logger.getLogger(getClass());
		//PropertyConfigurator.configure("mylog4j.properties");
		System.setProperty("webdriver.chrome.driver", "C://Libraries//chromedriver.exe");
		driver0 = new ChromeDriver();
		driver1 = new ChromeDriver();
		driver0.manage().window().maximize();
	}
	
	@After
	public void tearDown()
	{	
		driver0.quit();
		driver1.quit();
	}
	
	public void initializator()
	{
		String className = this.getClass().getSimpleName();
		Date date = new Date();
		String crtDate = String.format("Date/Time Execution: %tc", date );
		logger.info("-----------------------------------------");
		logger.info("Executing tests from class: " + className +".");
		logger.info(crtDate);
	}
	
	@Test
	public void testSweeps() throws InterruptedException, IOException
	{
		initializator();
		
		driver0.get(baseUrl1);
		driver0.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String loginWindow = driver0.getWindowHandle();
		logger.info("current handle: " + loginWindow);
		Runtime.getRuntime().exec(path);
		Thread.sleep(2000);
		driver0.manage().window().setPosition(new Point(12, 12));
		        
		driver1.get(baseUrl2);
        driver1.manage().window().setPosition(new Point(1032, 12));
        String secondWindow = driver1.getWindowHandle();
        driver1.switchTo().window(secondWindow);
        Thread.sleep(1500);
        Runtime.getRuntime().exec(path1);
        
        
        
        Thread.sleep(2000);               
               
//        driver.get(baseUrl);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		String loginWindow = driver.getWindowHandle();
//		System.out.println("current handle: " + loginWindow);
//		
//		String newTab = Keys.chord(Keys.SHIFT, Keys.ENTER);
//        driver.findElement(By.xpath("//*[@id='viewSource']")).sendKeys(newTab);
//        
//        Set<String> handles =  driver.getWindowHandles();       
//        String second = (String) handles.toArray()[1];
//        System.out.println("current handle: " + second);        
//        
//        driver.manage().window().setPosition(new Point(400, 400));
//        
//        Thread.sleep(2000);
//        driver.switchTo().window(loginWindow);
//        
//        Runtime.getRuntime().exec(path);
//        
//        Thread.sleep(1500);
//        driver.switchTo().window(second);
//        
//        System.out.println("current handle: " + driver.getWindowHandle());
        
//-----------------------------------------------------------------------------------------------------------------       
        
//        driver.get(baseUrl);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		String loginWindow = driver.getWindowHandle();
//		System.out.println("current handle: " + loginWindow);
//		
//		String newTab = Keys.chord(Keys.SHIFT, Keys.ENTER);
//        driver.findElement(By.xpath("//*[@id='signUpBtn']")).sendKeys(newTab);
//        
//        Set<String> handles =  driver.getWindowHandles();       
//        String second = (String) handles.toArray()[1];
//        System.out.println("current handle: " + second);        
//        
//        driver.manage().window().setPosition(new Point(400, 400));
//        
//        Thread.sleep(2000);
//        driver.switchTo().window(loginWindow);
//        
//        WebElement oldUser = driver.findElement(By.id("username"));
//        oldUser.sendKeys("old username");
//        
//        Thread.sleep(1500);
//        driver.switchTo().window(second);
//        
//        WebElement newUser = driver.findElement(By.id("first-name"));
//        newUser.sendKeys("new username");
//        
//        System.out.println("current handle: " + driver.getWindowHandle());
        
  
		
	}
}
