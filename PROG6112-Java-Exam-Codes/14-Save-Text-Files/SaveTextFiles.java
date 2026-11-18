import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class SaveTextFiles {
    public static void main(String[] args) {
        // This text is the report to save.
        String report = "Sales Report\nTotal: 2200";
        // try-with-resources closes the writer automatically.
        try (PrintWriter writer = new PrintWriter(new FileWriter("report.txt"))) {
            writer.println(report); // Write the report to the file.
            System.out.println("File saved!");
        } catch (IOException ex) {
            // Show a useful error instead of crashing.
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
