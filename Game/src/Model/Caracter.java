package Model;

import java.util.ArrayList;

public abstract class Caracter {
	protected String name;
	private int lifePoints;
	private ArrayList<Item> items;
	private float money;
	private int attackPoints;
	private int defensePoints;
	private String img;
	private String background;
	
	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Caracter(String name, int lifePoints, ArrayList<Item> items, float money, int attackPoints,
			int defensePoints, String img, String bg) {
		this.name = name;
		this.lifePoints = lifePoints;
		this.items = items;
		this.money = money;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.img = img;
		this.background = bg;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void addItem(Item items) {
		this.items.add(items);
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getAttackPoints() {
		return attackPoints;
	}
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}
	public int getDefensePoints() {
		return defensePoints;
	}
	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}

}
