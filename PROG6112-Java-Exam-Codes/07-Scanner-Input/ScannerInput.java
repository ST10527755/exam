import java.util.Scanner;
public class ScannerInput {
    public static void main(String[] args) {
        // Scanner reads text typed into the console.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine(); // Read a full line.
        System.out.print("Enter sales: ");
        double sales = input.nextDouble(); // Read a decimal number.
        System.out.println("Name: " + name);
        System.out.println("Sales: " + sales);
    }
}
