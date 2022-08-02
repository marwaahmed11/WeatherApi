package Services;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;

import Contracts.IJsonService;

public class GsonService implements IJsonService {
    private static Gson gson = new Gson();

   
    @Override
    public <T> T fromJson(String jsonString, Class<T> classOfT) {
        // TODO Auto-generated method stub
    	T  p= gson.fromJson(jsonString, classOfT);
        return p;  // java object
    }

    @Override
    public String toJson(Object object) {
        // TODO Auto-generated method stub
    	String json = gson.toJson(object);
        return json;
    }

}