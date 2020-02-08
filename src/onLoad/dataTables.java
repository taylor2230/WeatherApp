package onLoad;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class dataTables {
    //each HashMap contains the values parsed out by createDataTable, this allows POJO
    HashMap<Integer, Integer> CityID = new HashMap<>();
    HashMap<Integer, String> CityName = new HashMap<>();
    HashMap<Integer, String> CountryName = new HashMap<>();

    private String str = "";
    public void addID(Integer cityID, int cityNum){CityID.put(cityID, cityNum);}
    public void addCityName(Integer cityID, String cityName){CityName.put(cityID, cityName);}
    public void addCountryName(Integer cityID, String countryName){CountryName.put(cityID, countryName);}

    public int getID(int tableA, int tableB){
        //allow multiple HashMap searches to confirm location IDs to send for weather data
        return 1;
    }

    public void createDataTable(JsonArray json) {
        //loops through Json array to grab each element for create a data table's of HashMaps to be used in POJO
        Gson gson = new Gson();
        JsonArray jArray = gson.fromJson(json, JsonArray.class);
        JsonObject jObject = null;
        double numCities = jArray.size();
        double cnt = 0;
        for (int i = 0; i < jArray.size(); i++) {
            double progress = ((cnt / numCities) * 100);
            jObject = (JsonObject) jArray.get(i);
            JsonElement element1 = jObject.get("id");
            addID(element1.getAsInt(), element1.getAsInt());
            JsonElement element2 = jObject.get("name");
            addCityName(element1.getAsInt(), element2.getAsString());

            JsonElement element3 = jObject.get("country");
            addCountryName(element1.getAsInt(), element3.getAsString());
            //System.out.println(element2.getAsString() + ", " + element3.getAsString());
            cnt++;
            System.out.println(progress);
        }
        if(cnt == numCities){
            System.out.println("Data loading complete.." + cnt + " records loaded");
        }
    }
}
