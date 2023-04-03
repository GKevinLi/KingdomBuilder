import java.awt.*;
import javax.swing.*;
public class JFrame extends javax.swing.JFrame {
    final int WIDTH = 1600;
    final int LENGTH = 800;
    public JFrame(String name)
    {
        super(name);
        setSize(WIDTH, LENGTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add(new JPanel());
        setVisible(true);
    }
}
