import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        if(input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                String[] values = matcher.group(2).split(matcher.group(1));
                return getSum(values);
            }
        }

        if (input.contains(",") || input.contains("\n")) {
            String[] values = input.split(",|\n");
            return getSum(values);
        }
        return Integer.parseInt(input);
    }

    private static int getSum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }

}
