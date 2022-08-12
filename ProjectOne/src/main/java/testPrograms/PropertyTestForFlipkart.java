package testPrograms;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyTestForFlipkart {

	public static void main(String[] args) {
		
		try
		{
			FileInputStream fis = new FileInputStream("./Data/CommonProperties.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("FlipkartUrl");
			String browser = prop.getProperty("browser");
			System.out.println(url);
			System.out.println(browser);
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			driver.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

}
