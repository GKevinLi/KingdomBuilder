import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class StartScreenPanel extends JPanel implements MouseListener{
    private BufferedImage background;
    private int event;
    public StartScreenPanel()
    {
        event = 0;
        try
        {
            background = ImageIO.read(StartScreenPanel.class.getResource("/deez imgs/image (1).png"));
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
        g.setColor(Color.gray);
        g.fillRect(getWidth()/2, getHeight()/4, 300, 100);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}
