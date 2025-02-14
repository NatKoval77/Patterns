package src.Window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Buttons extends JPanel {
    private JButton deleteButton;
    private JButton updateButton;
    private JButton searchButton;
    private JButton clearButton;
    private JTable table;

    public Buttons(JTable table) {
        this.table = table;
        JButton createButton = new JButton("Create");
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        Font font = createButton.getFont();
        createButton.setFont(new Font(font.getFontName(), font.getStyle(), 15));
        this.updateButton = new JButton("Update");
        this.updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.updateButton.setFont(new Font(font.getFontName(), font.getStyle(), 15));
        this.deleteButton = new JButton("Delete");
        this.deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.deleteButton.setFont(new Font(font.getFontName(), font.getStyle(), 15));
        this.searchButton = new JButton("Search");
        this.searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.searchButton.setFont(new Font(font.getFontName(), font.getStyle(), 15));
        this.clearButton = new JButton("Clear");
        this.clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.clearButton.setFont(new Font(font.getFontName(), font.getStyle(), 15));
        this.updateButton.setEnabled(false);
        this.deleteButton.setEnabled(false);
        this.clearButton.addActionListener(e -> {
            this.table.clearSelection();
        });

        this.setBorder(new EmptyBorder(10, 20, 10, 20));
        GridLayout layout = new GridLayout(5, 1);
        layout.setVgap(40);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 400));
        panel.setLayout(layout);
        panel.add(createButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(searchButton);
        panel.add(clearButton);
        this.add(panel);

        ListSelectionModel selectionModel = this.table.getSelectionModel();
        selectionModel.addListSelectionListener(e -> {
            int selectedRowCount = this.table.getSelectedRowCount();
            updateButtonState(selectedRowCount);
        });
    }

    public void updateButtonState(int selectedRowsCount) {
        if (selectedRowsCount == 1) {
            this.updateButton.setEnabled(true);
            this.deleteButton.setEnabled(true);
        } else if (selectedRowsCount > 1) {
            this.updateButton.setEnabled(false);
            this.deleteButton.setEnabled(true);
        } else {
            this.updateButton.setEnabled(false);
            this.deleteButton.setEnabled(false);
        }
    }
}
