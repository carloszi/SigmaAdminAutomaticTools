Meta:

Narrative:
As a user
I want to find document client by barcode
So that I can achieve a business goal

Scenario: Searching document client
Given Open webdriver
When I go to operations-web
Then I see Podaj dane logowania
When I login to main page
Then I see welcome page
When I write <agreementId> in search field and click searching
Then I see client data <clientData>
When I click debt value
Then I see client data section <clientData>
When I click documents
Then I see documents header
When I fill <barcode>
Then I see only one document

Examples:
|agreementId|clientData|barcode|
|11749002|37KOM|009003207277|
|11748835|JH INTERNATIONAL SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ|009003207195|

