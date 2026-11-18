import javax.swing.*;
public class MenuBarExample extends JFrame {
    private final JTextField txtName = new JTextField(15);
    private final JTextArea txtOutput = new JTextArea(5, 20);
    public MenuBarExample() {
        setTitle("Menu Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(txtName);
        panel.add(new JScrollPane(txtOutput));
        add(panel);
        setupMenu(); // Create menu once when the window opens.
        pack();
    }
    private void setupMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem process = new JMenuItem("Process");
        JMenuItem clear = new JMenuItem("Clear");
        // Reuse the same logic methods as buttons would use.
        exit.addActionListener(e -> System.exit(0));
        process.addActionListener(e -> processData());
        clear.addActionListener(e -> clearData());
        file.add(exit);
        tools.add(process);
        tools.add(clear);
        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);
    }
    private void processData() { txtOutput.setText(txtName.getText()); }
    private void clearData() { txtName.setText(""); txtOutput.setText(""); }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuBarExample().setVisible(true));
    }
}
