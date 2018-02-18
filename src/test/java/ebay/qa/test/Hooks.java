package ebay.qa.test;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	//public static String url = "https://www.ebay.co.uk/";
	
	@Before
	public void setUp() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {  
        	System.out.println(("Scenario failed"));
            try {  
            	byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            	scenario.embed(bytes, "image/png");
            } catch (WebDriverException wde) {  
                System.err.println(wde.getMessage());  
            } catch (ClassCastException cce) {  
                cce.printStackTrace();  
            } catch (Exception e){
            	e.printStackTrace();
            }
        }  else{
        	System.out.println("Scenario passed");
        }		
		driver.quit();
	}
}