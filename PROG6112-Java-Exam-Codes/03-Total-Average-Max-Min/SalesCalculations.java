public class SalesCalculations {
    public static void main(String[] args) {
        // Replace these sample values with the exam data.
        int[][] data = {{300, 150, 700}, {250, 200, 600}};
        int total = 0, count = 0;
        // Start maximum and minimum at a real array value.
        int max = data[0][0], min = data[0][0];
        for (int[] row : data) {
            for (int value : row) {
                total += value; // Add to running total.
                count++; // Count values for average.
                if (value > max) max = value;
                if (value < min) min = value;
            }
        }
        // Casting avoids losing the decimal part.
        double average = (double) total / count;
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
