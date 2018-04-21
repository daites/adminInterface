import dorian.AdminSetupForm;

import javax.swing.*;

public class Main {
    public static void createAndShowGui() {
        JFrame frame = new JFrame("Create/Edit Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new dorian.AdminSetupForm().getRootPanel());
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
