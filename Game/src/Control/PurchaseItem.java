package Control;

import Model.Game;

public class PurchaseItem {
	public static boolean process(Game game, int item1, int item2, int item3){
		float total = 0;
        total += (item1 == 1)? game.getPlayer().getItems().get(0).getPrice() : 0;
        total += (item2 == 1)? game.getPlayer().getItems().get(1).getPrice() : 0;
        total += (item3 == 1)? game.getPlayer().getItems().get(2).getPrice() : 0;
        
        if(game.getPlayer().getMoney() > total){
        	if(item1 ==1){
        		game.getPlayer().setAttackPoints(game.getPlayer().getAttackPoints() + game.getPlayer().getItems().get(0).getAttackPoints());
        		game.getPlayer().setDefensePoints(game.getPlayer().getDefensePoints() + game.getPlayer().getItems().get(0).getDefensePoints());
        		game.getPlayer().getItems().get(0).setAmount(game.getPlayer().getItems().get(0).getAmount() + 1);
        	}
        	if(item2 ==1){
        		game.getPlayer().setAttackPoints(game.getPlayer().getAttackPoints() + game.getPlayer().getItems().get(1).getAttackPoints());
        		game.getPlayer().setDefensePoints(game.getPlayer().getDefensePoints() + game.getPlayer().getItems().get(1).getDefensePoints());
        		game.getPlayer().getItems().get(1).setAmount(game.getPlayer().getItems().get(1).getAmount() + 1);
        	}
        	if(item3 ==1){
        		game.getPlayer().setAttackPoints(game.getPlayer().getAttackPoints() + game.getPlayer().getItems().get(2).getAttackPoints());
        		game.getPlayer().setDefensePoints(game.getPlayer().getDefensePoints() + game.getPlayer().getItems().get(2).getDefensePoints());
        		game.getPlayer().getItems().get(2).setAmount(game.getPlayer().getItems().get(2).getAmount() + 1);
        	}
        	
        	game.getPlayer().setMoney(game.getPlayer().getMoney() - total);
        	
        	return true;
        }else{
        	return false;
        }
	}	
}
