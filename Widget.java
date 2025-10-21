package independent_clocks;

import javax.swing.*;
import java.util.Observer;

public abstract class Widget implements Observer {
    protected JPanel panel;

    public void show() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
