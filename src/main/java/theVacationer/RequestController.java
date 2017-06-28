package theVacationer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import theVacationer.model.geodata.Countries;
import theVacationer.model.geodata.Country;
import theVacationer.model.geodata.Geodata;
import theVacationer.model.landmarks.Landmarks;

@RestController
public class RequestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/geodata")
    public Geodata getGeoData() {

        //Mocking Data add DB query
        //TODO Pete, please query from DB
        //To test RUN and in web browser go to http://localhost:8080/geodata
        Countries c = new Countries("");
        Iterator itr = c.getCountryList().iterator();
        List<Country> countryList = new ArrayList<Country>();

        while(itr.hasNext()) {
            String country = (String)itr.next();
            List<String > cityList = Arrays.asList("NYC", "Boston", "Miami");
            Country mockCountry = new Country(country,cityList);
            countryList.add(mockCountry);

        }


        Geodata geoDataList = new Geodata(countryList);
        return geoDataList;
    }

    @RequestMapping("/landmarks")
    public Country getLandmarks(@RequestParam(value="city") String city,
                                  @RequestParam(value="country")String country) throws Exception {

        //TODO Query Landmark from DB with country/city and return Landmarks instead of Country, Landmark class is empty
        //To test RUN and in web browser go to http://localhost:8080/landmarks?city=boston&country=USA
        return new Country(country,Arrays.asList(city));
    }
}
