import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TerrainDeck {
    private BufferedImage Flower, Forest, Grassland, Desert, Canyon;
    private ArrayList<TerrainCard> deck;

    public TerrainDeck() {
        try {
            Grassland = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Grassland Terrain.png"));
            Flower = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Flower Terrain.png"));
            Canyon = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Canyon Terrain.png"));
            Desert = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Desert Terrain.png"));
            Forest = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Forest Terrain.png"));
        }
        catch (Exception E)
        {
            System.out.println("error");
            return;
        }
        deck = new ArrayList<>();
        newDeck();

    }
    public void newDeck() {
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Desert", Desert));
        }
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Canyon", Canyon));
        }
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Forest", Forest));
        }
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Flower", Flower));
        }
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Grass", Grassland));
        }
    }
    public TerrainCard pickRandom() {

        TerrainCard t = (deck.get((int)(Math.random() * deck.size())));
        deck.remove(t);
        return t;
    }
    public void addCard(TerrainCard t) {
        deck.add(t);
    }
    public void removeCard(TerrainCard t) {
        deck.remove(t);
    }


}
