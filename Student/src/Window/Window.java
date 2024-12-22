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
        this.add(new Tabs());
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
