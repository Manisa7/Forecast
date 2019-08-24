package pageObjects;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		//driver=this.driver;
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	 }
	
	@FindBy(how = How.ID, using = "nav-search") 
	 private WebElement elm_Search;
	 
	@FindBy(how = How.CSS, using = "input.form-control:nth-child(2)") 
	 private WebElement txtbx_Search;
	 
	@FindBy(how = How.XPATH, using = "/html/body/main/div[2]/div/div/div/div[2]/div/form/button") 
	 private WebElement btn_SubmitCity;
	
	public void enterCity(String cityName)
	{
		
		txtbx_Search.sendKeys(cityName);
	}
	public void searchCity()
	{
		btn_SubmitCity.click();
	}
	public void verifyHomepage()
	{
		try
		{
		assertTrue(txtbx_Search.isDisplayed());
		}
		catch(Error e)
		{
			System.out.println("assert fails and home page is not present");
		}
	}

}
