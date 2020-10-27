public class StringCalculator {
    public static int add(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        if(input.contains(",")) {
            String[] values = input.split(",");
            return Integer.parseInt(values[0])+Integer.parseInt(values[1]);
        }
        return Integer.parseInt(input);
    }
}
