import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;

public class StartScreenPanel extends JPanel{
    private BufferedImage background, title;
    private GameScreenPanel game = new GameScreenPanel();
    private String state;
    public StartScreenPanel()
    {
        state = "start";
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

        if(state == "start")
        {
            g.drawImage(background, 0,0,getWidth(),getHeight(),null);
            showStartingScreen(g);
        }
        else if(state == "rules")
        {
            showRules();
        }
        else if(state == "Game")
        {
            Frame f = new Frame("Kingdom Builder", "game");
            System.out.println("got here");
        }
    }

    public void showRules(){

    }


    public void showStartingScreen(Graphics g)
    {
        Rectangle2D play = new Rectangle2D.Double(getWidth()/3, getHeight()/4, 325.0, 125.0);
        g.drawImage(title, getWidth()/3 - getHeight()/40, getHeight()/16, null);
        g.setColor(Color.lightGray);
        g.fillRect(getWidth()/2 - 162, getHeight()/3, 325, 125);
        g.fillRect(getWidth()/2 - 162, getHeight()/2 + getHeight()/20, 325, 125);
        g.setColor(Color.white);
        g.setFont(new Font("Helvetica", Font.BOLD, 100));
        g.drawString("PLAY", getWidth()/2-135, getHeight()/3+getHeight()/10 + 20);
       //g.drawString("RULES", getWidth()/2 - 162, getHeight()/2 ;
        System.out.println(getWidth());
        System.out.println(getHeight());
    }

   public void setState(String s) {
        state = s;
   }
   public String getState() {
        return state;
   }
}
