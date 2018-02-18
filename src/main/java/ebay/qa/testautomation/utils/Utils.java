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
	
	public static boolean priceSort(List<Object> priceList, String sortOrderBy) throws Exception {
		
        List<Object> list = priceList;
        Collections.sort(list);
        if(sortOrderBy.equals("Lowest price")) {
        	return list.equals(priceList); 
        } else {
        	Collections.reverse(list);
    	    return list.equals(priceList);
        }
	}
}
