package theVacationer.model;

import java.sql.ResultSet;

/**
 * Created by Peter on 6/27/2017.
 */
public abstract class Model {
  public final String COUNTRY_TABLE = "Country";
  public final String SAFETYINFO_TABLE = "SafetyInfo";
  public final String CITY_TABLE = "City";
  public final String FILE_PATH = "src/main/resources/vacationer.sqlite";
  public abstract ResultSet query(String query) throws Exception;
}
