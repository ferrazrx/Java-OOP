package Control;
import View.SalePersonInput;
import Model.SalePerson;
import Model.Item;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]){
		boolean continueProgram = true;
		while(continueProgram){
			String name = SalePersonInput.showNameInput();
			SalePerson employee = new SalePerson(name);
			ArrayList<Item> items = employee.getItems();
			for(Item item : items){
				int amount = SalePersonInput.showItemInput(item);
				item.setAmount(amount);
			}
			SalePersonInput.showTotal(employee);
			continueProgram = SalePersonInput.continueProgram();
		}
	};
}
