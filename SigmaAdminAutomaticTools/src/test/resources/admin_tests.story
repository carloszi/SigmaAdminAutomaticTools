Scenario: Login and logout to Admin Page
Given Go to admin site
When I write user, password and click login
Then I go to admin main site
When I click logout button
Then I back to login admin page


Scenario: User go to Action Definition list
Given Go to Admin main site
When User try get into Action Definition List
Then User see Działania strategiczne


Scenario: User define new action definition
Given User in action definition list
When User try add new action definition with name DS_WE_test_name and symbol DS_WE_test_symbol
Then User see name DS_WE_test_name in database