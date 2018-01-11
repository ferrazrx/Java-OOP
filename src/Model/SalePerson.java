package Model;
import java.util.ArrayList;
import java.util.Arrays;

public class SalePerson {
	private String name;
	private ArrayList<Item> items;
	
	public SalePerson(String name){
		this.name = name;
		Item item1 = new Item(1,239.99);
		Item item2 = new Item(2,129.75);
		Item item3 = new Item(3,99.95);
		Item item4 = new Item(4,350.89);
		items = new ArrayList<Item>(Arrays.asList(item1,item2,item3,item4));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList getItems(){
		return this.items;
	}
	public Item getItemsId(int index) {
		return this.items.get(index);
	}

	public void setItem(Item item) {
		this.items.add(item);
	}
	public double getTotalSale(){
		double total = 0;
		for(Item item : this.items){
			total+= item.getPrice() * item.getAmount();
		}
		return total;
	}
}
