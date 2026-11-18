public class OneDimensionalArrays {
    public static void main(String[] args) {
        // A 1D array stores a list of names.
        String[] names = {"John", "Peter", "Mary"};
        // Visit each position and print its name.
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}


import java.util.Scanner;

public class SalesReport {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // STEP 1: Store the names of the 3 products
        String[] products = {
            "Cosy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // STEP 2: Create a 2D array
        // 3 rows = products
        // 3 columns = months
        int[][] sales = new int[3][3];

        // STEP 3: Enter sales for each product
        for (int i = 0; i < products.length; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print(
                    "Enter number of sales for month "
                    + (j + 1) + " for "
                    + products[i] + " mattresses: "
                );

                sales[i][j] = input.nextInt();
            }
        }

        // STEP 4: Calculate totals and averages
        int grandTotal = 0;
        int highestSales = 0;
        String popularProduct = "";

        System.out.println("\nSALES REPORT - 2026");
        System.out.println("--------------------------");

        for (int i = 0; i < products.length; i++) {

            int total = 0;

            // Add all 3 months for one product
            for (int j = 0; j < 3; j++) {
                total += sales[i][j];
            }

            // Calculate average
            double average = total / 3.0;

            // Add to overall total
            grandTotal += total;

            // Find product with highest sales
            if (total > highestSales) {
                highestSales = total;
                popularProduct = products[i];
            }

            System.out.println(products[i]);
            System.out.println("Total sales: " + total);
            System.out.printf(
                "Average sales: %.2f%n", average
            );
            System.out.println();
        }

        // STEP 5: Display final results
        System.out.println("Total products sold: "
                           + grandTotal);

        System.out.println("Most popular product: "
                           + popularProduct
                           + " (" + highestSales + ")");

        input.close();
    }
}
