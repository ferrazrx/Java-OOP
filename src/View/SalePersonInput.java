package View;
import javax.swing.JOptionPane;
import Model.Item;
import Model.SalePerson;

public class SalePersonInput {
	public static String showNameInput(){
		String name = JOptionPane.showInputDialog("Enter the employee's name: ");
		return name;
	}
	public static int showItemInput(Item item){
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Enter amount for Item #" + item.getNumber() + "(price $" + item.getPrice() + ")" + ":"));
		return amount;
	}
	public static void showTotal(SalePerson person){
		JOptionPane.showMessageDialog(null, "Employee's Name:" + person.getName() + "\nTotal: $" + String.format("%10.2f", person.getTotalSale()));
	}
	public static boolean continueProgram(){
		boolean error = true;
		String continueProgram = "";
		while(error){
			continueProgram = JOptionPane.showInputDialog("Continue calculating new employee's total income(Y/N)?");
			switch(continueProgram){
				case "y":
				case "yes":
				case "Y":
					error = false;
					return true;
				case "n":
				case "no":
				case "N":
					error= false;
					return false;
				default:
					JOptionPane.showMessageDialog(null, "Wrong Input, try again!");
					break;
			}
		}
		return false;
	}
}
