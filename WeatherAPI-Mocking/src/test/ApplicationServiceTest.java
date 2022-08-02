package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import Contracts.IJsonService;
import Contracts.IWeatherService;
import Services.ApplicationService;
import ViewModels.ViewModel;
import ViewModels.ViewModel.Clouds;
import ViewModels.ViewModel.Coord;
import ViewModels.ViewModel.Main;
import ViewModels.ViewModel.Sys;
import ViewModels.ViewModel.Weather;
import ViewModels.ViewModel.Wind;

class ApplicationServiceTest {

	private Mockery mockingContext;
	@Test
		void testgetCurrentWeatherByCityname1() {
			//arrange
		ViewModel vm=new ViewModel();
		vm.base="stations";
		vm.dt=1622663119;
		vm.cod=200;
		vm.name="london";
		vm.visibility=10000;
		vm.timezone=3600;
		vm.id=2643743;

		Coord cr=vm.new Coord();
		cr.lat=51.5085;
		cr.lon=-0.1257;
		vm.coord=cr;

		Clouds cl=vm.new Clouds();
		cl.all=96;
		vm.clouds=cl;

		Main ma=vm.new Main();
		ma.humidity=52;
		ma.pressure=1013;
		ma.sea_level=1013;
		ma.grnd_level=1010;
		ma.temp=293.76;
		ma.temp_max=295.21;
		ma.temp_min=290.36;
		vm.main=ma;

		Weather w=vm.new Weather();
		List<Weather> list=new ArrayList<>();
		w.id=804;
		w.icon="04d";
		w.main="Clouds";
		w.description="overcast clouds";

		list.add(w);
		vm.weather=list;

		Sys s=vm.new Sys();
		s.country="GB";
		s.id=1414;
		s.sunset=1622664543;
		s.sunrise=1622605698;
		s.type=1;
		vm.sys=s;

		Wind win =vm.new Wind();
		win.deg=113;
		win.gust=3.05;
		win.speed=1.31;
		vm.wind=win;
			
	   String cityname="London";
	   String output="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
	   mockingContext = new Mockery();
			
			IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
			IJsonService mockedObject2 =mockingContext.mock(IJsonService.class);
			ApplicationService instance =new ApplicationService(mockedObject,mockedObject2);
			
			mockingContext.checking(new Expectations(){
			{
				allowing(mockedObject).getCurrentWeather(cityname);
		    	will(returnValue(output));
		    	allowing(mockedObject2).fromJson(output,ViewModel.class);
		    	will(returnValue(vm));
		    	allowing(mockedObject2).toJson(vm);
		    	will(returnValue(output));    		    	
			}
			});	
			
			String result=instance.getCurrentWeather(cityname);
			//assert
			mockingContext.assertIsSatisfied();
			assertEquals(output,result);	
	}
	@Test
	void testgetCurrentWeatherByCityname2() {
		//arrange
	ViewModel vm=new ViewModel();
	vm.base="stations";
	vm.dt=1622663119;
	vm.cod=200;
	vm.name="london";
	vm.visibility=10000;
	vm.timezone=3600;
	vm.id=2643743;

	Coord cr=vm.new Coord();
	cr.lat=51.5085;
	cr.lon=-0.1257;
	vm.coord=cr;

	Clouds cl=vm.new Clouds();
	cl.all=96;
	vm.clouds=cl;

	Main ma=vm.new Main();
	ma.humidity=52;
	ma.pressure=1013;
	ma.sea_level=1013;
	ma.grnd_level=1010;
	ma.temp=293.76;
	ma.temp_max=295.21;
	ma.temp_min=290.36;
	vm.main=ma;

	Weather w=vm.new Weather();
	List<Weather> list=new ArrayList<>();
	w.id=804;
	w.icon="04d";
	w.main="Clouds";
	w.description="overcast clouds";

	list.add(w);
	vm.weather=list;

	Sys s=vm.new Sys();
	s.country="GB";
	s.id=1414;
	s.sunset=1622664543;
	s.sunrise=1622605698;
	s.type=1;
	vm.sys=s;

	Wind win =vm.new Wind();
	win.deg=113;
	win.gust=3.05;
	win.speed=1.31;
	vm.wind=win;
		
   String cityname="";
   String output="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
   mockingContext = new Mockery();
		
		IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 =mockingContext.mock(IJsonService.class);
		ApplicationService instance =new ApplicationService(mockedObject,mockedObject2);
		
		mockingContext.checking(new Expectations(){
		{
			allowing(mockedObject).getCurrentWeather(cityname);
	    	will(returnValue(output));
	    	allowing(mockedObject2).fromJson(output,ViewModel.class);
	    	will(returnValue(vm));
	    	allowing(mockedObject2).toJson(vm);
	    	will(returnValue(output));    		    	
		}
		});	
		
		String result=instance.getCurrentWeather(cityname);
		//assert
		mockingContext.assertIsSatisfied();
		assertEquals("City Name can't be null",result);	
}
	/*@Test
	void testgetCurrentWeatherByCityname2() throws Exception {
		//arrange
		String cityname="London";
		
		mockingContext = new Mockery();
		IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
		mockingContext.checking(new Expectations(){
		{
	    	oneOf(mockedObject).getCurrentWeather(null); //one of bklm get current mra w7da bs f appservice
	    	//allowing ay 3dd mn elmrat
	    	will(throwException(new IllegalArgumentException("City name can't be empty.")));
		
		}
		});
	//	ApplicationService instance =new ApplicationService(mockedObject,new GsonService());
		ApplicationService instance =new ApplicationService(new WeatherService(),new GsonService());
		//act 
		String result=instance.getCurrentWeather(null);
		
		//assert
		//mockingContext.assertIsSatisfied();
		//assertEquals(//catch bta3 app mess,result);
		
		
	}*/

	
	@Test
	void testgetCurrentWeatherByCityid1() {
		//arrange
	ViewModel vm=new ViewModel();
	vm.base="stations";
	vm.dt=1622663119;
	vm.cod=200;
	vm.name="london";
	vm.visibility=10000;
	vm.timezone=3600;
	vm.id=2643743;

	Coord cr=vm.new Coord();
	cr.lat=51.5085;
	cr.lon=-0.1257;
	vm.coord=cr;

	Clouds cl=vm.new Clouds();
	cl.all=96;
	vm.clouds=cl;

	Main ma=vm.new Main();
	ma.humidity=52;
	ma.sea_level=1013;
	ma.grnd_level=1010;
	ma.pressure=1013;
	ma.temp=293.76;
	ma.temp_max=295.21;
	ma.temp_min=290.36;
	vm.main=ma;

	Weather w=vm.new Weather();
	List<Weather> list=new ArrayList<>();
	w.id=804;
	w.icon="04d";
	w.main="Clouds";
	w.description="overcast clouds";

	list.add(w);
	vm.weather=list;

	Sys s=vm.new Sys();
	s.country="GB";
	s.id=1414;
	s.sunset=1622664543;
	s.sunrise=1622605698;
	s.type=1;
	vm.sys=s;

	Wind win =vm.new Wind();
	win.deg=113;
	win.gust=3.05;
	win.speed=1.31;
	vm.wind=win;
		
   int cityid=2643743;
   String output="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
   mockingContext = new Mockery();
		
		IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 =mockingContext.mock(IJsonService.class);
		ApplicationService instance =new ApplicationService(mockedObject,mockedObject2);
		
		mockingContext.checking(new Expectations(){
		{
			allowing(mockedObject).getCurrentWeather(cityid);
	    	will(returnValue(output));
	    	allowing(mockedObject2).fromJson(output,ViewModel.class);
	    	will(returnValue(vm));
	    	allowing(mockedObject2).toJson(vm);
	    	will(returnValue(output));    		    	
		}
		});	
		
		String result=instance.getCurrentWeather(cityid);
		//assert
		mockingContext.assertIsSatisfied();
		assertEquals(output,result);	
}
	
