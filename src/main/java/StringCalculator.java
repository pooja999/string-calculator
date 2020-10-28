import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                return splitAndSum(matcher.group(2), matcher.group(1));
            }
        }

        if (input.contains(",") || input.contains("\n")) {
            return splitAndSum(input, ",|\n");
        }
        return Integer.parseInt(input);
    }

    private static int splitAndSum(String numbersWithDelimiter, String delimiter) {
        String[] values = numbersWithDelimiter.split(delimiter);
        return getSum(values);
    }

    private static int getSum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }

}
