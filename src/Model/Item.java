package Model;

public class Item {
	private int number;
	private double price;
	private int amount;
	public int getNumber() {
		return number;
	}
	
	public Item(int number, double price){
		this.number = number;
		this.price = price;
		this.amount = 0;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
