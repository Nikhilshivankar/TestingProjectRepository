Feature: Find a price

	Background : 
		Given   User launches browser
		
	Scenario : Get the price for shipment
        Given   User launches web application
        When    User navigates to lookup menu for price
        And     User enters input to raise the request for price
        Then    User gets price
    