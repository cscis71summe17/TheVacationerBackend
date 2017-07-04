package theVacationer;

/**
 * Created by grigori on 7/3/17.
 */
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

import java.sql.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import theVacationer.model.Model;
import theVacationer.model.geodata.Cities;
import theVacationer.model.geodata.Countries;
import theVacationer.model.safetyInfo.SafetyInfo;

@RunWith(MockitoJUnitRunner.class)
public class ModelUnitTestsMocked {

    public final String COUNTRY_TABLE = "Country";
    public final String SAFETYINFO_TABLE = "SafetyInfo";

    @Test
    public void cityTestIndexVerification() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);


            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Cities ct = new Cities(stringSample, s);

            verify(rs, times(1)).getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cityTestQueryVerification() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            String str =
                    "SELECT A.name FROM  City AS A, Country AS B WHERE A.country_id = B.id AND B.name LIKE 'France';";

            Cities ct = new Cities(stringSample, s);

            verify(s, times(1)).executeQuery(str);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cityTestMultiCityNotNulltMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn("Paris")
                    .thenReturn("Marselle")
                    .thenReturn("Lyon");

            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            Cities ct = new Cities(stringSample, s);
            assertNotNull(ct);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cityTestMultiCityPresentMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn("Paris")
                    .thenReturn("Marselle")
                    .thenReturn("Lyon");

            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            Cities ct = new Cities(stringSample, s);
            assertTrue(ct.getCityList().contains("Paris"));
            assertTrue(ct.getCityList().contains("Marselle"));
            assertTrue(ct.getCityList().contains("Lyon"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cityTestFranceCapitalPresentMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(1)).thenReturn("Paris");
            when(rs.next()).thenReturn(true).thenReturn(false);

            Cities ct = new Cities(stringSample, s);
            assertNotNull(ct);
            assertTrue(ct.getCityList().contains("Paris"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestNotNullMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(2)).thenReturn(stringSample);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Countries ct = new Countries(s);
            assertNotNull(ct);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestPresentMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(2)).thenReturn(stringSample);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Countries ct = new Countries(s);
            assertTrue(ct.getCountryList().contains(stringSample));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestExactSizedMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.getString(2)).thenReturn(stringSample);
            when(rs.next()).thenReturn(true).thenReturn(false);

            Countries ct = new Countries(s);
            assertNotNull(ct);
            assertTrue(ct.getCountryList().size() == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestMultiCountryPresentMocked() {
        try {

            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(2))
                    .thenReturn("France")
                    .thenReturn("Spain")
                    .thenReturn("Germany");

            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            Countries ct = new Countries(s);
            assertNotNull(ct);
            assertTrue(ct.getCountryList().contains("Germany"));
            assertTrue(ct.getCountryList().contains("Spain"));
            assertTrue(ct.getCountryList().contains("France"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countryTestQueryVerification() {
        try {
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            String str =
                    "SELECT * FROM Country;";

            Countries ct = new Countries(s);

            verify(s, times(1)).executeQuery(str);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyinfoTestIndexVerification() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);


            when(s.executeQuery(anyString())).thenReturn(rs);
            when(rs.next()).thenReturn(true).thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);

            verify(rs, times(1)).getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestQueryVerification() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            String str ="SELECT A.number, A.description " +
                    "FROM  " + SAFETYINFO_TABLE + " AS A, " + COUNTRY_TABLE + " AS B " +
                    "WHERE A.country_id = B.id AND B.name LIKE '" + stringSample + "';";
            Cities ct = new Cities(stringSample, s);

            verify(s, times(1)).executeQuery(str);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoNotNullMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn("All Serivces")
                    .thenReturn("Police")
                    .thenReturn("Medical Help");


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertNotNull(ct);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestDescriptionNotEmptyMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn("All Serivces")
                    .thenReturn("Police")
                    .thenReturn("Medical Help");


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertTrue(ct.getNumbers().size()>0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestDescriptionPresentMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn("All Serivces")
                    .thenReturn("Police")
                    .thenReturn("Medical Help");


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertTrue(ct.getNumbers().get(0).getDescription().contains("All Serivces"));
            assertTrue(ct.getNumbers().get(1).getDescription().contains("Police"));
            assertTrue(ct.getNumbers().get(2).getDescription().contains("Medical Help"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestNumbersNotNullMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn("All Serivces")
                    .thenReturn("Police")
                    .thenReturn("Medical Help");


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertNotNull(ct.getNumbers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void safetyInfoTestNumbersPresentMocked() {
        try {
            String stringSample ="France";
            Statement s = mock(Statement.class);
            ResultSet rs = mock(ResultSet.class);

            when(s.executeQuery(anyString())).thenReturn(rs);

            when(rs.getString(1))
                    .thenReturn("All Serivces")
                    .thenReturn("Police")
                    .thenReturn("Medical Help");


            when(rs.next()).thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(true)
                    .thenReturn(false);

            SafetyInfo ct = new SafetyInfo(stringSample, s);
            assertNotNull(ct.getNumbers().get(0).getNumber());
            assertNotNull(ct.getNumbers().get(1).getNumber());
            assertNotNull(ct.getNumbers().get(2).getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}