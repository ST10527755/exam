public class TopPerformer {
    public static void main(String[] args) {
        // Names match the rows of the sales table.
        String[] names = {"John", "Peter", "Mary"};
        int[][] sales = {{100, 200}, {300, 400}, {150, 250}};
        int topIndex = -1, highest = Integer.MIN_VALUE;
        // Calculate one row total per performer.
        for (int i = 0; i < sales.length; i++) {
            int total = 0;
            for (int value : sales[i]) total += value;
            System.out.println(names[i] + ": " + total);
            // Remember the index of the largest total.
            if (total > highest) { highest = total; topIndex = i; }
        }
        System.out.println("Top performer: " + names[topIndex]);
    }
}
