package com.example.mattress;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MattressForm().setVisible(true));
    }
}
