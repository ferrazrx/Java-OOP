package Control;
import View.SalePersonInput;
import Model.SalePerson;
import Model.Item;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]){
		
		boolean continueProgram = true;
		ArrayList<SalePerson> employees = new ArrayList<SalePerson>();
		
		while(continueProgram){
			String name = SalePersonInput.showNameInput();
			
			SalePerson employee = new SalePerson(name);
			
			ArrayList<Item> items = employee.getItems();
			
			for(Item item : items){
				int amount = SalePersonInput.showItemInput(item);
				item.setAmount(amount);
			};
			
			employee.calculateEmployeeTotal();
			
			employees.add(employee);
			
			SalePerson bestSeller = Calculate.getBestSeller(employees);
			Item bestItem = Calculate.getBestItem(employees);
			
			SalePersonInput.showTotal(employee, bestSeller, bestItem);
			
			continueProgram = SalePersonInput.continueProgram();
		}
	};
}
