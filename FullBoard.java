import java.util.ArrayList;

public class FullBoard {
    private ArrayList<BoardSector> boards;
    private Tile[][] combinedBoard;
    private ArrayList<Tile> edgeTiles;
    public FullBoard() {
        boards = new ArrayList<>();
        combinedBoard = new Tile[20][20];
        edgeTiles = new ArrayList<>();
    }
    public void makeCombinedBoard() {
        for(int i = 0; i< 10; i++) {
            for(int j = 0; j < 10; j++) {
                combinedBoard[i][j] = boards.get(0).getBoard()[i][j];
                if(i == 0 || j == 0) {
                    edgeTiles.add(combinedBoard[i][j]);
                }
                if(i == 19 || j == 19) {
                    edgeTiles.add(combinedBoard[i][j]);
                }
            }
        }
        for(int i = 10; i< 20; i++) {
            for(int j = 0; j < 10; j++) {
                combinedBoard[i][j] = boards.get(1).getBoard()[i-10][j];
                if(i == 0 || j == 0) {
                    edgeTiles.add(combinedBoard[i][j]);
                }
                if(i == 19 || j == 19) {
                    edgeTiles.add(combinedBoard[i][j]);
                }
            }
        }
        for(int i = 0; i< 10; i++) {
            for(int j = 10; j < 20; j++) {
                combinedBoard[i][j] = boards.get(2).getBoard()[i][j-10];
                if(i == 0 || j == 0) {
                    edgeTiles.add(combinedBoard[i][j]);
                }
                if(i == 19 || j == 19) {
                    edgeTiles.add(combinedBoard[i][j]);
                }
            }
        }
        for(int i = 10; i< 20; i++) {
            for(int j = 10; j < 20; j++) {
                combinedBoard[i][j] = boards.get(3).getBoard()[i-10][j-10];
                if(i == 19 || j == 19) {
                    edgeTiles.add(combinedBoard[i][j]);
                }
            }

        }
        edgeTiles.removeIf(t -> t.getType().equals("Mountain") || t.getType().equals("Water"));

    }
    public void addBoard(BoardSector b) {
        boards.add(b);
    }
    public ArrayList<BoardSector> getBoards() {
        return boards;
    }
    public Tile[][] getCombinedBoard() {
        return combinedBoard;
    }
    public ArrayList<Tile> getEdgeTiles() {
        return edgeTiles;
    }
    public boolean tavernCheck(Tile t, Player p) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                if(combinedBoard[i][j].equals(t)) {
                    y = i;
                    x = j;
                }
            }
        }
        if(x - 3 >= 0) {
            if(combinedBoard[y][x-1].getSettlement() != null && combinedBoard[y][x-2].getSettlement() != null &&combinedBoard[y][x-3].getSettlement() != null)  {
                if(combinedBoard[y][x-1].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y][x-2].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y][x-3].getSettlement().getPlayerOwned().equals(p))  {
                    return true;
                }
            }
        }
        if(x + 3 < 20) {
            if(combinedBoard[y][x+1].getSettlement() != null && combinedBoard[y][x+2].getSettlement() != null &&combinedBoard[y][x+3].getSettlement() != null)  {
                if(combinedBoard[y][x+1].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y][x+2].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y][x+3].getSettlement().getPlayerOwned().equals(p))  {
                    return true;
                }
            }
        }
        if(y % 2 == 0) {
            if(x - 2 >= 0 && y + 3 < 20) {
                if(combinedBoard[y+1][x-1].getSettlement() != null && combinedBoard[y+2][x-1].getSettlement() != null &&combinedBoard[y+3][x-2].getSettlement() != null)  {
                    if(combinedBoard[y+1][x-1].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y+2][x-1].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y+3][x-2].getSettlement().getPlayerOwned().equals(p))  {
                        return true;
                    }
                }
            }
            if(x + 1 < 20 && y + 3 < 20) {
                if(combinedBoard[y+1][x].getSettlement() != null && combinedBoard[y+2][x+1].getSettlement() != null &&combinedBoard[y+3][x+1].getSettlement() != null)  {
                    if(combinedBoard[y+1][x].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y+2][x+1].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y+3][x+1].getSettlement().getPlayerOwned().equals(p))  {
                        return true;
                    }
                }
            }
            if(x - 2 >= 0 && y - 3 >= 0) {
                if(combinedBoard[y-1][x-1].getSettlement() != null && combinedBoard[y-2][x-1].getSettlement() != null &&combinedBoard[y-3][x-2].getSettlement() != null)  {
                    if(combinedBoard[y-1][x-1].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y-2][x-1].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y-3][x-2].getSettlement().getPlayerOwned().equals(p))  {
                        return true;
                    }
                }
            }
            if(x + 1 < 20 && y - 3 >= 0) {
                if(combinedBoard[y-1][x].getSettlement() != null && combinedBoard[y-2][x+1].getSettlement() != null &&combinedBoard[y-3][x+1].getSettlement() != null)  {
                    if(combinedBoard[y-1][x].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y-2][x+1].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y-3][x+1].getSettlement().getPlayerOwned().equals(p))  {
                        return true;
                    }
                }
            }
        }
        else {
            if(x - 1 >= 0 && y + 3 < 20) {
                if(combinedBoard[y+1][x].getSettlement() != null && combinedBoard[y+2][x-1].getSettlement() != null &&combinedBoard[y+3][x-1].getSettlement() != null)  {
                    if(combinedBoard[y+1][x].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y+2][x-1].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y+3][x-1].getSettlement().getPlayerOwned().equals(p))  {
                        return true;
                    }
                }
            }
            if(x + 2 < 20 && y + 3 < 20) {
                if(combinedBoard[y+1][x+1].getSettlement() != null && combinedBoard[y+2][x+1].getSettlement() != null &&combinedBoard[y+3][x+2].getSettlement() != null)  {
                    if(combinedBoard[y+1][x+1].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y+2][x+1].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y+3][x+2].getSettlement().getPlayerOwned().equals(p))  {
                        return true;
                    }
                }
            }
            if(x - 1 >= 0 && y - 3 >= 0) {
                if(combinedBoard[y-1][x].getSettlement() != null && combinedBoard[y-2][x-1].getSettlement() != null &&combinedBoard[y-3][x-1].getSettlement() != null)  {
                    if(combinedBoard[y-1][x].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y-2][x-1].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y-3][x-1].getSettlement().getPlayerOwned().equals(p))  {
                        return true;
                    }
                }
            }
            if(x + 2 < 20 && y - 3 >= 0) {
                if(combinedBoard[y-1][x+1].getSettlement() != null && combinedBoard[y-2][x+1].getSettlement() != null &&combinedBoard[y-3][x+2].getSettlement() != null)  {
                    if(combinedBoard[y-1][x+1].getSettlement().getPlayerOwned().equals(p) && combinedBoard[y-2][x+1].getSettlement().getPlayerOwned().equals(p) &&combinedBoard[y-3][x+2].getSettlement().getPlayerOwned().equals(p))  {
                        return true;
                    }
                }
            }
        }



        return false;
    }
}
