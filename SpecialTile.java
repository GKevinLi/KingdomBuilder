public class SpecialTile extends Tile{
    private int numCharges = 2;
    private ActionToken specialAction;
    public SpecialTile(String s, ActionToken a) {
        super(s);
        specialAction = a;


    }
    public SpecialTile(String s) {
        super(s);



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
}/*
    public class HorseCard extends SpecialActionCard {
        public HorseCard() {
            super("horse", CardType.HORSE);
    }
    public void executeAction(Board board, Player player) {
        Settlement settlement = player.selectSettlement();
        if (settlement == null) {
            System.out.println("You have no settlements to move.");
            return;
        }
        List<Location> validLocations = board.getValidLocations(settlement.getLocation(), 2, true, false);
        if (validLocations.isEmpty()){
            System.out.println("There are no valid locations to move your settlement.");
            return;
        }
        Location selectedLocation = player.selectLocation(validLocations);/    settlement.move(selectedLocation, true);
    }
}
    public class BoatCard extends SpecialActionCard {
}
         public BoatCard() {
              super("Boat", CardType.BOAT);
    }

    @Override
    public void executeAction(Board board, Player player) {
        Location selectedLocation = player.selectLocation(board.getValidBoatLocations(player), true);
        if (selectedLocation == null) {
            System.out.println("You have no valid locations to build a settlement.");
            return;
        }
        Settlement settlement = new Settlement(player, selectedLocation);
        board.addSettlement(settlement);
        System.out.println("You have built a settlement on " + selectedLocation + ".");
    }
}
//rgf
    public class TavernCard extends SpecialActionCard {
}

//public class OasisCard extends SpecialActionCard {    //}
//public class FieldCard extends SpecialActionCard {
//}
//public class TowerCard extends SpecialActionCard {
//}
//public class OracleCard extends SpecialActionCard {
//}
// public class HouseCard extends SpecialActionCard {
//}
*/
//}