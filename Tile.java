public class Tile {
    public String type;
    private boolean hasHouse;
    private boolean housePlaceable;
    private boolean alreadyFilled;
    private Tile[] adjacentTiles;
    private Settlement s;

    public Tile() {

    }
    public Tile(String s) {
        type = s;
    }
    public Tile[] getAdjacentTiles() {
        return adjacentTiles;
    }
    public void setAdjacentTiles(Tile[] t) {
        adjacentTiles = t;
    }
    public boolean getHousePlaceable() {
        return housePlaceable;
    }
    public String getType() {
        return type;
    }
    public void setFilled() {
        alreadyFilled = true;
    }
    public boolean HouseCheck() {
        return hasHouse;
    }
    public boolean getFilled() {
        return alreadyFilled;
    }

}
