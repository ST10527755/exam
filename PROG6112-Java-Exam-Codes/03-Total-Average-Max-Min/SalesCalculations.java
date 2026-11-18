
public interface IProductCalculations {

    double GetVat();

    double GetCommission();

    double GetTotal();
}


public class ProductCalculations
        implements IProductCalculations {

    private double price;

    // Constructor
    public ProductCalculations(double price) {
        this.price = price;
    }

    // Calculate 15% VAT
    @Override
    public double GetVat() {
        return price * 0.15;
    }

    // Calculate 5% commission
    @Override
    public double GetCommission() {
        return price * 0.05;
    }

    // Calculate final amount
    @Override
    public double GetTotal() {
        return price + GetVat()
                + GetCommission();
    }
}

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class MattressForm extends JFrame {

    JTextField txtName = new JTextField(20);
    JTextField txtPrice = new JTextField(20);

    String[] products = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    JComboBox<String> cmbProduct =
            new JComboBox<>(products);

    JButton btnProcess = new JButton("PROCESS");

    public MattressForm() {

        setTitle("Mattress Sales App");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create form
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Customer Name:"));
        panel.add(txtName);

        panel.add(new JLabel("Product:"));
        panel.add(cmbProduct);

        panel.add(new JLabel("Price:"));
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Button and menu actions
        btnProcess.addActionListener(e -> processSale());

        processItem.addActionListener(e -> processSale());

        clearItem.addActionListener(e -> clearForm());

        exitItem.addActionListener(e -> System.exit(0));
    }

    // Process sale
    public void processSale() {

        try {
            String name = txtName.getText().trim();
            String product = cmbProduct.getSelectedItem().toString();
            double price = Double.parseDouble(txtPrice.getText());

            if (name.isEmpty() || !Double.isFinite(price)
                    || price <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Enter a valid name and positive price.");
                return;
            }

            ProductCalculations calc =
                    new ProductCalculations(price);

            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String result =
                    "Customer Name: " + name
                    + "\nProduct: " + product
                    + "\nVAT: R " + vat
                    + "\nCOMMISSION: R " + commission
                    + "\nTOTAL: R " + total;

            // Display results
            JOptionPane.showMessageDialog(this, result);

            // Save results to data.txt
            try (FileWriter writer =
                    new FileWriter("data.txt", true)) {

                writer.write("DATA LOG\n");
                writer.write("************************\n");
                writer.write(result + "\n");
                writer.write("************************\n\n");
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number for price.");

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this,
                    "Error saving data.txt");
        }
    }

    // Clear fields
    public void clearForm() {

        txtName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }
}

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MattressForm form = new MattressForm();
            form.setVisible(true);
        });
    }
}
