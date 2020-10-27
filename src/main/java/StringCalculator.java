public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.contains(",")) {
            String[] values = input.split(",");
            return getSum(values[0], values[1]);
        }
        return Integer.parseInt(input);
    }

    private static int getSum(String operandOne, String operandTwo) {
        return Integer.parseInt(operandOne) + Integer.parseInt(operandTwo);
    }

}
