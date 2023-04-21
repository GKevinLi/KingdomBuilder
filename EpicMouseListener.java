import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EpicMouseListener implements MouseListener {
    private GameScreenPanel b;
    private StartScreenPanel c;
    private String state;
    public EpicMouseListener(GameScreenPanel a, StartScreenPanel d) {
        b = a;
        c=d;
        state = c.getState();
    }

    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        int x = e.getX();
        int y = e.getY();
        System.out.println(x);
        System.out.println(y);
        if(state.equals("Game")) {
        	if(x >= (int)((16 * ((double)b.getWidth() / 1600))) && y >= b.getHeight()/3 - b.getHeight()/30 && x <= ((b.getWidth() / 3) +(b.getWidth() / 50)) + (int)((16 * ((double)b.getWidth() / 1600))) && y <= (b.getHeight() - (b.getHeight() / 13)-(b.getHeight()/3 - b.getHeight()/30)) + b.getHeight()/3 - b.getHeight()/30) {
        		//System.out.println("hai");
        		/*
        		double Ydiff = (b.getHeight() - (b.getHeight() / 13)-(b.getHeight()/3 - b.getHeight()/30)) / 20;
        		int row = (int) ((y - b.getHeight()/3 - b.getHeight()/30) / (Ydiff / 2));
        		double Xdiff = ((b.getWidth() / 3) +(b.getWidth() / 50)) / 20;
        		int column = (int) ((x - (16 * ((double)b.getWidth() / 1600))) / Xdiff);
        		if(row % 2 != 0) {
        			column = (int) ((x - (16 * ((double)b.getWidth() / 1600)) + (Xdiff / 2)) / Xdiff);
        		}
        		
        		row = (row + 3) / 2;
        		//System.out.println(b.getBoard().getCombinedBoard()[row][column].getType());
        		System.out.println(b.getBoard().getCombinedBoard()[row][column].getX());
        		System.out.println(b.getBoard().getCombinedBoard()[row][column].getY());
        		*/
        		double min = Integer.MAX_VALUE;
        		Tile minTile = b.getBoard().getCombinedBoard()[0][0];
        		for(Tile[] i : b.getBoard().getCombinedBoard()) {
        			for(Tile j : i) {
        				if(Math.sqrt(Math.pow(x - j.getX(), 2) + Math.pow(y - j.getY(), 2)) < min) {
        					min = Math.sqrt(Math.pow(x - j.getX(), 2) + Math.pow(y - j.getY(), 2));
        					minTile = j;
        				}
        			}
        		}
        		System.out.println(minTile.getType());
        		b.DrawSettlementOn(minTile, b.getGraphics());
        		}
        }
        //System.out.println("W" + b.getWidth());
    	//System.out.println("H" + b.getHeight());
        if(state.equals("start")){
            if(x >= c.getWidth()/2 -162 && y >= c.getHeight()/3 && x <= c.getWidth()/2 - 162 + 325 && y <= c.getHeight()/3 + 125){
                c.setState("Game");
                c.repaint();
                System.out.println("state changed");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

