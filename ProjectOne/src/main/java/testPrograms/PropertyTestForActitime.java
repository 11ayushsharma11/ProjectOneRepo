package testPrograms;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyTestForActitime {

	public static void main(String[] args) {
		
		try
		{
			FileInputStream fis = new FileInputStream("./Data/CommonProperties.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("ActitimeUrl");
			String un = prop.getProperty("ActitimeUn");
			String pw = prop.getProperty("ActitimePw");
			String browser = prop.getProperty("browser");
			System.out.println(url);
			System.out.println(browser);
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(un);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(pw);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='loginButton']")).click();
			Thread.sleep(10000);
			driver.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

}
