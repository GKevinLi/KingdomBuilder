import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Frame extends JFrame {
    final int WIDTH = 1600;
    final int LENGTH = 800;
    private BufferedImage coolScreen;
    public Frame(String name)
    {

        super(name);
        try {
            coolScreen = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/image (5).png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setSize(WIDTH, LENGTH);
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        StartScreenPanel s = new StartScreenPanel();

        //setMinimumSize(new Dimension(1000,600));
        GameScreenPanel g = new GameScreenPanel();
        EpicMouseListener e = new EpicMouseListener(g,s);
        g.addMouseListener(e);
        s.addMouseListener(e);
        add(s);
        add(g);
 //       EpicMouseListener e = new EpicMouseListener(g,s);
 //       g.addMouseListener(e);
//        s.addMouseListener(e);
        //add(g);
//        add(s);
        setIconImage(coolScreen);
        setVisible(true);
    }
}

