package src.Window;

import javax.swing.*;

public class Window {
    public void createWindow() {
        JFrame frame = new JFrame("My Java Window");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
