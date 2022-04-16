package crm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.Base.TestBase;

public class CRMHomePage extends TestBase{
    
	
	//page factory -> it is an objects or element repository
	@CacheLookup
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement Homepageusername;
	
	@FindBy(xpath="//a[@title='Women' and @class='sf-with-ul']")
	WebElement WomenOptionInMenu;
	
	@FindBy(xpath="//a[@title='Women' and @class='sf-with-ul']//parent::li//a[@title='T-shirts']")
	WebElement TshirtsOstionUnderWomenMenu;
	
	@FindBy(xpath="//span[@class='category-name']")
	WebElement TishirtsPageclick;
	
	
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
	
	public void HoverOverWomenOptionAndClickOnTshirtsOption()
	{
		actions(WomenOptionInMenu);
		TshirtsOstionUnderWomenMenu.click();
		
	}
	
	public String verifyTshirtpageIsOPened()
	{
		
		String actualtshirtstitle=TishirtsPageclick.getText();
		return actualtshirtstitle;
		
	}
	
	
	
	
	
	
	
}
