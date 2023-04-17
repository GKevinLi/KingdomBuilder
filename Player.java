import java.util.ArrayList;

public class Player {
    private String playerName;
    private int score;
    private ArrayList<Settlement> houses;
    private ArrayList<ActionToken> specialActions;
    private boolean isFirstPlayer;
    private TerrainCard terrainCard;

    public Player(String s) {
        playerName = s;
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
    public boolean getFirstPlayer() {
        return isFirstPlayer;
    }
    public TerrainCard getTerrainCard() {
        return terrainCard;
    }
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
                if(!(i.HouseCheck()) && (i.getHousePlaceable())) {
                    t.add(i);
                }
            }
        }
        return t;
    }
    public String getName() {
        return playerName;
    }

}
