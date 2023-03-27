package Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import Utils.DataUtils;

public class BaseMethod {
	
	public static RemoteWebDriver driver;
	public String excelFileName;
	
	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://trello.com/login");
	}
	
	@AfterMethod
	public void stopBrowser() {
		
	}
	
	@DataProvider(name = "fetchData")
	public String[][] fetchData() throws IOException {
		DataUtils readData = new DataUtils();
		return readData.readExcel(excelFileName);
				
	}
	

}
