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
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

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
        assertThat(ct.getCountryList().size(), not(equalTo(0)));
    }
//
//    @Test
//    public void cityTestIsEmpty(){
//        stringSample ="";
//        Cities ct = new Cities(stringSample);
//        assertNotNull(ct);
//        assertEquals(0,ct.getCityList().size());
//    }
//
//    @Test
//    public void cityTestIsPresent(){
//        stringSample ="France";
//        Cities ct = new Cities(stringSample);
//        assertNotNull(ct);
//        assertThat(ct.getCityList().size(), not(equalTo(0)));
//    }
//
//    @Test
//    public void cityTestFranceCapitalPresent(){
//        stringSample ="France";
//        Cities ct = new Cities(stringSample);
//        assertNotNull(ct);
//        assertTrue(ct.getCityList().contains("Paris"));
//    }
//
//    @Test
//    public void cityTestItalyCapitalPresent(){
//        stringSample ="Italy";
//        Cities ct = new Cities(stringSample);
//        assertNotNull(ct);
//        assertTrue(ct.getCityList().contains("Rome"));
//    }
//
//    @Test
//    public void cityTestGermanyCapitalPresent(){
//        stringSample ="Germany";
//        Cities ct = new Cities(stringSample);
//        assertNotNull(ct);
//        assertTrue(ct.getCityList().contains("Munich"));
//    }
//
//    @Test
//    public void cityTestSpainCapitalPresent(){
//        stringSample ="Spain";
//        Cities ct = new Cities(stringSample);
//        assertNotNull(ct);
//        assertTrue(ct.getCityList().contains("Madrid"));
//    }
//
//    @Test
//    public void cityTestUkCapitalPresent(){
//        stringSample ="United Kingdom";
//        Cities ct = new Cities(stringSample);
//        assertNotNull(ct);
//        assertTrue(ct.getCityList().contains("London"));
//    }

    //Emergency numbers API tests
    @Test
    public void safetyinfoTestNotNull() {
        stringSample="";
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertNotNull(sf);
    }

    @Test
    public void safetyinfoTestIsEmpty() {
        stringSample="";
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertNotNull(sf);
        assertEquals(0,sf.getNumbers().size());
    }

    @Test
    public void safetyinfoTestIsPresent(){
        stringSample="Germany";
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertThat(sf.getNumbers().size(), not(equalTo(0)));
    }

    @Test
    public void safetyinfoTestEmergencyServicesPresentNotNullNotEmpty(){
        stringSample="Italy";
        intSample=0;
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertTrue(sf.getNumbers().get(intSample).getNumber()!=null
        & !sf.getNumbers().get(intSample).getNumber().isEmpty());
        assertTrue(Objects.equals(sf.getNumbers().get(intSample).getDescription().toLowerCase(), "all services"));
    }

    @Test
    public void safetyinfoTestPolicePresentNotNullNotEmpty(){
        stringSample="Italy";
        intSample=1;
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertTrue(sf.getNumbers().get(intSample).getNumber()!=null
                & !sf.getNumbers().get(intSample).getNumber().isEmpty());
        assertTrue(Objects.equals(sf.getNumbers().get(intSample).getDescription().toLowerCase(), "police"));
    }

    @Test
    public void safetyinfoTestMedicalHelpPresentNotNullNotEmpty(){
        stringSample="Italy";
        intSample=2;
        SafetyInfo sf = new SafetyInfo(stringSample);
        assertTrue(sf.getNumbers().get(intSample).getNumber()!=null
                & !sf.getNumbers().get(intSample).getNumber().isEmpty());
        assertTrue(Objects.equals(sf.getNumbers().get(intSample).getDescription().toLowerCase(), "medical help"));
    }

    //Landmarks
    @Test
    public void landmarkTestNotNull() {
        stringSample="";
        Places sf = new Places(stringSample, stringSample2 );
        assertNotNull(sf);
    }

    @Test
    public void landmarkTestEmpty() {
        stringSample="";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().size()==0);
    }

    @Test
    public void landmarkTestPresentBody(){
        stringSample="Germany";
        stringSample2="Munich";
        Places sf = new Places(stringSample, stringSample2 );
        assertThat(sf.getLandmarkList().size(), not(equalTo(0)));
    }

    @Test
    public void landmarkTestPresentHeader(){
        stringSample="Germany";
        stringSample2="Munich";
        Places sf = new Places(stringSample, stringSample2 );
        assertThat(sf.getLandmarkHeaderList().size(), not(equalTo(0)));
    }

    @Test
    public void landmarkTestHeaderPresentNotNullNotEmpty(){
        stringSample="Italy";
        stringSample2="Rome";
        intSample=0;
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue((sf.getLandmarkHeaderList().get(intSample).title != null)
                & !sf.getLandmarkHeaderList().get(intSample).title.isEmpty());
    }

    @Test
    public void landmarkTestBodyPresentNotNullNotEmpty(){
        stringSample="Italy";
        stringSample2="Rome";
        intSample=0;
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue((sf.getLandmarkList().get(intSample).description != null)
                & !sf.getLandmarkList().get(intSample).description.isEmpty());
    }

    //Restaurant
    @Test
    public void restaurantTestNotNull() {
        stringSample="";
        Places sf = new Places(stringSample, stringSample2 );
        assertNotNull(sf);
    }

    @Test
    public void restaurantTestIsEmpty() {
        stringSample="";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().size()==0);
    }

    @Test
    public void restaurantTestisPresentBody(){
        stringSample="Germany";
        stringSample2="Munich";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().size()>0);
    }

    @Test
    public void restaurantTestisPresentHeader(){
        stringSample="Germany";
        stringSample2="Munich";
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkHeaderList().size()>0);
    }

    @Test
    public void restaurantTestHeaderPresentNotNullNotEmpty(){
        stringSample="Italy";
        stringSample2="Rome";
        intSample=0;
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkHeaderList().get(intSample).title !=null
                & !sf.getLandmarkHeaderList().get(intSample).title.isEmpty());
    }

    @Test
    public void restaurantTestBodyPresentNotNullNotEmpty(){
        stringSample="Italy";
        stringSample2="Rome";
        intSample=0;
        Places sf = new Places(stringSample, stringSample2 );
        assertTrue(sf.getLandmarkList().get(intSample).description !=null
                & !sf.getLandmarkList().get(intSample).description.isEmpty());
    }
}
