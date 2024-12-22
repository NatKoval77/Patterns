package src.Window;

import javax.swing.*;
import java.awt.*;

public class StudentsView extends JPanel {
    public StudentsView() {
        super();
        this.setLayout(new BorderLayout());
        JPanel filterPanel = new JPanel(new GridLayout(1, 5));
        JPanel surname = new JPanel(new GridLayout(2, 1));
        JTextField nameField = new JTextField();
        surname.add(new JLabel("Surname and initial:"));
        surname.add(nameField);
        filterPanel.add(surname);
        this.add(filterPanel, BorderLayout.NORTH);
        JPanel tablePanel = new JPanel();
        this.add(tablePanel, BorderLayout.CENTER);
    }
}
