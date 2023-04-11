import java.awt.image.BufferedImage;

public class BoardSector {
    private Tile[][] board;
    private BufferedImage img;
    public BoardSector(Tile[][] t, BufferedImage i) {
        board = t;
        img = i;
    }
    public Tile[][] getBoard() {
        return board;
    }
    public void setImg(BufferedImage b) {
        img = b;
    }
    public BufferedImage getImg() {
        return img;
    }
    public Tile[] getRow(int a) {
        return board[a];
    }


}
