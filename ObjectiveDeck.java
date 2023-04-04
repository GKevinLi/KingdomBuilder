import java.util.ArrayList;

public class ObjectiveDeck {
    private ArrayList<ObjectiveCard> cards  = new ArrayList<ObjectiveCard>();
    public ObjectiveDeck() {
        cards.add(new ObjectiveCard("Workers"));
        cards.add(new ObjectiveCard("Miners"));
        cards.add(new ObjectiveCard("Fishermen"));
        cards.add(new ObjectiveCard("Explorers"));
        cards.add(new ObjectiveCard("Knights"));
        cards.add(new ObjectiveCard("Hermits"));
        cards.add(new ObjectiveCard("Citizens"));
        cards.add(new ObjectiveCard("Merchants"));
        cards.add(new ObjectiveCard("Lords"));
        cards.add(new ObjectiveCard("Farmers"));

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
