import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ActionToken {
    private String action;
    private boolean usedAlready;
    private int id;
    private BufferedImage img;

    public ActionToken(String s, int i) {
        action = s;
        id = i;
        s = s.toLowerCase();
        usedAlready = true;
        try {
			img = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KB-" + s + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public String getAction() {
        return action;
    }
    public int getID() {
    	return id;
    }
    public boolean getUsed() {
        return usedAlready;
    }
    public BufferedImage getImage() {
    	return img;
    }
   
    public void setUsed(boolean b) {
    	usedAlready = b;
    }
    public void useAction(Player p) {
        if(action.equals("Paddock")) {
        		
        }
        if(action.equals("Farm")) {

        }
        if(action.equals("Oasis")) {

        }
        if(action.equals("Oracle")) {

        }
        if(action.equals("Tower")) {

        }
        if(action.equals("Tavern")) {

        }
        if(action.equals("Barn")) {

        }
        if(action.equals("Harbor")) {

        }
    }
}
