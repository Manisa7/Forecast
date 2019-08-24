package testDataTypes;

import java.util.List;


public class CityData 
{

	public City city;
	public String cod;
	public float message;
	public int cnt;
	public List< ListValues > list;
	
	public class City 
	{

		public int id;
		public String name;
		public Coord coord;
		public String country;
		public int population;
		public Sys sys;	

	}

	public class Coord 
	{

		public float lon;
		public float lat;

	}

	public class Sys 
	{

		public int population;

	}
	public class ListValues
	{

		public int dt;
		public Main main;
		public List <Weather> weather = null;
		public Clouds clouds;
		public Wind wind;
		public Sys_ sys;
		public String dt_txt;

	}
	public class Clouds
	{
		public String all;
	}
	public class Main 
	{

		public float temp;
		public float tempMin;
		public float tempMax;
		public float pressure;
		public float seaLevel;
		public float grndLevel;
		public int humidity;
		public float tempKf;

	}
	public class Weather 
	{

		public int id;
		public String main;
		public String description;
		public String icon;

	}
	public class Wind 
	{

		public float speed;
		public float deg;
	}
	public class Sys_ 
	{

		public String pod;

	}


}
