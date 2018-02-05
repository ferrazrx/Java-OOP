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
			if(classOption.isEmpty() || (!classOption.equals("1") && !classOption.equals("2"))){
				JOptionPane.showMessageDialog(null, "Invalid input! Please, try again!");
			}else{
				error = false;
			}
		}while(error);
		
		
		return Integer.parseInt(classOption);
		
		
	}
	
	public String printGetName(){
		String name ="";
		boolean error = true;
		
		do{
			String message = "\t Flight Reservation Seat System" +
						 "\t\n------------------------------------------\n\nEnter Passanger's Name or Id:";
			name = JOptionPane.showInputDialog(message);
			for(int i=0;i<name.length();i++){
				if(name.charAt(i) == ' '){
				JOptionPane.showMessageDialog(null, "Invalid input! Please, try again!");
				break;
				}
			};
			if(Objects.isNull(name)){
				JOptionPane.showMessageDialog(null, "You canceled the option! The name will be set to guest");
				name = "Guest";
				error = false;
			} else{
				error = false;
			}
		}while(error);
		
		
		return name;	
		
	}
	
	public boolean printSeatOptions(){
		String windowsOption;
		boolean error = true;
		
		
		do{
			String message = "\t Flight Reservation Seat System" +
						 "\n\t------------------------------------------\n\nDo you want a seat in the window?(Enter Y or N)";
			windowsOption = JOptionPane.showInputDialog(message);
			windowsOption = windowsOption.toUpperCase();
			if(windowsOption.isEmpty() || (!windowsOption.equals("Y") && !windowsOption.equals("N"))){
				JOptionPane.showMessageDialog(null, "Invalid input! Please, try again!");
			}else{
				error = false;
			}
		}while(error);
		
	 
		return (windowsOption.equals("Y")? true : false);
		

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

}
