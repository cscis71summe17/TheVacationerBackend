package theVacationer.model.geodata;

import java.util.List;

/**
 * Created by Alexander Dmitryukov on 6/28/2017.
 */
public class Geodata {
    List<Country> geodataList;

    public Geodata(List<Country> geodataList) {
        this.geodataList = geodataList;
    }

    public List<Country> getGeodataList() {
        return geodataList;
    }

    public void setGeodataList(List<Country> geodataList) {
        this.geodataList = geodataList;
    }
}
