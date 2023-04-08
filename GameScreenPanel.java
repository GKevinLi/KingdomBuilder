import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
public class GameScreenPanel extends JPanel implements MouseListener {
    //
    private BufferedImage background, boat, field, horse, house, oasis, stonehenge, tavern, tower;
    private int currentPlayer;
    public GameScreenPanel()
    {
        //needs to be updated with turn logic is done
        currentPlayer = 4;
        try {
            background = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/photo-1434725039720-aaad6dd32dfe.jpg"));
            boat = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/BOAT (2).png"));
            field = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/FieldCard.png"));
            horse = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/horses-removebg-preview.png"));
            house = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/House.png"));
            oasis = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/oasis-removebg-preview.png"));
            stonehenge = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/stonehenge-removebg-preview.png"));
            tavern = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/TAVERN (2).png"));
            tower = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/tower-removebg-preview.png"));
        }
        catch (Exception E)
        {
            System.out.println("error");
            return;
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        drawGameScreen(g);
        g.drawImage(tower, 0, 0, 400, 400, null);
    }

    public void drawGameScreen(Graphics g)
    {
        //when turn logic is done, the currentPlayer will have a highlighted box
        Color transWhite = new Color(255, 255, 255, 60);
        Color transBlack = new Color(0, 0, 0, 60);
        Color transOrange = new Color(255, 128, 0, 60);
        Color transBlue = new Color(0, 102, 204, 60);
        Color orange = new Color(255, 128, 0);
        Color blue = new Color(0, 102, 204);

        g.setColor(transWhite);
        g.fillRect(getWidth()/160, getHeight()/40, 350, 278);
        g.setColor(transBlack);
        g.fillRect(getWidth()/4+getWidth()/100, getHeight()/40, 350, 278);
        g.setColor(transOrange);
        g.fillRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, 350, 278);
        g.setColor(transBlue);
        g.fillRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, 350, 278);

        g.setColor(transBlack);
        g.setFont(new Font("Helvetica", Font.PLAIN, 25));
        g.drawString(" PLAYER 1", getWidth()/160, getHeight()/16);
        g.setColor(transWhite);
        g.drawString(" PLAYER 2", getWidth()/4+getWidth()/100, getHeight()/16);
        g.setColor(orange);
        g.drawString(" PLAYER 3", getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/16);
        g.setColor(blue);
        g.drawString(" PLAYER 4", getWidth()-getWidth()/4+getWidth()/200, getHeight()/16);

        if(currentPlayer == 1)
        {
            g.setColor(new Color(255, 255, 255, 95));
            g.fillRect(getWidth()/160, getHeight()/40, 350, 278);
            g.setColor(Color.white);
            g.drawRect(getWidth()/160, getHeight()/40, 350, 278);
            g.setColor(Color.black);
            g.drawString(" PLAYER 1", getWidth()/160, getHeight()/16);
        }
        else if(currentPlayer == 2)
        {
            g.setColor(new Color(0, 0, 0, 95));
            g.fillRect(getWidth()/4+getWidth()/100, getHeight()/40, 350, 278);
            g.setColor(Color.black);
            g.drawRect(getWidth()/4+getWidth()/100, getHeight()/40, 350, 278);
            g.setColor(Color.white);
            g.drawString(" PLAYER 2", getWidth()/4+getWidth()/100, getHeight()/16);
        }
        else if(currentPlayer == 3)
        {
            g.setColor(new Color(255, 128, 0, 95));
            g.fillRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, 350, 278);
            g.setColor(orange);
            g.drawRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, 350, 278);
            g.drawString(" PLAYER 3", getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/16);
        }
        else if(currentPlayer == 4)
        {
            g.setColor(new Color(0, 102, 204, 95));
            g.fillRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, 350, 278);
            g.setColor(blue);
            g.drawRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, 350, 278);
            g.drawString(" PLAYER 4", getWidth()-getWidth()/4+getWidth()/200, getHeight()/16);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
