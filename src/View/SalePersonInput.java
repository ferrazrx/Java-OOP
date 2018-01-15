package View;
import javax.swing.JOptionPane;
import Model.Item;
import Model.SalePerson;


public class SalePersonInput {
	
	public static String showNameInput(){
		String first_name;
		String last_name;
		boolean error = true;
		
		do{
			first_name = JOptionPane.showInputDialog("Enter the employee's first name: ");
			if(first_name == null){
				first_name = "Guest";
				JOptionPane.showMessageDialog(null, "You cancelled the name option, the name will be set to 'Guest'.");
				break;
			}
			for(int i = 0;i<first_name.length();i++){
				if(!first_name.isEmpty() && !Character.isDigit(first_name.charAt(i)) && !(first_name.charAt(i) == ' ')){
					error = false;
				}
				else{
					error = true;
				};
			};
			if(error){
				JOptionPane.showMessageDialog(null, "Invalid input - Please use alphabetic caracters!");
			}
		}while(error);
		
		error = true;
		
		do{
			last_name = JOptionPane.showInputDialog("Enter the employee's last name: ");
			if(last_name == null){
				last_name = " ";
				JOptionPane.showMessageDialog(null, "You cancelled the last name option!");
				break;
			}
			for(int i = 0;i<last_name.length();i++){
				if(!last_name.isEmpty() && !Character.isDigit(last_name.charAt(i)) && !(last_name.charAt(i) == ' ')){
					error = false;
				}
				else{
					error = true;
				};
			};
			if(error){
				JOptionPane.showMessageDialog(null, "Invalid input - Please use alphabetic caracters!");
			}
		}while(error);
		

		return first_name + " " + last_name;
	}
	
	public static int showItemInput(Item item){
		boolean error = true;
		String amount;
		int amount_n = 0;
		
		do{
			try{
				amount = JOptionPane.showInputDialog("Enter amount for Item #" + item.getNumber() + "(price $" + item.getPrice() + ")" + ":");
				if(amount == null){
					JOptionPane.showMessageDialog(null, "You cancelled the item option.");
					break;
				}else{
					amount_n = Integer.parseInt(amount);
				}
				error = false;
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, e.getMessage() + "\n\n\tYou enter an invalid digit. Please, try again!");
			};
		}while(error);	
			
			return amount_n;
	}
	
	public static void showTotal(SalePerson person, SalePerson bestPerson, Item item){
		JOptionPane.showMessageDialog(null, "Employee's Name: " + person.getName() +
				"\nTotal: $ " + String.format("%10.2f", person.getTotal())
				+ "\n\n\t Top Sale Person:" + bestPerson.getName()+" - Total: $" + String.format("%10.2f", bestPerson.getTotal())
				+"\n\t Top Item: #" + item.getNumber() );
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
