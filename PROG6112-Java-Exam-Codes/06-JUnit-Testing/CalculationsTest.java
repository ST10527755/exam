// Requires JUnit 5 and the Calculations + ICalculations files from topic 05.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculationsTest {
    @Test
    public void testTotal() {
        // Arrange: choose data with a known answer.
        int[][] data = {{100, 200}, {300, 400}};
        Calculations calc = new Calculations();
        // Act and assert: compare expected and actual totals.
        assertEquals(1000, calc.calculateTotal(data));
    }
    @Test
    public void testAverage() {
        int[][] data = {{100, 200}, {300, 400}};
        Calculations calc = new Calculations();
        // Delta 0.001 allows tiny floating-point differences.
        assertEquals(250.0, calc.calculateAverage(data), 0.001);
    }
}