	@Test
	void testgetCurrentWeatherByCityid2() {
		//arrange
	ViewModel vm=new ViewModel();
	vm.base="stations";
	vm.dt=1622663119;
	vm.cod=200;
	vm.name="london";
	vm.visibility=10000;
	vm.timezone=3600;
	vm.id=2643743;

	Coord cr=vm.new Coord();
	cr.lat=51.5085;
	cr.lon=-0.1257;
	vm.coord=cr;

	Clouds cl=vm.new Clouds();
	cl.all=96;
	vm.clouds=cl;

	Main ma=vm.new Main();
	ma.humidity=52;
	ma.pressure=1013;
	ma.sea_level=1013;
	ma.grnd_level=1010;
	ma.temp=293.76;
	ma.temp_max=295.21;
	ma.temp_min=290.36;
	vm.main=ma;

	Weather w=vm.new Weather();
	List<Weather> list=new ArrayList<>();
	w.id=804;
	w.icon="04d";
	w.main="Clouds";
	w.description="overcast clouds";

	list.add(w);
	vm.weather=list;

	Sys s=vm.new Sys();
	s.country="GB";
	s.id=1414;
	s.sunset=1622664543;
	s.sunrise=1622605698;
	s.type=1;
	vm.sys=s;

	Wind win =vm.new Wind();
	win.deg=113;
	win.gust=3.05;
	win.speed=1.31;
	vm.wind=win;
		
   int cityid=0;
   String output="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
   mockingContext = new Mockery();
		
		IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 =mockingContext.mock(IJsonService.class);
		ApplicationService instance =new ApplicationService(mockedObject,mockedObject2);
		
		mockingContext.checking(new Expectations(){
		{
			allowing(mockedObject).getCurrentWeather(cityid);
	    	will(returnValue(output));
	    	allowing(mockedObject2).fromJson(output,ViewModel.class);
	    	will(returnValue(vm));
	    	allowing(mockedObject2).toJson(vm);
	    	will(returnValue(output));   
		}
		});	
		
		String result=instance.getCurrentWeather(cityid);
		//assert
		mockingContext.assertIsSatisfied();
		assertEquals("CityId is Invalid.",result);	
}
	@Test
	void testgetCurrentWeatherByCityid3() {
		//arrange
	ViewModel vm=new ViewModel();
	vm.base="stations";
	vm.dt=1622663119;
	vm.cod=200;
	vm.name="london";
	vm.visibility=10000;
	vm.timezone=3600;
	vm.id=2643743;

	Coord cr=vm.new Coord();
	cr.lat=51.5085;
	cr.lon=-0.1257;
	vm.coord=cr;

	Clouds cl=vm.new Clouds();
	cl.all=96;
	vm.clouds=cl;

	Main ma=vm.new Main();
	ma.humidity=52;
	ma.pressure=1013;
	ma.sea_level=1013;
	ma.grnd_level=1010;
	ma.temp=293.76;
	ma.temp_max=295.21;
	ma.temp_min=290.36;
	vm.main=ma;

	Weather w=vm.new Weather();
	List<Weather> list=new ArrayList<>();
	w.id=804;
	w.icon="04d";
	w.main="Clouds";
	w.description="overcast clouds";

	list.add(w);
	vm.weather=list;

	Sys s=vm.new Sys();
	s.country="GB";
	s.id=1414;
	s.sunset=1622664543;
	s.sunrise=1622605698;
	s.type=1;
	vm.sys=s;

	Wind win =vm.new Wind();
	win.deg=113;
	win.gust=3.05;
	win.speed=1.31;
	vm.wind=win;
		
   int cityid=-1;
   String output="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
   mockingContext = new Mockery();
		
		IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 =mockingContext.mock(IJsonService.class);
		ApplicationService instance =new ApplicationService(mockedObject,mockedObject2);
		
		mockingContext.checking(new Expectations(){
		{
			allowing(mockedObject).getCurrentWeather(cityid);
	    	will(returnValue(output));
	    	allowing(mockedObject2).fromJson(output,ViewModel.class);
	    	will(returnValue(vm));
	    	allowing(mockedObject2).toJson(vm);
	    	will(returnValue(output));   
		}
		});	
		
		String result=instance.getCurrentWeather(cityid);
		//assert
		mockingContext.assertIsSatisfied();
		assertEquals("CityId is Invalid.",result);	
}
	@Test
	void testgetCurrentWeatherBylon1() {
		//arrange
	ViewModel vm=new ViewModel();
	vm.base="stations";
	vm.dt=1622663119;
	vm.cod=200;
	vm.name="london";
	vm.visibility=10000;
	vm.timezone=3600;
	vm.id=2643743;

	Coord cr=vm.new Coord();
	cr.lat=51.5085;
	cr.lon=-0.1257;
	vm.coord=cr;

	Clouds cl=vm.new Clouds();
	cl.all=96;
	vm.clouds=cl;

	Main ma=vm.new Main();
	ma.humidity=52;
	ma.sea_level=1013;
	ma.grnd_level=1010;
	ma.pressure=1013;
	ma.temp=293.76;
	ma.temp_max=295.21;
	ma.temp_min=290.36;
	vm.main=ma;

	Weather w=vm.new Weather();
	List<Weather> list=new ArrayList<>();
	w.id=804;
	w.icon="04d";
	w.main="Clouds";
	w.description="overcast clouds";

	list.add(w);
	vm.weather=list;

	Sys s=vm.new Sys();
	s.country="GB";
	s.id=1414;
	s.sunset=1622664543;
	s.sunrise=1622605698;
	s.type=1;
	vm.sys=s;

	Wind win =vm.new Wind();
	win.deg=113;
	win.gust=3.05;
	win.speed=1.31;
	vm.wind=win;
		
   double lon=-0.1257;
   double lat=51.5085;
   
   
   String output="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
   mockingContext = new Mockery();
		
		IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 =mockingContext.mock(IJsonService.class);
		ApplicationService instance =new ApplicationService(mockedObject,mockedObject2);
		
		mockingContext.checking(new Expectations(){
		{
			allowing(mockedObject).getCurrentWeather(lat,lon);
	    	will(returnValue(output));
	    	allowing(mockedObject2).fromJson(output,ViewModel.class);
	    	will(returnValue(vm));
	    	allowing(mockedObject2).toJson(vm);
	    	will(returnValue(output));   
		}
		});	
		
		String result=instance.getCurrentWeather(lat,lon);
		//assert
		mockingContext.assertIsSatisfied();
		assertEquals(output,result);	
}
	
