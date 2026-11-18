import javax.swing.*;
public class ReusableForm extends JFrame {
    // Components used to enter and display information.
    private final JTextField txtName = new JTextField(15);
    private final JTextArea txtOutput = new JTextArea(8, 25);
    private final JButton btnProcess = new JButton("Process");
    private final JButton btnClear = new JButton("Clear");
    public ReusableForm() {
        setTitle("Exam Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(btnProcess);
        panel.add(btnClear);
        txtOutput.setEditable(false); // Make report read-only.
        panel.add(new JScrollPane(txtOutput));
        add(panel);
        // Both buttons call reusable methods.
        btnProcess.addActionListener(e -> processData());
        btnClear.addActionListener(e -> clearData());
        pack();
        setLocationRelativeTo(null);
    }
    private void processData() {
        // Read and show the entered name.
        txtOutput.setText("Name: " + txtName.getText().trim());
    }
    private void clearData() {
        // Reset all user controls.
        txtName.setText("");
        txtOutput.setText("");
    }
    public static void main(String[] args) {
        // Create Swing windows on the event dispatch thread.
        SwingUtilities.invokeLater(() -> new ReusableForm().setVisible(true));
    }
}
