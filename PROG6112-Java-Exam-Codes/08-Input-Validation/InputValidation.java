public class InputValidation {
    public static void main(String[] args) {
        // Replace with input from a field or Scanner.
        String input = "250";
        try {
            // Attempt to convert the text to a number.
            double value = Double.parseDouble(input);
            if (value > 0) System.out.println("Valid input");
            else System.out.println("Value must be positive");
        } catch (NumberFormatException ex) {
            // Bad number text should not crash the program.
            System.out.println("Enter a valid number");
        }
    }
}
