package vtiger.organization.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class createOrganisation_test {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./data/commonData2.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String Browser = pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String Username=pObj.getProperty("username");
		String Password=pObj.getProperty("password");
		
		WebDriver driver=null;
		
		if(Browser.equals("chrome")) {
			driver= new ChromeDriver();
		}else if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}else if(Browser.equals("ie")) {
			driver= new InternetExplorerDriver();
		}
		

		
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	driver.get(URL);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("ABCCORP");
	driver.findElement(By.xpath("//input[@type='checkbox' and @name='notify_owner']")).click();
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
	WebElement confmsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String msg = confmsg.getText();
	System.out.println(msg);
	driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
	driver.findElement(By.xpath("(//a[@title='Organizations'])[11]")).click();
	WebElement confmsg1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String actmsg = confmsg1.getText();
	
	if(msg.equals(actmsg))
	{
		System.out.println("Organisation no.is matching");
	}else {
		System.out.println("Organisation no. is not same");
	}
	
	
	
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}

}
