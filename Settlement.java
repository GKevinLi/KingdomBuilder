import java.util.*;
public class Settlement {
    Player playerOwned;
    Tile isPlacedOn;

    public Settlement() {

    }
    public int countAdjacentHouses(Tile b) {
        Tile[] adjacents = b.getAdjacentTiles();
        ArrayList<Tile> a = new ArrayList<Tile>();
        int cnt = 0;
        for(Tile t : adjacents) {
            if(t.HouseCheck() && !t.getFilled()) {
               cnt++;
            }
            else {
               a.add(t);
            }
        }
        if(cnt == 0) {
            return 1;
        }
        else {
            int sum = 0;
            for(Tile t : a) {
                sum += countAdjacentHouses(t);
            }
            return sum;
        }

    }
}
