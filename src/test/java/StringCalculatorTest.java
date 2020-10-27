import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void shouldReturn0ForAnEmptyString() {
        Assert.assertEquals(0, StringCalculator.add(""));
    }
}
