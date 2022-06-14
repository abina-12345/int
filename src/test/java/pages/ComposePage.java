package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposePage {
	@FindBy(xpath="//*[text()='Compose']")
	public WebElement Compose;
	@FindBy(name=("to"))
	public WebElement to;
	@FindBy(name="subjectbox")
	public WebElement subject;
	@FindBy(xpath="//*[@role='textbox']")
	public WebElement body;
	@FindBy(name="Filedata")
	public WebElement attachfile;
	@FindBy(xpath="//*[text()='Send']")
	public WebElement send;
	@FindBy(xpath="//*[text()='Message sent']")
	public WebElement outputmsg;
	
	public ComposePage(RemoteWebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isComposeDisplayed()
	{
		if(Compose.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public void clickCompose()
	{
		Compose.click();
	}
	public void fillto(String x)
	{
		to.sendKeys(x);
	}
	public void fillsubject(String x) throws Exception
	{
		subject.sendKeys(x);
		Thread.sleep(15000);
	}
	public void fillbody(String x) throws Exception
	{
		body.sendKeys(x);
		Thread.sleep(15000);
	}
	public void fillfilepath(String x)
	{
		attachfile.sendKeys(x);
		
	}
	public void clickSend() throws Exception
	{
		send.click();
		Thread.sleep(15000);
		
	}
	public String outputmsg()
	{
		String x=outputmsg.getText();
				return(x);
				
	}

}
