public class SalesLimit {
    public static void main(String[] args) {
        // Rows represent years; columns represent sales.
        int[][] data = {{300, 150, 700}, {250, 200, 600}};
        final int LIMIT = 500; // Change the threshold for the question.
        int over = 0, under = 0;
        for (int[] row : data) {
            for (int value : row) {
                if (value > LIMIT) over++; // Count above limit.
                else if (value < LIMIT) under++; // Count below limit.
                // Equal to LIMIT counts as neither.
            }
        }
        System.out.println("Over limit: " + over);
        System.out.println("Under limit: " + under);
    }
}
