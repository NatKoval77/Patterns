package src.Window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(String name){
        super(name);
        this.setTitle(name);
    }
    public void createWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new StudentsView();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        tabbedPane.addTab("Student View List", panel1);
        tabbedPane.addTab("Tab 2", panel2);
        tabbedPane.addTab("Tab 3", panel3);
        this.add(tabbedPane);
        this.setMinimumSize(new Dimension(800,600));
        this.pack();
        this.setVisible(true);
    }
    public static void start(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window win = new Window("Student");
                win.createWindow();
            }
        });
    }
}
