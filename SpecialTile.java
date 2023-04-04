public class SpecialTile extends Tile{
    private int numCharges;
    private ActionToken specialAction;
    public SpecialTile(String s, ActionToken a) {
        super(s);
        specialAction = a;


    }
    public ActionToken getAction() {
        return specialAction;
    }
    public int getNumCharges() {
        return numCharges;
    }
    public void subtractNumCharges() {
        numCharges--;
    }
}
