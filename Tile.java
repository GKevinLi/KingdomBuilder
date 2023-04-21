import java.util.ArrayList;

public class Tile {
    public String type;
    private boolean hasHouse;
    private boolean housePlaceable;
    private boolean alreadyFilled;
    private ArrayList<Tile> adjacentTiles;
    private Settlement s;
    private int xPos;
    private int yPos;
    public Tile(String s) {
        type = s;
        if(s.equals("Flower") || s.equals("Grass") || s.equals("Forest")|| s.equals("Desert") || s.equals("Canyon")) {
            housePlaceable = true;
        }
        else {
            housePlaceable = false;
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
    public void setSettlement(Settlement se) {
        s=se;
    }
    public void setX(int x) {
    	xPos = x;
    }
    public void setY(int x) {
    	yPos = x;
    }
    public int getX() {
    	return xPos;
    }
    public int getY() {
    	return yPos;
    }

}
