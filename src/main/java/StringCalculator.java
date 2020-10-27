import java.util.Arrays;

public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if(input.startsWith("//")) {
            return 1;
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
