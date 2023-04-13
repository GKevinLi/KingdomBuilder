import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EpicMouseListener implements MouseListener {
    private GameScreenPanel b;
    private StartScreenPanel c;
    private String state;
    public EpicMouseListener(GameScreenPanel a, StartScreenPanel d) {
        b = a;
        c=d;
        state = "Start Screen";
    }

    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(state.equals("Start Screen")) {

        }
        int x = e.getX();
        int y = e.getY();
        System.out.println(x);
        System.out.println(y);
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
