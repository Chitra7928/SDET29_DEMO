package vtiger.organization.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Checkbox_test {
	public static void main(String[] args) {
		
	FileInputStream fis = new FileInputStream("/data/commonData2.properties");
	Properties pObj= new Properties();
	
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
	


}
