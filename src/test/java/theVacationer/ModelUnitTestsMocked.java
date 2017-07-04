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
import theVacationer.model.geodata.Cities;

@RunWith(MockitoJUnitRunner.class)
public class ModelUnitTestsMocked {

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

}



//
//public class MyReaderTest {
//
//    @InjectMocks
//    private MyReader myReader;
//
//    @SuppressWarnings("unchecked")
//    @Before
//    public void setUp() throws Exception {
//        Statement s = mock(Statement.class);
//        ResultSet rs = mock(ResultSet.class);
//
//        when(s.executeQuery(anyString())).thenReturn(rs);
//        when(rs.getString("myColumn")).thenThrow(SQLException.class);
//    }
//
//    @Test
//    public void testRead_AccessNonExistentColumn() {
//        // Use mock statement and mock resultset
//    }
//
//}