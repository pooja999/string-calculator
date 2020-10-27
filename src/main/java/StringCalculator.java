public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.contains(",")) {
            String[] values = input.split(",");
            return getSum(values);
        }
        return Integer.parseInt(input);
    }

    private static int getSum(String[] values) {
        int sum = 0;
        for(int i=0; i<values.length; i++) {
            sum += Integer.parseInt(values[i]);
        }
        return sum;
    }

}
