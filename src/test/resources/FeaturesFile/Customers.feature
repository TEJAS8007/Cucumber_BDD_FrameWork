Feature: Customer

  Background: Common Steps for all Sceanrios
    Given user launch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    And user enter email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then User can view Dashboard

@sanity
  Scenario: Add New Customer
    When User click on customer Menu
    And click on customer menu item
    And click on Add noew button
    Then user can view add New Customer page
    When user enter Customer Info
    And click on save button
    Then user can view Confirmation Massage "The new customer has been added successfully."
    And close Browser
    
  @regression
  Scenario: Search Customer By Email
    When User click on customer Menu
    And click on customer menu item
    And Enter customer Email
    When Click on search button
    Then user should found Email in the search table
    And close Browser
    
  @regression
  Scenario: Search Customer By Name
    When User click on customer Menu
    And click on customer menu item
    And Enter customer firstName
    And Enter customer LastName
    When Click on search button
    Then user should found Name in the search table
    And close Browser
