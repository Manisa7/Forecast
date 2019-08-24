package dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader 
{
	private Properties properties;
	private final String propertyFilePath= "ConfigData//ProjectConfiguration.properties";
	 
	public ConfigFileReader()
	{
		BufferedReader reader;
		try 
		{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try 
			{
				properties.load(reader);
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		} 
	 }
	public String getScreenShotsPath()
	 {
		 String screenShotPath = properties.getProperty("screenShot");
		 if(screenShotPath!= null) 
			 return screenShotPath;
		 else 
			 throw new RuntimeException("screenShotPath not specified in the Configuration.properties file."); 
	 }
	 public String getDriverPath()
	 {
		 String driverPath = properties.getProperty("chromeDriverPath");
		 if(driverPath!= null) 
			 return driverPath;
		 else 
			 throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
	 }
	 
	 public String getBrowser() 
	 { 
		 String browser = properties.getProperty("browser");
		 if(browser != null) 
			 return browser;
		 else 
			 throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
	 }
	 
	 public String getApplicationUrl() 
	 {
	 String url = properties.getProperty("URL");
	 if(url != null) 
		 return url;
	 else 
		 throw new RuntimeException("url not specified in the Configuration.properties file.");
	 }
	 public String getTestDataResourcePath()
	 {
		 String testDataResourcePath = properties.getProperty("testDataResourcePath");
		 if(testDataResourcePath!= null) 
			 return testDataResourcePath;
		 else 
			 throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
		}
	 public String getTestDataResourcePathForCity(String cname)
	 {
		 cname=cname.toLowerCase();
		 String testDataResourcePath = properties.getProperty(cname);
		 if(testDataResourcePath!= null) 
			 return testDataResourcePath;
		 else 
			 throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
		}
}
