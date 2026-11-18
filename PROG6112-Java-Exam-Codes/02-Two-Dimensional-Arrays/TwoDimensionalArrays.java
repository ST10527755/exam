

public interface IProduct {

    int GetTotalProductsSold();

    double GetAverageProductsSold();

    String GetMostPopularProduct();
}


public class Product implements IProduct {

    // Product names
    String[] products = {
        "Cosy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    // Store sales for 3 products over 3 months
    int[][] sales = new int[3][3];

    // Constructor receives sales data
    public Product(int[][] sales) {
        this.sales = sales;
    }

    // Calculate total products sold
    @Override
    public int GetTotalProductsSold() {

        int total = 0;

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }

        return total;
    }

    // Calculate average sales per product
    @Override
    public double GetAverageProductsSold() {

        return (double) GetTotalProductsSold()
                / products.length;
    }

    // Find the product with highest sales
    @Override
    public String GetMostPopularProduct() {

        int highest = -1;
        String popular = "";

        for (int i = 0; i < sales.length; i++) {

            int total = 0;

            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }

            if (total > highest) {
                highest = total;
                popular = products[i];
            }
        }

        return popular;
    }
}


public class PrintProduct {

    // Display total products sold
    public void printTotal(Product product) {

        System.out.println("Total products sold: "
                + product.GetTotalProductsSold());
    }

    // Display average sales
    public void printAverage(Product product) {

        System.out.println("Average sales per product: "
                + product.GetAverageProductsSold());
    }

    // Display most popular product
    public void printPopular(Product product) {

        System.out.println("Most popular product: "
                + product.GetMostPopularProduct());
    }
}



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = {
            "Cosy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] sales = new int[3][3];

        // Enter sales for each product
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print(
                    "Enter sales for month " + (j + 1)
                    + " for " + names[i] + ": "
                );

                sales[i][j] = input.nextInt();
            }
        }

        // Create Product object
        Product product = new Product(sales);

        // Create PrintProduct object
        PrintProduct print = new PrintProduct();

        System.out.println("\nSALES REPORT - 2026");

        // Display report
        print.printTotal(product);
        print.printAverage(product);
        print.printPopular(product);

        input.close();
    }
}
