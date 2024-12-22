package src.Window;

import javax.swing.*;
import java.awt.*;

public class Input extends JTextField {
    public Input() {
        super();
        this.setMargin(new Insets(5, 5, 5, 5));
        this.setFont(new Font(this.getFont().getFontName(), Font.PLAIN, 15));
    }
    public void changeEnabling(boolean enabling){
        this.setEnabled(enabling);
    }
}