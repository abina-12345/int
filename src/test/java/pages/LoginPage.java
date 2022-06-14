package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="identifier") public WebElement username;
	
	@FindBy(xpath=("//span[text()='Next']/parent::button")) public WebElement homeNext;
	
	public LoginPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void fillUsername(String x)
	{
		username.sendKeys(x);
	}
	
	public void clickNext()
	{
		homeNext.click();
	}
	
	

}
