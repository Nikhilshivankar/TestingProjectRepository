Feature: Updating a schedule


    Background:	Launching browser and web application
        Given   User launches browser and open web application
	
    Scenario:   TC_005_Update a port to port schedule
    	#   User launches browser and open web application
        
        When    User navigates to lookup menu for schedule and select schedule type
        And     User enters input to get schedule
        Then    User gets schedule
        
        