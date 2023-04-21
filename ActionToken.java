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
