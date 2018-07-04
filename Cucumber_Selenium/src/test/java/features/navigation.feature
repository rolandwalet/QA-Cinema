Feature: Navigation
  As a customer 
  I want to be able navigate between pages on the website 
  so that I I can find the information I need.

  Scenario: Home
    Given I am on the Home page
    When when I press the Home button
    Then I remain on the Home page
    And when navigating to a different page
    When I press click the logo
    Then Im taken back to to the Home Page

  Scenario: Currently showing
    Given I am on the Home page
    When I click the currently showing link
    Then I am taken to the films listing page
    And the listings gallery heading is shown

  Scenario: Coming Soon
    Given I am on the Home page
    When I click the Coming Soon link
    Then I am taken to the Coming Soon page

  Scenario: Message board
    Given I am on the Home page
    When I click the Message board  link
    Then I am taken to the Message board page

  Scenario: Opening Times
    Given I am on the Home page
    When I click the Opening Times  link
    Then I am taken to the Opening Times page
    And the opening times heading is shown

  Scenario: Calssifications
    Given I am on the Home page
    When I click the Classifications  link
    Then I am taken to the Classifications page
    And the Classifications heading is shown

  Scenario: Screens
    Given I am on the Home page
    When I click the Screens link
    Then I am taken to the Screens page
    And the Screeens heading is shown

  Scenario: Contact Us
    Given I am on the Home page
    When I click the contact Us link
    Then I am taken to the Contact Us page
    And the Contact Us heading is shown

  Scenario: Local Area
    Given I am on the Home page
    When I click the Loacal Area link
    Then I am taken to the Loacal Area page
    And the Local Venues heading is shown

  Scenario: Find Us
    Given I am on the Home page
    When I click the Find Us link
    Then I am taken to the Find us page
    And the How to find us heading is shown

  Scenario: About Us
    Given I am on the Home page
    When I click the About Us link
    Then I am taken to the About Us page
    And the About Us heading is shown
