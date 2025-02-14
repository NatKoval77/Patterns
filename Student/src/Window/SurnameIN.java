package src.Window;

import javax.swing.*;
import java.awt.*;

public class SurnameIN extends JPanel {
    public SurnameIN(){
        super();
        this.setLayout(new GridLayout(2,1));
        JTextField nameField = new JTextField();
        JLabel label = new JLabel("Surname and initial:");
        this.add(label);
        this.add(nameField);
    }
}
