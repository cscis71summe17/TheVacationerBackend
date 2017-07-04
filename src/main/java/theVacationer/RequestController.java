package theVacationer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import theVacationer.model.Model;
import theVacationer.model.geodata.*;
import theVacationer.model.landmarks.Landmarks;
import theVacationer.model.landmarks.Places;
import theVacationer.model.retaurants.Response;
import theVacationer.model.retaurants.Restaurants;
import theVacationer.model.retaurants.Venue;
import theVacationer.model.safetyInfo.SafetyInfo;
import theVacationer.model.safetyInfo.SafetyNumber;

import static theVacationer.model.Model.*;

@RestController
public class RequestController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/geodata")
    public Geodata getGeoData() {
        //Mocking Data add DB query
        //TODO Pete, please query from DB
        //To test RUN and in web browser go to http://localhost:8080/geodata
        Countries c = new Countries();
        Iterator itr = c.getCountryList().iterator();
        List<Country> countryList = new ArrayList<Country>();

        Connection con  = null;
        try {
            con = Model.getConnection();
            while(itr.hasNext()) {
                String country = (String)itr.next();
                Cities city = new Cities(country, con.createStatement());
                List<String > cityList = city.getCityList();
                Country mockCountry = new Country(country,cityList);
                countryList.add(mockCountry);
            }
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Geodata geoDataList = new Geodata(countryList);
        return geoDataList;
    }

    @RequestMapping("/landmarks")
    public Landmarks getLandmarks(@RequestParam(value="city") String city,
                                  @RequestParam(value="country")String country) throws Exception {
        //TODO Query Landmark from DB with country/city and return Landmarks instead of Country, Landmark class is empty
        //To test RUN and in web browser go to http://localhost:8080/landmarks?city=boston&country=USA
      Places pl = new Places(country,city);
      return new Landmarks(pl.getLandmarkList(),pl.getLandmarkHeaderList());
    }

    @RequestMapping("/safetyinfo")
    public List<SafetyNumber> getSafetyinfo(@RequestParam(value="country")String country) throws Exception {
        return new SafetyInfo(country).getNumbers();
    }

    @RequestMapping("/reataurants")
    public List<Venue> getRestaurants(@RequestParam(value="city") String city,
                                   @RequestParam(value="country")String country) throws Exception {
        RestTemplate response = new RestTemplate();
        Restaurants restaurants = new Restaurants();
        restaurants = response.getForObject("https://api.foursquare.com/v2/venues/search?query=restaurant&limit=5&v=20170701&client_id=ZWDQ4TMCCPQD4EGPFXUU0B1S0A1ESD5ATWDAGSIQQ0MHIYQ5&client_secret=VTCW04XIPQYL3MWMNSLX3ZIIFGZXIY5IGOXGK35PJGXON1M1&near="+city+","+country,
                Restaurants.class);
        System.out.println(response.toString());
        return restaurants.getResponse().getVenues();
    }

    @RequestMapping("/gratuities")
    public List<Integer> getGratuities(@RequestParam(value="country")String country) throws Exception {
        return new ArrayList<>();
    }
}

