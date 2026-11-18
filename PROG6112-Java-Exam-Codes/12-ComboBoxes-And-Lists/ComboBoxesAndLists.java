import javax.swing.*;
public class ComboBoxesAndLists extends JFrame {
    // Combo box holds selectable locations.
    private final JComboBox<String> cmbLocation = new JComboBox<>(
        new String[]{"Durban", "Cape Town", "Pretoria"});
    // A list model holds the displayed results.
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> lstResults = new JList<>(model);
    public ComboBoxesAndLists() {
        setTitle("Combo Boxes and Lists");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton add = new JButton("Add Location");
        JButton clear = new JButton("Clear List");
        panel.add(cmbLocation);
        panel.add(add);
        panel.add(clear);
        panel.add(new JScrollPane(lstResults));
        add(panel);
        // Add the selected item to the list.
        add.addActionListener(e -> model.addElement(
            "Location: " + cmbLocation.getSelectedItem()));
        // Remove all displayed items.
        clear.addActionListener(e -> model.clear());
        pack();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ComboBoxesAndLists().setVisible(true));
    }
}
