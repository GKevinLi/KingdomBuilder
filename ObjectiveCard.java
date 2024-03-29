import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ObjectiveCard {
    private String objective;
    private BufferedImage img;
    public ObjectiveCard(String s, BufferedImage b) {
        objective = s;
        img = b;
    }
    public String getObjective() {
        return objective;
    }
    public BufferedImage getImg() {
        return img;
    }
    public int scoreCard(Player p, FullBoard b, int x) {
        if(objective.equals("Lords")) {
            
            BoardSector bs = b.getBoards().get(x);
            int cnt = 0;
            for(Tile[] i : bs.getBoard()) {
                for(Tile j : i) {
                    if(j.getSettlement() != null) {
                        if (j.getSettlement().getPlayerOwned() == p) {
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
            
        }
        if(objective.equals("Miners")) {
            ArrayList<Settlement> s = p.getHouses();
            int i = 0;
            for(Settlement house : s) {
                int mtnCount = 0;
                for(Tile t : house.getPlacedOn().getAdjacentTiles()) {
                    if(t.getType().equals("Mountain")) {
                        mtnCount++;
                    }
                }
                if(mtnCount >= 1) {
                   i++;
                }
            }
            return i;
        }
        if(objective.equals("Fishermen")) {
            ArrayList<Settlement> s = p.getHouses();
            int i = 0;
            for(Settlement house : s) {
                int wtrCount = 0;
                for(Tile t : house.getPlacedOn().getAdjacentTiles()) {
                    if(t.getType().equals("Water")) {
                        wtrCount++;
                    }
                }
                if(wtrCount >= 1) {
                    i++;
                }
            }
            return i;
        }
        if(objective.equals("Workers")) {
            ArrayList<Settlement> s = p.getHouses();
            int i = 0;
            for(Settlement house : s) {
                int Count = 0;
                for(Tile t : house.getPlacedOn().getAdjacentTiles()) {
                    if(t.getType().equals("Castle") || t.getType().equals("Paddock") || t.getType().equals("Farm") || t.getType().equals("Oasis") || t.getType().equals("Oracle") || t.getType().equals("Tower") || t.getType().equals("Tavern") || t.getType().equals("Barn") || t.getType().equals("Harbor")) {
                        Count++;
                    }
                }
                if(Count >= 1) {
                    i++;
                }
            }
            return i;
        }
        if(objective.equals("Citizens")) {
            ArrayList<Settlement> s = p.getHouses();
            for(Settlement huse : s) {
                huse.getPlacedOn().resetFilled();
            }
            int max = 0;
            for(Settlement huse : s) {
                int t = huse.countAdjacentHouses(huse.getPlacedOn(), p);

                if(t > max) {
                    max = t;
                }
            }
            double d = max / 2.0;
            return (int)(Math.floor(d));
        }
        if(objective.equals("Hermits")) {
            ArrayList<Settlement> s = p.getHouses();
            for(Settlement huse : s) {
                huse.getPlacedOn().resetFilled();
            }
            int cnt = 0;
            for(Settlement huse : s) {
                if(!(huse.getPlacedOn().getFilled())) {
                    int lol = huse.countAdjacentHouses(huse.getPlacedOn(), p);
                    cnt++;
                }

            }
            return cnt;
        }
        if(objective.equals("Explorers")) {
            int cnt = 0;
            Tile[][] board = b.getCombinedBoard();
            for(Tile[] i : board) {
                int temp = 0;
                for(Tile j : i) {

                    if(j.getSettlement() != null) {
                        if (j.getSettlement().getPlayerOwned() == p) {
                            temp++;
                        }
                    }

                }
                if(temp >= 1) {
                    cnt++;
                }
            }
            return cnt;
        }
        if(objective.equals("Knights")) {
            int max = 0;
            Tile[][] board = b.getCombinedBoard();
            for(Tile[] i : board) {
                int temp = 0;
                for(Tile j : i) {

                    if(j.getSettlement() != null) {
                        if (j.getSettlement().getPlayerOwned() == p) {
                            temp++;
                        }
                    }

                }
                if(temp > max) {
                    max = temp;
                }
            }
            return max * 2;
        }
        if(objective.equals("Merchants")) {

        }
        if(objective.equals("Farmers")) {
            int least = Integer.MAX_VALUE;
            for(BoardSector bs : b.getBoards()) {
                int cnt = 0;
                for(Tile[] i : bs.getBoard()) {
                    for(Tile j : i) {
                        if(j.getSettlement() != null) {
                            if (j.getSettlement().getPlayerOwned().equals(p)) {
                                cnt++;
                            }
                        }
                    }
                }
                
                if(cnt < least) {
                    least = cnt;
                }
            }
            return least * 3;
        }
        return 0;
    }
}
