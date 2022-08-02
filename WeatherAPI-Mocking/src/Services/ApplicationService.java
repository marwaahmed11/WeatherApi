package Services;

import Contracts.IJsonService;
import Contracts.IWeatherService;
import ViewModels.ViewModel;

public class ApplicationService {
    private IWeatherService weatherService;
    private IJsonService jsonService;

    public ApplicationService(IWeatherService wService, IJsonService jService) {
        weatherService = wService;
        jsonService = jService;
    }

    public String getCurrentWeather(String cityName)  {
    	
    	if (cityName=="")
    	{
    		String s="City Name can't be null";
    		return s;
    	}
    	else
    	{
            	String s = weatherService.getCurrentWeather(cityName);
        		ViewModel v=new ViewModel();
    	    	v=jsonService.fromJson(s, ViewModel.class);
    	    	String m=jsonService.toJson(v);
    	    	return m;
    	}
         
   }
    public String getCurrentWeather(int  id) {
    	
    	if (id <= 0)
    	{
    		String s="CityId is Invalid.";
    		return s;
    	}
    	else
    	{
	    	String s=weatherService.getCurrentWeather(id);
	    	ViewModel v=new ViewModel();
	    	v=jsonService.fromJson(s, ViewModel.class);
	    	String m=jsonService.toJson(v);
	    	return m;
    	}
    	
    }
    public String getCurrentWeather(double lat,double longt) {
 	   if (lat==0)
 	   {
 		  String s="Incorrect latitude.";
  		  return s;
 	   }
 	   else if (longt==0)
 	   {
 		  String s="Incorrect longitude.";
  		  return s;
 	   }
 	   else
 	   {
    	String s=weatherService.getCurrentWeather(lat,longt);
    	ViewModel v=new ViewModel();
    	v=jsonService.fromJson(s, ViewModel.class);
    	String m=jsonService.toJson(v);
    	return m;
 	   }
    }
}