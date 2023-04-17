import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameScreenPanel extends JPanel implements MouseListener {
    //
    private BufferedImage background, boat, field, horse, house, oasis, stonehenge, tower, tavern, board1, board2, board3, board4, board5, board6, board7, board8, blueHouse, greenHouse, yellowHouse, orangeHouse;
    private BufferedImage cardBack, knights, miners, discoverers, citizens, farmers, fisherman, hermits, worker, grasslandTerrain, flowerTerrain, forestTerrain, canyonTerrain, desertTerrain;
    private int currentPlayer;
    BufferedImage joinedImg;
    private ArrayList<BoardSector> boards;
    private FullBoard b;
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
    private Tile[][] b2 = {{new Tile("Flower"), new Tile("Desert"), new Tile("Desert"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Mountain")},
            {new Tile("Water"), new Tile("Water"), new Tile("Flower"), new SpecialTile("Castle"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Mountain"), new Tile("Mountain")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Water"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Canyon")},
            {new Tile("Flower"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Water"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Desert"), new Tile("Flower"), new SpecialTile("Oasis", new ActionToken("1")), new Tile("Canyon"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new SpecialTile("Oasis", new ActionToken("1")), new Tile("Canyon"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass")},
    };
    private Tile[][] b3 = {{new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new SpecialTile("Paddock", new ActionToken("2")), new Tile("Flower")},
            {new Tile("Mountain"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Water"), new Tile("Mountain"), new Tile("Desert"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Canyon"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Canyon"), new SpecialTile("Paddock", new ActionToken("2")), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new SpecialTile("Castle"), new Tile("Grass"), new Tile("Flower"), new Tile("Grass"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest")},
    };

    private FullBoard f;
    public GameScreenPanel()
    {

        //needs to be updated with turn logic is done
        boards = new ArrayList<>();
        b = new FullBoard();

        //hi
        currentPlayer = 1;
        //boards.add(new BoardSector())
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

            cardBack = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/back of card.png"));
            knights = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KnightsObjective (1).png"));
            miners = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/MinersObjective (1).png"));
            discoverers = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/DiscoverersObjective (1).png"));
            citizens = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Citizens Objective.png"));
            farmers = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Farmers Objective.png"));
            hermits = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Hermits Objective.png"));
            worker = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Worker Objective.png"));

            blueHouse = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/image (2).png"));
            greenHouse = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/image (3).png"));
            yellowHouse = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/image (4).png"));
            orangeHouse = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/image (5).png"));

            grasslandTerrain = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Grassland Terrain.png"));
            flowerTerrain = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Flower Terrain.png"));
            canyonTerrain = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Canyon Terrain.png"));
            desertTerrain = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Desert Terrain.png"));
            forestTerrain = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Forest Terrain.png"));

            board1 = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Board4 (1).png"));
            board2 = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/1.png"));

        }
        catch (Exception E)
        {
            System.out.println("error");
            return;
        }
        boards.add(new BoardSector(b1, board1));
        boards.add(new BoardSector(b1, board1));
        boards.add(new BoardSector(b1, board1));
        boards.add(new BoardSector(b1, board1));
        boards.add(new BoardSector(b2, board2));
        boards.add(new BoardSector(b2, board2));
        boards.add(new BoardSector(b2, board2));
        boards.add(new BoardSector(b2, board2));
        for(int i = 0; i < 4; i++) {
            BoardSector temp = (boards.get((int)(Math.random() * boards.size())));
            b.addBoard(temp);
            boards.remove(temp);
        }
        BufferedImage temp = joinBufferedImage(b.getBoards().get(0).getImg(), b.getBoards().get(1).getImg());
        BufferedImage temp2 = joinBufferedImage(b.getBoards().get(2).getImg(), b.getBoards().get(3).getImg());
        joinedImg = joinBufferedImage2(temp, temp2);
        b.makeCombinedBoard();

        Tile[][] combinedBoard = b.getCombinedBoard();
        double Ydiff = (getHeight() - (getHeight() / 13)-(getHeight()/3 - getHeight()/30)) / 20;
        double Xdiff = (((double)getWidth() / 3) + ((double)getWidth() / 50)) / 20;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                ArrayList<Tile> t = new ArrayList<>();
                if(i - 1 >= 0) {
                    t.add(combinedBoard[i-1][j]);
                }
                if(i + 1 < 20) {
                    t.add(combinedBoard[i+1][j]);
                }
                if(j + 1 < 20) {
                    t.add(combinedBoard[i][j+1]);
                }
                if(j - 1 >= 0) {
                    t.add(combinedBoard[i][j-1]);
                }
                if(i - 1 >= 0 && j - 1 >= 0) {
                    t.add(combinedBoard[i-1][j-1]);
                }
                if(i + 1 < 20 && j - 1 >= 0) {
                    t.add(combinedBoard[i+1][j-1]);
                }
                combinedBoard[i][j].setAdjacentTiles(t);

            }
        }


    }

    public void paint(Graphics g)
    {
        System.out.println(getWidth() + " " + getHeight());
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        drawGameScreen(g);
        drawMap(g);
        drawObjective(g);
        setPositions(g);

        //drawObjective(g);
        //g.drawImage(grasslandTerrain, 0, 0, 117, 163, null);
    }
    public void setPositions(Graphics g) {
    	Tile[][] combinedBoard = b.getCombinedBoard();
    	double Ydiff = ((double)getHeight() - ((double)getHeight() / 13)-((double)getHeight()/3 - (double)getHeight()/45)) / 20;
        double Xdiff = (((double)getWidth() / 3) + ((double)getWidth() / 115)) / 20;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
            	combinedBoard[i][j].setY((int) ((getHeight()/3 - getHeight()/24) + ((i+1) * Ydiff)));

                if(i % 2 != 0) {
                	combinedBoard[i][j].setX((int) (((16 * ((double)getWidth() / 1600))) + ((j+0.5) * Xdiff) + (Xdiff / 2)));
                }
                else {
                	combinedBoard[i][j].setX((int) (((16 * ((double)getWidth() / 1600))) + ((j+0.5) * Xdiff)));
                }
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(2));
                g.drawLine(combinedBoard[i][j].getX(), combinedBoard[i][j].getY(), combinedBoard[i][j].getX(), combinedBoard[i][j].getY());

            }

        }
    }
    public void drawGameScreen(Graphics g)
    {
        //when turn logic is done, the currentPlayer will have a highlighted box
        Color transGrey = new Color(192, 192, 192, 95);
        Color transYellow = new Color(255, 255, 102, 95);
        Color transGreen = new Color(0, 204, 0, 95);
        Color transOrange = new Color(255, 128, 0, 95);
        Color transBlue = new Color(0, 102, 204, 95);
        Color orange = new Color(255, 128, 0);
        Color blue = new Color(0, 102, 204);

        g.setColor(orange);
        g.setFont(new Font("Helvetica", Font.PLAIN, getWidth()/64));
        g.drawString(" PLAYER 1", getWidth()/160, getHeight()/16);
        g.setColor(Color.yellow);
        g.drawString(" PLAYER 2", getWidth()/4+getWidth()/100, getHeight()/16);
        g.setColor(Color.green);
        g.drawString(" PLAYER 3", getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/16);
        g.setColor(blue);
        g.drawString(" PLAYER 4", getWidth()-getWidth()/4+getWidth()/200, getHeight()/16);

        if(currentPlayer == 1)
        {
            g.setColor(transOrange);
            g.fillRect(getWidth()/160, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.setColor(orange);
            g.drawRect(getWidth()/160, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.drawString(" PLAYER 1", getWidth()/160, getHeight()/16);

            g.setColor(transGrey);
            g.fillRect(getWidth()/4+getWidth()/100, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.fillRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.fillRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
        }
        else if(currentPlayer == 2)
        {
            g.setColor(transYellow);
            g.fillRect(getWidth()/4+getWidth()/100, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.setColor(Color.yellow);
            g.drawRect(getWidth()/4+getWidth()/100, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.drawString(" PLAYER 2", getWidth()/4+getWidth()/100, getHeight()/16);

            g.setColor(transGrey);
            g.fillRect(getWidth()/160, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.fillRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.fillRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
        }
        else if(currentPlayer == 3)
        {
            g.setColor(transGreen);
            g.fillRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.setColor(Color.green);
            g.drawRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.drawString(" PLAYER 3", getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/16);

            g.setColor(transGrey);
            g.fillRect(getWidth()/160, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.fillRect(getWidth()/4+getWidth()/100, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.fillRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
        }
        else if(currentPlayer == 4)
        {
            g.setColor(transBlue);
            g.fillRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.setColor(blue);
            g.drawRect(getWidth()-getWidth()/4+getWidth()/200, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.drawString(" PLAYER 4", getWidth()-getWidth()/4+getWidth()/200, getHeight()/16);

            g.setColor(transGrey);
            g.fillRect(getWidth()/160, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.fillRect(getWidth()/4+getWidth()/100, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
            g.fillRect(getWidth()/2+getWidth()/160+getWidth()/800, getHeight()/40, (getWidth()/4)-(getWidth()/32), (getHeight()/4 + getHeight()/10)/4*3);
        }

        //change number when getHouse() is done
        g.setColor(Color.black);
        g.drawImage(orangeHouse, getWidth()/80 + getWidth()/200, getHeight()/10, getWidth()/40, getHeight()/20, null);
        g.drawString("= 40", getWidth()/20 + getWidth()/200, (getHeight()/8) + (getHeight()/80));
        g.drawImage(yellowHouse, getWidth()/4 + getWidth()/80 + getWidth()/400, getHeight()/10, getWidth()/40, getHeight()/20, null);
        g.drawString( "= 40", getWidth()/4 + getWidth()/20 + getWidth()/400, (getHeight()/8) + (getHeight()/80));
        g.drawImage(greenHouse, getWidth()/2 + getWidth()/80, getHeight()/10, getWidth()/40, getHeight()/20, null);
        g.drawString("= 40", getWidth()/2 + getWidth()/20, (getHeight()/8) + (getHeight()/80));
        g.drawImage(blueHouse, getWidth() - (getWidth()/4) + getWidth()/100, getHeight()/10, getWidth()/40, getHeight()/20, null);
        g.drawString("= 40", getWidth() - (getWidth()/4) + getWidth()/100 + getWidth()/32 + getWidth()/100, (getHeight()/8) + (getHeight()/80));

        //back of the card
        g.setColor(Color.white);
        g.drawImage(cardBack, 1662, getHeight()/2 + getHeight()/8, 188, 290, null);
    }

    public void drawMap(Graphics g)
    {
//        g.drawImage(b.getBoards().get(0).getImg(), getWidth()/97, getHeight()/40+300,202, 202, null);
//        g.drawImage(b.getBoards().get(1).getImg(), getWidth()/97, getHeight()/40+502,202, 202, null);
//        g.drawImage(b.getBoards().get(2).getImg(), getWidth()/97 + 202, getHeight()/40+300,202, 202, null);
//        g.drawImage(b.getBoards().get(2).getImg(), getWidth()/97 + 202, getHeight()/40+502,202, 202, null);

//        g.drawImage(b.getBoards().get(0).getImg(), getWidth()/32 + getWidth()/160, getHeight()/2 - getHeight()/40,(3*getWidth()/16) + getWidth()/80 + getWidth()/320, getHeight()/2 - (3*getHeight()/32), null);
//        g.drawImage(b.getBoards().get(1).getImg(), getWidth()/32 + getWidth()/160, getHeight() - getHeight()/8 + getHeight()/160,(3*getWidth()/16) + getWidth()/80 + getWidth()/320, getHeight()/2 - (3*getHeight()/32), null);
//        g.drawImage(b.getBoards().get(2).getImg(), getWidth()/4 + getWidth()/40 + getWidth()/320, getHeight()/2 - getHeight()/40,(3*getWidth()/16) + getWidth()/80 + getWidth()/320, getHeight()/2 - (3*getHeight()/32), null);
//        g.drawImage(b.getBoards().get(2).getImg(), getWidth()/4 + getWidth()/40 + getWidth()/320, getHeight() - getHeight()/8 + getHeight()/160,(3*getWidth()/16) + getWidth()/80 + getWidth()/320, getHeight()/2 - (3*getHeight()/32), null);
//getHeight()/30 - getHeight()/17
    	//System.out.println("W" + getWidth());
    	//System.out.println("H" + getHeight());
    	//drawScaledImage(b.getBoards().get(0).getImg(), g);
    	g.drawImage(joinedImg, getWidth() / 100, (getHeight() / 3) - (getHeight() / 30), 571, 731 + (getHeight() / 3) - (getHeight() / 30), 0, 0, (int)((double)1200 / ((double)getWidth() / 1600)), (int)((double)1500 / ((double)getHeight() / 800)), null);
    	for(int i = 0; i < 20; i++) {
    		//double i = 27; i < 520; i += 25.8
    		g.drawOval((int)(i * (26.9 * ((double)getWidth() / 1600)))+getWidth() / 100, getHeight()/3 - getHeight()/37 , (int)(26 * ((double)getWidth() / 1600)), (int)(26 * ((double)getHeight() / 800)));
    	}
    	for(int i = 0; i < 20; i++) {
    		//double i = 27; i < 520; i += 25.8
    		g.drawOval((int)(i * (26.9 * ((double)getWidth() / 1600)))+getWidth() / 56, getHeight()/3 + getHeight()/150 , (int)(26 * ((double)getWidth() / 1600)), (int)(26 * ((double)getHeight() / 800)));
    	}
    	g.drawRect((int)((16 * ((double)getWidth() / 1600))), getHeight()/3 - getHeight()/30, (getWidth() / 3) +(getWidth() / 50) , getHeight() - (getHeight() / 13)-(getHeight()/3 - getHeight()/30));
    	//for(double i = 40; i < 550; i += 25.8) {
    		//g.drawOval((int)i-13, 295-13, 26, 26);
    	//}
    	//g.drawImage(b.getBoards().get(1).getImg(), getWidth() / 100, (getHeight() / 2) + (getHeight() / 10), 310, 750, 0, 0, (int)((double)620 / ((double)getWidth() / 1600)), (int)((double)620 / ((double)getHeight() / 800)), null);
    	//System.out.println((26 * ((double)getWidth() / 1600)));


        //g.drawImage(b.getBoards().get(0).getImg(), getWidth()/(getWidth()/114), (getHeight()/5) + (getHeight()/6),getWidth()/(getWidth()/325), getHeight()/(getHeight()/325), null);
        //g.drawImage(b.getBoards().get(1).getImg(), getWidth()/(getWidth()/114), (10*(getHeight()/30))+(getHeight()/34) + getHeight()/(getHeight()/325),getWidth()/(getWidth()/325), getHeight()/(getHeight()/325), null);
        //g.drawImage(b.getBoards().get(2).getImg(), getWidth()/(getWidth()/415), (getHeight()/5) + (getHeight()/6),getWidth()/(getWidth()/325), getHeight()/(getHeight()/325), null);
        //g.drawImage(b.getBoards().get(2).getImg(), getWidth()/(getWidth()/415), (10*(getHeight()/30))+(getHeight()/34)+getHeight()/(getHeight()/325),getWidth()/(getWidth()/325), getHeight()/(getHeight()/325), null);
        //g.setColor(Color.gray);




        //g.fillRect(getWidth()/27, getHeight()/40+300, 505, 505);
    }
    public void drawScaledImage(Image image, Graphics g) {
        int imgWidth = image.getWidth(null);
        int imgHeight = image.getHeight(null);

        double imgAspect = (double) imgHeight / imgWidth;

        int canvasWidth = getWidth()/3;
        int canvasHeight = getHeight()/3;

        double canvasAspect = (double) canvasHeight / canvasWidth;

        int x1 = 0; // top left X position
        int y1 = 0; // top left Y position
        int x2 = 0; // bottom right X position
        int y2 = 0; // bottom right Y position

        if (imgWidth < canvasWidth && imgHeight < canvasHeight) {
            // the image is smaller than the canvas
            x1 = (canvasWidth - imgWidth);
            y1 = (canvasHeight - imgHeight);
            x2 = imgWidth + x1;
            y2 = imgHeight + y1;

        } else {
            if (canvasAspect > imgAspect) {
                y1 = canvasHeight;
                // keep image aspect ratio
                canvasHeight = (int) (canvasWidth * imgAspect);
                y1 = (y1 - canvasHeight) / 2;
            } else {
                x1 = canvasWidth;
                // keep image aspect ratio
                canvasWidth = (int) (canvasHeight / imgAspect);
                x1 = (x1 - canvasWidth) / 2;
            }
            x2 = canvasWidth + x1;
            y2 = canvasHeight + y1;
        }

        g.drawImage(image, x1-100, y1 + 300, x2 -100 , y2 + 300, 0 ,0 ,imgWidth, imgHeight, null);
    }
    public void drawObjective(Graphics g)
    {
        g.setColor(Color.black);
        g.setFont(new Font("Helvetica", Font.PLAIN, 40));
        g.drawString("OBJECTIVES", getWidth()/2+getWidth()/32, getHeight()/2+getHeight()/16);

        g.fillRect(getWidth()/3+getWidth()/16, getHeight()/2 + getHeight()/8, 188, 290);
        g.fillRect(getWidth()/2 + getWidth()/24, getHeight()/2 + getHeight()/8, 188, 290);
        g.fillRect(getWidth() - (10*(getHeight()/16)), getHeight()/2 + getHeight()/8, 188, 290);

        g.drawImage(knights, getWidth() - (10*(getHeight()/16)), getHeight()/2 + getHeight()/8, 188, 290, null);
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
    public static BufferedImage joinBufferedImage(BufferedImage img1,
    	      BufferedImage img2) {
    	    int offset = -29;
    	    int width = img1.getWidth() + img2.getWidth() + offset;
    	    int height = Math.max(img1.getHeight(), img2.getHeight());
    	    BufferedImage newImage = new BufferedImage(width, height,
    	        BufferedImage.TYPE_INT_ARGB);
    	    Graphics2D g2 = newImage.createGraphics();
    	    Color oldColor = g2.getColor();
    	    g2.setPaint(Color.BLACK);
    	    //g2.fillRect(0, 0, width, height);
    	    g2.setColor(oldColor);
    	    g2.drawImage(img1, null, 0, 0);
    	    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
    	    g2.dispose();
    	    return newImage;
    	  }
    public static BufferedImage joinBufferedImage2(BufferedImage img1,
  	      BufferedImage img2) {
  	    int offset = -29;
  	    int width = Math.max(img1.getWidth(), img2.getWidth());
  	    int height = img1.getHeight() + img2.getHeight() + offset;
  	    BufferedImage newImage = new BufferedImage(width, height,
  	        BufferedImage.TYPE_INT_ARGB);
  	    Graphics2D g2 = newImage.createGraphics();
  	    Color oldColor = g2.getColor();
  	    g2.setPaint(Color.BLACK);
  	    g2.fillRect(0, 0, width, height);
  	    g2.setColor(oldColor);
  	    g2.drawImage(img1, null, 0, 0);
  	    g2.drawImage(img2, null, 0, img1.getHeight() + offset );
  	    g2.dispose();
  	    return newImage;
  	  }
    public FullBoard getBoard() {
    	return b;
    }
    public void DrawSettlementOn(Tile t, Graphics g) {
    	g.drawImage(blueHouse, t.getX()-10, t.getY()-10, t.getX() + 300, t.getY() + 300, 0, 0, (int)((double)1200 / ((double)getWidth() / 1600)), (int)((double)1500 / ((double)getHeight() / 800)), null);
    }

}
