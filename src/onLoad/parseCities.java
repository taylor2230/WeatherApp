package onLoad;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.*;


class serializer {
    @SerializedName("id")
    @Expose
    private int cityID;
    @SerializedName("name")
    @Expose
    private String cityName;
    @SerializedName("country")
    @Expose
    private String cityCountry;
}

public class parseCities {

    public static JsonArray importData() throws FileNotFoundException {
        //this loads the data in as a JSON array to be used
        Gson gson = new Gson();
        JsonArray cityData = gson.fromJson(new FileReader("/Users/Shane1/IdeaProjects/WeatherApp/src/cities.json"), JsonArray.class);
        return cityData;
    }

    public static String findData(JsonArray file, int i) {
        // takes file and allows individual parsing to eventually search
        Gson gson = new Gson();
        serializer[] citiesData = gson.fromJson(file, serializer[].class);
        String cityToReturn = gson.toJson(citiesData[i]);
        return cityToReturn;
    }

    public static void parseReturnedResults(String json) {
        //on hold but maybe the start of the search function based on whats returned to display end results
        Gson gson = new Gson();
        JsonObject jObject = gson.fromJson(json, JsonObject.class);
        System.out.println(json);
        System.out.println(jObject.get("name").getAsString());

    }
}

