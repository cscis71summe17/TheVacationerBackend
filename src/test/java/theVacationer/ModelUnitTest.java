package theVacationer;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;
import theVacationer.model.Model;
import theVacationer.model.geodata.Cities;
import theVacationer.model.geodata.Countries;
import theVacationer.model.geodata.Geodata;
import theVacationer.model.landmarks.Places;
import theVacationer.model.safetyInfo.SafetyInfo;
import theVacationer.model.safetyInfo.SafetyNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static junit.framework.TestCase.*;

/**
 * Created by Alexander Dmitryukov on 7/2/2017.
 */
public class ModelUnitTest {

    String stringSample = "sample";
    String stringSample2 = "sample";
    int intSample = 1;

    @Test
    public void countryTest(){
        Countries ct = new Countries();
        assertNotNull(ct);
        assertTrue(ct.getCountryList().size()>0);
    }

    @Test
    public void cityTest_empty(){
        stringSample ="";
        Cities ct = new Cities(stringSample);
        assertNotNull(ct);
        assertTrue(ct.getCityList().size()==0);
    }

    @Test
    public void cityTest_present(){
        stringSample ="France";
        Cities ct = new Cities(stringSample);
        assertNotNull(ct);
        assertTrue(ct.getCityList().size()>0);
    }


    //Emergency numbers API tests
    @Test
    public void safetyinfoTest_notNull() {
        stringSample="";
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertNotNull(sf);
    }

    @Test
    public void safetyinfoTest_empty() {
        stringSample="";
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertNotNull(sf);
        assertTrue(sf.getNumbers().size()==0);
    }

    @Test
    public void safetyinfoTest_present(){
        stringSample="Germany";
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertTrue(sf.getNumbers().size()>0);
    }

    @Test
    public void safetyinfoTest_emergencyServicesPresentNotNullNotEmpty(){
        stringSample="Italy";
        intSample=0;
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertTrue(sf.getNumbers().get(intSample).getNumber()!=null
        & !sf.getNumbers().get(intSample).getNumber().isEmpty());
        assertTrue(Objects.equals(sf.getNumbers().get(intSample).getDescription().toLowerCase(), "all services"));
    }

    @Test
    public void safetyinfoTest_policePresentNotNullNotEmpty(){
        stringSample="Italy";
        intSample=1;
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertTrue(sf.getNumbers().get(intSample).getNumber()!=null
                & !sf.getNumbers().get(intSample).getNumber().isEmpty());
        assertTrue(Objects.equals(sf.getNumbers().get(intSample).getDescription().toLowerCase(), "police"));
    }

    @Test
    public void safetyinfoTest_medicalHelpPresentNotNullNotEmpty(){
        stringSample="Italy";
        intSample=2;
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertTrue(sf.getNumbers().get(intSample).getNumber()!=null
                & !sf.getNumbers().get(intSample).getNumber().isEmpty());
        assertTrue(Objects.equals(sf.getNumbers().get(intSample).getDescription().toLowerCase(), "medical help"));
    }

    //Landmarks
    @Test
    public void landmarkTest_notNull() {
        stringSample="";
        Places sf = new Places(stringSample, stringSample2 );
        assertNotNull(sf);
    }

    @Test
    public void landmarkTest_empty() {
        stringSample="";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().size()==0);
    }

    @Test
    public void landmarkTest_presentBody(){
        stringSample="Germany";
        stringSample2="Munich";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().size()>0);
    }

    @Test
    public void landmarkTest_presentHeader(){
        stringSample="Germany";
        stringSample2="Munich";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkHeaderList().size()>0);
    }

    @Test
    public void landmarkTest_headerPresentNotNullNotEmpty(){
        stringSample="Italy";
        stringSample2="Rome";
        intSample=0;
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue((sf.getLandmarkHeaderList().get(intSample).title != null)
                & !sf.getLandmarkHeaderList().get(intSample).title.isEmpty());
    }

    @Test
    public void landmarkTest_bodyPresentNotNullNotEmpty(){
        stringSample="Italy";
        stringSample2="Rome";
        intSample=0;
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue((sf.getLandmarkList().get(intSample).description != null)
                & !sf.getLandmarkList().get(intSample).description.isEmpty());
    }

    //Restaurant
    @Test
    public void restaurantTest_notNull() {
        stringSample="";
        Places sf = new Places(stringSample, stringSample2 );
        assertNotNull(sf);
    }

    @Test
    public void restaurantTest_empty() {
        stringSample="";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().size()==0);
    }

    @Test
    public void restaurantTest_presentBody(){
        stringSample="Germany";
        stringSample2="Munich";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().size()>0);
    }

    @Test
    public void restaurantTest_presentHeader(){
        stringSample="Germany";
        stringSample2="Munich";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkHeaderList().size()>0);
    }

    @Test
    public void restaurantTest_headerPresentNotNullNotEmpty(){
        stringSample="Italy";
        stringSample2="Rome";
        intSample=0;
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkHeaderList().get(intSample).title !=null
                & !sf.getLandmarkHeaderList().get(intSample).title.isEmpty());
    }

    @Test
    public void restaurantTest_bodyPresentNotNullNotEmpty(){
        stringSample="Italy";
        stringSample2="Rome";
        intSample=0;
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().get(intSample).description !=null
                & !sf.getLandmarkList().get(intSample).description.isEmpty());
    }
}
