import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameScreenPanel extends JPanel implements MouseListener {
    //
    private BufferedImage startScreen, title, background, boat, field, horse, house, oasis, stonehenge, tower, tavern, board1, board2, board3, board4, board5, board6, board7, board8, blueHouse, greenHouse, yellowHouse, orangeHouse, highlight, barnIcon, cityIcon, farmIcon, harborIcon, oasisIcon, oracleIcon, paddockIcon, tavernIcon, towerIcon;
    private BufferedImage cardBack, knights, miners, discoverers, citizens, farmers, fisherman, hermits, worker, grasslandTerrain, flowerTerrain, forestTerrain, canyonTerrain, desertTerrain;
    private int currentPlayer, panelNumber, displayRules;
    private ArrayList<Player> players;
    private Tile paddockUsing;
    BufferedImage joinedImg;
    private ArrayList<BoardSector> boards;
    private ArrayList<TerrainCard> discardPile;
    private TerrainDeck d;
    private Tile[][] combinedBoard;
    private boolean isPlacingSettlements;
    private String specialActionUsed;
    private boolean usingSpecialAction;
    private boolean usingSpecialAction2;
    private ObjectiveDeck obj;
    private ObjectiveCard ob1;
    private ObjectiveCard ob2;
    private ObjectiveCard ob3;
    private FullBoard b;
    private String state;
    private Tile[][] b1 = {{new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Flower")},
            {new Tile("Grass"), new Tile("Flower"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Grass"), new Tile("Flower"), new Tile("Flower"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Mountain"), new Tile("Flower"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Flower"), new SpecialTile("Castle"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Grass"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Water"), new Tile("Water"), new SpecialTile("Harbor", new ActionToken("Harbor", 1)), new Tile("Canyon"), new Tile("Mountain"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Desert"), new SpecialTile("Castle"), new Tile("Grass"), new Tile("Water"), new Tile("Mountain"), new Tile("Water"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
    };
    private Tile[][] b2 = {{new Tile("Flower"), new Tile("Desert"), new Tile("Desert"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Mountain")},
            {new Tile("Water"), new Tile("Water"), new Tile("Flower"), new SpecialTile("Castle"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Mountain"), new Tile("Mountain")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Water"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Canyon")},
            {new Tile("Flower"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Water"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Desert"), new Tile("Flower"), new SpecialTile("Tavern", new ActionToken("Tavern", 2)), new Tile("Canyon"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new SpecialTile("Tavern", new ActionToken("Tavern", 3)), new Tile("Canyon"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass")},
    };
    private Tile[][] b3 = {{new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new SpecialTile("Paddock", new ActionToken("Paddock", 4)), new Tile("Flower")},
            {new Tile("Mountain"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Water"), new Tile("Mountain"), new Tile("Desert"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Canyon"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Canyon"), new SpecialTile("Paddock", new ActionToken("Paddock", 5)), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new SpecialTile("Castle"), new Tile("Grass"), new Tile("Flower"), new Tile("Grass"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest")},
    };
    private Tile[][] b4 = {{new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Water"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Canyon"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Forest"), new Tile("Forest"), new SpecialTile("Oasis", new ActionToken("Oasis", 6)), new Tile("Flower"), new Tile("Grass")},
            {new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Flower"), new Tile("Grass"), new Tile("Forest"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Desert"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Forest"), new Tile("Canyon"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Desert"), new Tile("Canyon")},
            {new Tile("Water"), new SpecialTile("Castle"), new Tile("Canyon"), new Tile("Flower"), new Tile("Water"), new SpecialTile("Oasis", new ActionToken("Oasis", 7)), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Water")},
            {new Tile("Water"), new Tile("Water"), new Tile("Canyon"), new Tile("Flower"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Water")},
            {new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water")},
    };
    private Tile[][] b5 = {{new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Grass"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Forest"), new Tile("Mountain"), new Tile("Forest"), new Tile("Forest"), new Tile("Flower"), new Tile("Grass"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Forest"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Grass"), new Tile("Grass"), new Tile("Water"), new Tile("Mountain")},
            {new Tile("Desert"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Water"), new SpecialTile("Tower", new ActionToken("Tower", 8)), new Tile("Grass"), new Tile("Water"), new Tile("Mountain"), new Tile("Mountain")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Flower"), new Tile("Water"), new Tile("Grass"), new Tile("Water"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Desert"), new Tile("Canyon"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Water"), new Tile("Canyon"), new Tile("Grass"), new Tile("Canyon")},
            {new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Desert"), new Tile("Desert"), new Tile("Water"), new Tile("Flower"), new SpecialTile("Castle"), new Tile("Grass"), new Tile("Canyon")},
            {new Tile("Canyon"), new Tile("Canyon"),new SpecialTile("Tower", new ActionToken("Tower", 9)), new Tile("Desert"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Canyon"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Flower"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass"), new Tile("Grass")},
    };
    private Tile[][] b6 = {{new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new SpecialTile("Castle"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Flower"), new Tile("Flower"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Canyon"), new Tile("Grass"), new Tile("Forest"), new Tile("Water"), new Tile("Flower"), new SpecialTile("Oracle", new ActionToken("Oracle", 10)), new Tile("Forest"), new Tile("Forest")},
            {new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Water"), new Tile("Water")},
            {new Tile("Mountain"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Grass"), new Tile("Grass"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Grass"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Canyon"),new SpecialTile("Castle"), new Tile("Desert"), new Tile("Mountain"), new Tile("Desert"), new Tile("Flower"), new Tile("Flower"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Mountain"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon")},
    };
    private Tile[][] b7 = {{new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Water"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Desert"), new SpecialTile("Castle"), new Tile("Canyon"), new Tile("Water"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new SpecialTile("Farm", new ActionToken("Farm", 11)), new Tile("Grass"), new Tile("Grass")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Forest"), new Tile("Canyon"), new Tile("Flower"), new Tile("Flower")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Flower"), new Tile("Flower"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Flower")},
            {new Tile("Canyon"), new Tile("Grass"), new Tile("Grass"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Grass"), new Tile("Grass"), new SpecialTile("Farm", new ActionToken("Farm", 12)), new Tile("Flower"), new Tile("Water"), new Tile("Flower"), new Tile("Water"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Flower"), new Tile("Flower"), new Tile("Water"), new Tile("Water"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Mountain"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Desert"), new Tile("Water")},
            {new Tile("Grass"), new Tile("Mountain"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water")},
            {new Tile("Forest"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water"), new Tile("Water")},
    };
    private Tile[][] b8 = {{new Tile("Canyon"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon"), new Tile("Desert")},
            {new Tile("Mountain"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Desert"), new Tile("Mountain"), new Tile("Mountain"),new SpecialTile("Barn", new ActionToken("Barn", 13)), new Tile("Desert"), new Tile("Desert"), new Tile("Canyon")},
            {new Tile("Canyon"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Flower"), new Tile("Flower"), new Tile("Canyon"), new Tile("Canyon")},
            {new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Mountain"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Flower"), new Tile("Canyon")},
            {new Tile("Grass"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Canyon"), new Tile("Mountain"), new Tile("Flower"), new Tile("Flower"), new Tile("Water"), new Tile("Forest"), new Tile("Canyon")},
            {new Tile("Grass"), new Tile("Grass"), new SpecialTile("Barn", new ActionToken("Barn", 14)), new Tile("Forest"), new Tile("Flower"), new Tile("Flower"), new Tile("Water"), new Tile("Flower"), new Tile("Flower"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Flower"), new Tile("Flower"), new Tile("Grass"), new SpecialTile("Castle"), new Tile("Forest"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest")},
            {new Tile("Grass"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Water"), new Tile("Grass"), new Tile("Grass"), new Tile("Forest"), new Tile("Forest"), new Tile("Forest")},
    };

    private FullBoard f;
    public GameScreenPanel()
    {

        //needs to be updated with turn logic is done
    	specialActionUsed = "";
    	state = "Game";
        displayRules = 0;
        boards = new ArrayList<>();
        b = new FullBoard();
        d = new TerrainDeck();
        obj = new ObjectiveDeck();
        ArrayList<ObjectiveCard> temp3 = obj.get3Random();
        ob1 = temp3.get(0);
        ob2 = temp3.get(1);
        ob3 = temp3.get(2);
        //hi
        currentPlayer = 1;
        players = new ArrayList<>();
        players.add(new Player("1"));
        players.add(new Player("2"));
        players.add(new Player("3"));
        players.add(new Player("4"));
        //for(int i = 0; i < 4; i++) {
            //players.get(i).setTerrainCard(d.pickRandom());
        //}

        //boards.add(new BoardSector())
        try {
	    startScreen = ImageIO.read(StartScreenPanel.class.getResource("/deez imgs/image (1).png"));
            title = ImageIO.read(StartScreenPanel.class.getResource("/deez imgs/Screenshot_2023-03-30_213259-removebg-preview.png"));
            background = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/photo-1434725039720-aaad6dd32dfe.jpg"));
            boat = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-harbor.png"));
            field = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-farm.png"));
            horse = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-paddock.png"));
            house = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-barn.png"));
            oasis = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-oasis.png"));
            stonehenge = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-oracle.png"));
            tavern = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-tavern.png"));
            tower = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-tower.png"));

            barnIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-Barn.png"));
            farmIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-Farm.png"));
            cityIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-City.png"));
            harborIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-Harbor.png"));
            oasisIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-Oasis.png"));
            oracleIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-Oracle.png"));
            paddockIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-Paddock.png"));
            tavernIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-Tavern.png"));
            towerIcon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-Location-Tower.png"));

            cardBack = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/back of card.png"));
            knights = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KnightsObjective (1).png"));
            miners = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/MinersObjective (1).png"));
            discoverers = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/DiscoverersObjective (1).png"));
            citizens = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Citizens Objective.png"));
            farmers = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Farmers Objective.png"));
            hermits = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Hermits Objective.png"));
            worker = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Worker Objective.png"));
            fisherman = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Fisherman Objective.png"));

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
            board3 = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/2.png"));
            board4 = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/3.png"));
            board5 = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/4.png"));
            board6 = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/5.png"));
            board7 = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/6.png"));
            board8 = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/7.png"));
            highlight = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/image-removebg-preview.png"));


        }
        catch (Exception E)
        {
            System.out.println("error");
            return;
        }
        boards.add(new BoardSector(b1, board1));
        boards.add(new BoardSector(b2, board2));
        boards.add(new BoardSector(b3, board3));
        boards.add(new BoardSector(b4, board4));
        boards.add(new BoardSector(b5, board5));
        boards.add(new BoardSector(b6, board6));
        boards.add(new BoardSector(b7, board7));
        boards.add(new BoardSector(b8, board8));
        discardPile = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            BoardSector temp = (boards.get((int)(Math.random() * boards.size())));
            b.addBoard(temp);
            boards.remove(temp);
        }
        BufferedImage temp = joinBufferedImage(b.getBoards().get(0).getImg(), b.getBoards().get(2).getImg());
        BufferedImage temp2 = joinBufferedImage(b.getBoards().get(1).getImg(), b.getBoards().get(3).getImg());
        joinedImg = joinBufferedImage2(temp, temp2);
        b.makeCombinedBoard();
//hi
        combinedBoard = b.getCombinedBoard();
        double Ydiff = (getHeight() - (getHeight() / 13)-(getHeight()/3 - getHeight()/30)) / 20;
        double Xdiff = (((double)getWidth() / 3) + ((double)getWidth() / 50)) / 20;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
            	ArrayList<Tile> t = new ArrayList<>();
            	if(i % 2 == 0) {
            		
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
            	}
            	else {
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
            		if(i - 1 >= 0 && j + 1 < 20) {
            			t.add(combinedBoard[i-1][j+1]);
            		}
            		if(i + 1 < 20 && j + 1 < 20) {
            			t.add(combinedBoard[i+1][j+1]);
            		}
            	}
                combinedBoard[i][j].setAdjacentTiles(t);
               
            }
        }
        for(Tile[] t : combinedBoard) {
            for(Tile i : t) {

            }

        }
        addMouseListener(this);


    }

    public void paint(Graphics g)
    {
        //System.out.println(displayRules);
        if(state.equals("Start"))
        {
            g.drawImage(startScreen, 0,0,getWidth(),getHeight(),null);
            g.drawImage(title, getWidth()/3 - getHeight()/40, getHeight()/16, null);
            g.setColor(Color.lightGray);
            g.fillRect(getWidth()/2 - 162, getHeight()/3, 325, 125);
            g.fillRect(getWidth()/2 - 162, getHeight()/2 + getHeight()/20, 325, 125);
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", Font.BOLD, 100));
            g.drawString("PLAY", getWidth()/2-135, getHeight()/3+getHeight()/10 + 20);
            //g.drawString("RULES", getWidth()/2 - 162, getHeight()/2 ;
            //System.out.println(getWidth());
            //System.out.println(getHeight());
        }
        else if(state.equals("Game")) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            drawGameScreen(g);
            drawMap(g);
            drawObjective(g);
            drawActionTokens(g);
            drawTerrainCards(g);
            DrawAllSettlements(g);
            HighlightTiles(g);
            highlightSpecialActionTiles(g);
            setPositions(g);
            addAllSpecialTiles(g);
            displayPlayerActionTokens(players.get(0), g, 19, 113);
            displayPlayerActionTokens(players.get(1), g, 411, 113);
            displayPlayerActionTokens(players.get(2), g, 789, 113);
            displayPlayerActionTokens(players.get(3), g, 1171, 113);
            g.setColor(new Color(181, 155, 85));
            g.fillRect((10*getWidth()/24), getHeight() - getHeight()/6, getWidth()/5, (10*getHeight()/76));
            g.fillRect((3*getWidth()/4), getHeight() - getHeight()/6, getWidth()/5, (10*getHeight()/76));
            g.setColor(Color.black);
            g.setFont(new Font("Helvetica", Font.PLAIN, getHeight()/15));
            g.drawString("End Turn", (10*getWidth()/23), getHeight() - getHeight()/11);
            g.drawString("How to Play", (3*getWidth()/4), getHeight() - getHeight()/11);
        }
        else if(state.equals("End")) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            System.out.println(ob1.getObjective() + " " + players.get(0).getName() + " " + ob1.scoreCard(players.get(0), b, 0));
            System.out.println(ob1.getObjective() + " " + players.get(1).getName() + " " + ob1.scoreCard(players.get(1), b, 0));
            System.out.println(ob1.getObjective() + " " + players.get(2).getName() + " " + ob1.scoreCard(players.get(2), b, 0));
            System.out.println(ob1.getObjective() + " " + players.get(3).getName() + " " + ob1.scoreCard(players.get(3), b, 0));
            System.out.println(ob2.getObjective() + " " + players.get(0).getName() + " " + ob2.scoreCard(players.get(0), b, 0));
            System.out.println(ob2.getObjective() + " " + players.get(1).getName() + " " + ob2.scoreCard(players.get(1), b, 0));
            System.out.println(ob2.getObjective() + " " + players.get(2).getName() + " " + ob2.scoreCard(players.get(2), b, 0));
            System.out.println(ob2.getObjective() + " " + players.get(3).getName() + " " + ob2.scoreCard(players.get(3), b, 0));
            System.out.println(ob3.getObjective() + " " + players.get(0).getName() + " " + ob3.scoreCard(players.get(0), b, 0));
            System.out.println(ob3.getObjective() + " " + players.get(1).getName() + " " + ob3.scoreCard(players.get(1), b, 0));
            System.out.println(ob3.getObjective() + " " + players.get(2).getName() + " " + ob3.scoreCard(players.get(2), b, 0));
            System.out.println(ob3.getObjective() + " " + players.get(3).getName() + " " + ob3.scoreCard(players.get(3), b, 0));



            players.get(0).addScore(ob1.scoreCard(players.get(0), b, 0));

            players.get(1).addScore(ob1.scoreCard(players.get(1), b, 0));
            players.get(2).addScore(ob1.scoreCard(players.get(2), b, 0));
            players.get(3).addScore(ob1.scoreCard(players.get(3), b, 0));
            players.get(0).addScore(ob2.scoreCard(players.get(0), b, 0));
            players.get(1).addScore(ob2.scoreCard(players.get(1), b, 0));
            players.get(2).addScore(ob2.scoreCard(players.get(2), b, 0));
            players.get(3).addScore(ob2.scoreCard(players.get(3), b, 0));
            players.get(0).addScore(ob3.scoreCard(players.get(0), b, 0));
            players.get(1).addScore(ob3.scoreCard(players.get(1), b, 0));
            players.get(2).addScore(ob3.scoreCard(players.get(2), b, 0));
            players.get(3).addScore(ob3.scoreCard(players.get(3), b, 0));
            System.out.println(players.get(0).getName() + " " + players.get(0).getScore());
            System.out.println(players.get(1).getName() + " " + players.get(1).getScore());
            System.out.println(players.get(2).getName() + " " + players.get(2).getScore());
            System.out.println(players.get(3).getName() + " " + players.get(3).getScore());

        }
        if(displayRules == 1) { showRules(g);}

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
                //g.drawLine(combinedBoard[i][j].getX(), combinedBoard[i][j].getY(), combinedBoard[i][j].getX(), combinedBoard[i][j].getY());

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
         g.setFont(new Font("Helvetica", Font.PLAIN, getWidth()/68));
        g.setColor(Color.black);
        g.drawImage(orangeHouse, getWidth()/80 + getWidth()/200, getHeight()/10, getWidth()/45, getHeight()/25, null);
        g.drawString("= " + (players.get(0).getNumHouses()), getWidth()/20 + getWidth()/200, (getHeight()/8) + (getHeight()/80));
        g.drawImage(yellowHouse, getWidth()/4 + getWidth()/80 + getWidth()/400, getHeight()/10, getWidth()/45, getHeight()/25, null);
        g.drawString( "= " + (players.get(1).getNumHouses()), getWidth()/4 + getWidth()/20 + getWidth()/400, (getHeight()/8) + (getHeight()/80));
        g.drawImage(greenHouse, getWidth()/2 + getWidth()/80, getHeight()/10, getWidth()/45, getHeight()/25, null);
        g.drawString("= " + (players.get(2).getNumHouses()), getWidth()/2 + getWidth()/20, (getHeight()/8) + (getHeight()/80));
        g.drawImage(blueHouse, getWidth() - (getWidth()/4) + getWidth()/100, getHeight()/10, getWidth()/45, getHeight()/25, null);
        g.drawString("= " + (players.get(3).getNumHouses()), getWidth() - (getWidth()/4) + getWidth()/100 + getWidth()/32 + getWidth()/100, (getHeight()/8) + (getHeight()/80));


        //back of the card
        g.setColor(Color.white);
        g.drawImage(cardBack, (getWidth()/2) - (getWidth()/32) + (3*(getWidth()/8)), getHeight()/3 + getHeight()/12, getWidth()/9, getHeight()/3, null);
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
    	//for(int i = 0; i < 20; i++) {
    		//double i = 27; i < 520; i += 25.8
    		//g.drawOval((int)(i * (26.9 * ((double)getWidth() / 1600)))+getWidth() / 100, getHeight()/3 - getHeight()/37 , (int)(26 * ((double)getWidth() / 1600)), (int)(26 * ((double)getHeight() / 800)));
    	//}
    	//for(int i = 0; i < 20; i++) {
    		//double i = 27; i < 520; i += 25.8
    		//g.drawOval((int)(i * (26.9 * ((double)getWidth() / 1600)))+getWidth() / 56, getHeight()/3 + getHeight()/150 , (int)(26 * ((double)getWidth() / 1600)), (int)(26 * ((double)getHeight() / 800)));
    	//}
    	//g.drawRect((int)((16 * ((double)getWidth() / 1600))), getHeight()/3 - getHeight()/30, (getWidth() / 3) +(getWidth() / 50) , getHeight() - (getHeight() / 13)-(getHeight()/3 - getHeight()/30));
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
        BufferedImage obj1 = cardBack;
        BufferedImage obj2 = cardBack;
        BufferedImage obj3 = cardBack;
        g.setColor(Color.black);
        g.setFont(new Font("Helvetica", Font.PLAIN, getWidth()/45));
        g.drawString("OBJECTIVES", (getWidth()/2) - (getWidth()/32) + (getWidth()/9), getHeight()/3 + getHeight()/30);

        if(ob1.getObjective().equals("Lords")) {obj1 = cardBack; } //fix later
        else if(ob1.getObjective().equals("Miners")) {obj1 = miners;}
        else if(ob1.getObjective().equals("Fishermen")) {obj1 = fisherman;}
        else if(ob1.getObjective().equals("Workers")) {obj1 = worker;}
        else if(ob1.getObjective().equals("Citizens")) {obj1 = citizens;}
        else if(ob1.getObjective().equals("Hermits")) {obj1 = hermits;}
        else if(ob1.getObjective().equals("Explorers")) {obj1 = discoverers;}
        else if(ob1.getObjective().equals("Knights")) {obj1 = knights;}
        else if(ob1.getObjective().equals("Merchants")) {obj1 = cardBack;} //fix later
        else if(ob1.getObjective().equals("Farmers")) {obj1 = farmers;}

        if(ob2.getObjective().equals("Lords")) {obj2 = cardBack; } //fix later
        else if(ob2.getObjective().equals("Miners")) {obj2 = miners;}
        else if(ob2.getObjective().equals("Fishermen")) {obj2 = fisherman;}
        else if(ob2.getObjective().equals("Workers")) {obj2 = worker;}
        else if(ob2.getObjective().equals("Citizens")) {obj2 = citizens;}
        else if(ob2.getObjective().equals("Hermits")) {obj2 = hermits;}
        else if(ob2.getObjective().equals("Explorers")) {obj2 = discoverers;}
        else if(ob2.getObjective().equals("Knights")) {obj2 = knights;}
        else if(ob2.getObjective().equals("Merchants")) {obj2 = cardBack;} //fix later
        else if(ob2.getObjective().equals("Farmers")) {obj2 = farmers;}

        if(ob3.getObjective().equals("Lords")) {obj3 = cardBack; } //fix later
        else if(ob3.getObjective().equals("Miners")) {obj3 = miners;}
        else if(ob3.getObjective().equals("Fishermen")) {obj3 = fisherman;}
        else if(ob3.getObjective().equals("Workers")) {obj3 = worker;}
        else if(ob3.getObjective().equals("Citizens")) {obj3 = citizens;}
        else if(ob3.getObjective().equals("Hermits")) {obj3 = hermits;}
        else if(ob3.getObjective().equals("Explorers")) {obj3 = discoverers;}
        else if(ob3.getObjective().equals("Knights")) {obj3 = knights;}
        else if(ob3.getObjective().equals("Merchants")) {obj3 = cardBack;} //fix later
        else if(ob3.getObjective().equals("Farmers")) {obj3 = farmers;}

        g.drawImage(obj1, (getWidth()/2) - (getWidth()/32), getHeight()/3 + getHeight()/12, getWidth()/9, getHeight()/3, null);
        g.drawImage(obj2, (getWidth()/2) - (getWidth()/32) + (getWidth()/8), getHeight()/3 + getHeight()/12, getWidth()/9, getHeight()/3, null);
        g.drawImage(obj3, (getWidth()/2) - (getWidth()/32) + (2*(getWidth()/8)), getHeight()/3 + getHeight()/12, getWidth()/9, getHeight()/3, null);
    }

    public void drawActionTokens(Graphics g)
    {
//          POSITIONS ARE SAVED ON A GOOGLE DOC
	    //testing
//         g.drawImage(boat, getWidth()/90 - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/65), (3*getHeight()/16), null);
//         g.drawImage(boat, getWidth()/90 - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/14), (10*getWidth()/65), (3*getHeight()/16), null);
//         g.drawImage(boat, getWidth()/90 + getWidth()/19 - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/65), (3*getHeight()/16), null);
//         g.drawImage(boat, getWidth()/90 + getWidth()/19 - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/14), (10*getWidth()/65), (3*getHeight()/16), null);


        //FINAL + TEST CODE, DONT MESS WITH IT, I WILL END U
        ArrayList<ActionToken> test = new ArrayList<ActionToken>();
        //test.add(new ActionToken("tower"));
        //test.add(new ActionToken("tavern"));
        //test.add(new ActionToken("field"));
        //test.add(new ActionToken("boat")); //WILL BE REPLACED WITH PLAYER.GETSPECIALACTION()

        ArrayList<ActionToken> test2 = new ArrayList<ActionToken>();
        //test2.add(new ActionToken("horse"));
        //test2.add(new ActionToken("barn"));
        //test2.add(new ActionToken("oasis"));
        //test2.add(new ActionToken("oracle")); //WILL BE REPLACED WITH PLAYER.GETSPECIALACTION()

        for(int i = 0; i < test.size(); i++) //PLAYER 1
        {
            if(test.get(i).getAction().equals("horse"))
            {
                if(i == 0) { g.drawImage(horse, getWidth()/90 - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 1) { g.drawImage(horse, getWidth()/90  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/14), (10*getWidth()/63), (3*getHeight()/18), null); }
                else if(i == 2) { g.drawImage(horse, getWidth()/90 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/63), (3*getHeight()/18), null); }
                else if(i == 3) { g.drawImage(horse, getWidth()/90 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 +(2*getHeight()/14), (10*getWidth()/63), (3*getHeight()/18), null); }
            }
            else if(test.get(i).getAction().equals("field"))
            {
                if(i == 0) { g.drawImage(field, getWidth()/90, getHeight()/40 + (2*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i == 1) { g.drawImage(field, getWidth()/90, getHeight()/40 + (3*getHeight()/15),(2*getWidth()/60), getHeight()/16, null); }
                else if(i == 2) { g.drawImage(field, getWidth()/90 + getWidth()/19, getHeight()/40 + (2*getHeight()/15),(2*getWidth()/60), getHeight()/16, null); }
                else if(i == 3) { g.drawImage(field, getWidth()/90 + getWidth()/19, getHeight()/40 +(3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null); }
            }
            else if(test.get(i).getAction().equals("oasis"))
            {
                if(i==0) {g.drawImage(oasis, getWidth()/90  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==1) {g.drawImage(oasis, getWidth()/90  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==2) {g.drawImage(oasis, getWidth()/90 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==3) {g.drawImage(oasis, getWidth()/90 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/62), (3*getHeight()/21), null);}
            }
            else if(test.get(i).getAction().equals("oracle"))
            {
                if(i==0) {g.drawImage(stonehenge, getWidth()/90  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==1) {g.drawImage(stonehenge, getWidth()/90  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==2) {g.drawImage(stonehenge, getWidth()/90 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==3) {g.drawImage(stonehenge, getWidth()/90 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/20), null);}
            }
            else if(test.get(i).getAction().equals("tower"))
            {
                if(i==0) {g.drawImage(tower, getWidth()/90  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/60), (3*getHeight()/21), null);}
                else if(i==1) {g.drawImage(tower, getWidth()/90  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/21), null);}
                else if(i==2) {g.drawImage(tower, getWidth()/90 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/21), null);}
                else if(i==3) {g.drawImage(tower, getWidth()/90 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/21), null); }
            }
            else if(test.get(i).getAction().equals("tavern"))
            {
                if(i==0) {g.drawImage(tavern, getWidth()/90  - (2*getWidth()/63), getHeight()/40 + (getHeight()/12), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==1) {g.drawImage(tavern, getWidth()/90  - (2*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==2) {g.drawImage(tavern, getWidth()/90 + getWidth()/19  - (2*getWidth()/63), getHeight()/40 + (getHeight()/12), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==3) {g.drawImage(tavern, getWidth()/90 + getWidth()/19  - (2*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (6*getWidth()/59), (3*getHeight()/19), null); }
            }
            else if(test.get(i).getAction().equals("barn"))
            {
                if(i==0) {g.drawImage(house, getWidth()/86, getHeight()/40 + (2*getHeight()/16), (2*getWidth()/60), getHeight()/16, null); }
                else if(i==1) {g.drawImage(house, getWidth()/86, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==2) {g.drawImage(house, getWidth()/86 + getWidth()/19, getHeight()/40 + (2*getHeight()/16), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==3) {g.drawImage(house, getWidth()/86 + getWidth()/19, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
            }
        }

        for(int i = 0; i < test.size(); i++) //PLAYER 2
        {
            if(test.get(i).getAction().equals("horse"))
            {
                if(i == 0) { g.drawImage(horse, getWidth()/4+getWidth()/60 - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 1) { g.drawImage(horse, getWidth()/4+getWidth()/60  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/14), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 2) { g.drawImage(horse, getWidth()/4+getWidth()/60 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 3) { g.drawImage(horse, getWidth()/4+getWidth()/60 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 +(2*getHeight()/14), (10*getWidth()/63), (3*getHeight()/18), null); }
            }
            else if(test.get(i).getAction().equals("field"))
            {
                if(i == 0) { g.drawImage(field, getWidth()/4+getWidth()/60, getHeight()/40 + (2*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==1) { g.drawImage(field, getWidth()/4+getWidth()/60, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==2) { g.drawImage(field, getWidth()/4+getWidth()/60 + getWidth()/19, getHeight()/40 + (2*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==3) { g.drawImage(field, getWidth()/4+getWidth()/60 + getWidth()/19, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
            }
            else if(test.get(i).getAction().equals("oasis"))
            {
                if (i==0) { g.drawImage(oasis, getWidth()/4+getWidth()/60  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/62), (3*getHeight()/21), null); }
                else if(i==1) {g.drawImage(oasis, getWidth()/4+getWidth()/60  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==2) {g.drawImage(oasis, getWidth()/4+getWidth()/60 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/62), (3*getHeight()/21), null); }
                else if(i==3) {g.drawImage(oasis, getWidth()/4+getWidth()/60 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/62), (3*getHeight()/21), null);}
            }
            else if(test.get(i).getAction().equals("oracle"))
            {
                if(i==0) {g.drawImage(stonehenge, getWidth()/4+getWidth()/60  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==1) {g.drawImage(stonehenge, getWidth()/4+getWidth()/60  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==2) {g.drawImage(stonehenge, getWidth()/4+getWidth()/60 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==3) {g.drawImage(stonehenge, getWidth()/4+getWidth()/60 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/20), null);}
            }
            else if(test.get(i).getAction().equals("tower"))
            {
                if(i==0) {g.drawImage(tower, getWidth()/4+getWidth()/60  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/60), (3*getHeight()/21), null);}
                else if(i==1) {g.drawImage(tower, getWidth()/4+getWidth()/60  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/21), null);}
                else if(i==2) {g.drawImage(tower, getWidth()/4+getWidth()/60 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/21), null);}
                else if(i==3) {g.drawImage(tower, getWidth()/4+getWidth()/60 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/21), null); }
            }
            else if(test.get(i).getAction().equals("tavern"))
            {
                if(i==0) {g.drawImage(tavern, getWidth()/4+getWidth()/60  - (2*getWidth()/63), getHeight()/40 + (getHeight()/12), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==1) {g.drawImage(tavern, getWidth()/4+getWidth()/60  - (2*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==2) {g.drawImage(tavern, getWidth()/4+getWidth()/60 + getWidth()/19  - (2*getWidth()/63), getHeight()/40 + (getHeight()/12), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==3) {g.drawImage(tavern, getWidth()/4+getWidth()/60 + getWidth()/19  - (2*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (6*getWidth()/59), (3*getHeight()/19), null); }
            }
            else if(test.get(i).getAction().equals("barn"))
            {
                if(i==0) {g.drawImage(house, getWidth()/4+getWidth()/58, getHeight()/40 + (2*getHeight()/16), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==1) {g.drawImage(house, getWidth()/4+getWidth()/58, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==2) {g.drawImage(house, getWidth()/4+getWidth()/58 + getWidth()/19, getHeight()/40 + (2*getHeight()/16), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==3) {g.drawImage(house, getWidth()/4+getWidth()/58 + getWidth()/19, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
            }
        }

        for(int i = 0; i < test2.size(); i++) //PLAYER 3
        {
            if(test2.get(i).getAction().equals("horse"))
            {
                if(i == 0) { g.drawImage(horse, getWidth()/2+getWidth()/85 - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 1) { g.drawImage(horse, getWidth()/2+getWidth()/85  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/14), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 2) { g.drawImage(horse, getWidth()/2+getWidth()/85 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 3) { g.drawImage(horse, getWidth()/2+getWidth()/85 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 +(2*getHeight()/14), (10*getWidth()/63), (3*getHeight()/18), null); }
            }
            else if(test2.get(i).getAction().equals("field"))
            {
                if(i == 0) { g.drawImage(field, getWidth()/2+getWidth()/85, getHeight()/40 + (2*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==1) { g.drawImage(field, getWidth()/2+getWidth()/85, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==2) { g.drawImage(field, getWidth()/2+getWidth()/85 + getWidth()/19, getHeight()/40 + (2*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==3) { g.drawImage(field, getWidth()/2+getWidth()/85 + getWidth()/19, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
            }
            else if(test2.get(i).getAction().equals("oasis"))
            {
                if(i==0) {g.drawImage(oasis, getWidth()/2+getWidth()/85  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==1) {g.drawImage(oasis, getWidth()/2+getWidth()/85  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==2) {g.drawImage(oasis, getWidth()/2+getWidth()/85 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==3) {g.drawImage(oasis, getWidth()/2+getWidth()/85 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/62), (3*getHeight()/21), null);}
            }
            else if(test2.get(i).getAction().equals("oracle"))
            {
                if(i==0) {g.drawImage(stonehenge, getWidth()/2+getWidth()/85  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==1) {g.drawImage(stonehenge, getWidth()/2+getWidth()/85  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==2) {g.drawImage(stonehenge, getWidth()/2+getWidth()/85 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==3) {g.drawImage(stonehenge, getWidth()/2+getWidth()/85 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/20), null);}
            }
            else if(test2.get(i).getAction().equals("tower"))
            {
                if(i==0) {g.drawImage(tower, getWidth()/2+getWidth()/85  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/60), (3*getHeight()/21), null);}
                else if(i==1) {g.drawImage(tower, getWidth()/2+getWidth()/85  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/21), null);}
                else if(i==2) {g.drawImage(tower, getWidth()/2+getWidth()/85 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/21), null);}
                else if(i==3) {g.drawImage(tower, getWidth()/2+getWidth()/85 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/21), null); }
            }
            else if(test2.get(i).getAction().equals("tavern"))
            {
                if(i==0) {g.drawImage(tavern, getWidth()/2+getWidth()/85  - (2*getWidth()/63), getHeight()/40 + (getHeight()/12), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==1) {g.drawImage(tavern, getWidth()/4+getWidth()/60  - (2*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==2) {g.drawImage(tavern, getWidth()/2+getWidth()/85 + getWidth()/19  - (2*getWidth()/63), getHeight()/40 + (getHeight()/12), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==3) {g.drawImage(tavern, getWidth()/2+getWidth()/85 + getWidth()/19  - (2*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (6*getWidth()/59), (3*getHeight()/19), null); }
            }
            else if(test2.get(i).getAction().equals("barn"))
            {
                if(i==0) {g.drawImage(house, getWidth()/2+getWidth()/85, getHeight()/40 + (2*getHeight()/16), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==1) {g.drawImage(house, getWidth()/2+getWidth()/85, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==2) {g.drawImage(house, getWidth()/2+getWidth()/85 + getWidth()/19, getHeight()/40 + (2*getHeight()/16), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==3) {g.drawImage(house, getWidth()/2+getWidth()/85 + getWidth()/19, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
            }
        }

        for(int i = 0; i < test2.size(); i++) //PLAYER 4
        {
            if(test2.get(i).getAction().equals("horse"))
            {
                if(i == 0) { g.drawImage(horse, getWidth()-getWidth()/4+getWidth()/100 - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 1) { g.drawImage(horse, getWidth()-getWidth()/4+getWidth()/100  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/14), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 2) { g.drawImage(horse, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/15), (10*getWidth()/63), (3*getHeight()/18), null);}
                else if(i == 3) { g.drawImage(horse, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 +(2*getHeight()/14), (10*getWidth()/63), (3*getHeight()/18), null); }
            }
            else if(test2.get(i).getAction().equals("field"))
            {
                if(i == 0) { g.drawImage(field, getWidth()-getWidth()/4+getWidth()/100, getHeight()/40 + (2*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==1) { g.drawImage(field, getWidth()-getWidth()/4+getWidth()/100, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==2) { g.drawImage(field, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19, getHeight()/40 + (2*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==3) { g.drawImage(field, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
            }
            else if(test2.get(i).getAction().equals("oasis"))
            {
                if(i==0) {g.drawImage(oasis, getWidth()-getWidth()/4+getWidth()/100  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==1) {g.drawImage(oasis, getWidth()-getWidth()/4+getWidth()/100  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==2) {g.drawImage(oasis, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/62), (3*getHeight()/21), null);}
                else if(i==3) {g.drawImage(oasis, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/62), (3*getHeight()/21), null);}
            }
            else if(test2.get(i).getAction().equals("oracle"))
            {
                if(i==0) {g.drawImage(stonehenge, getWidth()-getWidth()/4+getWidth()/100  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==1) {g.drawImage(stonehenge, getWidth()-getWidth()/4+getWidth()/100  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==2) {g.drawImage(stonehenge, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/20), null);}
                else if(i==3) {g.drawImage(stonehenge, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/20), null);}
            }
            else if(test2.get(i).getAction().equals("tower"))
            {
                if(i==0) {g.drawImage(tower, getWidth()-getWidth()/4+getWidth()/100  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/60), (3*getHeight()/21), null);}
                else if(i==1) {g.drawImage(tower, getWidth()-getWidth()/4+getWidth()/100  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/21), null);}
                else if(i==2) {g.drawImage(tower, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (getHeight()/12), (10*getWidth()/61), (3*getHeight()/21), null);}
                else if(i==3) {g.drawImage(tower, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (4*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (10*getWidth()/61), (3*getHeight()/21), null); }
            }
            else if(test2.get(i).getAction().equals("tavern"))
            {
                if(i==0) {g.drawImage(tavern, getWidth()-getWidth()/4+getWidth()/100  - (2*getWidth()/63), getHeight()/40 + (getHeight()/12), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==1) {g.drawImage(tavern, getWidth()-getWidth()/4+getWidth()/100  - (2*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==2) {g.drawImage(tavern, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (2*getWidth()/63), getHeight()/40 + (getHeight()/12), (6*getWidth()/59), (3*getHeight()/19), null);}
                else if(i==3) {g.drawImage(tavern, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19  - (2*getWidth()/63), getHeight()/40 + (2*getHeight()/13), (6*getWidth()/59), (3*getHeight()/19), null); }
            }
            else if(test2.get(i).getAction().equals("barn"))
            {
                if(i==0) {g.drawImage(house, getWidth()-getWidth()/4+getWidth()/100, getHeight()/40 + (2*getHeight()/16), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==1) {g.drawImage(house, getWidth()-getWidth()/4+getWidth()/100, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==2) {g.drawImage(house, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19, getHeight()/40 + (2*getHeight()/16), (2*getWidth()/60), getHeight()/16, null);}
                else if(i==3) {g.drawImage(house, getWidth()-getWidth()/4+getWidth()/100 + getWidth()/19, getHeight()/40 + (3*getHeight()/15), (2*getWidth()/60), getHeight()/16, null);}
            }
        }
    }


    public void drawTerrainCards(Graphics g)
    {
//        g.drawImage(desertTerrain, getWidth()/160 + (getWidth()/4)-(getWidth()/32) - 75, getHeight()/32, 70, 90, null);
//        g.drawImage(desertTerrain, getWidth()/4+getWidth()/100 + (getWidth()/4)-(getWidth()/32) - 75, getHeight()/32, getWidth()/23, 90, null);
//        g.drawImage(desertTerrain, getWidth()/2+getWidth()/160+getWidth()/800 + (getWidth()/4)-(getWidth()/32) - 75, getHeight()/32, 70, 90, null);
//        g.drawImage(desertTerrain, getWidth()-getWidth()/4+getWidth()/200 + (getWidth()/4)-(getWidth()/32) - 75, getHeight()/32, 70, 90, null);

//        g.drawImage(desertTerrain, getWidth()/160 + (getWidth()/4)-(getWidth()/32) - (3*getWidth()/64), getHeight()/32, getWidth()/23, getHeight()/9, null);
//        g.drawImage(desertTerrain, getWidth()/4+getWidth()/100 + (getWidth()/4)-(getWidth()/32) - (3*getWidth()/64), getHeight()/32, getWidth()/23, getHeight()/9, null);
//        g.drawImage(desertTerrain, getWidth()/2+getWidth()/160+getWidth()/800 + (getWidth()/4)-(getWidth()/32) - (3*getWidth()/64), getHeight()/32, getWidth()/23, getHeight()/9, null);
//        g.drawImage(desertTerrain, getWidth()-getWidth()/4+getWidth()/200 + (getWidth()/4)-(getWidth()/32) - (3*getWidth()/64), getHeight()/32, getWidth()/23, getHeight()/9, null);

        //System.out.println(getWidth());
        //System.out.println(getHeight());
        if(players.get(0).getTerrainCard() != null) {
        	g.drawImage(players.get(0).getTerrainCard().getImg(), (getWidth()/7), getHeight()/20, getWidth()/13, (10*getHeight()/46), null);
        }
        if(players.get(1).getTerrainCard() != null) {
        	g.drawImage(players.get(1).getTerrainCard().getImg(), getWidth()/3 + getWidth()/16, getHeight()/20, getWidth()/13, (10*getHeight()/46), null);
        }
        if(players.get(2).getTerrainCard() != null) {
        
        	g.drawImage(players.get(2).getTerrainCard().getImg(), getWidth()/2+getWidth()/7, getHeight()/20, getWidth()/13, (10*getHeight()/46), null);
        }
        if(players.get(3).getTerrainCard() != null) {
        
        	g.drawImage(players.get(3).getTerrainCard().getImg(), getWidth()-getWidth()/5+getWidth()/11, getHeight()/20, getWidth()/13, (10*getHeight()/46), null);
        }
    }
        
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //g.fillRect((10*getWidth()/16) + getWidth()/107, getHeight()/19, (10*getWidth()/145), getHeight()/16);
        System.out.println(x + " " + y);
        if((x >= 3*getWidth()/4) && (x <= (3*getWidth()/4) + getWidth()/5) && (y >= getHeight() - getHeight()/6) && (y <= getHeight() - getHeight()/6 + (10*getHeight()/76)))
        {
            if(state == "Game" && displayRules == 0)
            {
                displayRules = 1;
                repaint();
            }
        }
        else if(x>= (10*getWidth()/16) + getWidth()/107 && x <= (10*getWidth()/16) + getWidth()/107 + (10*getWidth()/145) && y >= getHeight()/19 && y <= getHeight()/19 + getHeight()/16)
        {
            if(state == "Game" && displayRules == 1)
            {
                displayRules = 0;
                repaint();
            }
        }
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
        if(t.getHousePlaceable()) {
            g.drawImage(blueHouse, t.getX() - 10, t.getY() - 10, t.getX() + 300, t.getY() + 300, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
        }
    }
    public void DrawAllSettlements(Graphics g) {
        Tile[][] combinedBoard = b.getCombinedBoard();
        for(Tile[] i : combinedBoard) {
            for(Tile j : i) {
                if(j.getSettlement() != null) {
                    if(j.getSettlement().getPlayerOwned() == players.get(0)) {
                        g.drawImage(orangeHouse, (int)(j.getX() - (double)(getWidth()/160)), (int)(j.getY() - (double)(getHeight()/80)), j.getX() + 300, j.getY() + 300, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                    }
                    if(j.getSettlement().getPlayerOwned() == players.get(1)) {
                        g.drawImage(yellowHouse, (int)(j.getX() - (double)(getWidth()/160)), (int)(j.getY() - (double)(getHeight()/80)), j.getX() + 300, j.getY() + 300, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                    }
                    if(j.getSettlement().getPlayerOwned() == players.get(2)) {
                        g.drawImage(greenHouse, (int)(j.getX() - (double)(getWidth()/160)), (int)(j.getY() - (double)(getHeight()/80)), j.getX() + 300, j.getY() + 300, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                    }
                    if(j.getSettlement().getPlayerOwned() == players.get(3)) {
                        g.drawImage(blueHouse, (int)(j.getX() - (double)(getWidth()/160)), (int)(j.getY() - (double)(getHeight()/80)), j.getX() + 300, j.getY() + 300, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                    }
                }
            }
        }
    }
    public void displayPlayerActionTokens(Player p, Graphics g, int x, int y) {
    	if(p.getSpecialActions() != null) {
    		if(p.getSpecialActions().size() >= 1) {
    			g.drawImage(p.getSpecialActions().get(0).getImage(), x, y, x+49, y+49, 0, 0,field.getWidth(), field.getHeight(), null);
    		}
    		if(p.getSpecialActions().size() >= 2) {
    			g.drawImage(p.getSpecialActions().get(1).getImage(), x, y+49, x+49, y+106, 0, 0,field.getWidth(), field.getHeight(), null);
    		}
    		if(p.getSpecialActions().size() >= 3) {

    			g.drawImage(p.getSpecialActions().get(2).getImage(), x+60, y, x+114, y+49, 0, 0,field.getWidth(), field.getHeight(), null);
    		}
    		if(p.getSpecialActions().size() >= 4) {
    			g.drawImage(p.getSpecialActions().get(3).getImage(), x+60, y+49, x+114, y+106, 0, 0,field.getWidth(), field.getHeight(), null);
    		}
    	}

    }
    public void addAllSpecialTiles(Graphics g) {
    	for(Tile[] j : combinedBoard) {
            for(Tile i : j) {
            	if(!(i.getType().equals("Water")) && !(i.getType().equals("Grass")) && !(i.getType().equals("Mountain")) && !(i.getType().equals("Desert")) && !(i.getType().equals("Forest")) && !(i.getType().equals("Flower")) && !(i.getType().equals("Canyon"))) {
            		if(i.getType().equals("Castle")) {
            			g.drawImage(cityIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            		if(i.getType().equals("Paddock")) {
            			g.drawImage(paddockIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            		if(i.getType().equals("Farm")) {
            			g.drawImage(farmIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            		if(i.getType().equals("Barn")) {
            			g.drawImage(barnIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            		if(i.getType().equals("Harbor")) {
            			g.drawImage(harborIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            		if(i.getType().equals("Oasis")) {
            			g.drawImage(oasisIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            		if(i.getType().equals("Oracle")) {
            			g.drawImage(oracleIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            		if(i.getType().equals("Tavern")) {
            			g.drawImage(tavernIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            		if(i.getType().equals("Tower")) {
            			g.drawImage(towerIcon, (int)(i.getX() - (double)(getWidth()/72)), (int)(i.getY() - (double)(getHeight()/42)), i.getX() + 210, i.getY() + 210, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            		}
            	}
            }
        }
    }
    public void highlightSpecialActionTiles(Graphics g) {
    	if(usingSpecialAction || usingSpecialAction2) {
    	String action = specialActionUsed;

        if(action.equals("Farm")) {
        	ArrayList<Tile> temp16 = new ArrayList<>();
        	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
        		if(t.getType().equals("Grass")) {
        			temp16.add(t);
        			//b.HighlightTile(t, b.getGraphics());
        		}
        	}
        	if(temp16.size() > 0) {
        		for(Tile j : players.get(currentPlayer-1).getAllAdjacentTiles()) {
        			if(players.get(currentPlayer-1).getTerrainCard() != null) {
        			if(j.getType().equals("Grass")) {
        				if(!isPlacingSettlements) {
        					g.drawImage(highlight, j.getX() - 20, j.getY() - 20, j.getX() + 150, j.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
        				
        			}}
        			}
        		}
        	}
        	else {
        		for(Tile[] j : combinedBoard) {
                    for(Tile i : j) {
                    	
                    	if(!isPlacingSettlements) {
                    		if(i.getType().equals("Grass") && i.getSettlement() == null) {
                    			g.drawImage(highlight, i.getX() - 20, i.getY() - 20, i.getX() + 150, i.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            			
                    		}
                    		
                    	}
                    }

                }
        	}
        
        }
        if(action.equals("Oasis")) {
        	ArrayList<Tile> temp16 = new ArrayList<>();
        	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
        		if(t.getType().equals("Desert")) {
        			temp16.add(t);
        			//b.HighlightTile(t, b.getGraphics());
        		}
        	}
        	if(temp16.size() > 0) {
        		for(Tile j : players.get(currentPlayer-1).getAllAdjacentTiles()) {
        			if(players.get(currentPlayer-1).getTerrainCard() != null) {
        			if(j.getType().equals("Desert")) {
        				if(!isPlacingSettlements) {
        					g.drawImage(highlight, j.getX() - 20, j.getY() - 20, j.getX() + 150, j.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
        				}
        			}
        			}
        		}
        	}
        	else {
        		for(Tile[] j : combinedBoard) {
                    for(Tile i : j) {
                    	
                    	if(!isPlacingSettlements) {
                    		if(i.getType().equals("Desert") && i.getSettlement() == null) {
                    			g.drawImage(highlight, i.getX() - 20, i.getY() - 20, i.getX() + 150, i.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            			
                    		}
                    		
                    	}
                    }

                }
        	}
        }
        if(action.equals("Oracle")) {
        	ArrayList<Tile> temp16 = new ArrayList<>();
        	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
        		if(t.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType())) {
        			temp16.add(t);
        			//b.HighlightTile(t, b.getGraphics());
        		}
        	}
        	if(temp16.size() > 0) {
        		for(Tile j : players.get(currentPlayer-1).getAllAdjacentTiles()) {
        			if(players.get(currentPlayer-1).getTerrainCard() != null) {
        			if(j.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType())) {
        				if(!isPlacingSettlements) {
        					g.drawImage(highlight, j.getX() - 20, j.getY() - 20, j.getX() + 150, j.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
        				}
        			}
        			}
        		}
        	}
        	else {
        		for(Tile[] j : combinedBoard) {
                    for(Tile i : j) {
                    	
                    	if(!isPlacingSettlements) {
                    		if(i.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType()) && i.getSettlement() == null) {
                    			g.drawImage(highlight, i.getX() - 20, i.getY() - 20, i.getX() + 150, i.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            			
                    		}
                    		
                    	}
                    }

                }
        	}
        }
        if(action.equals("Tower")) {
            b.getEdgeTiles().removeIf(t -> t.getSettlement() != null);
            repaint();
            ArrayList<Tile> temp16 = new ArrayList<>();
            for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                for(Tile j : b.getEdgeTiles()) {
                    if(t.getX() == j.getX() && t.getY() == j.getY()) {
                        temp16.add(t);
                    }
                }

            }
            if(temp16.size() > 0) {
                for(Tile j : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    if(players.get(currentPlayer-1).getTerrainCard() != null) {
                        for(Tile jj : b.getEdgeTiles()) {
                            if(jj.getX() == j.getX() && jj.getY() == j.getY()) {
                                if(!isPlacingSettlements) {
                                    g.drawImage(highlight, j.getX() - 20, j.getY() - 20, j.getX() + 150, j.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                                }
                            }
                        }

                    }
                }
            }
            else {
                for(Tile[] j : combinedBoard) {
                    for(Tile i : j) {

                        for(Tile jj : b.getEdgeTiles()) {
                            if(jj.getX() == i.getX() && jj.getY() == i.getY()) {
                                if(!isPlacingSettlements) {
                                    g.drawImage(highlight, i.getX() - 20, i.getY() - 20, i.getX() + 150, i.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                                }
                            }
                        }
                    }

                }
            }
        }
        if(action.equals("Tavern")) {
        	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
               if(b.tavernCheck(t,players.get(currentPlayer-1))) {
            	   if(!isPlacingSettlements) {
                       g.drawImage(highlight, t.getX() - 20, t.getY() - 20, t.getX() + 150, t.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                   }
               }

            }
        }
        if(action.equals("Paddock")) {
            if(!(usingSpecialAction2)) {
                for(Settlement s : players.get(currentPlayer-1).getHouses()) {
                    if(b.paddockTileCheck(s.getPlacedOn(),players.get(currentPlayer-1))) {
                        g.drawImage(highlight, s.getPlacedOn().getX() - 20, s.getPlacedOn().getY() - 20, s.getPlacedOn().getX() + 150, s.getPlacedOn().getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                    }
                }

            }
            //regoinjdkofgbj nm
            for(Tile[] i : b.getCombinedBoard()) {
            for(Tile t : i) {
                if(paddockUsing != null) {
                if (b.paddockCheck(t, paddockUsing,players.get(currentPlayer - 1)) && t.getHousePlaceable()) {
                    if (!isPlacingSettlements) {
                        g.drawImage(highlight, t.getX() - 20, t.getY() - 20, t.getX() + 150, t.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                    }
                }
            }
            }}
        }
        if(action.equals("Barn")) {
        	if(!(usingSpecialAction2)) {
        		for(Settlement s : players.get(currentPlayer-1).getHouses()) {
        			g.drawImage(highlight, s.getPlacedOn().getX() - 20, s.getPlacedOn().getY() - 20, s.getPlacedOn().getX() + 150, s.getPlacedOn().getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
        		}
        	}
        	else {
        		ArrayList<Tile> temp16 = new ArrayList<>();
            	for(Tile t : players.get(currentPlayer-1).getRawAdjacentTiles()) {
            		if(t.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType())) {
            			temp16.add(t);
            			//b.HighlightTile(t, b.getGraphics());
            		}
            	}
            	if(temp16.size() > 0) {
            		for(Tile j : players.get(currentPlayer-1).getRawAdjacentTiles()) {
            			if(players.get(currentPlayer-1).getTerrainCard() != null) {
            			if(j.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType())) {
            				if(!isPlacingSettlements) {
            					g.drawImage(highlight, j.getX() - 20, j.getY() - 20, j.getX() + 150, j.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            				}
            			}
            			}
            		}
            	}
            	else {
            		for(Tile[] j : combinedBoard) {
                        for(Tile i : j) {
                        	
                        	if(!isPlacingSettlements) {
                        		if(i.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType()) && i.getSettlement() == null) {
                        			g.drawImage(highlight, i.getX() - 20, i.getY() - 20, i.getX() + 150, i.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                			
                        		}
                        		
                        	}
                        }

                    }
            	}
        	}
        }
        
        if(action.equals("Harbor")) {
        	if(!(usingSpecialAction2)) {
        		for(Settlement s : players.get(currentPlayer-1).getHouses()) {
        			g.drawImage(highlight, s.getPlacedOn().getX() - 20, s.getPlacedOn().getY() - 20, s.getPlacedOn().getX() + 150, s.getPlacedOn().getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
        		}
        	}
        	else {
        		ArrayList<Tile> temp16 = new ArrayList<>();
            	for(Tile t : players.get(currentPlayer-1).getRawAdjacentTiles()) {
            		if(t.getType().equals("Water")) {
            			temp16.add(t);
            			//b.HighlightTile(t, b.getGraphics());
            		}
            	}
            	if(temp16.size() > 0) {
            		for(Tile j : players.get(currentPlayer-1).getRawAdjacentTiles()) {
            			if(players.get(currentPlayer-1).getTerrainCard() != null) {
            			if(j.getType().equals("Water")) {
            				if(!isPlacingSettlements) {
            					g.drawImage(highlight, j.getX() - 20, j.getY() - 20, j.getX() + 150, j.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
            				}
            			}
            			}
            		}
            	}
            	else {
            		for(Tile[] j : combinedBoard) {
                        for(Tile i : j) {
                        	
                        	if(!isPlacingSettlements) {
                        		if(i.getType().equals("Water") && i.getSettlement() == null) {
                        			g.drawImage(highlight, i.getX() - 20, i.getY() - 20, i.getX() + 150, i.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
                			
                        		}
                        		
                        	}
                        }

                    }
            	}
        	}
        }}
    }
    public void HighlightTiles(Graphics g) {
    	ArrayList<Tile> temp16 = new ArrayList<>();
    	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
    		if(t.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType())) {
    			temp16.add(t);
    			//b.HighlightTile(t, b.getGraphics());
    		}
    	}
    	if(temp16.size() > 0) {
    		for(Tile j : players.get(currentPlayer-1).getAllAdjacentTiles()) {
    			if(players.get(currentPlayer-1).getTerrainCard() != null) {
    			if(j.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType())) {
    				if(isPlacingSettlements) {
    					g.drawImage(highlight, j.getX() - 20, j.getY() - 20, j.getX() + 150, j.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
    				}
    			}
    			}
    		}
    	}
    	else {
    		for(Tile[] j : combinedBoard) {
                for(Tile i : j) {
                	if(isPlacingSettlements) {
                		if(players.get(currentPlayer-1).getTerrainCard() != null) {
                		if(i.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType()) && i.getSettlement() == null) {
                			g.drawImage(highlight, i.getX() - 20, i.getY() - 20, i.getX() + 150, i.getY() + 180, 0, 0, (int) ((double) 1200 / ((double) getWidth() / 1600)), (int) ((double) 1500 / ((double) getHeight() / 800)), null);
        			
                		}
                		}
                	}
                }

            }
    	}
    }
	
public void showRules(Graphics g)
    {
        String rules = "At the beginning of the game, a random map will be generated and 3 Objective cards will be drawn.\nThese cards will help determine scoring. Each player starts with 40 settlements that they will place throughout the game.\nA random player will be chosen to go first. A player's box will be highlighted to indicate when it is their turn.\n";
        rules += "\nNOTE TO PLAYERS: DO NOT MAXIMIZE THE GAME SCREEN.\nPLEASE PLAY AT THE GAME SCREEN SIZE THAT AUTOMATICALLY OPENS.\n";
        rules += "\nON A PLAYER’S TURN:\n1. Click on the deck of the card at the far right of the screen. A terrain card will be drawn.\n2. Click on the terrain card. Available tiles will be highlighted.\n3. Click on the tile to place a settlement.\n    Settlements can only be placed adjacently to each other and in the terrain drawn.\n    At the beginning of each turn, 3 settlements are placed.";
        rules += "\n4. If a player has action tokens that can be played, click on the action token and play it accordingly.\n5. To end a player's turn, click the 'End Turn' button\n6. The game progresses like this until the starting player runs out of settlements.\n    Once all players have had their final turn afterward, the game ends.\n";
        rules += "\nACTION TOKENS:\nHorse: Allows for a settlement to be moved two tiles in any direction\n           Landing spot cannot be on WATER, MOUNTAINS, or a special action tile.\nFarm: Allows for an extra settlement to be placed on a tile in the PLAINS terrain\n          The settlement has to be placed adjacent to a previously placed settlement.\n          If the player has no settlements in the terrain, the settlement can be placed on any Plains tile.";
        rules += "\nOasis: Allows for an extra settlement to be placed on a tile in the DESERT terrain\n         The settlement has to be placed adjacent to a previously placed settlement.\n          If the player has no settlements in the terrain, the settlement can be placed on any Desert tile.";
        rules += "\nOracle: Allows for an extra settlement to be placed on a tile in the terrain of the card the player drew\n            The settlement has to be placed adjacent to a previously placed settlement.\n             If the player has no settlements in the terrain, the settlement can be placed on any tile of the terrain type card drawn.";
        rules += "\nTower: Allows for an extra settlement to be placed at the edge of the board\n            The settlement has to be placed adjacent to a previously placed settlement.\n            If the player has no settlements in the terrain, the settlement can be placed on any tile on the edge of the board.";
        rules += "\nTavern: Allows for an extra settlement to be placed at the end of an existing chain of 3 settlements\n             Landing spot cannot be on WATER, MOUNTAINS, or a special action tile.";
        rules += "\nBarn: Allows an existing settlement to be moved to a tile in the terrain of the card the player drew\n         The settlement has to be placed adjacent to a previously placed settlement.\n         If the player has no settlements in the terrain, the settlement can be placed on any tile of the terrain type card drawn.";
        rules += "\nHarbor: Allows an existing settlement to be moved to a WATER tile\n             The settlement has to be placed adjacent to a previously placed settlement.\n             If there is no adjacency, the settlement can be moved to any water tile.\n\n~ENJOY!!!";

        g.setColor(new Color(181, 155, 85));
        g.fillRect((2*getWidth()/8), (getHeight()/20), getWidth()/2, (10*getHeight()/11));
        g.setColor(Color.black);
        g.drawRect((2*getWidth()/8), (getHeight()/20), getWidth()/2, (10*getHeight()/11));
        g.setColor(Color.white);
        g.fillRect((10*getWidth()/16) + getWidth()/107, getHeight()/19, (10*getWidth()/145), getHeight()/16);
        g.setFont(new Font("Times New Roman", Font.BOLD, getWidth()/53));
        g.setColor(Color.black);
        g.drawString("HOW TO PLAY", (2*getWidth()/8) + getWidth()/16, (getHeight()/11));
        g.drawString("EXIT", getWidth()-(10*(getWidth()/28)), getHeight()/10);
        g.setFont(new Font("Times New Roman", Font.PLAIN, getWidth()/96));
        int x = 2*getWidth()/8;
        int y = getHeight()/9;

        for(String str: rules.split("\n"))
        {
            y += g.getFontMetrics().getAscent();
            g.drawString(str, 2*getWidth()/8, y);
        }
        System.out.println(getWidth());
        System.out.println(getHeight());
    }
	
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(int x) {
        currentPlayer = x;
    }
    public void setPlacingSpecials(boolean b) {
    	usingSpecialAction = b;
    }
    public void setPlacingSpecials2(boolean b) {
    	usingSpecialAction2 = b;
    }
    public void setSpecialActionUsed(String s) {
    	specialActionUsed = s;
    }
    public void setPlacingSettlements(boolean b ) {
    	isPlacingSettlements = b;
    }
    public void setPaddockUsing(Tile t) {
        paddockUsing = t;
    }
    public void AddTerrainCard(Player p) {
    	if(d.getDeckSize() == 0) {
        	//System.out.println("ji");
        	for(TerrainCard t : discardPile) {
        		d.addCard(t);
        	}
        }
    	TerrainCard t = d.pickRandom();
    	p.setTerrainCard(t);
    	discardPile.add(t);
    	//System.out.println(d.getDeckSize());
    }
    public void setState(String s) {
        state = s;
        repaint();
    }


}
