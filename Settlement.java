import java.util.*;
public class Settlement {
    Player playerOwned;
    Tile isPlacedOn;

    public Settlement() {

    }
    public void setPlayerOwned(Player p) {
        playerOwned = p;
    }
    public void setPlacedOn(Tile t) {
        isPlacedOn = t;
    }
    public Tile getPlacedOn() {
        return isPlacedOn;
    }
    public Player getPlayerOwned() {
        return playerOwned;
    }
    public int countAdjacentHouses(Tile b, Player p) {
        Tile[] adjacents = b.getAdjacentTiles();
        ArrayList<Tile> a = new ArrayList<Tile>();
        int cnt = 0;
        for(Tile t : adjacents) {
            if(t.HouseCheck() && !t.getFilled()) {
                if(t.getSettlement().getPlayerOwned() == p) {
                    a.add(t);
                    cnt++;
                    t.setFilled();
                }
            }

        }
        if(cnt == 0) {
            return 1;
        }
        else {
            int sum = 0;
            for(Tile t : a) {
                sum += countAdjacentHouses(t, p);
            }
            return sum + cnt;
        }

    }
}
