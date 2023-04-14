import java.util.ArrayList;

public class Tile {
    public String type;
    private boolean hasHouse;
    private boolean housePlaceable;
    private boolean alreadyFilled;
    private ArrayList<Tile> adjacentTiles;
    private Settlement s;
    public Tile(String s) {
        type = s;
        if(s.equals("Mountain") || s.equals("Water")) {
            housePlaceable = false;
        }
        else {
            housePlaceable = true;
        }
        alreadyFilled = false;
        hasHouse = false;


    }
    //public Tile() {

    //}

    public ArrayList<Tile> getAdjacentTiles() {
        return adjacentTiles;
    }
    public void setAdjacentTiles(ArrayList<Tile> t) {
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
    public void fillHouse() {
        hasHouse = true;
    }
    public void unfillHouse() {
        hasHouse = false;
    }
    public boolean HouseCheck() {
        return hasHouse;
    }
    public boolean getFilled() {
        return alreadyFilled;
    }
    public void resetFilled() {
        alreadyFilled = false;
    }

    public Settlement getSettlement() {
        return s;
    }

}
