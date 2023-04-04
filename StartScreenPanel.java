import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;

public class StartScreenPanel extends JPanel implements MouseListener{
    private BufferedImage background;
    public StartScreenPanel()
    {
        try
        {
            background = ImageIO.read(StartScreenPanel.class.getResource("/deez imgs/image (1).png"));
        }
        catch (java.lang.Exception e)
        {
            System.out.println("exception error");
            return;
        }
        addMouseListener();
    }

    public void paint(Graphics g)
    {

    }

    public void showRules()
    {
        //find good pdf
    }

    public void showStartingScreen()
    {

    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}
