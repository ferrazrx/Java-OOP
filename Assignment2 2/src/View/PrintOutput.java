package View;
import javax.swing.JOptionPane;

import Model.Flight;
import Model.Seat;
import java.util.Objects;

public class PrintOutput {
	
	public int printPlaneSeats(Flight flight, int[] position){
		Seat[][] seats = flight.getSeats();
		boolean rowFound = false;
		String message = "        / | |  \\\n" + "     /    --      \\\n"+ "   /                  \\\n";
		message += "   -----------\n";
		int confirm = 2;
		
		for(int i = 0; i<flight.getRows(); i++){
			String row = "";
			message+= (i+1) + " |";
			for(int j = 0; j<flight.getSeatPerRow(); j++){
				message += (seats[i][j].isOccupied()==true ? "X |" : (seats[i][j].getPosition() == position ? "M |" : " O |"));
				row+=(seats[i][j].isOccupied()==true ? "X |" : (seats[i][j].getPosition() == position ? "M |" : " O |"));
				if(j == (flight.getSeatPerRow()-1)){
					if(row.contains("M")){
						message+=" <- Your seat is mark with a M";
					}
				};
			}
			message+=(rowFound? "Your seat is mark with a M" : "");
			message+="\n";
		}
		message+="   -----------\n";           
		message+="\n\n\n\tDo you confirm your seat?";
		confirm = JOptionPane.showConfirmDialog(null, message);
		return confirm;
	}
	
	public void printPlaneSeats(Flight flight){
		Seat[][] seats = flight.getSeats();
		String message = "        / | |  \\\n" + "     /    --      \\\n"+ "   /                  \\\n";
		message += "   -----------\n";
		
		for(int i = 0; i<flight.getRows(); i++){
			message+= (i+1) + " |";
			for(int j = 0; j<flight.getSeatPerRow(); j++){
				message += (seats[i][j].isOccupied()==true ? "X |" : " O |");
				
			};
			message+="\n";
		}
	
		message+="   -----------\n";           
		message+="\n\n\n\tNo options available! Please try again!";
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	public int printClassOptions(){
		String classOption;
		boolean error = true;
		
		do{
			String message = "\t Flight Reservation Seat System" +
						 "\t\n------------------------------------------\n\nDo you want a seat in the first or second class?(Enter 1 or 2)";
			classOption = JOptionPane.showInputDialog(message);
			if(classOption == null){
				JOptionPane.showMessageDialog(null, "You canceled the option!");
				classOption = "0";
				error= false;
			}else
			if(!classOption.equals("1") && !classOption.equals("2")){
				JOptionPane.showMessageDialog(null, "Invalid input! Please, try again!");
			}else{
				error = false;
			}
		}while(error);
		
		
		return Integer.parseInt(classOption);
	}
	
	public String printGetName(){
		String name ="";
		boolean errorFound = true;
		
		do{
			String message = "\t Flight Reservation Seat System" +
						 "\t\n------------------------------------------\n\nEnter Passanger's Name or Id:";
			name = JOptionPane.showInputDialog(message);
			if(name == null){
				JOptionPane.showMessageDialog(null, "You canceled the option! The name will be set to guest");
				name = "Guest";
				errorFound = false;
			} else {
				int count = 0;
				for(int i=0;i<name.length();i++){
					if(name.charAt(i) == ' '){
					JOptionPane.showMessageDialog(null, "Invalid input! Please, try again!");
					count++;
					break;
					}
				};
				
				if(count == 0){
					errorFound = false;	
				}	
			}
			
		}while(errorFound);
		
		
		return name;	
	}
	
	public String printWindowsOptions(){
		String windowsOption;
		boolean error = true;
		
		
		do{
			String message = "\t Flight Reservation Seat System" +
						 "\n\t------------------------------------------\n\nDo you want a seat in the window?(Enter Y or N)";
			windowsOption = JOptionPane.showInputDialog(message);
			if(windowsOption == null){
				JOptionPane.showMessageDialog(null, "You cancelled the option!");
				return null;
			}else{
				windowsOption = windowsOption.toUpperCase();
				if(windowsOption.isEmpty() || (!windowsOption.equals("Y") && !windowsOption.equals("N"))){
					JOptionPane.showMessageDialog(null, "Invalid input! Please, try again!");
				}else{
					switch(windowsOption){
						case "Yes":
						case "Y":
						case "y": windowsOption = "Y";
							break;
						case "Not":
						case "N":
						case "n": windowsOption = "N";
							break;
					}
					error = false;
				}
			}
			
		}while(error);
		return windowsOption ;
		

	}
	
	public void printTicket(Seat seat){
		String message = "\t Flight Reservation Seat System" +
						 "\n\t------------------------------------------";
		message+= "\n\t\tPassanger: " + seat.getPassangerName();
		message+= "\n\t\tSeat: " + "(Row: " + (seat.getPosition()[0]+1) + " "+ "Seat: " + (seat.getPosition()[1]+1)+")";
		message+= "\n\t\tClass: " + seat.getFlighClass() + " Class";
		message+= "\n\t\tWindows: " + (seat.isWindow()?"Yes":"No");
		
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void printCanceledMessage(){
		JOptionPane.showMessageDialog(null, "You cancelled the option!");
	}
	
	public boolean continueProgram(Flight flight){
		int option = JOptionPane.showConfirmDialog(null, "Continue Program?(Y or N)");
		String message = "Bye! \n\tBut before you go here is the list of passangers!\n";
		message += flight.getPassangers();
		if(option !=0){
			JOptionPane.showMessageDialog(null, message);
		}
		return (option == 0? true : false);
	}
}
