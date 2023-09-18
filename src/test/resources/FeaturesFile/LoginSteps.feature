Feature: Login
  @sanity 
  Scenario: Succesfull LOgin with valid Credentials
    Given user launch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    And user enter email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on logout Link
    Then page title should be "your store.Login"
    And close Browser

  
