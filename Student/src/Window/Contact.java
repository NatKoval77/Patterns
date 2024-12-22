package src.Window;

import javax.swing.*;
import java.awt.*;

public class Contact extends JPanel{
    private final Input inputField;
    public Contact(String title){
        super();
        this.setLayout(new GridLayout(2,1));
        this.inputField = new Input();
        JLabel label = new JLabel(title);
        Box comboBox = new Box(this);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.add(this.inputField);
        panel.add(comboBox);
        this.add(label);
        this.add(panel);
    }
    public void changeInputEnable(boolean enabling){
        this.inputField.changeEnabling(enabling);
    }
}
