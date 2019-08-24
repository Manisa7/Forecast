$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/features/ForecastFeature.feature");
formatter.feature({
  "line": 1,
  "name": "Verification of daily and three hourly forecast of given city",
  "description": "Description: Parameter \"day\" refers 0-\u003ecurrent day 1-tomorrow 2-\u003ethe day after tomorrow",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Checks 5 day weather forecast of given city",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@weather"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters \"\u003ccityname\u003e\" and clicks search button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User gets relevent city with country code",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User clicks required city",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User gets five day weather forecast of given city",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;",
  "rows": [
    {
      "cells": [
        "cityname"
      ],
      "line": 13,
      "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;1"
    },
    {
      "cells": [
        "Perth"
      ],
      "line": 14,
      "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Checks 5 day weather forecast of given city",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@weather"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters \"Perth\" and clicks search button",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User gets relevent city with country code",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User clicks required city",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User gets five day weather forecast of given city",
  "keyword": "Then "
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.user_is_on_home_page()"
});
formatter.result({
  "duration": 33934579155,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Perth",
      "offset": 13
    }
  ],
  "location": "ForecastFeatureStepDefinition.user_enters_cityName_and_clicks_search_button(String)"
});
formatter.result({
  "duration": 15454770052,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.verifyCitywithCountryCode()"
});
formatter.result({
  "duration": 834926258,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.selectCitybyCountry()"
});
formatter.result({
  "duration": 23920048442,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.user_gets_day_weather_forecast_of_given_city()"
});
formatter.result({
  "duration": 3211397136,
  "status": "passed"
});
formatter.after({
  "duration": 411504696,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 17,
  "name": "Checks 5 day weather forecast of given city",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 16,
      "name": "@Forecast"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "User enters \"\u003ccityname\u003e\" and clicks search button",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "User gets relevent city with country code",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "User clicks required city",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "User clicks hourly status",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "User gets hourly forecast for \"\u003cday\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "User clicks hourly status",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Hourly forecast is hidden",
  "keyword": "Then "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;",
  "rows": [
    {
      "cells": [
        "cityname",
        "day"
      ],
      "line": 28,
      "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;1"
    },
    {
      "cells": [
        "Perth",
        "0"
      ],
      "line": 29,
      "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 29,
  "name": "Checks 5 day weather forecast of given city",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 16,
      "name": "@Forecast"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "User enters \"Perth\" and clicks search button",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "User gets relevent city with country code",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "User clicks required city",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "User clicks hourly status",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "User gets hourly forecast for \"0\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "User clicks hourly status",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Hourly forecast is hidden",
  "keyword": "Then "
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.user_is_on_home_page()"
});
formatter.result({
  "duration": 24943497101,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Perth",
      "offset": 13
    }
  ],
  "location": "ForecastFeatureStepDefinition.user_enters_cityName_and_clicks_search_button(String)"
});
formatter.result({
  "duration": 5430772925,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.verifyCitywithCountryCode()"
});
formatter.result({
  "duration": 524666906,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.selectCitybyCountry()"
});
formatter.result({
  "duration": 22056011494,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.user_Clicks_Hourly()"
});
formatter.result({
  "duration": 308537589,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 31
    }
  ],
  "location": "ForecastFeatureStepDefinition.verify_Hourly(String)"
});
formatter.result({
  "duration": 2087502849,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.user_Clicks_Hourly()"
});
formatter.result({
  "duration": 80040232,
  "error_message": "org.openqa.selenium.WebDriverException: unknown error: Element \u003ca href\u003d\"/\" id\u003d\"tab-hourly\" class\u003d\"widget-tabs__link--active\"\u003e...\u003c/a\u003e is not clickable at point (627, 19). Other element would receive the click: \u003ca href\u003d\"/city\" class\u003d\"nav__link bg-hover-color\" onclick\u003d\"_gaq.push([\u0027_trackEvent\u0027, \u0027Navbar\u0027, \u0027Main\u0027, \u0027weather\u0027]);\"\u003e...\u003c/a\u003e\n  (Session info: chrome\u003d76.0.3809.100)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 61 milliseconds\nBuild info: version: \u0027unknown\u0027, revision: \u0027unknown\u0027, time: \u0027unknown\u0027\nSystem info: host: \u0027DESKTOP-25FQ7UP\u0027, ip: \u0027192.168.42.133\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_191\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:51557}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5), userDataDir\u003dC:\\Users\\Admin\\AppData\\Local\\Temp\\scoped_dir12704_27686}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d76.0.3809.100, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 27c4e9c986a08751a2325f19a904566c\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:671)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:272)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:82)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy15.click(Unknown Source)\r\n\tat pageObjects.CurrentWeather.tab_Hourly_Click(CurrentWeather.java:105)\r\n\tat step_definitions.ForecastFeatureStepDefinition.user_Clicks_Hourly(ForecastFeatureStepDefinition.java:175)\r\n\tat ✽.When User clicks hourly status(src/features/ForecastFeature.feature:24)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.verify_HourlyForecast_hidden()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 2109841843,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 32,
  "name": "Checks 5 day weather forecast of given city",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 31,
      "name": "@Round"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "User enters \"\u003ccityname\u003e\" and clicks search button",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "User gets relevent city with country code",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "User clicks required city",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "User gets five day weather forecast of given city",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "Forecast for a \"\u003cday\u003e\"contains most dominant condition most dominant wind speed rainfall and minimum maximum temparature with rounded value",
  "keyword": "Then "
});
formatter.examples({
  "line": 40,
  "name": "",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;",
  "rows": [
    {
      "cells": [
        "cityname",
        "day"
      ],
      "line": 41,
      "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;1"
    },
    {
      "cells": [
        "Perth",
        "0"
      ],
      "line": 42,
      "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 42,
  "name": "Checks 5 day weather forecast of given city",
  "description": "",
  "id": "verification-of-daily-and-three-hourly-forecast-of-given-city;checks-5-day-weather-forecast-of-given-city;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 31,
      "name": "@Round"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "User enters \"Perth\" and clicks search button",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "User gets relevent city with country code",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "User clicks required city",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "User gets five day weather forecast of given city",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "Forecast for a \"0\"contains most dominant condition most dominant wind speed rainfall and minimum maximum temparature with rounded value",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.user_is_on_home_page()"
});
formatter.result({
  "duration": 16081437265,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Perth",
      "offset": 13
    }
  ],
  "location": "ForecastFeatureStepDefinition.user_enters_cityName_and_clicks_search_button(String)"
});
formatter.result({
  "duration": 5573280649,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.verifyCitywithCountryCode()"
});
formatter.result({
  "duration": 864084980,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.selectCitybyCountry()"
});
formatter.result({
  "duration": 22533703905,
  "status": "passed"
});
formatter.match({
  "location": "ForecastFeatureStepDefinition.user_gets_day_weather_forecast_of_given_city()"
});
formatter.result({
  "duration": 2244283060,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 16
    }
  ],
  "location": "ForecastFeatureStepDefinition.verify_DailyForecast(String)"
});
formatter.result({
  "duration": 1402995638,
  "status": "passed"
});
formatter.after({
  "duration": 640162980,
  "status": "passed"
});
});