import com.google.gson.*;
import onLoad.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Playground {

    public static void main(String[] args) throws Exception {
        dataTables f = new dataTables();
        String website = "http://api.openweathermap.org/data/2.5/forecast?id=";
        String key = "649dc78ddc1f1fd88560838daa3e5f04";
        String city = "4309414";
        String WBS = website + city + "&APPID=" + key;
        System.out.println(WBS);
        f.createDataTable(parseCities.importData());

    }

}
