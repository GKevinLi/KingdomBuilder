import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameScreenPanel extends JPanel implements MouseListener {
    //
    private BufferedImage background, boat, field, horse, house, oasis, stonehenge, tavern, tower;
    private int currentPlayer;
    private ArrayList<BoardSector> boards;
    private Tile[][] b1 = {{new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Flower")},
            {new Tile("Grass"), new Tile("Flower"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Grass"), new Tile("Flower"), new Tile("Flower"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Mountain"), new Tile("Flower"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Flower"), new SpecialTile("Castle"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Grass"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Water"), new Tile("Water"), new SpecialTile("Oasis", new ActionToken("1")), new Tile("Canyon"), new Tile("Mountain"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Desert"), new SpecialTile("Castle"), new Tile("Grass"), new Tile("Water"), new Tile("Mountain"), new Tile("Water"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
    };
    public GameScreenPanel()
    {
        //needs to be updated with turn logic is done

        currentPlayer = 1;
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
        drawMap(g);
        drawObjective(g);
        g.drawImage(tower, 0, 0, 400, 400, null);
    }

    public void drawGameScreen(Graphics g)
    {
        //when turn logic is done, the currentPlayer will have a highlighted box
        Color transGrey = new Color(192, 192, 192, 95);
        Color transWhite = new Color(255, 255, 255, 95);
        Color transBlack = new Color(0, 0, 0, 95);
        Color transOrange = new Color(255, 128, 0, 95);
        Color transBlue = new Color(0, 102, 204, 95);
        Color orange = new Color(255, 128, 0);
        Color blue = new Color(0, 102, 204);

        g.setColor(transGrey);
        g.fillRect(getWidth()/160, getHeight()/40, 350, 278);
        g.fillRect(getWidth()/4+getWidth()/100, getHeight()/40, 350, 278);
        g.fillRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, 350, 278);
        g.fillRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, 350, 278);

        g.setColor(Color.white);
        g.setFont(new Font("Helvetica", Font.PLAIN, 25));
        g.drawString(" PLAYER 1", getWidth()/160, getHeight()/16);
        g.setColor(Color.black);
        g.drawString(" PLAYER 2", getWidth()/4+getWidth()/100, getHeight()/16);
        g.setColor(orange);
        g.drawString(" PLAYER 3", getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/16);
        g.setColor(blue);
        g.drawString(" PLAYER 4", getWidth()-getWidth()/4+getWidth()/200, getHeight()/16);

        if(currentPlayer == 1)
        {
            g.setColor(transWhite);
            g.fillRect(getWidth()/160, getHeight()/40, 350, 278);
            g.setColor(Color.white);
            g.drawRect(getWidth()/160, getHeight()/40, 350, 278);
            //g.setColor(Color.black);
            g.drawString(" PLAYER 1", getWidth()/160, getHeight()/16);
        }
        else if(currentPlayer == 2)
        {
            g.setColor(transBlack);
            g.fillRect(getWidth()/4+getWidth()/100, getHeight()/40, 350, 278);
            g.setColor(Color.black);
            g.drawRect(getWidth()/4+getWidth()/100, getHeight()/40, 350, 278);
            //g.setColor(Color.white);
            g.drawString(" PLAYER 2", getWidth()/4+getWidth()/100, getHeight()/16);
        }
        else if(currentPlayer == 3)
        {
            g.setColor(transOrange);
            g.fillRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, 350, 278);
            g.setColor(orange);
            g.drawRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, 350, 278);
            g.drawString(" PLAYER 3", getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/16);
        }
        else if(currentPlayer == 4)
        {
            g.setColor(transBlue);
            g.fillRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, 350, 278);
            g.setColor(blue);
            g.drawRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, 350, 278);
            g.drawString(" PLAYER 4", getWidth()-getWidth()/4+getWidth()/200, getHeight()/16);
        }

        //back of the card
        g.setColor(Color.white);
        g.fillRect(1360, 434, 198, 356);
    }

    public void drawMap(Graphics g)
    {
        g.setColor(Color.gray);
        g.fillRect(getWidth()/27, getHeight()/40+300, 505, 505);
    }

    public void drawObjective(Graphics g)
    {
        g.setColor(Color.black);
        g.setFont(new Font("Helvetica", Font.PLAIN, 40));
        g.drawString("OBJECTIVES", getWidth()/2+getWidth()/32, getHeight()/2+getHeight()/16);

        g.fillRect(getWidth()/3+getWidth()/16, getHeight()/2 + getHeight()/8, 188, 290);
        g.fillRect(getWidth()/2 + getWidth()/24, getHeight()/2 + getHeight()/8, 188, 290);
        g.fillRect(getWidth() - (10*(getHeight()/16)), getHeight()/2 + getHeight()/8, 188, 290);//
    }

    public void drawActionTokens(Graphics g)
    {

    }

    public void drawTerrainCards(Graphics g)
    {

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
