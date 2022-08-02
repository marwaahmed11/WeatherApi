 package Services;

import Contracts.IWeatherService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class WeatherService implements IWeatherService {
	 
	
	
   	 public String getCurrentWeather(String cityName)  {
   		 if (cityName == "")
   		 {
   			 throw new IllegalArgumentException("City name can't be empty");
   		 }
   	// TODO Auto-generated method stu 
 		String Response = " ";   
 		HttpClient client = HttpClient.newHttpClient();
 		 HttpRequest request = null;
		request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=dcfdc4ee4ee06b4619114bc0d07ee081"))
		        .header("Content-Type", "application/json")
		        .build();
 		   client.sendAsync(request, BodyHandlers.ofString())
 		        .thenApply(HttpResponse::body);
 		      //.thenAccept(System.out::println);  	
 		try
 		{
			HttpResponse<String>response = client.send(request, BodyHandlers.ofString());
			Response=response.body();   
		 }
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	return Response;
   	    }

   	
	@Override
	public String getCurrentWeather(int cityId) {
        // TODO Auto-generated method stub
		String Response = " ";     
   		HttpClient client = HttpClient.newHttpClient();
   		HttpRequest request =  HttpRequest.newBuilder()
   		.uri(URI.create("https://api.openweathermap.org/data/2.5/weather?id="+cityId+"&appid=dcfdc4ee4ee06b4619114bc0d07ee081"))
        .build(); 
   		client.sendAsync(request, BodyHandlers.ofString())
	        .thenApply(HttpResponse::body);
	      //.thenAccept(System.out::println);  	
   		try
   		{
			HttpResponse<String>response = client.send(request, BodyHandlers.ofString());
			Response=response.body();
	        
		 }
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
   		return Response;
   		
    }


   
public String getCurrentWeather(double latitude, double longitude) {
    	
        // TODO Auto-generated method stub
    	String Response = " ";     
   		HttpClient client = HttpClient.newHttpClient();
   		HttpRequest request =  HttpRequest.newBuilder()
   		.uri(URI.create("https://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=dcfdc4ee4ee06b4619114bc0d07ee081"))
        .build();      
   		client.sendAsync(request, BodyHandlers.ofString())
        .thenApply(HttpResponse::body);
      //.thenAccept(System.out::println);  	
   		try
   		{
			HttpResponse<String>response = client.send(request, BodyHandlers.ofString());
			Response=response.body();
	        
		 }
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	return Response;
   		
    	
    }

}