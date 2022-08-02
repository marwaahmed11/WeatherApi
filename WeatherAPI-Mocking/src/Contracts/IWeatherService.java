package Contracts;

public interface IWeatherService {
    public String getCurrentWeather(String cityName);

    public String getCurrentWeather(int cityId);

    public String getCurrentWeather(double latitude, double longitude);
}
