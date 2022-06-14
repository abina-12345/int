package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath="//*[starts-with(@aria-label,'Google Account')]") public WebElement profilepic;
	@FindBy(xpath="//div[text()='Sign out']") public WebElement signout;
	@FindBy(xpath="//*[text()='Choose an account']") public WebElement loginRedisplay;
	
	public LogoutPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickProfilePic() throws Exception
	{
		profilepic.click();
		Thread.sleep(15000);
	}
	public void dosignout(RemoteWebDriver driver) throws Exception
	{
	//	WebElement e=driver.findElement(By.xpath("(//iFrame[@role='presentation'])[2]"));
		driver.switchTo().frame(2);
		signout.click();
		Thread.sleep(5000);
	}
	public boolean isLoginRedisplayed()
	{
		if(loginRedisplay.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}

	
	

}
