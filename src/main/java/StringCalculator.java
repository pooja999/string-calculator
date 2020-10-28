import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input) throws Exception {
        if (input.isEmpty()) {
            return 0;
        }

        if(input.startsWith("//[")) {
            Integer sum = getSumForChangedDelimiter(input, "\\[(.*)\\]\n(.*)");
            if (sum != null) return sum;
        }

        if (input.startsWith("//")) {
            Integer sum = getSumForChangedDelimiter(input, "//(.)\n(.*)");
            if (sum != null) return sum;
        }

        if (input.contains(",") || input.contains("\n")) {
            return splitAndSum(input, ",|\n");
        }

        int parsedInput = Integer.parseInt(input);
        if(parsedInput > 1000) {
            return 0;
        }
        checkForNegativeNumbers(input);
        return parsedInput;
    }

    private static Integer getSumForChangedDelimiter(String input, String pattern) throws Exception {
        Matcher matcher = Pattern.compile(pattern).matcher(input);
        if (matcher.find()) {
            return splitAndSum(matcher.group(2), matcher.group(1));
        }
        return null;
    }

    private static int splitAndSum(String numbersWithDelimiter, String delimiter) throws Exception {
        String[] values = numbersWithDelimiter.split(delimiter);
        for(String value:values) {
            checkForNegativeNumbers(value);
        }

        return getSum(values);
    }

    private static int getSum(String[] values) {
        int sum = 0;
        for (String value : values) {
            int parsedInput = Integer.parseInt(value);
            if(parsedInput <= 1000) {
                sum += parsedInput;;
            }
        }
        return sum;
    }

    private static void checkForNegativeNumbers(String number) throws Exception {
        int parsedInput = Integer.parseInt(number);
        if(parsedInput < 0) {
            throw new Exception("negatives not allowed: "+parsedInput);
        }
    }

}
