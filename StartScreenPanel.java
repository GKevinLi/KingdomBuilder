import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;

public class StartScreenPanel extends JPanel implements MouseListener{
    private BufferedImage background, title;
    private int event;
    public StartScreenPanel()
    {
        event = 0;
        try
        {
            background = ImageIO.read(StartScreenPanel.class.getResource("/deez imgs/image (1).png"));
            title = ImageIO.read(StartScreenPanel.class.getResource("/deez imgs/Screenshot_2023-03-30_213259-removebg-preview.png"));
        }
        catch (Exception e)
        {
            System.out.println("exception error");
            return;
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(background, 0,0,getWidth(),getHeight(),null);
        if(event == 0)
        {
            showStartingScreen(g);

        }
    }

    public void showRules()
    {
        //find good pdf

    }

    public void showStartingScreen(Graphics g)
    {
        //Graphics2D g2 = Graphics
        Rectangle2D play = new Rectangle2D.Double(getWidth()/3, getHeight()/4, 325.0, 125.0);
        g.drawImage(title, getWidth()/3 - getHeight()/40, getHeight()/16, null);
        g.setColor(Color.lightGray);
        //Rectangle2D play = new Rectangle2D.Double(getWidth()/3, getHeight()/4, 325.0, 125.0);
        //play
        g.fillRect(getWidth()/2 - 162, getHeight()/3, 325, 125);
        g.fillRect(getWidth()/2 - 162, getHeight()/2 + getHeight()/20, 325, 125);
        g.setColor(Color.white);
        g.setFont(new Font("Helvetica", Font.BOLD, 100));
        g.drawString("PLAY", getWidth()/2-162, getHeight()/3+getHeight()/10);
       //g.drawString("RULES", getWidth()/2 - 162, getHeight()/2 ;
        System.out.println(getWidth());
        System.out.println(getHeight());
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}
