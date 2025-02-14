package src.Window;

import javax.swing.*;
import java.awt.*;

public class Tabl extends JPanel {
    public Tabl(){
        super(new BorderLayout());
        this.add(new Table(), BorderLayout.NORTH);
    }
}