package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	
	@FindBy(name="password") public WebElement passWord;
	@FindBy(xpath=("//*[text()='Next']")) public WebElement homeNext;
	
	public PasswordPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//operational and observation
	public void fillPassword(String x)
	{
		passWord.sendKeys(x);
	}
	public void clickNext() throws Exception
	{
		homeNext.click();
		Thread.sleep(15000);
	}


}
