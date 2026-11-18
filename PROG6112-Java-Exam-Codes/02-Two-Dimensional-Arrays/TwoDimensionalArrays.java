public class TwoDimensionalArrays {
    public static void main(String[] args) {
        // Rows are years; columns are quarters.
        int[][] sales = {{300, 150, 700}, {250, 200, 600}};
        // Outer loop visits rows; inner loop visits columns.
        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                System.out.print(sales[row][col] + "\t");
            }
            System.out.println(); // Start the next row on a new line.
        }
    }
}
