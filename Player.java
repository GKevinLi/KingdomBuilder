import java.util.ArrayList;

public class Player {
    private String playerName;
    private int score;
    private Settlement[] houses;
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
    public Settlement[] getHouses() {
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
    public String getName() {
        return playerName;
    }

}
