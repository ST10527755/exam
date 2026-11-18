import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadTextFiles {
    public static void main(String[] args) {
        // Read the file created by topic 14.
        try (BufferedReader reader = new BufferedReader(new FileReader("report.txt"))) {
            String line;
            // null means there are no more lines.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            // A missing file is also an IOException.
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
