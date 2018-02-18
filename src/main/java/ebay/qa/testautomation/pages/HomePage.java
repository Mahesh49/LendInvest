package ebay.qa.testautomation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(how=How.CSS, using="#gh-ac")
	public static WebElement searchBox;
	
	@FindBy(how=How.CSS, using="#gh-btn")
	public static WebElement searchButton;
	
	@FindBy(how=How.CSS, using="select")
	public static WebElement selectDropdown;
	
	@FindBy(how=How.CSS, using=".cat-app")
	public static WebElement category;	
}
