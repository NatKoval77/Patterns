package src.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class Box extends JComboBox {
    public Box(Contact mainField){
        super(new String[]{"Yes","No"});
        this.setPreferredSize(new Dimension(100, 30));
        this.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                mainField.changeInputEnable(e.getItem() != "No");
            }
        });
    }
}
