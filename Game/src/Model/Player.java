package Model;

import java.util.ArrayList;

public class Player extends Caracter{
	
	public Player(String name, int lifePoints, ArrayList<Item> items, float money, int attackPoints, int defensePoints, String img, String bg){
		super(name,lifePoints,items, money, attackPoints, defensePoints, img, bg);
	}
	
    public void buyItem(Item item){
    	this.setMoney(this.getMoney() - item.getPrice());
    	this.addItem(item);
    }
}
