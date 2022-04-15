package crm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import crm.Base.TestBase;

public class CRMLoginPage extends TestBase{

	//page-factory
	
    @FindBy(xpath="//a[@class='login']")
    WebElement SignButton;
    
    @FindBy(xpath="//input[@id='email']")
    WebElement username;
    
    @FindBy(how=How.ID, using="passwd")
    WebElement password;
    
    @FindBy(xpath="//button[@id='SubmitLogin']")
    WebElement SubmitButton;
	
	public CRMLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginIntoYourLogoApplication(String usernamedata,String passworddata)
	{
		SignButton.click();
		implicitwait(10);
		username.sendKeys(usernamedata);
		password.sendKeys(passworddata);
		SubmitButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
