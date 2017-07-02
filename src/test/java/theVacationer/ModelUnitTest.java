package theVacationer;

import org.junit.Test;
import org.springframework.util.Assert;
import theVacationer.model.safetyInfo.SafetyNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Dmitryukov on 7/2/2017.
 */
public class ModelUnitTest {

    String stringSample = "sample";
    int intSample = 1;


    @Test
    public void safetyinfoTest(){
        SafetyNumber number = new SafetyNumber(stringSample, stringSample, intSample);
        List<SafetyNumber> numbers = new ArrayList<SafetyNumber>();
        numbers.add(number);
        Assert.notEmpty(numbers);
        Assert.noNullElements(new String[]{number.getDescription()}, "test");
    }
}
