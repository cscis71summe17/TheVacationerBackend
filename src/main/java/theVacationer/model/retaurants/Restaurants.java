
package theVacationer.model.retaurants;

import javax.annotation.Generated;
import javax.jws.WebParam;

import com.google.gson.annotations.SerializedName;
import org.springframework.web.client.RestTemplate;
import theVacationer.model.Model;

import java.sql.ResultSet;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Restaurants extends Model {

    @SerializedName("response")
    private Response mResponse;

    public Restaurants() {
    }

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(Response response) {
        mResponse = response;
    }

    @Override
    public ResultSet query(String query) throws Exception {
        return null;
    }
}
