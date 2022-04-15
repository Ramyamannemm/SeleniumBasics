package crm.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.Base.TestBase;

public class CRMLoginPage extends TestBase{

	//page-factory
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement LoginLabel;
	
    @FindBy(xpath="//div[@class='ui fluid large blue submit button']")
    WebElement LoginButton;
    
    @FindBy(name="email")
    WebElement username;
    
    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement password;
	
	public CRMLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginIntoCRMApplication(String usernamedata,String passworddata)
	{
		LoginLabel.click();
		implicitwait(10);
		username.sendKeys(usernamedata);
		password.sendKeys(passworddata);
		LoginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
