import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void shouldReturn0ForAnEmptyString() {
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void shouldReturnValueForSingleNumber() {
        Assert.assertEquals(1,StringCalculator.add("1"));
        Assert.assertEquals(2,StringCalculator.add("2"));
        Assert.assertEquals(10,StringCalculator.add("10"));
    }

    @Test
    public void shouldReturnSumForTwoNumbersSeparatedByComma() {
        Assert.assertEquals(3,StringCalculator.add("1,2"));
    }

    @Test
    public void shouldReturnSumForAnyAmountOfNumbersSeparatedByComma() {
        Assert.assertEquals(6,StringCalculator.add("1,2,3"));
    }
}
