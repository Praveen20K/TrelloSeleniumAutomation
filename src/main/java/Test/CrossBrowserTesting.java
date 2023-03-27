package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


// This testcase is to run the trello application parallely by Chrome and Edge Browsers. 
// To Run the testcase go to "testng.xml" and right click --> "run as" --> "TestNG test"
public class CrossBrowserTesting {
	static RemoteWebDriver driver;
	@Parameters({"browser"})
	@Test
	public void main(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		}
		driver.get("https://trello.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
