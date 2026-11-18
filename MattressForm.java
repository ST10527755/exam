package com.example.mattress;

import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class MattressForm extends JFrame {
    private final JTextField txtName = new JTextField(20);
    private final JTextField txtPrice = new JTextField(20);
    private final JComboBox<String> cmbProduct = new JComboBox<>(new String[] {
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
    });
    private final JButton btnProcess = new JButton("PROCESS");

    public MattressForm() {
        setTitle("Mattress Sales App");
        setSize(440, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.add(new JLabel("Customer Name:")); panel.add(txtName);
        panel.add(new JLabel("Product:")); panel.add(cmbProduct);
        panel.add(new JLabel("Price (R):")); panel.add(txtPrice);
        panel.add(new JLabel("")); panel.add(btnProcess);
        add(panel);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem process = new JMenuItem("Process");
        JMenuItem clear = new JMenuItem("Clear");
        exit.addActionListener(e -> dispose());
        process.addActionListener(e -> processSale());
        clear.addActionListener(e -> clearForm());
        btnProcess.addActionListener(e -> processSale());
        file.add(exit); tools.add(process); tools.add(clear);
        bar.add(file); bar.add(tools); setJMenuBar(bar);
    }

    private void processSale() {
        String name = txtName.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a customer name.");
            return;
        }
        try {
            double price = Double.parseDouble(txtPrice.getText().trim());
            if (!Double.isFinite(price) || price <= 0) {
                JOptionPane.showMessageDialog(this, "Enter a positive price.");
                return;
            }
            String product = (String) cmbProduct.getSelectedItem();
            ProductCalculations calc = new ProductCalculations(price);
            String report = String.format(
                "DATA LOG%n************************%nCustomer Name: %s%nProduct: %s%nVAT: R %.2f%nCOMMISSION: R %.2f%nTOTAL: R %.2f%n************************%n",
                name, product, calc.GetVat(), calc.GetCommission(), calc.GetTotal());
            try (FileWriter writer = new FileWriter("data.txt", true)) {
                writer.write(report + System.lineSeparator());
            }
            JOptionPane.showMessageDialog(this, report);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid numeric price.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save data.txt: " + ex.getMessage());
        }
    }

    private void clearForm() {
        txtName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }
}
