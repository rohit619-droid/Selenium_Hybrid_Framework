Feature: Login in to application 
Scenario Outline: Succesful login with valid credentials 
	Given Initialize chrome driver 
	And Navigating to " http://www.qaclickacademy.com/" 
	And click on login link  to land on sign in page 
	When user enters valid <username> and <password> and logs in
	Then verify the user is successfully naviagtes to sign page 
	And close the browser 
	
	
	Examples: 
		|username	|password	|
		|test99@gmail.com	|123456	|
		|test33@gmail.com	|12345	|
		|test323@gmail.com	|12335	|