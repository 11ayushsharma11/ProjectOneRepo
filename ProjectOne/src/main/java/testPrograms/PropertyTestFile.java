package testPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyTestFile {

	public static void main(String[] args) {
		
		try
		{
			FileInputStream fis = new FileInputStream("./Data/CommonProperties.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			String un = prop.getProperty("un");
			String pw = prop.getProperty("pw");
			String browser = prop.getProperty("browser");
			System.out.println(url);
			System.out.println(un);
			System.out.println(pw);
			System.out.println(browser);
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		storeProperty();
	}

	public static void storeProperty()
	{
		try
		{
			Properties prop = new Properties();
			prop.setProperty("prop1", "value1");
			prop.setProperty("prop2", "val2");
			FileOutputStream fos = new FileOutputStream(new File("./prop.properties"));
			prop.store(fos, "Storing new properties");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
