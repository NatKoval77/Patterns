package src.Window;

import javax.swing.*;

public class Window {
    public void createWindow() {
        JFrame frame = new JFrame("Students");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        tabbedPane.addTab("Tab 1", panel1);
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("Tab 2", panel2);
        JPanel panel3 = new JPanel();
        tabbedPane.addTab("Tab 3", panel3);
        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }
}
