package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import dataProvider.ConfigFileReader;
//import managers.FileReaderManager;
import testDataTypes.CityData;

public class JsonDataReader 
{
	
	ConfigFileReader configFileReader= new ConfigFileReader();
	private String cityFilePath;
	//private final String cityFilePath = configFileReader.getTestDataResourcePath() + "/Cities.json";
	private List<CityData> cityList;
	CityData cities;
	Set < String > dateTime=new HashSet< String>();
	Set < String > date=new HashSet< String>();
	
	public JsonDataReader(String cname)
	{
		cityFilePath=configFileReader.getTestDataResourcePathForCity(cname);
		
		cityList = getCustomerData();
	}
	
	private List<CityData> getCustomerData() 
	{
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try 
		{
			bufferReader = new BufferedReader(new FileReader(cityFilePath));
			cities = gson.fromJson(bufferReader, CityData.class);
			return Arrays.asList(cities);
		}
		catch(FileNotFoundException e) 
		{
			throw new RuntimeException("Json file not found at path : " + cityFilePath);
		}
		finally 
		{
			try 
			{ 
				if(bufferReader != null) bufferReader.close();
			}
			catch (IOException ignore) {}
		}
	}
	
	public String getCityName()
	{
		return cities.city.name;
	}
	public String getCountry()
	{
		return cities.city.country;
	}
	
	public Set findDatesfromJson()
	{		
		for(int i=0;i<cities.list.size();i++)
		{
			String curDate=cities.list.get(i).dt_txt;
			curDate=curDate.substring(0, 10);			
			date.add(curDate.substring(0, 9));			
		}				
		return date;
	}
	
	public Set findDatesHourlyfromJson()
	{		
		for(int i=0;i<cities.list.size();i++)
		{
			String curDate=cities.list.get(i).dt_txt;					
			dateTime.add(curDate);			
		}				
		return dateTime;
	}
	
	public HashMap<String,String> findHourlyforday(int day)
	{
		Date objDate = new Date();	
		String JsonDateFormat = "yyyy-MM-dd";
		String appDateFormat = "EEE MMM dd";
		String hourData="";
		HashMap<String, String> ExData = new HashMap<String, String>(); 
		
		SimpleDateFormat objSDF = new SimpleDateFormat(JsonDateFormat);
		SimpleDateFormat objSDF2 = new SimpleDateFormat(appDateFormat);
		
		Calendar c = Calendar.getInstance();
		c.setTime(objDate);		
		c.add(Calendar.DAY_OF_MONTH, 1);  
		String jsonDate = objSDF.format(c.getTime());
		String appDate = objSDF2.format(c.getTime());	
		
		String curDateTime,curDate;
		int pos=0;
		for(int i=0;i<cities.list.size();i++)
		{
			curDateTime=cities.list.get(i).dt_txt;
			
			curDate=curDateTime.substring(0, 10);			
				
			if  (jsonDate.contains(curDate)) 
			{
				
				String temp1=curDateTime.substring(11, 16);
				String temp2=cities.list.get(i).main.temp + " °C" +
								"   "+ cities.list.get(i).weather.get(0).main + "\r\n" +
								cities.list.get(i).wind.speed + ", m/s" + 
								"  "+"clouds: "+ cities.list.get(i).clouds.all + "%" +
								" " + cities.list.get(i).main.pressure + "hpa";
			
				ExData.put(temp1, temp2);
				/*hourData=hourData+"$"+ cities.list.get(i).main.temp + " °C";
				hourData=hourData+"$"+ cities.list.get(i).weather.get(0).main;
				hourData=hourData+"$"+ cities.list.get(i).wind.speed + ", m/s";
				hourData=hourData+"$"+"clouds: "+ cities.list.get(i).clouds.all + "%";
				hourData=hourData+"$"+ cities.list.get(i).main.pressure + "hpa";*/
			}	
			
		}
		return ExData;
		
	}
	
	public String findSummaryforday(int expDay)
	{
		Date objDate = new Date();	
		String JsonDateFormat = "yyyy-MM-dd";
		String appDateFormat = "EEE MMM dd";
		String hourData="";
		
		
		SimpleDateFormat objSDF = new SimpleDateFormat(JsonDateFormat);
		SimpleDateFormat objSDF2 = new SimpleDateFormat(appDateFormat);
		
		Calendar c = Calendar.getInstance();
		c.setTime(objDate);		
		c.add(Calendar.DAY_OF_MONTH, 1);  
		String jsonDate = objSDF.format(c.getTime());
		String appDate = objSDF2.format(c.getTime());	
		
		String curDateTime,curDate;
		int pos=0;
		String temp2="";
		float temp = 0,tempmin = 0,tempmax = 0;
		for(int i=0;i<cities.list.size();i++)
		{
			curDateTime=cities.list.get(i).dt_txt;
			
			curDate=curDateTime.substring(0, 10);			
				
			if  (jsonDate.contains(curDate)) 
			{
				
				//String temp1=curDateTime.substring(11, 16);
				temp=temp + cities.list.get(i).main.temp;
				tempmin=tempmin + +cities.list.get(i).main.tempMin;
				tempmax=tempmax + +cities.list.get(i).main.tempMax;
				temp2="   "+ cities.list.get(i).weather.get(0).main + "\r\n" +
								cities.list.get(i).wind.speed + ", m/s" + 
								"  "+"clouds: "+ cities.list.get(i).clouds.all + "%" +
								" " + cities.list.get(i).main.pressure + "hpa";
			
				
				
			}	
			
		}
		float avgtemp=temp/7;
		float avgtempmin=tempmin/7;
		float avgtempmax=tempmax/7;
		temp2=avgtemp+ " °C" +avgtempmax+" °C"+avgtempmin+" °C"+temp2;
		return temp2;
	}
}
