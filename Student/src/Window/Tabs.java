package src.Window;

import javax.swing.*;

public class Tabs extends JTabbedPane {
    public Tabs(){
        JPanel panel1 = new StudentView();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        this.addTab("Student View List", panel1);
        this.addTab("Tab 2", panel2);
        this.addTab("Tab 3", panel3);
    }
}
