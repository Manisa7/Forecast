package step_definitions;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import pageObjects.HomePage;
import pageObjects.CurrentWeather;
import pageManager.PageObjectManager;
import dataProvider.JsonDataReader;


public class ForecastFeatureStepDefinition 
{
	//Declaration of required variables
	WebDriver driver;
	PageObjectManager pageObjectManager;
	HomePage homePage;
	CurrentWeather currentWeather;
	JsonDataReader jsonReader;
	ConfigFileReader configFileReader= new ConfigFileReader();
	String cName,URL,countryCode,cityNmeCountryCode;
	TakesScreenshot screenshot;
	File src ;
	
	Set < String > dates = new HashSet <String>();
	
	
	@Given("^User is on home page$")	
	public void user_is_on_home_page() throws Throwable 
	{
		//This will launch the Url and checks the home page is displayed
		System.setProperty(configFileReader.getBrowser(),configFileReader.getDriverPath());
		driver=new ChromeDriver();
		String URL=configFileReader.getApplicationUrl();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();		
		homePage.verifyHomepage();
		screenshot = (TakesScreenshot) driver;
		
		src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File( "D:\\Java_workspace\\WeatherForecast\\target\\ForeCast Run Reports\\verifyHompge.jpg"));
	}	

	@When("^User enters \\\"([^\\\"]*)\\\" and clicks search button$")
	public void user_enters_cityName_and_clicks_search_button(String cityName) throws Throwable 
	{		
		
		System.out.println(cityName);
		jsonReader=new JsonDataReader(cityName);
		
		cName=jsonReader.getCityName();		
		countryCode=jsonReader.getCountry();
		cityNmeCountryCode=cName+", "+countryCode;
		homePage.enterCity(cName);
		homePage.searchCity();		
	 
	}
	@Then("^User gets relevent city with country code$")
	public void verifyCitywithCountryCode() throws IOException
	{
		try
		{
		assertTrue(driver.findElement(By.linkText(cityNmeCountryCode)).isDisplayed());
		}
		catch(Error e)
		{
			System.out.println("Given city with country code is not present  "+cityNmeCountryCode );
		}
		src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Java_workspace\\WeatherForecast\\target\\ForeCast Run Reports\\verifyCitypresent.jpg"));
	
	}
	@When("^User clicks required city$")
	public void selectCitybyCountry() throws InterruptedException
	{
		driver.findElement(By.linkText(cityNmeCountryCode)).click();
		Thread.sleep(20000);
	}

	@Then("^User gets five day weather forecast of given city$")
	public void user_gets_day_weather_forecast_of_given_city() throws Throwable 
	{
		
		currentWeather=pageObjectManager.getCurrentWeather();
		verifyText_fiveDayWeather();
		verifyValues_fiveDayWeather();
	    
	}
	private void verifyText_fiveDayWeather() throws IOException 
	{
		String verifytext;		
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.visibilityOf(currentWeather.elm_daysWeather));
		verifytext=currentWeather.getTextofDays();
		
		try
		{
			assertEquals("5 day weather forecast", verifytext);
		
		}
		catch(Error e)
		{
			System.out.println("5 day weather forecast text is not present");
		}
		if (verifytext=="5 day weather forecast")
			System.out.println("5 day weather forecast text is present");	
		src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Java_workspace\\WeatherForecast\\target\\ForeCast Run Reports\\forecastpresent.jpg"));
		
	}
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	private void verifyValues_fiveDayWeather() throws IOException 
	{
		
		try
		{
		assertTrue(currentWeather.getRowCount()>5);}
		catch(Error e)
		{
			System.out.println("Forecast is available for more days ");
			
		}		
		
		try
		{
		assertTrue(currentWeather.verifyCells(driver));
		}
		catch(Error e)
		{
			System.out.println("Forecast is missing for few days ");
		}
		
		
		src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Java_workspace\\WeatherForecast\\target\\ForeCast Run Reports\\5dayforecast.jpg"));
		
		
	}

	@When("^User clicks hourly status$")
	public void user_Clicks_Hourly() throws InterruptedException
	{
		currentWeather=pageObjectManager.getCurrentWeather();
		currentWeather.tab_Hourly_Click();
	}
	@Then("^User gets hourly forecast for \"([^\"]*)\"$")
	public void verify_Hourly(String day) throws IOException
	{
		int expDay=Integer.parseInt(day);
		currentWeather.verify_Hourly_Title(cityNmeCountryCode);
		src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Java_workspace\\WeatherForecast\\target\\ForeCast Run Reportshourlytext.jpg"));
//		
		//currentWeather.verify_HourlyForecastForDay(expDay,jsonReader.findHourlyforday(expDay));
		currentWeather.verify_HourlyForecastForDay(expDay,jsonReader,driver);
		src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Java_workspace\\WeatherForecast\\target\\ForeCast Run Reports\\hourlytext.jpg"));
		
	}
	@Then("^Hourly forecast is hidden$")
	public void verify_HourlyForecast_hidden()
	{
		currentWeather.verify_Hourly_TitleNot(cityNmeCountryCode);
	}
	
	@Then("^Forecast for a \"([^\"]*)\"contains most dominant condition most dominant wind speed rainfall and minimum maximum temparature with rounded value$")
	public void verify_DailyForecast(String day) throws IOException
	{
		int expDay=Integer.parseInt(day);
		currentWeather.verify_DailyForecastForDay(expDay,jsonReader);
		src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Java_workspace\\WeatherForecast\\target\\ForeCast Run Reports\\dailyvalues.jpg"));
		
	}
	
	@After()
	public void close_browsers()
	{
		driver.close();
	}
	
}

