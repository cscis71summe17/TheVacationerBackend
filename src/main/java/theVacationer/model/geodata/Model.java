package theVacationer.model.geodata;

import java.sql.ResultSet;

/**
 * Created by Peter on 6/27/2017.
 */
public abstract class Model {
  public final String FILE_PATH = "src/main/resources/vacationer.sqlite";
  public abstract ResultSet query(String query) throws Exception;
}
