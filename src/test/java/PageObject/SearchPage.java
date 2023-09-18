package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="SearchEmail")
	WebElement emailAdd;

	@FindBy(id="search-customers")
	WebElement searchBtn;

	@FindBy(xpath="//table[@role='grid']")
	WebElement searchResult;

	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	/*@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;*/

	@FindBy(id="SearchFirstName")
	WebElement firstName;

	@FindBy(id="SearchLastName")
	WebElement lastName;

	//method to enter email address
	public void enterEmailAdd(String email)
	{
		emailAdd.sendKeys(email);
	}

	//action method to perform click on search button
	public void clickOnSearchButton()
	{
		searchBtn.click();
		
	}


	public boolean searchCustomerByEmailFromEmailSection(String email)
	{
		boolean found = false;
		int totalRows = tableRows.size();

		for(int i=1;i<=totalRows;i++) 
		{
			System.out.println("Searching row:" +i);

			WebElement webElementEmail = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			System.out.println(actualEmailAdd);

			if(actualEmailAdd.equals(email))
			{
				found=true;
			}
		}
		return found;
	}
	//****************Search customer by name*************
	
	public void enterFirstName(String firstNameText)
	{
		firstName.sendKeys(firstNameText);
	}

	
	public void enterLastName(String LastNameText)
	{
		lastName.sendKeys(LastNameText);
	}

	public boolean searchCustomerByName(String name)
	{
		boolean found = false;
		int totalRows = tableRows.size();
		for(int i=1;i<=totalRows;i++)
		{
			WebElement webElementName = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[3]"));
			String actualName = webElementName.getText();

			if(actualName.equals(name))
			{
				found=true;
				break;
			}
		}
          return found;
	}
}
