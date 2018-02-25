package Model;

public class Item {
	private String name;
	private int attackPoints;
	private int defensePoints;
	private float price;
	private String description;
	private int amount;
	

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Item(String name, int attackPoints, int defensePoints, float price, String description) {
		super();
		this.name = name;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.price = price;
		this.description = description;
		this.amount = 0;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
