import java.awt.image.BufferedImage;

public class TerrainCard {
    private String cardType;
    private BufferedImage img;

    public TerrainCard(String s, BufferedImage b) {
        cardType = s;
        img = b;
    }
    public String getCardType() {
        return cardType;
    }
    public BufferedImage getImg() {
        return img;
    }
    public void setCardType(String s) {
        cardType = s;
    }
}
