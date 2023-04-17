import java.util.ArrayList;

public class TerrainDeck {
    private ArrayList<TerrainCard> deck;

    public TerrainDeck() {
        deck = new ArrayList<>();
        newDeck();

    }
    public void newDeck() {
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Desert"));
        }
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Canyon"));
        }
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Forest"));
        }
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Flower"));
        }
        for(int i = 0; i < 5; i++) {
            deck.add(new TerrainCard("Grass"));
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
