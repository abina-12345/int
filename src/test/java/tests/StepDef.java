package tests;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ComposePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.PasswordPage;

public class StepDef {
	
	RemoteWebDriver driver;
	LoginPage obj1;
	PasswordPage obj2;
	ComposePage obj3;
	LogoutPage obj4;
	
	@Given("open {string} browser")
	public void open_browser(String string) {
		
		if(string.equalsIgnoreCase("chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			    driver=new ChromeDriver();
			    
			    
		}
		obj1=new LoginPage(driver);
	    obj2=new PasswordPage(driver);
	    obj3=new ComposePage(driver);
	    obj4=new LogoutPage(driver);
	   
	    
	}

	@When("launch {string}")
	public void launch(String string) {
		driver.get(string);
	}

	@When("do login using {string} and {string}")
	public void do_login_using_and(String string, String string2) throws Exception
	{
	   obj1.fillUsername(string);
	   obj1.clickNext();
	   
	   obj2.fillPassword(string2);
	   obj2.clickNext();
	   
	}

	@Then("compose is displayed")
	public void compose_is_displayed() {
	 
		if(obj3.isComposeDisplayed())
		{
			System.out.println("compose is displayed");
			
		}
		else
		{
			System.out.println("compose is not displayed");
		}

	}

	@When("click on compose and fill fields and send mail and check response")
	public void click_on_compose_and_fill_fields_and_send_mail_and_check_response(io.cucumber.datatable.DataTable dataTable) throws Exception {
	   
		
	
		List<Map<String,String>> l=dataTable.asMaps();
		for(int i=0; i<=0; i++)
		{
			obj3.clickCompose();
			obj3.fillto(l.get(i).get("to"));
			obj3.fillbody(l.get(i).get("subject"));
			obj3.fillsubject(l.get(i).get("body"));
			obj3.fillfilepath(l.get(i).get("attachment"));
			
			obj3.clickSend();
			System.out.println(obj3.outputmsg());
		}
	}

	@When("do logout")
	public void do_logout() throws Exception {
	   
		obj4.clickProfilePic();
		obj4.dosignout(driver);
		
	}

	@Then("login page should be resdisplayed")
	public void login_page_should_be_resdisplayed() {
		if(obj4.isLoginRedisplayed())
		{
			System.out.println("Successfully logout");
		}
		else
		{
			System.out.println("Unsuccessful logout");
		}
	}

	@When("close site")
	public void close_site() {
	    driver.close();
	}


}
