package Control;
import java.util.ArrayList;

import Model.Item;
import Model.SalePerson;

public class Calculate {
		
	public static SalePerson getBestSeller(ArrayList<SalePerson> employees){
		double total = 0;
		SalePerson bestone = null;
		for(SalePerson employee : employees){
			if(employee.getTotal()>total){
				total = employee.getTotal();
				bestone = employee;
			}
		}
		return bestone;
	}
	
	public static Item getBestItem(ArrayList<SalePerson> employees){
		int[] itemTotals = new int[4];
		int total = 0;
		int index = 0;
		for(SalePerson employee : employees){
			ArrayList<Item> items = employee.getItems();
			for(int i = 1; i<=items.size();i++){
				itemTotals[i-1] += items.get(i-1).getAmount();
			}
		}	
		
		for(int i = 0;i<itemTotals.length;i++){
			if(itemTotals[i] >= total){
				total = itemTotals[i];
				index = i;
			}
		}
		
		return employees.get(0).getItems().get(index);
	}
}