	@Test
	void testgetCurrentWeatherBylon2() {
		//arrange
	ViewModel vm=new ViewModel();
	vm.base="stations";
	vm.dt=1622663119;
	vm.cod=200;
	vm.name="london";
	vm.visibility=10000;
	vm.timezone=3600;
	vm.id=2643743;

	Coord cr=vm.new Coord();
	cr.lat=51.5085;
	cr.lon=-0.1257;
	vm.coord=cr;

	Clouds cl=vm.new Clouds();
	cl.all=96;
	vm.clouds=cl;

	Main ma=vm.new Main();
	ma.humidity=52;
	ma.pressure=1013;
	ma.sea_level=1013;
	ma.grnd_level=1010;
	ma.temp=293.76;
	ma.temp_max=295.21;
	ma.temp_min=290.36;
	vm.main=ma;

	Weather w=vm.new Weather();
	List<Weather> list=new ArrayList<>();
	w.id=804;
	w.icon="04d";
	w.main="Clouds";
	w.description="overcast clouds";

	list.add(w);
	vm.weather=list;

	Sys s=vm.new Sys();
	s.country="GB";
	s.id=1414;
	s.sunset=1622664543;
	s.sunrise=1622605698;
	s.type=1;
	vm.sys=s;

	Wind win =vm.new Wind();
	win.deg=113;
	win.gust=3.05;
	win.speed=1.31;
	vm.wind=win;
		
   double lon=-0.1257;
   double lat=0;
   
   
   String output="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
   mockingContext = new Mockery();
		
		IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 =mockingContext.mock(IJsonService.class);
		ApplicationService instance =new ApplicationService(mockedObject,mockedObject2);
		
		mockingContext.checking(new Expectations(){
		{
			allowing(mockedObject).getCurrentWeather(lat,lon);
	    	will(returnValue(output));
	    	allowing(mockedObject2).fromJson(output,ViewModel.class);
	    	will(returnValue(vm));
	    	allowing(mockedObject2).toJson(vm);
	    	will(returnValue(output));   
		}
		});	
		
		String result=instance.getCurrentWeather(lat,lon);
		//assert
		mockingContext.assertIsSatisfied();
		assertEquals("Incorrect latitude.",result);	
}
	@Test
	void testgetCurrentWeatherBylon3() {
		//arrange
	ViewModel vm=new ViewModel();
	vm.base="stations";
	vm.dt=1622663119;
	vm.cod=200;
	vm.name="london";
	vm.visibility=10000;
	vm.timezone=3600;
	vm.id=2643743;

	Coord cr=vm.new Coord();
	cr.lat=51.5085;
	cr.lon=-0.1257;
	vm.coord=cr;

	Clouds cl=vm.new Clouds();
	cl.all=96;
	vm.clouds=cl;

	Main ma=vm.new Main();
	ma.humidity=52;
	ma.pressure=1013;
	ma.sea_level=1013;
	ma.grnd_level=1010;
	ma.temp=293.76;
	ma.temp_max=295.21;
	ma.temp_min=290.36;
	vm.main=ma;

	Weather w=vm.new Weather();
	List<Weather> list=new ArrayList<>();
	w.id=804;
	w.icon="04d";
	w.main="Clouds";
	w.description="overcast clouds";

	list.add(w);
	vm.weather=list;

	Sys s=vm.new Sys();
	s.country="GB";
	s.id=1414;
	s.sunset=1622664543;
	s.sunrise=1622605698;
	s.type=1;
	vm.sys=s;

	Wind win =vm.new Wind();
	win.deg=113;
	win.gust=3.05;
	win.speed=1.31;
	vm.wind=win;
		
   double lon=0;
   double lat=51.5085;
   
   
   String output="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
   mockingContext = new Mockery();
		
		IWeatherService mockedObject =mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 =mockingContext.mock(IJsonService.class);
		ApplicationService instance =new ApplicationService(mockedObject,mockedObject2);
		
		mockingContext.checking(new Expectations(){
		{
			allowing(mockedObject).getCurrentWeather(lat,lon);
	    	will(returnValue(output));
	    	allowing(mockedObject2).fromJson(output,ViewModel.class);
	    	will(returnValue(vm));
	    	allowing(mockedObject2).toJson(vm);
	    	will(returnValue(output));   
		}
		});	
		
		String result=instance.getCurrentWeather(lat,lon);
		//assert
		mockingContext.assertIsSatisfied();
		assertEquals("Incorrect longitude.",result);	
}
	

}
