import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class ObjectiveDeck {
    private BufferedImage worker, miners, fisherman, discoverers, knights, hermits, citizens, merchants, lords, farmers;
    private ArrayList<ObjectiveCard> cards  = new ArrayList<ObjectiveCard>();
    public ObjectiveDeck(){
        try {
            knights = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/KnightsObjective (1).png"));
            miners = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/MinersObjective (1).png"));
            discoverers = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/DiscoverersObjective (1).png"));
            citizens = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Citizens Objective.png"));
            farmers = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Farmers Objective.png"));
            hermits = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Hermits Objective.png"));
            worker = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Worker Objective.png"));
            fisherman = ImageIO.read(GameScreenPanel.class.getResource("/deez imgs/Fisherman Objective.png"));
        }
        catch (Exception E)
        {
            System.out.println("error");
            return;
        }
        cards.add(new ObjectiveCard("Workers", worker));
        cards.add(new ObjectiveCard("Miners", miners));
        cards.add(new ObjectiveCard("Fishermen", fisherman));
        cards.add(new ObjectiveCard("Explorers", discoverers));
        cards.add(new ObjectiveCard("Knights", knights));
        cards.add(new ObjectiveCard("Hermits", hermits));
        cards.add(new ObjectiveCard("Citizens", citizens));
        cards.add(new ObjectiveCard("Merchants", worker));
        cards.add(new ObjectiveCard("Lords", worker));
        cards.add(new ObjectiveCard("Farmers", farmers));

    }
    public ArrayList<ObjectiveCard> get3Random() {
        ArrayList<ObjectiveCard> a = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < cards.size(); j++) {
                ObjectiveCard o = cards.get((int)(Math.random() * cards.size()));
                a.add(o);
                cards.remove(o);
            }
        }
        return a;
    }
}
