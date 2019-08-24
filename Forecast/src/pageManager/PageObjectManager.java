package pageManager;
import org.openqa.selenium.WebDriver;

import pageObjects.CurrentWeather;
import pageObjects.HomePage;
public class PageObjectManager 
{
	private WebDriver driver;
	 
	private HomePage homePage;
	private CurrentWeather currentWeather;
	
	public PageObjectManager(WebDriver driver) 
	{		 
		 this.driver = driver;		 
	}
	public HomePage getHomePage()
	{
		 
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
		 
	}
	public CurrentWeather getCurrentWeather()
	{
		 
		 return (currentWeather == null) ? currentWeather = new CurrentWeather(driver) : currentWeather;
		 
	}
}
