package ebay.qa.testautomation.pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.CSS, using=".rcnt")
	public static WebElement totalResults;
	
	@FindAll(@FindBy(how=How.CSS, using=".sresult"))
	public static List<WebElement> searchResults;
	
	@FindAll(@FindBy(how=How.CSS, using=".lvtitle"))
	public static List<WebElement> resultTitles;
	
	@FindBy(how=How.CSS, using="#gh-ac")
	public static WebElement searchBox;
	
	@FindBy(how=How.CSS, using="#gh-btn")
	public static WebElement searchButton;
	
	@FindBy(how=How.CSS, using=".lvtitle")
	public static WebElement itemTitle;
	
	@FindBy(how=How.CSS, using=".sort-menu-container")
	public static WebElement sortMenu;
	
	@FindAll(@FindBy(how=How.CSS, using=".lvprice"))
	public static List<WebElement> itemPrices;
	
	@FindAll(@FindBy(how=How.CSS, using="#SortMenu li a"))
	public static List<WebElement> sortMenuItems;
	
	@FindAll(@FindBy(how=How.CSS, using=".lvshipping"))
	public static List<WebElement> shipping;
	
	@FindBy(how=How.CSS, using=".pnl-b>a.last_b")
	public static WebElement buyItNow;
	
	@FindBy(how=How.CSS, using="[title='Buy it now or Best Offer']")
	public static WebElement buyItNowOrOfferLogo;
	
	@FindBy(how=How.CSS, using="[title='Buy it now']")
	public static WebElement buyItNowLogo;
	
	@FindBy(how=How.CSS, using=".pages")
	public static WebElement pagination;
	
	@FindBy(how=How.CSS, using=".next")
	public static WebElement pageNext;
	
	@FindBy(how=How.CSS, using="select")
	public static WebElement selectDropdown;
	
	@FindBy(how=How.CSS, using=".cat-app")
	public static WebElement category;	
}
