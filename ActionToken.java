public class ActionToken {
    private String action;
    private boolean usedAlready;
    public ActionToken(String s) {
        action = s;
    }
    public String getAction() {
        return action;
    }
    public boolean getUsed() {
        return usedAlready;
    }
    public void switchUsed() {
        usedAlready = !(usedAlready);
    }
}
