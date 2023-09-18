package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement Password;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement Login;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	public void sendEmail(String Email)
	{
		email.clear();
		email.sendKeys(Email);
	}
	
	public void sendPasssword(String passWord)
	{
		Password.clear();
		Password.sendKeys(passWord);
	}
	
	public void clickOnLogin()
	{
		Login.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
	
}
