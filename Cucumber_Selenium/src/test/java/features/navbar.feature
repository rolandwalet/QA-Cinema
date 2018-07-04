Feature: Navbar Feature
   As a customer 
  I want to be able navigate (Using the nav bar) between pages on the website 
  so that I I can find the information I need.


  Scenario: Whats on
    Given I am on any page of the site
    When I press the Films Button
    And I press the Whats on button on the drop down 
    Then I am taken to the listing page 
    
  Scenario: Future Releases
    Given I am on any page of the site
    When I press the Films Button
    And I press the Future Releases button on the drop down 
    Then I am taken to the FutureReleases page 
    
  Scenario: Opening Times
    Given I am on any page of the site
    When I press the Information Button
    And I press the Opening Times button on the drop down 
    Then I am taken to the OpeningTimes page 
    
  Scenario: Classifications
    Given I am on any page of the site
    When I press the Information Button
    And I press the Classifications button on the drop down 
    Then I am taken to the Classification page 
    
  Scenario: Screens
    Given I am on any page of the site
    When I press the Information Button
    And I press the Screens button on the drop down 
    Then I am taken to the Screen page   
    
  Scenario: Contact
  	Given I am on any page of the site
  	When I press the Conact Us Button
  	Then I am taken to the ContactUs Page
  

