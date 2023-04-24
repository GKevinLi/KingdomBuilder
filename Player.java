import java.util.ArrayList;

public class Player {
    private String playerName;
    private int score;
    private ArrayList<Settlement> houses;
    private ArrayList<ActionToken> specialActions;
    private boolean isFirstPlayer;
    private TerrainCard terrainCard;
    private int numHousesLeft;

    public Player(String s)
    {
        playerName = s;
        score = 0;
        houses = new ArrayList<Settlement>();
        specialActions = new ArrayList<ActionToken>();
        isFirstPlayer = false;
        numHousesLeft = 40;
        //terrainCard = new TerrainCard();
    }
    public void addScore(int a) {
        score += a;
    }
    public int getScore() {
        return score;
    }
    public ArrayList<Settlement> getHouses() {
        return houses;
    }
    public void addHouse(Settlement s) {
        houses.add(s);
    }
    public boolean getFirstPlayer() {
        return isFirstPlayer;
    }
    public TerrainCard getTerrainCard() {
        return terrainCard;
    }
    public ArrayList<ActionToken> getSpecialActions() { return specialActions; }
    public void setTerrainCard(TerrainCard t) {
        terrainCard = t;
    }
    public void addSpecialAction(ActionToken t) {
        specialActions.add(t);
    }
    public ArrayList<Tile> getAllAdjacentTiles() {
        ArrayList<Tile> t = new ArrayList<>();
        for(Settlement s : houses) {
            ArrayList<Tile> adj = s.getPlacedOn().getAdjacentTiles();
            for(Tile i : adj) {
                if(!(i.getSettlement() != null) && (i.getHousePlaceable())) {
                	
                    t.add(i);
                }
            }
        }
        return t;
    }
    public ArrayList<Tile> getRawAdjacentTiles() {
        ArrayList<Tile> t = new ArrayList<>();
        for(Settlement s : houses) {
            ArrayList<Tile> adj = s.getPlacedOn().getAdjacentTiles();
            for(Tile i : adj) {
                if(!(i.getSettlement() != null)) {
                	
                    t.add(i);
                }
            }
        }
        return t;
    }
    public String getName() {
        return playerName;
    }
    public void setNumHouses(int t) {
        numHousesLeft = t;
    }
    public int getNumHouses() {
        return numHousesLeft;
    }

}
