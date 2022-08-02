package test;

import org.jmock.Expectations;
import org.jmock.Mockery;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import org.junit.jupiter.api.extension.ExtendWith;

import Contracts.IJsonService;
import Contracts.IWeatherService;
import Services.ApplicationService;
import Services.GsonService;
import Services.WeatherService;
import ViewModels.ViewModel;

class WeatherServiceTest {

	// fail
	@Test
	void testgetCurrentWeatherByCityname1() {
		//arrange
		String cityname="\"London\"";
		String expected="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
	
		//act
		WeatherService instance =new WeatherService();
		String result=instance.getCurrentWeather(cityname);
	
		//assert
		assertEquals(expected,result);	
	}
	
	@Test
	void testgetCurrentWeatherByCityname2() {
		//arrange
		String cityname="";
		String expected="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
	
		//act
		WeatherService instance =new WeatherService();
		String result=instance.getCurrentWeather(cityname);
	
		//assert
		assertEquals(expected,result);	
	}
	@Test
	void testgetCurrentWeatherByCityid1() {
		//arrange
		//String cityname="\"London\"";
		String expected="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		int cityid=2643743;
		
		//act
		WeatherService instance =new WeatherService();
		String result=instance.getCurrentWeather(cityid);
	
		//assert
		assertEquals(expected,result);	
	}
	@Test
	void testgetCurrentWeatherByCityid2() {
		//arrange
		
		String expected="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		int cityid=0;
		
		//act
		WeatherService instance =new WeatherService();
		String result=instance.getCurrentWeather(cityid);
	
		//assert
		assertEquals(expected,result);	
	}
	@Test
	void testgetCurrentWeatherByCityid3() {
		//arrange
		
		String expected="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		int cityid=-1;
		
		//act
		WeatherService instance =new WeatherService();
		String result=instance.getCurrentWeather(cityid);
	
		//assert
		assertEquals(expected,result);	
	}
	@Test
	void testgetCurrentWeatherByLong1() {
		//arrange
		
		String expected="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		double lon=-0.1257;
		double lat=51.5085;
		
		//act
		WeatherService instance =new WeatherService();
		String result=instance.getCurrentWeather(lat,lon);
	
		//assert
		assertEquals(expected,result);	
	}
	// invalid longitude
	@Test
	void testgetCurrentWeatherByLong2() {
		//arrange
		
		String expected="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		double lon=0;
		double lat=51.5085;
		
		//act
		WeatherService instance =new WeatherService();
		String result=instance.getCurrentWeather(lat,lon);
	
		//assert
		assertEquals(expected,result);	
	}
	// invalid latitude
	@Test
	void testgetCurrentWeatherByLong3() {
		//arrange
		
		String expected="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		double lon=-0.1257;
		double lat=0;
		
		//act
		WeatherService instance =new WeatherService();
		String result=instance.getCurrentWeather(lat,lon);
	
		//assert
		assertEquals(expected,result);	
	}
	

	

}
