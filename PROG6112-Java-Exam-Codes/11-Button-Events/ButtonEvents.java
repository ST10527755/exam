import javax.swing.*;
public class ButtonEvents extends JFrame {
    private final JTextField txtName = new JTextField(15);
    private final JTextArea txtAreaOutput = new JTextArea(5, 20);
    public ButtonEvents() {
        setTitle("Button Events");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton btnProcess = new JButton("Process");
        JButton btnClear = new JButton("Clear");
        panel.add(txtName);
        panel.add(btnProcess);
        panel.add(btnClear);
        panel.add(new JScrollPane(txtAreaOutput));
        add(panel);
        // Click handlers delegate to one method each.
        btnProcess.addActionListener(e -> processData());
        btnClear.addActionListener(e -> clearData());
        pack();
    }
    private void processData() {
        // Copy the input into the output area.
        txtAreaOutput.setText(txtName.getText());
    }
    private void clearData() {
        // Clear both fields.
        txtName.setText("");
        txtAreaOutput.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ButtonEvents().setVisible(true));
    }
}
