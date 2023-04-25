import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class EpicMouseListener implements MouseListener {
    private GameScreenPanel b;
    private StartScreenPanel c;
    private ArrayList<Player> players;
    private boolean endGame;
    private boolean placingSettlements;
    private boolean drawnTerrainCard = false;
    private boolean doingSpecialAction = false;
    private String action;
    private int currentPlayer;
    private int numSettlementsPlaced = 3;

    private String state;
    public EpicMouseListener(GameScreenPanel a, StartScreenPanel d) {
        b = a;
        c=d;
        state = "Game";
        players = a.getPlayers();
        currentPlayer = a.getCurrentPlayer();
        state = c.getState();
        endGame = false;
    }

    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        //System.out.println(x);
        //System.out.println(y);
        if(doingSpecialAction && drawnTerrainCard) {
        	System.out.println("hi am here");
        	System.out.println(action);
        	if(action.equals("Paddock")) {
        		
            }
            if(action.equals("Farm")) {
            	if(x >= (int)((16 * ((double)b.getWidth() / 1600))) && y >= b.getHeight()/3 - b.getHeight()/30 && x <= ((b.getWidth() / 3) +(b.getWidth() / 50)) + (int)((16 * ((double)b.getWidth() / 1600))) && y <= (b.getHeight() - (b.getHeight() / 13)-(b.getHeight()/3 - b.getHeight()/30)) + b.getHeight()/3 - b.getHeight()/30) {
              
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
                    //System.out.println(players.get(currentPlayer-1).getTerrainCard().getCardType());
                    //System.out.println(minTile.getType());
                    //if(players.get(currentPlayer-1).getTerrainCard() != null) {
                    if(minTile.getType().equals("Grass") && minTile.getSettlement() == null) {
                    	
                    	ArrayList<Tile> temp16 = new ArrayList<>();
                    	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    		if(t.getType().equals("Grass")) {
                    			temp16.add(t);
                    			//b.HighlightTile(t, b.getGraphics());
                    		}
                    	}
                    	if(temp16.size() != 0) {
                    		int cnt = 0;
                    		for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    			
                    			if(t == minTile) {
                    				cnt++;
                    			}
                    		} 
                    		if(cnt >= 1) {
                    			Settlement s = new Settlement(minTile, players.get(currentPlayer-1));
                                players.get(currentPlayer-1).addHouse(s);
                                minTile.setSettlement(s);
                                ArrayList<Tile> tt = minTile.getAdjacentTiles();
                                for(Tile ttt:tt) {
                                	if(!(ttt.getType().equals("Water")) && !(ttt.getType().equals("Grass")) && !(ttt.getType().equals("Mountain")) && !(ttt.getType().equals("Desert")) && !(ttt.getType().equals("Forest")) && !(ttt.getType().equals("Flower")) && !(ttt.getType().equals("Canyon"))) {
                                		SpecialTile tttt= (SpecialTile) ttt;
                                		if(tttt.getType().equals("Castle")) {
                                			int cnt421 = 0;
                                			for(Tile ttttt : players.get(currentPlayer-1).getRawAdjacentTiles()) {
                                				if(ttttt.getX()==(tttt.getX()) && ttttt.getY()==(tttt.getY())) {
                                					cnt421++;
                                				}
                                			}
                                			if(cnt421 == 1) {
                                				players.get(currentPlayer-1).addScore(3);
                                			}
                                			
                                			System.out.println(players.get(currentPlayer-1).getScore());
                                		}
                                		else {
                                			int cnt55 = 0;
                                			for(ActionToken a : players.get(currentPlayer-1).getSpecialActions()) {
                                				if(a.getID() == tttt.getAction().getID()) {
                                					cnt55++;
                                				}
                                			}
                                			if(cnt55 == 0) {
                                				tttt.getAction().setUsed(true);
                                				players.get(currentPlayer-1).addSpecialAction(tttt.getAction());
                                			}
                                		}
                                	}
                                }
                                //b.DrawSettlementOn(minTile, b.getGraphics());
                                
                                players.get(currentPlayer-1).setNumHouses(players.get(currentPlayer-1).getNumHouses()-1);
                                doingSpecialAction = false;
                                b.setPlacingSpecials(false);
                    		}
                    	}
                    	else {
                    		Settlement s = new Settlement(minTile, players.get(currentPlayer-1));
                            players.get(currentPlayer-1).addHouse(s);
                            minTile.setSettlement(s);
                            ArrayList<Tile> tt = minTile.getAdjacentTiles();
                            for(Tile ttt:tt) {
                            	if(!(ttt.getType().equals("Water")) && !(ttt.getType().equals("Grass")) && !(ttt.getType().equals("Mountain")) && !(ttt.getType().equals("Desert")) && !(ttt.getType().equals("Forest")) && !(ttt.getType().equals("Flower")) && !(ttt.getType().equals("Canyon"))) {
                            		SpecialTile tttt= (SpecialTile) ttt;
                            		if(tttt.getType().equals("Castle")) {
                            			if(tttt.getType().equals("Castle")) {
                                			int cnt420 = 0;
                                			for(Tile ttttt : players.get(currentPlayer-1).getRawAdjacentTiles()) {
                                				if(ttttt.getX()==(tttt.getX()) && ttttt.getY()==(tttt.getY())) {
                                			
                                					cnt420++;
                                				}
                                			}
                                			
                                			if(cnt420 == 1) {
                                				players.get(currentPlayer-1).addScore(3);
                                			}
                                			
                                			System.out.println(players.get(currentPlayer-1).getScore());
                                		}
                            		}
                            		else {
                            			int cnt69 = 0;
                            			for(ActionToken a : players.get(currentPlayer-1).getSpecialActions()) {
                            				if(a.getID() == tttt.getAction().getID()) {
                            					cnt69++;
                            				}
                            			}
                            			if(cnt69 == 0) {
                            				tttt.getAction().setUsed(true);
                            				players.get(currentPlayer-1).addSpecialAction(tttt.getAction());
                            			}
                            		}
                            	}
                            }
                            //b.repaint();
                            //b.DrawSettlementOn(minTile, b.getGraphics());
                           
                            players.get(currentPlayer-1).setNumHouses(players.get(currentPlayer-1).getNumHouses()-1);
                            doingSpecialAction = false;
                            b.setPlacingSpecials(false);
                    	}
                        
                    }
                    

                }
                //b.repaint();
                
            }
            if(action.equals("Oasis")) {
            	if(x >= (int)((16 * ((double)b.getWidth() / 1600))) && y >= b.getHeight()/3 - b.getHeight()/30 && x <= ((b.getWidth() / 3) +(b.getWidth() / 50)) + (int)((16 * ((double)b.getWidth() / 1600))) && y <= (b.getHeight() - (b.getHeight() / 13)-(b.getHeight()/3 - b.getHeight()/30)) + b.getHeight()/3 - b.getHeight()/30) {
                    
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
                    //System.out.println(players.get(currentPlayer-1).getTerrainCard().getCardType());
                    //System.out.println(minTile.getType());
                    //if(players.get(currentPlayer-1).getTerrainCard() != null) {
                    if(minTile.getType().equals("Desert") && minTile.getSettlement() == null) {
                    	
                    	ArrayList<Tile> temp16 = new ArrayList<>();
                    	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    		if(t.getType().equals("Desert")) {
                    			temp16.add(t);
                    			//b.HighlightTile(t, b.getGraphics());
                    		}
                    	}
                    	if(temp16.size() != 0) {
                    		int cnt = 0;
                    		for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    			
                    			if(t == minTile) {
                    				cnt++;
                    			}
                    		} 
                    		if(cnt >= 1) {
                    			Settlement s = new Settlement(minTile, players.get(currentPlayer-1));
                                players.get(currentPlayer-1).addHouse(s);
                                minTile.setSettlement(s);
                                ArrayList<Tile> tt = minTile.getAdjacentTiles();
                                for(Tile ttt:tt) {
                                	if(!(ttt.getType().equals("Water")) && !(ttt.getType().equals("Grass")) && !(ttt.getType().equals("Mountain")) && !(ttt.getType().equals("Desert")) && !(ttt.getType().equals("Forest")) && !(ttt.getType().equals("Flower")) && !(ttt.getType().equals("Canyon"))) {
                                		SpecialTile tttt= (SpecialTile) ttt;
                                		if(tttt.getType().equals("Castle")) {
                                			int cnt421 = 0;
                                			for(Tile ttttt : players.get(currentPlayer-1).getRawAdjacentTiles()) {
                                				if(ttttt.getX()==(tttt.getX()) && ttttt.getY()==(tttt.getY())) {
                                					cnt421++;
                                				}
                                			}
                                			if(cnt421 == 1) {
                                				players.get(currentPlayer-1).addScore(3);
                                			}
                                			
                                			System.out.println(players.get(currentPlayer-1).getScore());
                                		}
                                		else {
                                			int cnt55 = 0;
                                			for(ActionToken a : players.get(currentPlayer-1).getSpecialActions()) {
                                				if(a.getID() == tttt.getAction().getID()) {
                                					cnt55++;
                                				}
                                			}
                                			if(cnt55 == 0) {
                                				tttt.getAction().setUsed(true);
                                				players.get(currentPlayer-1).addSpecialAction(tttt.getAction());
                                			}
                                		}
                                	}
                                }
                                //b.DrawSettlementOn(minTile, b.getGraphics());
                                
                                players.get(currentPlayer-1).setNumHouses(players.get(currentPlayer-1).getNumHouses()-1);
                                doingSpecialAction = false;
                                b.setPlacingSpecials(false);
                    		}
                    	}
                    	else {
                    		Settlement s = new Settlement(minTile, players.get(currentPlayer-1));
                            players.get(currentPlayer-1).addHouse(s);
                            minTile.setSettlement(s);
                            ArrayList<Tile> tt = minTile.getAdjacentTiles();
                            for(Tile ttt:tt) {
                            	if(!(ttt.getType().equals("Water")) && !(ttt.getType().equals("Grass")) && !(ttt.getType().equals("Mountain")) && !(ttt.getType().equals("Desert")) && !(ttt.getType().equals("Forest")) && !(ttt.getType().equals("Flower")) && !(ttt.getType().equals("Canyon"))) {
                            		SpecialTile tttt= (SpecialTile) ttt;
                            		if(tttt.getType().equals("Castle")) {
                            			if(tttt.getType().equals("Castle")) {
                                			int cnt420 = 0;
                                			for(Tile ttttt : players.get(currentPlayer-1).getRawAdjacentTiles()) {
                                				if(ttttt.getX()==(tttt.getX()) && ttttt.getY()==(tttt.getY())) {
                                			
                                					cnt420++;
                                				}
                                			}
                                			
                                			if(cnt420 == 1) {
                                				players.get(currentPlayer-1).addScore(3);
                                			}
                                			
                                			System.out.println(players.get(currentPlayer-1).getScore());
                                		}
                            		}
                            		else {
                            			int cnt69 = 0;
                            			for(ActionToken a : players.get(currentPlayer-1).getSpecialActions()) {
                            				if(a.getID() == tttt.getAction().getID()) {
                            					cnt69++;
                            				}
                            			}
                            			if(cnt69 == 0) {
                            				tttt.getAction().setUsed(true);
                            				players.get(currentPlayer-1).addSpecialAction(tttt.getAction());
                            			}
                            		}
                            	}
                            }
                            //b.repaint();
                            //b.DrawSettlementOn(minTile, b.getGraphics());
                            
                            players.get(currentPlayer-1).setNumHouses(players.get(currentPlayer-1).getNumHouses()-1);
                            doingSpecialAction = false;
                            b.setPlacingSpecials(false);
                    	}
                        
                    }
                    

                }
                
                
            }
            if(action.equals("Oracle")) {
            	if(x >= (int)((16 * ((double)b.getWidth() / 1600))) && y >= b.getHeight()/3 - b.getHeight()/30 && x <= ((b.getWidth() / 3) +(b.getWidth() / 50)) + (int)((16 * ((double)b.getWidth() / 1600))) && y <= (b.getHeight() - (b.getHeight() / 13)-(b.getHeight()/3 - b.getHeight()/30)) + b.getHeight()/3 - b.getHeight()/30) {
                    
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
                    //System.out.println(players.get(currentPlayer-1).getTerrainCard().getCardType());
                    //System.out.println(minTile.getType());
                    //if(players.get(currentPlayer-1).getTerrainCard() != null) {
                    if(minTile.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType()) && minTile.getSettlement() == null) {
                    	
                    	ArrayList<Tile> temp16 = new ArrayList<>();
                    	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    		if(t.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType())) {
                    			temp16.add(t);
                    			//b.HighlightTile(t, b.getGraphics());
                    		}
                    	}
                    	if(temp16.size() != 0) {
                    		int cnt = 0;
                    		for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    			
                    			if(t == minTile) {
                    				cnt++;
                    			}
                    		} 
                    		if(cnt >= 1) {
                    			Settlement s = new Settlement(minTile, players.get(currentPlayer-1));
                                players.get(currentPlayer-1).addHouse(s);
                                minTile.setSettlement(s);
                                ArrayList<Tile> tt = minTile.getAdjacentTiles();
                                for(Tile ttt:tt) {
                                	if(!(ttt.getType().equals("Water")) && !(ttt.getType().equals("Grass")) && !(ttt.getType().equals("Mountain")) && !(ttt.getType().equals("Desert")) && !(ttt.getType().equals("Forest")) && !(ttt.getType().equals("Flower")) && !(ttt.getType().equals("Canyon"))) {
                                		SpecialTile tttt= (SpecialTile) ttt;
                                		if(tttt.getType().equals("Castle")) {
                                			int cnt421 = 0;
                                			for(Tile ttttt : players.get(currentPlayer-1).getRawAdjacentTiles()) {
                                				if(ttttt.getX()==(tttt.getX()) && ttttt.getY()==(tttt.getY())) {
                                					cnt421++;
                                				}
                                			}
                                			if(cnt421 == 1) {
                                				players.get(currentPlayer-1).addScore(3);
                                			}
                                			
                                			System.out.println(players.get(currentPlayer-1).getScore());
                                		}
                                		else {
                                			int cnt55 = 0;
                                			for(ActionToken a : players.get(currentPlayer-1).getSpecialActions()) {
                                				if(a.getID() == tttt.getAction().getID()) {
                                					cnt55++;
                                				}
                                			}
                                			if(cnt55 == 0) {
                                				tttt.getAction().setUsed(true);
                                				players.get(currentPlayer-1).addSpecialAction(tttt.getAction());
                                			}
                                		}
                                	}
                                }
                                //b.DrawSettlementOn(minTile, b.getGraphics());
                                
                                players.get(currentPlayer-1).setNumHouses(players.get(currentPlayer-1).getNumHouses()-1);
                                doingSpecialAction = false;
                                b.setPlacingSpecials(false);
                    		}
                    	}
                    	else {
                    		Settlement s = new Settlement(minTile, players.get(currentPlayer-1));
                            players.get(currentPlayer-1).addHouse(s);
                            minTile.setSettlement(s);
                            ArrayList<Tile> tt = minTile.getAdjacentTiles();
                            for(Tile ttt:tt) {
                            	if(!(ttt.getType().equals("Water")) && !(ttt.getType().equals("Grass")) && !(ttt.getType().equals("Mountain")) && !(ttt.getType().equals("Desert")) && !(ttt.getType().equals("Forest")) && !(ttt.getType().equals("Flower")) && !(ttt.getType().equals("Canyon"))) {
                            		SpecialTile tttt= (SpecialTile) ttt;
                            		if(tttt.getType().equals("Castle")) {
                            			if(tttt.getType().equals("Castle")) {
                                			int cnt420 = 0;
                                			for(Tile ttttt : players.get(currentPlayer-1).getRawAdjacentTiles()) {
                                				if(ttttt.getX()==(tttt.getX()) && ttttt.getY()==(tttt.getY())) {
                                			
                                					cnt420++;
                                				}
                                			}
                                			
                                			if(cnt420 == 1) {
                                				players.get(currentPlayer-1).addScore(3);
                                			}
                                			
                                			System.out.println(players.get(currentPlayer-1).getScore());
                                		}
                            		}
                            		else {
                            			int cnt69 = 0;
                            			for(ActionToken a : players.get(currentPlayer-1).getSpecialActions()) {
                            				if(a.getID() == tttt.getAction().getID()) {
                            					cnt69++;
                            				}
                            			}
                            			if(cnt69 == 0) {
                            				tttt.getAction().setUsed(true);
                            				players.get(currentPlayer-1).addSpecialAction(tttt.getAction());
                            			}
                            		}
                            	}
                            }
                            //b.repaint();
                            //b.DrawSettlementOn(minTile, b.getGraphics());
                            
                            players.get(currentPlayer-1).setNumHouses(players.get(currentPlayer-1).getNumHouses()-1);
                            doingSpecialAction = false;
                            b.setPlacingSpecials(false);
                    	}
                        
                    }
                    

                }
            }
            if(action.equals("Tower")) {

            }
            if(action.equals("Tavern")) {

            }
            if(action.equals("Barn")) {

            }
            if(action.equals("Harbor")) {

            }
            //b.setPlacingSpecials(false);
            b.repaint();
            
        }
        if(placingSettlements) {
            if(numSettlementsPlaced >= 1) {
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
                    //System.out.println(players.get(currentPlayer-1).getTerrainCard().getCardType());
                    //System.out.println(minTile.getType());
                    if(players.get(currentPlayer-1).getTerrainCard() != null) {
                    if(minTile.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType()) && minTile.getSettlement() == null) {
                    	
                    	ArrayList<Tile> temp16 = new ArrayList<>();
                    	for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    		if(t.getType().equals(players.get(currentPlayer-1).getTerrainCard().getCardType())) {
                    			temp16.add(t);
                    			//b.HighlightTile(t, b.getGraphics());
                    		}
                    	}
                    	if(temp16.size() != 0) {
                    		int cnt = 0;
                    		for(Tile t : players.get(currentPlayer-1).getAllAdjacentTiles()) {
                    			
                    			if(t == minTile) {
                    				cnt++;
                    			}
                    		} 
                    		if(cnt >= 1) {
                    			Settlement s = new Settlement(minTile, players.get(currentPlayer-1));
                                players.get(currentPlayer-1).addHouse(s);
                                minTile.setSettlement(s);
                                ArrayList<Tile> tt = minTile.getAdjacentTiles();
                                for(Tile ttt:tt) {
                                	if(!(ttt.getType().equals("Water")) && !(ttt.getType().equals("Grass")) && !(ttt.getType().equals("Mountain")) && !(ttt.getType().equals("Desert")) && !(ttt.getType().equals("Forest")) && !(ttt.getType().equals("Flower")) && !(ttt.getType().equals("Canyon"))) {
                                		SpecialTile tttt= (SpecialTile) ttt;
                                		if(tttt.getType().equals("Castle")) {
                                			int cnt421 = 0;
                                			for(Tile ttttt : players.get(currentPlayer-1).getRawAdjacentTiles()) {
                                				if(ttttt.getX()==(tttt.getX()) && ttttt.getY()==(tttt.getY())) {
                                					cnt421++;
                                				}
                                			}
                                			if(cnt421 == 1) {
                                				players.get(currentPlayer-1).addScore(3);
                                			}
                                			
                                			System.out.println(players.get(currentPlayer-1).getScore());
                                		}
                                		else {
                                			int cnt55 = 0;
                                			for(ActionToken a : players.get(currentPlayer-1).getSpecialActions()) {
                                				if(a.getID() == tttt.getAction().getID()) {
                                					cnt55++;
                                				}
                                			}
                                			if(cnt55 == 0) {
                                				tttt.getAction().setUsed(true);
                                				players.get(currentPlayer-1).addSpecialAction(tttt.getAction());
                                			}
                                		}
                                	}
                                }
                                //b.DrawSettlementOn(minTile, b.getGraphics());
                                numSettlementsPlaced --;
                                players.get(currentPlayer-1).setNumHouses(players.get(currentPlayer-1).getNumHouses()-1);
                    		}
                    	}
                    	else {
                    		Settlement s = new Settlement(minTile, players.get(currentPlayer-1));
                            players.get(currentPlayer-1).addHouse(s);
                            minTile.setSettlement(s);
                            ArrayList<Tile> tt = minTile.getAdjacentTiles();
                            for(Tile ttt:tt) {
                            	if(!(ttt.getType().equals("Water")) && !(ttt.getType().equals("Grass")) && !(ttt.getType().equals("Mountain")) && !(ttt.getType().equals("Desert")) && !(ttt.getType().equals("Forest")) && !(ttt.getType().equals("Flower")) && !(ttt.getType().equals("Canyon"))) {
                            		SpecialTile tttt= (SpecialTile) ttt;
                            		if(tttt.getType().equals("Castle")) {
                            			if(tttt.getType().equals("Castle")) {
                                			int cnt420 = 0;
                                			for(Tile ttttt : players.get(currentPlayer-1).getRawAdjacentTiles()) {
                                				if(ttttt.getX()==(tttt.getX()) && ttttt.getY()==(tttt.getY())) {
                                			
                                					cnt420++;
                                				}
                                			}
                                			
                                			if(cnt420 == 1) {
                                				players.get(currentPlayer-1).addScore(3);
                                			}
                                			
                                			System.out.println(players.get(currentPlayer-1).getScore());
                                		}
                            		}
                            		else {
                            			int cnt69 = 0;
                            			for(ActionToken a : players.get(currentPlayer-1).getSpecialActions()) {
                            				if(a.getID() == tttt.getAction().getID()) {
                            					cnt69++;
                            				}
                            			}
                            			if(cnt69 == 0) {
                            				tttt.getAction().setUsed(true);
                            				players.get(currentPlayer-1).addSpecialAction(tttt.getAction());
                            			}
                            		}
                            	}
                            }
                            //b.repaint();
                            //b.DrawSettlementOn(minTile, b.getGraphics());
                            numSettlementsPlaced --;
                            players.get(currentPlayer-1).setNumHouses(players.get(currentPlayer-1).getNumHouses()-1);
                    	}
                        
                    }}
                    

                }
                b.repaint();
            }
            else {
                placingSettlements = false;
                b.setPlacingSettlements(false);
                //numSettlementsPlaced = 3;

                
                
                b.repaint();
            }
        }
        //Player 1
        if(currentPlayer == 1) {
        if(x >= 17 && y >= 112 && x <= 66 && y <= 161 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	System.out.println("AM HERE HELP");
        	if(players.get(0).getSpecialActions().size() >= 1) {
        		if(!(players.get(0).getSpecialActions().get(0).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(0).getSpecialActions().get(0).getAction();
        			players.get(0).getSpecialActions().get(0).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 17 && y >= 164 && x <= 66 && y <= 217 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(0).getSpecialActions().size() >= 2) {
        		if(!(players.get(0).getSpecialActions().get(1).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(0).getSpecialActions().get(1).getAction();
        			players.get(0).getSpecialActions().get(1).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 77 && y >= 112 && x <= 131 && y <= 161 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(0).getSpecialActions().size() >= 3) {
        		if(!(players.get(0).getSpecialActions().get(2).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(0).getSpecialActions().get(2).getAction();
        			players.get(0).getSpecialActions().get(1).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 77 && y >= 164 && x <= 131 && y <= 217 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(0).getSpecialActions().size() >= 4) {
        		if(!(players.get(0).getSpecialActions().get(3).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(0).getSpecialActions().get(3).getAction();
        			players.get(0).getSpecialActions().get(3).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        b.repaint();
        }
        
        
        //Player 2
        if(currentPlayer == 2) {
        if(x >= 411 && y >= 112 && x <= 458 && y <= 161 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(1).getSpecialActions().size() >= 1) {
        		if(!(players.get(1).getSpecialActions().get(0).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(1).getSpecialActions().get(0).getAction();
        			players.get(1).getSpecialActions().get(0).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 411 && y >= 164 && x <= 458 && y <= 217 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(1).getSpecialActions().size() >= 2) {
        		if(!(players.get(1).getSpecialActions().get(1).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(1).getSpecialActions().get(1).getAction();
        			players.get(1).getSpecialActions().get(1).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 471 && y >= 112 && x <= 523 && y <= 161 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(1).getSpecialActions().size() >= 3) {
        		if(!(players.get(1).getSpecialActions().get(2).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(1).getSpecialActions().get(2).getAction();
        			players.get(1).getSpecialActions().get(2).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 471 && y >= 164 && x <= 523 && y <= 217 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(1).getSpecialActions().size() >= 4) {
        		if(!(players.get(1).getSpecialActions().get(3).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(1).getSpecialActions().get(3).getAction();
        			players.get(1).getSpecialActions().get(3).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        }
        //Player 3
        if(currentPlayer == 3) {
        if(x >= 790 && y >= 112 && x <= 835 && y <= 161 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(2).getSpecialActions().size() >= 1) {
        		if(!(players.get(2).getSpecialActions().get(0).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(2).getSpecialActions().get(0).getAction();
        			players.get(2).getSpecialActions().get(0).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 790 && y >= 164 && x <= 835 && y <= 217 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(2).getSpecialActions().size() >= 2) {
        		if(!(players.get(2).getSpecialActions().get(1).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(2).getSpecialActions().get(1).getAction();
        			players.get(2).getSpecialActions().get(1).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 860 && y >= 112 && x <= 901 && y <= 161 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction) && !(placingSettlements)) {
        	if(players.get(2).getSpecialActions().size() >= 3) {
        		if(!(players.get(2).getSpecialActions().get(2).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(2).getSpecialActions().get(2).getAction();
        			players.get(2).getSpecialActions().get(2).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 860 && y >= 164 && x <= 901 && y <= 217 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction) && !(placingSettlements)) {
        	if(players.get(2).getSpecialActions().size() >= 4) {
        		if(!(players.get(2).getSpecialActions().get(3).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(2).getSpecialActions().get(3).getAction();
        			players.get(2).getSpecialActions().get(3).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        b.repaint();
        }
        
        //Player 4
        if(currentPlayer == 4) {
        if(x >= 1171 && y >= 112 && x <= 1218 && y <= 161 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction) && !(placingSettlements)) {
        	if(players.get(3).getSpecialActions().size() >= 1) {
        		if(!(players.get(3).getSpecialActions().get(0).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(3).getSpecialActions().get(0).getAction();
        			players.get(3).getSpecialActions().get(0).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 1171 && y >= 164 && x <= 1218 && y <= 217 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(3).getSpecialActions().size() >= 1) {
        		if(!(players.get(3).getSpecialActions().get(1).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(3).getSpecialActions().get(1).getAction();
        			players.get(3).getSpecialActions().get(1).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 1231 && y >= 112 && x <= 1283 && y <= 161 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(3).getSpecialActions().size() >= 1) {
        		if(!(players.get(3).getSpecialActions().get(2).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(3).getSpecialActions().get(2).getAction();
        			players.get(3).getSpecialActions().get(2).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        if(x >= 1231 && y >= 164 && x <= 1283 && y <= 217 && (numSettlementsPlaced == 0 || numSettlementsPlaced == 3) && !(doingSpecialAction)&& !(placingSettlements)) {
        	if(players.get(3).getSpecialActions().size() >= 1) {
        		if(!(players.get(3).getSpecialActions().get(3).getUsed())) {
        			doingSpecialAction = true;
        			action = players.get(3).getSpecialActions().get(3).getAction();
        			players.get(3).getSpecialActions().get(3).setUsed(true);
        			b.setPlacingSpecials(true);
        			b.setSpecialActionUsed(action);
        		}
        	}
        }
        b.repaint();
        }
        
        
        if(x >= 1300 && y >= 320 && x <= 1467 && y <= 568 && !(drawnTerrainCard)) {
        	drawnTerrainCard = true;
        	b.AddTerrainCard(players.get(currentPlayer-1));
        	b.repaint();
        }
        //if()
        if(x >= 604 && y >= 598 && x <= 945 && y <= 729 && numSettlementsPlaced == 0) {
            //hi
            if(players.get(currentPlayer-1).getNumHouses() <= 0) {
                endGame = true;
            }
            for(ActionToken t : players.get(currentPlayer-1).getSpecialActions()) {
            	t.setUsed(false);
            }
        	currentPlayer++;
            currentPlayer = currentPlayer % 5;
            
            if(currentPlayer == 0 && endGame) {
                b.setState("End");
            }
            if(currentPlayer == 0) {
            	currentPlayer++;
            }
            b.setCurrentPlayer(currentPlayer);
            b.repaint();
            numSettlementsPlaced = 3;
            drawnTerrainCard = false;
        }
        if(currentPlayer == 1) {
            if(x >= 222 && y >= 39 && x <= 337 && y <= 201 && drawnTerrainCard) {
                placingSettlements = true;
                
                b.setPlacingSettlements(true);
                b.repaint();
            }
        }
        if(currentPlayer == 2) {
            if(x >= 611 && y >= 39 && x <= 726 && y <= 201 && drawnTerrainCard) {
                placingSettlements = true;
                b.setPlacingSettlements(true);
                b.repaint();
            }
        }
        if(currentPlayer == 3) {
            if(x >= 991 && y >= 39 && x <= 1107 && y <= 201 && drawnTerrainCard) {
                placingSettlements = true;
                b.setPlacingSettlements(true);
                b.repaint();
            }
        }
        if(currentPlayer == 4) {
            if(x >= 1373 && y >= 39 && x <= 1489 && y <= 201 && drawnTerrainCard) {
                placingSettlements = true;
                b.setPlacingSettlements(true);
                b.repaint();

            }
        }

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
                /*
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
        		*/
            }

        }
        //System.out.println("W" + b.getWidth());
    	//System.out.println("H" + b.getHeight());
        if(state.equals("start")){
            if(x >= c.getWidth()/2 -162 && y >= c.getHeight()/3 && x <= c.getWidth()/2 - 162 + 325 && y <= c.getHeight()/3 + 125){
                c.setState("Game");
                c.repaint();
                //System.out.println("state changed");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
    //hi

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public boolean getPlacing() {
    	return placingSettlements;
    }
}

