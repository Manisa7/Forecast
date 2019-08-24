"WeatherForecastTest" is an automation test project to test AUT "https://openweathermap.org/city/2640358"

Folder Structure :
-------------------------------------
Forecast
	->src
		->Runner package
			->WeatherForecastTestRunner.java- junit test runner which maintains the run attributes such as reports tags
		->dataProvider package
			->ConfigFileReader.java -it is a reader class for ProjectConfiguration.properties file
			->JsonDataReader.java - it is a reader class for json files
		->ForecastFeatureFiles
			->ForecastFeature.feature - It is a feature file which has all the scenarios in gherkin language
		->ForecastStepDefinitions
			->ForecastFeatureStepDefinition.java - Step definition file for feature file
			->ForecastHoos.java - Cucumber hoos for sept definition file
		->pageManager
			->PageObjectManager.jav - to maintain the Page object model with code effieciency
		->pageObjects
			->CurrentWeather.java - POM model page objects
			->Homepage.java - POM model page objects
		->testDataResources - contains all test data resources
			->edinbugh.json
			->aberdeen.json
			->glasgow.json
			->perth.json
			->stirling.json
		->testDataTypes - contains Java POJO classes to read Json data
			->CityData.java
	->Maven Dependencies
		-contains all dependencies to implement Selenium Java Junit Cucumber Gherkin
	->ConfigData
		->ProjectConfiguration.properties - contain all global settings data
	->ForeCast Run Reports - contains the html report of last run	
	->pom.xls - contains all dependencies
	
	
To Setup the Global data : (URL, Browser type , Browser driver path , Json data mapping)
-------------------------------------	
	-> Open ProjectConfiguration.properties
	-> Modifiy the global values as per requirement
	
To setup the Test Data : 
-------------------------------------
	-> Open Test Data resources as per requirement and modify the values
	-> Modify / update the test data in feature file as well
	
To run the test : 
-------------------------------------
	-> Open WeatherForecast runner class 
	-> Modify the options if required such as tags, format
	-> Run as Junit test