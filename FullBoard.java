import java.util.ArrayList;

public class FullBoard {
    private ArrayList<BoardSector> boards;
    public FullBoard() {
        boards = new ArrayList<>();
    }
    public void addBoard(BoardSector b) {
        boards.add(b);
    }
}
