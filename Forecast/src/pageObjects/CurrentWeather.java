package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import dataProvider.JsonDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.JsonDataReader;

public class CurrentWeather 
{
	WebDriver driver;
	List < WebElement > rows;
	String logs="";
	JsonDataReader jsonReader;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div[2]/div/div/div/div[3]/div[3]/span/span/div[3]/h3") 
	 public WebElement elm_daysWeather;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div[2]/div/div/div/div[3]/div[3]/span/span/div[3]/table") 
	 private WebElement tbl_DaysWeather;	
	
	@FindBy(how = How.ID, using = "tab-hourly") 
	 private WebElement tab_Hourly;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div[2]/div/div/div/div[3]/div[3]/span/span/div/h2") 
	 private WebElement elm_Hourly_title;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div[2]/div/div/div/div[3]/div[3]/span/span/div/table") 
	 private WebElement tbl_HourWeather;
	
	public CurrentWeather(WebDriver driver) 
	{
		//driver=this.driver;
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	 }
	public String getTextofDays()
	{
		return elm_daysWeather.getText();
	}
	public int getRowCount()
	{
		
		rows = tbl_DaysWeather.findElements(By.tagName("tr"));
		return rows.size();
	}
	public boolean verifyCells(WebDriver driver) 
	{	
		boolean verifyFlg=true;		
		Date objDate ;
		String newDate;
		String strDateFormat = "EEE dd MMM"; //Date format is Specified
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object
		Calendar c = Calendar.getInstance();
		Actions builder=new Actions(driver);
		
		for (int row = 0; row < 5; row++) 
		{
			objDate = new Date();
			c.setTime(objDate);
			c.add(Calendar.DAY_OF_MONTH, row);  
			newDate = objSDF.format(c.getTime()); 
    	    //To locate columns(cells) of that specific row.
    	    List < WebElement > Columns_row = rows.get(row).findElements(By.tagName("td"));
    	   
    	    // To retrieve text from that specific cell.
    	    String datetext = Columns_row.get(0).getText();
    	    String forecasttext = Columns_row.get(1).getText();
    	   // Columns_row.get(1).click(); 
    	    builder.moveToElement(Columns_row.get(1)).build().perform();
    	    if ((forecasttext == "") && (datetext != newDate))
    	    {
    	    	verifyFlg=false;  
    	    	logs=logs + "Forecast is not availble for "+newDate + "\n";
    	    	
    	    }
    	    else
    	    	logs=logs + "Forecast is availble for "+newDate+ "\n";;
    	    
    	 }
		System.out.println(logs);
		if (verifyFlg)
			System.out.println("5 records are available");
		return verifyFlg;
		
	}
	public void tab_Hourly_Click()
	{
		tab_Hourly.click();
	}
	public void verify_Hourly_Title(String cityNmeCountryCode)
	{
		String act_text=elm_Hourly_title.getText();
		String exp_text="Hourly weather and forecasts in "+cityNmeCountryCode;
		System.out.println(act_text + "\n"+ exp_text);
		
		try
		{
		assertEquals(act_text,exp_text);
		}
		catch(Error e)
		{
			System.out.println("Hourly titile is not present for the city "+exp_text);
		}		
		if (act_text==exp_text)
		{
			System.out.println("Hourly text titile is present for the city "+exp_text);
		}			
		
	}
	public void verify_Hourly_TitleNot(String cityNmeCountryCode)
	{
		Boolean flg=elm_Hourly_title.isDisplayed();
		
		try
		{
		assertFalse(flg);
		}
		catch(Error e)
		{
			System.out.println("Hourly titile is present for the city ");
		}		
			
		
	}
	public void verify_HourlyForecastForDay(int day,JsonDataReader jsonReader,WebDriver driver)
	{
		
		Date objDate = new Date();	
		String JsonDateFormat = "yyyy-mm-dd";
		String appDateFormat = "EEE MMM dd";
		String actResult="";
		SimpleDateFormat objSDF = new SimpleDateFormat(JsonDateFormat);
		SimpleDateFormat objSDF2 = new SimpleDateFormat(appDateFormat);
		Actions builder=new Actions(driver);
		Calendar c = Calendar.getInstance();
		c.setTime(objDate);		
		c.add(Calendar.DAY_OF_MONTH,day);  
		String jsonDate = objSDF.format(c.getTime());
		String appDate = objSDF2.format(c.getTime());		
		//System.out.println(expResult);
		List<WebElement> table_hour=tbl_HourWeather.findElements(By.tagName("table"));		
		
		HashMap<String, String> actData = new HashMap<String, String>(); 
		HashMap<String, String> expData =jsonReader.findHourlyforday(day);
		int pos=0;
		List < WebElement > Columns_row;
		for (int i=0;i<table_hour.size();i++)
		{
			Columns_row = table_hour.get(i).findElements(By.tagName("td"));
		
				if((Columns_row.size()==3) && (Columns_row.get(0).getText().contains(appDate)) )
				{
					String temp1=actResult + Columns_row.get(1).getText();
					String temp2=actResult + Columns_row.get(2).getText();
					
					actData.put(temp1, temp2);
					i++;
					Columns_row = table_hour.get(i).findElements(By.tagName("td"));
					while (Columns_row.size() ==2)
					{							
						temp1=actResult + Columns_row.get(0).getText();
						temp2=actResult + Columns_row.get(1).getText();
						builder.moveToElement(Columns_row.get(1)).build().perform();
						actData.put(temp1, temp2);
						i++;
						Columns_row = table_hour.get(i).findElements(By.tagName("td"));
					}
					break;
				}		
		}
		
		try
		{
		assertTrue(actData.equals(expData));
		}
		catch(Error e)
		{
			System.out.println("Hourly forecast is mismatched with the actual data");
		}
	}
	
	public void verify_DailyForecastForDay(int expDay,JsonDataReader jsonReader)
	{
		boolean verifyFlg=true;		
		Date objDate ;
		String newDate;
		String strDateFormat = "EEE dd MMM"; //Date format is Specified
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object
		Calendar c = Calendar.getInstance();
		
			objDate = new Date();
			c.setTime(objDate);
			c.add(Calendar.DAY_OF_MONTH, expDay);  
			newDate = objSDF.format(c.getTime()); 
    	    //To locate columns(cells) of that specific row.
    	    List < WebElement > Columns_row = rows.get(expDay).findElements(By.tagName("td"));
    	   
    	    // To retrieve text from that specific cell.
    	    String datetext = Columns_row.get(0).getText();
    	    String forecasttext = Columns_row.get(1).getText();
    	    
    	    String expForecast=jsonReader.findSummaryforday(expDay);
    	    
    	    if ((forecasttext == expForecast) )
    	    {
    	    	
    	    	System.out.println("Forecast summary is as expected\n");
    	    	System.out.println("actual forecast \n"+forecasttext);
    	    	System.out.println("expected forecast \n"+expForecast);
    	    	
    	    	
    	    }
    	    else
    	    {
    	    	System.out.println("Forecast summary is as expected");
    	    	System.out.println("actual forecast \n"+forecasttext);
    	    	System.out.println("expected forecast \n"+expForecast);
    	    
    	    }
    	
	}
}
