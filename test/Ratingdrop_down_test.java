package vtiger.organization.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Ratingdrop_down_test {

		public static void main(String[] args) throws IOException, SQLException {
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
			

			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("(//a[@href='index.php?module=Accounts&action=index'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@name='rating']"));
		boolean b = ele.isEnabled();
		if(b)
		{
			System.out.println("Dropdown is enabled");
		}else {
			System.out.println("Drop down is disabled");
		}
				
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}

}
