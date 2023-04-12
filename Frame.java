import javax.swing.*;
public class Frame extends JFrame {
    final int WIDTH = 1600;
    final int LENGTH = 800;
    public Frame(String name)
    {
        super(name);
        setSize(WIDTH, LENGTH);
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        StartScreenPanel s = new StartScreenPanel();
        GameScreenPanel g = new GameScreenPanel();
        add(s);
        add(g);
        setVisible(true);
    }
}
