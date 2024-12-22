package src.Window;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JPanel {
    public StudentView(){
        super(new BorderLayout());
        this.add(new Table(), BorderLayout.NORTH);
        MainTable main = new MainTable();
        JScrollPane scroll = new JScrollPane(main);
        this.add(scroll,BorderLayout.CENTER);
        this.add(new Navigator(main),BorderLayout.SOUTH);
    }
}