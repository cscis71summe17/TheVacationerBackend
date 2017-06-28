package theVacationer.model.geodata;

import java.util.List;

/**
 * Created by Alexander Dmitryukov on 6/28/2017.
 */
public class Country {
    public String country;
    public List<String> cityList;

    public Country(String country, List<String> cityList) {
        this.country = country;
        this.cityList = cityList;
    }
}
