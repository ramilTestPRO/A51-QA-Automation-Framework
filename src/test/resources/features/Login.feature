Feature: Login feature

  #This will get us logged in // # used for  comments like // in java
  Scenario: Login Success
    Given I open browser
    And I open Login Page
    And I enter email "ramil.hasanli@testpro.io"
    And I enter password "iutZVH7Q"
    And Submit
    Then I should get logged in


  Scenario Outline: Login different Passwords
    Given I open Login Page
    When I enter email "<email>"
    And I enter password "<password>"
    And Submit
    Then I should get logged in

    Examples:
      | email                    |password|
      | ramil.hasanli@testpro.io |iutZVH7Q|
      | ramil.hasanli@testpro.io |S0000rT |
      | ramil.hasanli@testpro.io |        |
