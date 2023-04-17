import java.util.ArrayList;

public class FullBoard {
    private ArrayList<BoardSector> boards;
    private Tile[][] combinedBoard;
    public FullBoard() {
        boards = new ArrayList<>();
        combinedBoard = new Tile[20][20];
    }
    public void makeCombinedBoard() {
        for(int i = 0; i< 10; i++) {
            for(int j = 0; j < 10; j++) {
                combinedBoard[i][j] = boards.get(0).getBoard()[i][j];
            }
        }
        for(int i = 10; i< 20; i++) {
            for(int j = 0; j < 10; j++) {
                combinedBoard[i][j] = boards.get(1).getBoard()[i-10][j];
            }
        }
        for(int i = 0; i< 10; i++) {
            for(int j = 10; j < 20; j++) {
                combinedBoard[i][j] = boards.get(2).getBoard()[i][j-10];
            }
        }
        for(int i = 10; i< 20; i++) {
            for(int j = 10; j < 20; j++) {
                combinedBoard[i][j] = boards.get(3).getBoard()[i-10][j-10];
            }
        }
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
}
