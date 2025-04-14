Feature: To test the functionalities of Search Module.



  @tag1
  Scenario: REGISTRATION OF NEW USER
    Given I am in registration page
    When I enter valid required details
    And I click on Register
    Then it should redirect the user to login page


  @tag2
  Scenario: LOGGING IN OF USER
    Given I am in login page
    When I enter the registered email id and valid password
    Then I should navigate to flight search page


  @tag3
  Scenario: Saving Credentials
    Given  I am in login page
    When  I enter the registered email id and valid password
    And I check Remember me box
    Then Password must be fetched automatically

  @tag4
  Scenario: SearchPage
    Given I am in search page
    When I enter origin, destination, flight date and no. of passengers
    Then I get the result of flight details


  @tag4
  Scenario: BookingPage
    Given I am in flight search page
    When I should be able to opt the flight from the list
    Then I should be redirected to booking page
