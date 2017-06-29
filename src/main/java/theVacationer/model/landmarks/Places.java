package theVacationer.model.geodata;

import theVacationer.model.landmarks.Header;
import theVacationer.model.landmarks.Landmark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 6/28/2017.
 */
public class Places extends Model{
  private final String COUNTRY_TABLE = "Country";
  private final String CITY_TABLE = "City";
  private final String LANDMARK_TABLE = "Landmarks";
  List<Landmark> landmarkList;
  List<Header> landmarkHeaderList;

  public Places (String country,String city) {
    try {
      landmarkList = new ArrayList<Landmark>();
      landmarkHeaderList = new ArrayList<Header>();
      ResultSet results = query(country,city);
      int i = 1;
      while (results.next()) {
        Landmark place = new Landmark();
        String name = results.getString(1);
        place.description = results.getString(2);
        landmarkList.add(place);
        landmarkHeaderList.add(new Header(i,name));
        i++;
      }

    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  public ResultSet query(String query) throws Exception {
    return null;
  }
  public ResultSet query(String country,String city) throws Exception {
    Connection db = DriverManager.getConnection("jdbc:sqlite:" + FILE_PATH);
    Statement stmt = db.createStatement();
    String str =
      "SELECT A.name, A.description " +
      "FROM " + LANDMARK_TABLE + " AS A, " +
                 COUNTRY_TABLE + " AS B, " + CITY_TABLE + " AS C " +
       "WHERE A.country_id = B.id AND A.city_id = C.id AND B.name = '" +
              country + "' AND C.name = '"+ city+"';";
    return stmt.executeQuery(str);
  }
  public List<Landmark> getLandmarkList() {
    return landmarkList;
  }
  public List<Header> getLandmarkHeaderList() {return landmarkHeaderList;};
}
