package ebay.qa.testautomation.utils;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import ebay.qa.test.Hooks;
import edu.emory.mathcs.backport.java.util.Collections;

public class Utils {

	public static WebDriver driver;

	public Utils() {
		
		driver = Hooks.driver;
	}
	
	public static void notSignedIn() {
		try
		{
			driver.manage().deleteAllCookies();
		}
		catch(WebDriverException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void lowestPriceSort(List<Object> priceList) throws Exception {
		
        //Compares if the numbers included in the list are sorted 
        List<Object> tmp = priceList;
        Collections.sort(tmp);
        boolean sorted = tmp.equals(priceList);
        if(sorted) {
        	System.out.println("Items are sorted based on lowest price");
        } else {
        	throw new Exception("Lowest price sorting is broken in search results page");
        }
                
	}

	public static void highestPriceSort(List<Object> priceList) throws Exception {
	    //Compares if the numbers included in the list are sorted 
	    List<Object> tmp = priceList;
	    Collections.sort(tmp);
	    Collections.reverse(tmp);
	    boolean sorted = tmp.equals(priceList);
	    if(sorted) {
	    	System.out.println("Items are sorted based on highest price");
	    } else {
	    	throw new Exception("Highest price sorting is broken in search results page");
	    }
	}
}
