package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Services.GsonService;
import Services.WeatherService;
import ViewModels.ViewModel;
import ViewModels.ViewModel.Clouds;
import ViewModels.ViewModel.Coord;
import ViewModels.ViewModel.Main;
import ViewModels.ViewModel.Sys;
import ViewModels.ViewModel.Weather;
import ViewModels.ViewModel.Wind;


public class GsonServiceTest {
	
	//1)(non-empty, valid)
	@Test
	void testfromJson1() {
		//arrange
		String jsonstring="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
			
		//act
		ViewModel v=new ViewModel();
		v.name="London";
		
		GsonService instance =new GsonService();
		String result=instance.fromJson(jsonstring,ViewModel.class).name;	
		
		//assert
	    assertEquals(v.name,result);
		
	}
	//2) (non-empty, invalid)
	@Test
	void testfromJson2() {
		//arrange
		String jsonstring="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
			
		//act
		ViewModel v=new ViewModel();
		v.name="London";
		
		GsonService instance =new GsonService();
		WeatherService result=instance.fromJson(jsonstring,WeatherService.class);	
		
		//assert
	    assertEquals(v.name,result);
		
	}
	
	//3) //(empty, valid)
	@Test
	void testfromJson3() {
		//arrange
		String jsonstring="";
			
		//act
		ViewModel v=new ViewModel();
		v.name="London";
		
		GsonService instance =new GsonService();
		String result=instance.fromJson(jsonstring,ViewModel.class).name;	
		
		//assert
	    assertEquals(v.name,result);
		
	}

		//1) (valid)
	    @Test
		void testtoJson1() {
	    	ViewModel vm=new ViewModel();
	    	vm.base="stations";
	    	vm.dt=1622663119;
	    	vm.cod=200;
	    	vm.name="London";
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
	    	ma.feels_like=293.23;
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
	            
	       String jsonString ="{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":293.76,\"feels_like\":293.23,\"temp_min\":290.36,\"temp_max\":295.21,\"pressure\":1013,\"humidity\":52,\"sea_level\":1013,\"grnd_level\":1010},\"visibility\":10000,\"wind\":{\"speed\":1.31,\"deg\":113,\"gust\":3.05},\"clouds\":{\"all\":96},\"dt\":1622663119,\"sys\":{\"type\":1,\"id\":1414,\"country\":\"GB\",\"sunrise\":1622605698,\"sunset\":1622664543},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
	      
	
			//act
			GsonService instance =new GsonService();
			String result=instance.toJson(vm);
			
			//assert
		    assertEquals(jsonString,result);
		}
	    
	   // 2) invalid
		@Test
		void testtoJson2() {
			//arrange
	    	ViewModel vm=new ViewModel();
			vm=null;
			
			String jsonString=null;
			//act
			GsonService instance =new GsonService();
			String result=instance.toJson(vm);
			
			//assert
		    assertEquals("null",result);	
		}
}
