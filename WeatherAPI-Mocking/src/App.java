import Services.ApplicationService;
import Services.GsonService;
import Services.WeatherService;

public class App {

    public static void main(String[] args) throws Exception {
        var application = new ApplicationService(new WeatherService(), new GsonService());
       System.out.println(application.getCurrentWeather("London"));
       int id=2643743;
       System.out.println(application.getCurrentWeather(id));
        double lat=51.5085;
        double longt= -0.1257;
      System.out.println(application.getCurrentWeather(lat,longt));
    }
}