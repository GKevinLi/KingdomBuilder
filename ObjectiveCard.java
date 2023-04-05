public class ObjectiveCard {
    private String objective;
    public ObjectiveCard(String s) {
        objective = s;
    }
    public String getObjective() {
        return objective;
    }
    public int scoreCard(Player p, FullBoard b) {
        if(objective.equals("Lords")) {

        }
        if(objective.equals("Miners")) {
            Settlement[] s = p.getHouses();
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
            Settlement[] s = p.getHouses();
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
            Settlement[] s = p.getHouses();
            int i = 0;
            for(Settlement house : s) {
                int Count = 0;
                for(Tile t : house.getPlacedOn().getAdjacentTiles()) {
                    if(t.getType().equals("Castle") || t.getType().equals("Horse") || t.getType().equals("Farm") || t.getType().equals("Oasis") || t.getType().equals("Oracle") || t.getType().equals("Tower") || t.getType().equals("Tavern") || t.getType().equals("Barn") || t.getType().equals("Harbor")) {
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
            Settlement[] s = p.getHouses();
            int max = 0;
            for(Settlement huse : s) {
                if(huse.countAdjacentHouses(huse.getPlacedOn(), p) > max) {
                    max = huse.countAdjacentHouses(huse.getPlacedOn(), p);
                }
            }
            return max /2;
        }
        if(objective.equals("Hermits")) {
            Settlement[] s = p.getHouses();
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

        }
        if(objective.equals("Knights")) {

        }
        if(objective.equals("Merchants")) {

        }
        if(objective.equals("Farmers")) {

        }
        return 0;
    }
}
