import java.util.*;
public class Settlement {
    Player playerOwned;
    Tile isPlacedOn;

    public Settlement(Tile t, Player p) {
        playerOwned = p;
        isPlacedOn = t;
    }
    public void setPlayerOwned(Player p) {
        playerOwned = p;
    }
    //hi
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
        ArrayList<Tile> adjacents = b.getAdjacentTiles();
        ArrayList<Tile> a = new ArrayList<Tile>();
        int cnt = 0;
        for(Tile t : adjacents) {
            if(t.getSettlement() != null && !t.getFilled()) {
                if(t.getSettlement().getPlayerOwned().equals(p)) {
                    a.add(t);
                    cnt++;
                    t.setFilled();
                }
            }

        }

        if(cnt == 0) {
            return 0;
        }
        else {
            int sum = 0;
            for(Tile t : a) {
                sum += countAdjacentHouses(t, p);
            }
            if(!(b.getFilled())) {
                sum++;
            }
            b.setFilled();
            return (sum + cnt);
        }
    }
}
