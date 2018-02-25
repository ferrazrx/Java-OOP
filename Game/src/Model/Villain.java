package Model;

import java.util.ArrayList;

public class Villain extends Caracter{
	private String[] message;
	
	

	public Villain(String name, int lifePoints, ArrayList<Item> items, float money, int attackPoints, int defensePoints, String img, String bg) {
		super(name,lifePoints,items, money, attackPoints, defensePoints,img, bg);
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}

}
