package src.Window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Navigator extends JPanel {
    JButton prevButton;
    JButton nextButton;
    JLabel pageLabel;
    JComboBox<Integer> rowsPerPageSelect;
    int currentPage = 1;
    int rowsPerPage = 12;
    int maxCountOfPages;
    MainTable mainTable;

    public Navigator(MainTable mainTable) {
        this.mainTable = mainTable;
        this.maxCountOfPages = calculateMaxPages();
        setupComponents();
        setupLayout();
        updateTableData();
    }

    private void setupComponents() {
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        Font font = prevButton.getFont();
        prevButton.setFont(new Font(font.getName(), font.getStyle(), 15));
        nextButton.setFont(new Font(font.getName(), font.getStyle(), 15));

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    updateTableData();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < maxCountOfPages) {
                    currentPage++;
                    updateTableData();
                }
            }
        });

        rowsPerPageSelect = new JComboBox<>(new Integer[]{4, 6, 8, 10, 12, 15, 20});
        rowsPerPageSelect.setFont(new Font(font.getName(), font.getStyle(), 15));
        rowsPerPageSelect.setSelectedItem(12);

        rowsPerPageSelect.addActionListener(e -> {
            rowsPerPage = (int) rowsPerPageSelect.getSelectedItem();
            currentPage = 1;
            maxCountOfPages = calculateMaxPages();
            updateTableData();
        });

        pageLabel = new JLabel("", JLabel.CENTER);
        pageLabel.setFont(new Font(font.getName(), font.getStyle(), 15));
    }

    private void setupLayout() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20, 0, 0, 0));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 60));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.add(prevButton);
        panel.add(pageLabel);
        panel.add(nextButton);
        panel.add(rowsPerPageSelect);
        this.add(panel, BorderLayout.CENTER);
    }

    private int calculateMaxPages() {
        return (int) Math.ceil((double) mainTable.dataHard.length / rowsPerPage);
    }

    private void updateTableData() {
        int start = (currentPage - 1) * rowsPerPage;
        int end = Math.min(start + rowsPerPage, mainTable.dataHard.length);

        Object[][] pageData = new Object[end - start][mainTable.columnsNames.length];
        for (int i = 0; i < (end - start); i++) {
            pageData[i] = mainTable.dataHard[start + i];
        }

        mainTable.tableModel.setDataVector(pageData, mainTable.columnsNames);
        updateLabel();
    }

    private void updateLabel() {
        pageLabel.setText("Page " + currentPage + " of " + maxCountOfPages);
    }

}