package StepDefinition;


import org.apache.logging.log4j.LogManager;
import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObject.CustomersPage;
import PageObject.LoginPage;
import PageObject.SearchPage;
import Utilities.ExtentReportManager;
import Utilities.ReadConfig;
import cucumber.api.java.Before;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.*;




public class Stepdef extends Base{

	public static String email;


	@Before
	public void setup1(Scenario scenario)
	{
		logger=LogManager.getLogger(this.getClass());

		ExtentTest test = ExtentReportManager.createTest(scenario.getName());
		test.log(Status.INFO, "Scenario: " + scenario.getName() + " started.");

		pro=new ReadConfig();
		String browser=pro.getBrowser().toLowerCase();
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "src//test//resources//Drivers//geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		System.out.println("Setup1 executed");
		Log.info("Setup1 Executed");
	}


	@Given("^user launch chrome browser$")
	public void user_launch_chrome_browser() {
		login=new LoginPage(driver);
		customer=new CustomersPage(driver);
		search=new SearchPage(driver);
		Log.info("chrome browser Started");
	}

	@When("^user opens url \"(.*)\"$")
	public void user_opens_url(String url) {
		driver.get(url);
		Log.info("url passed");
	}

	@When("^user enter email as \"(.*)\" and password as \"(.*)\"$")
	public void user_enter_email_as_and_password_as(String email, String password) {
		login.sendEmail(email); 
		login.sendPasssword(password);
		Log.info("Email And Password Enterd");
	}


	@When("^click on Login$")
	public void click_on_login() {
		login.clickOnLogin();
		Log.info("Click on login");
	}

	@Then("^Page title should be \"(.*)\"$")
	public void page_title_should_be(String title) {
		String TitleName=driver.getTitle();
		if(TitleName.equals(title))
		{
			Log.warn("page Title matched");
			Assert.assertTrue(true);
		}
		else
		{
			Log.warn("page Title not matched");
			Assert.assertFalse(false);
		}
	}

	@When("^user click on logout Link$")
	public void user_click_on_logout_link() {
		login.clickOnLogout();
		Log.info("Click on Logout");
	}

	@Then("^page title should be \"(.*)\"$")
	public void page_title_should_(String string) {
		String expectedTitle=driver.getTitle();
		if(string.equals(expectedTitle))
		{
			Log.warn("page Title matched");
			Assert.assertTrue(true);
		}
		else
		{
			Log.warn("page Title not matched");
			Assert.assertFalse(false);
		}
	}

	@Then("^close Browser$")
	public void close_browser() {

		driver.close();
		//driver.quit();
	}

	@Then("^User can view Dashboard$")
	public void user_can_view_Dashboard() throws Throwable {
		String ActualTitle=customer.getPageTitle();
		String ExpectedTitle="Dashboard / nopCommerce administration";

		if(ActualTitle.equals(ExpectedTitle))
		{
			Log.warn("page Title matched");
			Assert.assertTrue(true);
		}
		else
		{
			Log.warn("page Title not matched");
			Assert.assertTrue(false);
		}
	}

	@When("^User click on customer Menu$")
	public void user_click_on_customer_Menu() throws Throwable {
		customer.clickOnCustomersMenu();
		Log.info("User click on customer Menu");
	}

	@When("^click on customer menu item$")
	public void click_on_customer_menu_item() throws Throwable {
		customer.clickOnCustomersMenuItem();
		Log.info("User click on customer Menu item");
	}

	@When("^click on Add noew button$")
	public void click_on_Add_noew_button() throws Throwable {
		customer.clickOnAddnew();
		Log.info("user click on add new");
	}

	@Then("^user can view add New Customer page$")
	public void user_can_view_add_New_Customer_page() throws Throwable {
		String ActualTitle=customer.getPageTitle();
		String ExpectedTitle="Add a new customer / nopCommerce administration";

		if(ActualTitle.equals(ExpectedTitle))
		{
			Log.warn("Title matched");
			Assert.assertTrue(true);
		}
		else
		{
			Log.warn("Title not matched");
			Assert.assertTrue(false);
		}
	}

	@When("^user enter Customer Info$")
	public void user_enter_Customer_Info() throws Throwable {
		//customer.enterEmail("AZA@gmail.com");
		email= generateEmailID();
		customer.enterEmail(email+"@gmail.com");
		customer.enterPassword("test1");
		customer.enterFirstName("Tejas");
		customer.enterLastName("Aware");
		customer.enterGender("Male");
		customer.enterDob("05/28/2001");
		customer.enterCompanyName("Shrimant Group");
		customer.enterAdminContent("Admin Contenet");
		customer.enterManagerOfVendor("Vendor 2");
		Log.info("user Entred customer info");
	}

	@When("^click on save button$")
	public void click_on_save_button() throws Throwable {
		customer.clickOnSave();
		Log.info("user click on save");
	}

	@Then("^user can view Confirmation Massage \"(.*)\"$")
	public void user_can_view_Confirmation_Massage(String exptitle) throws Throwable {
		String bodyTageText=driver.findElement(By.tagName("Body")).getText();
		if(bodyTageText.contains(exptitle)) 
		{
			Log.info("Confirmation Massaged Verified");
			Assert.assertTrue(true);
		}
		else
		{
			Log.warn("Not verified failed");
			Assert.assertTrue(false);
		}
	}


	@When("^Enter customer Email$")
	public void enter_customer_Email() throws Throwable {
		search.enterEmailAdd(email+"@gmail.com");
		Log.info(email+" : email entred");
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable {
		search.clickOnSearchButton();
		Log.info("click on save button");
	}

	@Then("^user should found Email in the search table$")
	public void user_should_found_Email_in_the_search_table() throws Throwable {
		String EXpectedemail=email+"@gmail.com";
		Assert.assertTrue(search.searchCustomerByEmailFromEmailSection(EXpectedemail));
		Log.info("Email Verified in Search table");
		/*
       if(search.searchCustomerByEmailFromEmailSection(EXpectedemail)==true)
       {
    	   Assert.assertTrue(true);
       }
       else
       {
    	   Assert.assertTrue(false);
       }
		 */
	}

	@When("^Enter customer firstName$")
	public void enter_customer_firstName() throws Throwable {
		search.enterFirstName("Tejas");
		Log.info("FirstName Entered");
	}

	@When("^Enter customer LastName$")
	public void enter_customer_LastName() throws Throwable {
		search.enterLastName("Aware");
		Log.info("Last Name Entred");
	}

	@Then("^user should found Name in the search table$")
	public void user_should_found_Name_in_the_search_table() throws Throwable {
		String Expected="Tejas Aware";
		if(search.searchCustomerByName(Expected)==true)
		{
			Log.info("Name Found in search Table");
			Assert.assertTrue(true);
		}
		else
		{
			Log.warn("Name Not found in search table");
			Assert.assertTrue(false);
		}
	}

	@After
	public void cleanup(Scenario scenario)
	{
		System.out.println("tear Down Methd executed");
		driver.quit();
		Log.info("SuccessFully Excuted Cleanup");
		ExtentTest test = ExtentReportManager.getTest();
		if (scenario.isFailed()) {
			test.log(Status.FAIL, "Scenario failed: " + scenario.getName());
			
		} else {
			test.log(Status.PASS, "Scenario passed: " + scenario.getName());
		}
		ExtentReportManager.flushReport();
	}






}
