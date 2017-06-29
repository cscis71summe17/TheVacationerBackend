package theVacationer.model.geodata;

import theVacationer.model.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Created by Peter on 6/27/2017.
 */
public class Countries extends Model {
  private final String COUNTRY_TABLE = "Country";
  private final String CITY_TABLE = "City";
  List<String> countryList;
  public Countries () {
    try {
      countryList = new ArrayList<String>();
      ResultSet results = query(null);
      while (results.next()) {
        countryList.add(results.getString(2));
      }

    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  public ResultSet query(String query) throws Exception {
    Connection db = DriverManager.getConnection("jdbc:sqlite:" + FILE_PATH);
    Statement stmt = db.createStatement();
    return stmt.executeQuery("SELECT * FROM " + COUNTRY_TABLE + ";");
  }
  public List<String> getCountryList() {
    return countryList;
  }
}
