package src.Window;

import javax.swing.*;
import java.awt.*;

public class Table extends JPanel {
    public Table(){
        GridLayout layout =new GridLayout(1,5);
        layout.setHgap(30);
        this.setLayout(layout);
        SurnameIN surnameIn = new SurnameIN();
        this.add(surnameIn);
        Contact git = new Contact("Github");
        this.add(git);
        Contact email = new Contact("Email");
        this.add(email);
        Contact phone = new Contact("Telegram");
        this.add(phone);
        Contact tg = new Contact("Phone");
        this.add(tg);
    }
}