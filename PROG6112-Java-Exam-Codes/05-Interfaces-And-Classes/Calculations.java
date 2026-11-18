// Implements the contract; keep calculations separate from the user interface.
public class Calculations implements ICalculations {
    @Override
    public int calculateTotal(int[][] data) {
        int total = 0;
        // Visit every cell and add its value.
        for (int[] row : data) for (int value : row) total += value;
        return total;
    }
    @Override
    public double calculateAverage(int[][] data) {
        int count = 0;
        // Count cells instead of assuming a fixed table size.
        for (int[] row : data) count += row.length;
        if (count == 0) return 0; // Avoid division by zero.
        return (double) calculateTotal(data) / count;
    }
}
