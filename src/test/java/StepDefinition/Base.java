package StepDefinition;



import org.apache.commons.lang.RandomStringUtils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import PageObject.CustomersPage;
import PageObject.LoginPage;
import PageObject.SearchPage;
import Utilities.ReadConfig;

public class Base  {

	public static WebDriver driver;
	public LoginPage login;
	public CustomersPage customer;
	public SearchPage search;
    public static Logger logger;
    public ReadConfig pro;
    
	public String generateEmailID()
	{
		String email=RandomStringUtils.randomAlphabetic(5);
		return email;
	}
	
	
}
