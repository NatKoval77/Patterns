package src.Window;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainTable extends JTable {
    public DefaultTableModel tableModel;
    public Object[][] dataHard = {
            {0, "Aaa B.C.", "github.com/aaabc", "{tg=@aaabc}"},
            {1, "Bbb C.D." , "github.com/bbbcd", "{email=bbbcd@mail.ru}"},
            {2, "Ccc D.E." , "github.com/cccde", "{phone=+79996665544}"},
            {3, "Ddd E.F.", "github.com/dddef", "{tg=@dddef}"},
            {4, "Eee F.G.", "github.com/eeefg", "{email=eeefg@mail.ru}"},
            {5, "Fff G.H.", "github.com/fffgh", "{phone=+79996665545}"},
            {6, "Ggg H.I.", "github.com/ggghi", "{tg=@ggghi}"},
            {7, "Hhh I.J.", "github.com/hhhij", "{email=hhhij@mail.ru}"},
            {8, "Iii J.K.", "github.com/iijk", "{phone=+79996665546}"},
            {9, "Jjj K.L.", "github.com/jjjkl", "{tg=@jjjkl}"},
            {10, "Kkk L.M.", "github.com/kkklm", "{email=kkklm@mail.ru}"},
            {11, "Lll M.N.", "github.com/lllmn", "{phone=+79996665547}"},
            {12, "Mmm N.O.", "github.com/mmmno", "{tg=@mmmno}"},
            {13, "Nnn O.P.", "github.com/nnnop", "{email=nnnop@mail.ru}"},
            {14, "Ooo P.Q.", "github.com/ooopq", "{phone=+79996665548}"},
            {15, "Ppp Q.R.", "github.com/pppqr", "{tg=@pppqr}"},
            {16, "Qqq R.S.", "github.com/qqqrs", "{email=qqqrs@mail.ru}"},
            {17, "Rrr S.T.", "github.com/rrrst", "{phone=+79996665549}"},
            {18, "Sss T.U.", "github.com/ssstu", "{tg=@ssstu}"},
            {19, "Ttt U.V.", "github.com/tttuv", "{email=tttuv@mail.ru}"},
            {20, "Uuu V.W.", "github.com/uuuww", "{phone=+79996665550}"},
            {21, "Vvv W.X.", "github.com/vvvwx", "{tg=@vvvwx}"},
            {22, "Www X.Y.", "github.com/wwwxy", "{email=wwwxy@mail.ru}"},
            {23, "Xxx Y.Z.", "github.com/xxxyz", "{phone=+79996665551}"},
    };
    public Object[] columnsNames = {"ID","SurnameIN", "GitHub", "Contact"};
    private int clickCount = 0;
    private int lastSortedColumn = -1;

    public MainTable(){
        this.tableModel = new DefaultTableModel(dataHard,columnsNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.setFillsViewportHeight(true);
        this.setModel(this.tableModel);
        Font font = new Font("Arial", Font.PLAIN, 16);
        this.setFont(font);
        this.setRowHeight(30);
        this.getTableHeader().setFont(font);
        // Установка рендерера для центрирования текста
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Центрирование текста
        // Применяем рендерер ко всем столбцам
        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        // Добавление TableRowSorter для управления сортировкой
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(this.tableModel);
        this.setRowSorter(sorter);
        this.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = MainTable.this.columnAtPoint(e.getPoint());
                // Проверяем, был ли нажат тот же столбец
                if (MainTable.this.lastSortedColumn == column) {
                    MainTable.this.clickCount +=1;
                } else {
                    MainTable.this.clickCount = 1; // Сбрасываем счетчик
                    MainTable.this.lastSortedColumn = column; // Запоминаем новый столбец
                }
                // Сортируем или сбрасываем сортировку
                if (MainTable.this.clickCount == 3) {
                    MainTable.this.setRowSorter(null); // Сброс сортировки
                    MainTable.this.setRowSorter(new TableRowSorter<>(MainTable.this.tableModel)); // Установить сортировщик снова
                    MainTable.this.clickCount = 0; // Сбрасываем счетчик
                    MainTable.this.lastSortedColumn = -1; // Сбрасываем последний отслеживаемый столбец
                }
            }
        });
    }
}