package crm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.Base.TestBase;

public class CRMHomePage extends TestBase{
    
	
	//page factory -> it is an objects or element repository
	@FindBy(xpath="//a[text()='Login']")
	WebElement LoginLabel;
	
	@CacheLookup
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignupLabel;
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement Homepageusername;
	
	
	public CRMHomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String HomePageTitle()
	{
		
		String ActualTitle=driver.getTitle();
		return ActualTitle;	
	}
	
	public String HomePageusername()
	{
		String ActualHomepageusername=Homepageusername.getText();
		
		return ActualHomepageusername;
		
	}
	
	
	
	
	
	
	
	
}
