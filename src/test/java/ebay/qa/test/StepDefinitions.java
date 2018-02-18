package ebay.qa.test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ebay.qa.testautomation.pages.HomePage;
import ebay.qa.testautomation.pages.SearchResultsPage;
import ebay.qa.testautomation.utils.Utils;

public class StepDefinitions {

	public static WebDriver driver;
	public WebElement sortOrder;
	public String sortOrderBy;
	public StepDefinitions() {
		driver = Hooks.driver;
	}
	
	@Given("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to(String arg1) throws Throwable {
		driver.get(arg1); 	
	}
	
	@Given("^I am a non-registered customer$")
	public void i_am_a_non_registered_customer() throws Throwable {
		PageFactory.initElements(driver, Utils.class);
		Utils.notSignedIn();		
	}
	
	@When("^I search for an item$")
	public void i_search_for_an_item() throws Throwable {
		PageFactory.initElements(driver, HomePage.class);
		HomePage.searchBox.sendKeys("eggs");
	    HomePage.searchButton.click();
	}
	
	@Then("^I get a list of matching results$")
	public void i_get_a_list_of_matching_results() throws Throwable {
		PageFactory.initElements(driver, SearchResultsPage.class);
		assertNotEquals(0, SearchResultsPage.totalResults.getText());
		for (int i= 0; i< SearchResultsPage.searchResults.size(); i++) {
			assertTrue(SearchResultsPage.resultTitles.get(i).getText().toLowerCase().contains("egg"));
		}
	}
	
	@Then("^the resulting items cards show: postage price, No of bids, price or show BuyItNow tag$")
	public void the_resulting_items_cards_show_postage_price_noofbid_price_show_buyitnow_tags() throws Throwable  {
	 	assertEquals(SearchResultsPage.searchResults.size(), SearchResultsPage.shipping.size());
	}
	
	@Then("^I can sort the results by \"([^\"]*)\"$")
	public void i_can_sort_the_results_by_lowest_price(String arg1) throws Throwable {
		SearchResultsPage.sortMenu.click();
		Thread.sleep(6000);
		sortOrderBy = arg1;
	    for (WebElement sortOrder : SearchResultsPage.sortMenuItems){
		  if(sortOrder.getText().equals(sortOrderBy)) {
		   sortOrder.click();
    	   break;
		  }
	    }
	}
	
	@Then("^the results are listed in the page in the correct order$")
	public void the_results_are_listed_in_the_page_in_the_correct_order() throws Throwable {
	     List<Object> priceList = new ArrayList<Object>();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 for(int j=0; j<SearchResultsPage.itemPrices.size();j++) {
	    	 priceList.add(SearchResultsPage.itemPrices.get(j).getText().substring(1).replaceAll(",","").replace(".", "")); 
	    	 System.out.println(priceList.get(j));
	     }
	     if(sortOrderBy.equals("Lowest price")) {
	     Utils.lowestPriceSort(priceList);
	     } else {
	    	 Utils.highestPriceSort(priceList);
	     }
	}
	
	@Then("^I can filter the results by 'Buy it now'$")
	public void i_can_filter_results_by_Buy_it_now() throws Throwable {
		SearchResultsPage.buyItNow.click();
		Thread.sleep(5000);
	}
	
	@Then("^all the results shown in the page have the 'Buy it now' tag$")
	public void all_the_results_shown_in_the_page_have_the_Buy_it_now_tag() throws Throwable {
		for (int i=0; i<SearchResultsPage.searchResults.size();i++) {
			assertTrue(SearchResultsPage.buyItNowOrOfferLogo.isDisplayed() || SearchResultsPage.buyItNowLogo.isDisplayed());
		}
	}
	
	@Then("^the results show more than one page$")
	public void the_results_show_more_than_one_page() throws Throwable {
	      assertTrue(SearchResultsPage.pagination.isDisplayed());
	}

	@Then("^the user can navigate through the pages to continue looking at the items$")  
	public void the_user_can_navigate_through_the_pages_to_continue_looking_at_the_items() throws Throwable {
		SearchResultsPage.pageNext.click();
	    assertTrue(SearchResultsPage.itemTitle.isDisplayed());
	}
	
	@When("^select a specific Category$")
	public void select_a_specific_category() throws Throwable {
		Select selection = new Select(HomePage.selectDropdown);
		selection.selectByVisibleText("Antiques");
		HomePage.searchButton.click();
	}

	@Then("^I can verify that the results shown as per the the selected category$")
	public void i_can_verify_that_the_results_shown_as_par_the_selected_category() throws Throwable {
	    HomePage.category.getText().equals("Antiques");
	}
}