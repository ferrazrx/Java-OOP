package Model;

import java.util.ArrayList;

public class Heroe extends Caracter{
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Heroe(String name, int lifePoints, ArrayList<Item> items, float money, int attackPoints, int defensePoints, String img, String bg) {
		super(name, lifePoints, items, money, attackPoints, defensePoints, img, bg);
		// TODO Auto-generated constructor stub
	}
	

}
