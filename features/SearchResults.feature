	Feature: Search Results. Where one can sort, filter and see details of resulting products.
		
		@001
		Scenario: Search and verify results
			Given I navigate to "https://www.ebay.co.uk/"  
			And I am a non-registered customer 
			When I search for an item
			Then I get a list of matching results 
			And the resulting items cards show: postage price, No of bids, price or show BuyItNow tag
			Then I can sort the results by "Lowest price"
			And the results are listed in the page in the correct order
			Then I can sort the results by "Highest price"
			And the results are listed in the page in the correct order
			Then I can filter the results by 'Buy it now'
			And all the results shown in the page have the 'Buy it now' tag 
		
		@002
		Scenario: Search per category
			Given I navigate to "https://www.ebay.co.uk/"
			And I am a non-registered customer 
			When I search for an item
			And select a specific Category "Antiques"
			Then I get a list of matching results
			And I can verify that the results shown as per the the selected category
		
		@003
		Scenario: Search and navigate through results pages
			Given I navigate to "https://www.ebay.co.uk/"
			And I am a non-registered customer 
			When I search for an item
			Then I get a list of matching results 
			And the results show more than one page
			Then the user can navigate through the pages to continue looking at the items
