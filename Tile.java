public class Tile {
    private String type;
    private boolean hasHouse;
    private boolean housePlaceable;
    private Tile[] adjacentTiles;


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

}
