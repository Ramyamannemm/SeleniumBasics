package crm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.Base.TestBase;

public class MyProfilePage extends TestBase {

	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement MyProfileClick;
	
	@FindBy(xpath="//a[@title='Addresses']")
	WebElement MyAddresses;
	
	@FindBy(xpath="//a[@title='Add an address']")
	WebElement AddNewAddress;
	
	@FindBy(id="firstname")
	WebElement FirstName;
	
	@FindBy(id="lastname")
	WebElement LastName;
	
	
	public MyProfilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void AddressFilling(String Firstname, String Lastname)
	{
		
		MyProfileClick.click();
		MyAddresses.click();
		AddNewAddress.click();
		FirstName.clear();
		FirstName.sendKeys(Firstname);
		LastName.clear();
		LastName.sendKeys(Lastname);
	}
	
	
}
