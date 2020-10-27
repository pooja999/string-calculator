import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void shouldReturn0ForAnEmptyString() {
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void shouldReturnValueForSingleDigit() {
        Assert.assertEquals(1,StringCalculator.add("1"));
        Assert.assertEquals(2,StringCalculator.add("2"));
    }
}
