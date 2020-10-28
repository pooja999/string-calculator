import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void shouldReturn0ForAnEmptyString() throws Exception {
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void shouldReturnValueForSingleNumber() throws Exception {
        Assert.assertEquals(1, StringCalculator.add("1"));
        Assert.assertEquals(2, StringCalculator.add("2"));
        Assert.assertEquals(10, StringCalculator.add("10"));
    }

    @Test
    public void shouldReturnSumForAnyAmountOfNumbersSeparatedByNewLineOrComma() throws Exception {
        Assert.assertEquals(3, StringCalculator.add("1,2"));
        Assert.assertEquals(6, StringCalculator.add("1,2,3"));
        Assert.assertEquals(3, StringCalculator.add("1\n2"));
        Assert.assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void shouldReturnSumForChangedDelimiter() throws Exception {
        Assert.assertEquals(1, StringCalculator.add("//;\n1"));
        Assert.assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void shouldThrowAnExceptionForANegativeNumber() {
        Assertions.assertThatThrownBy(() -> StringCalculator.add("-1")).hasMessage("negatives not allowed: -1");
        Assertions.assertThatThrownBy(() -> StringCalculator.add("-2")).hasMessage("negatives not allowed: -2");
    }

    @Test
    public void shouldThrowAnExceptionForANegativeNumberInASequence() {
        Assertions.assertThatThrownBy(() -> StringCalculator.add("-1,2")).hasMessage("negatives not allowed: -1");
        Assertions.assertThatThrownBy(() -> StringCalculator.add("//;\n1;-2")).hasMessage("negatives not allowed: -2");
    }

    @Test
    public void shouldReturn0ForNumberGreaterThan1000() throws Exception {
        Assert.assertEquals(0, StringCalculator.add("1001"));
    }

    @Test
    public void shouldIgnoreForNumbersGreaterThan1000InASequence() throws Exception {
        Assert.assertEquals(2,StringCalculator.add("2,1001"));
        Assert.assertEquals(6,StringCalculator.add("//,\n1,2,1002,3"));
    }
}
