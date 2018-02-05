package Control;

import Model.Flight;
import Model.Seat;
import View.PrintOutput;

public class ApplicationStart {
	
	public ApplicationStart(){
		//Create a new FLight(rows, seatPerRow, rowsInTheFirstClass)
		Flight flight = new Flight(4,4,2);
		PrintOutput output = new PrintOutput();
		boolean continueProgram = true;
		
		do{	
			if(FindSeat.checkSeatAvailability(flight) == null){
				output.printPlaneSeats(flight);
			}else{
				String name = output.printGetName();
				int classOption = output.printClassOptions();
				if(classOption != 0){
					String windowsOption = output.printWindowsOptions();
					if(windowsOption != null){
						boolean windows = windowsOption == "Y"? true : false;
						Seat seat = FindSeat.findSeatAvailable(classOption, windows, flight);
						
						if(seat == null){
							output.printPlaneSeats(flight);
						}else{
						
							int confirm = output.printPlaneSeats(flight, seat.getPosition());
						
							if(confirm == 0){
								seat.setOccupied(true);
								seat.setPassangerName(name);
								output.printTicket(seat);
								continueProgram = output.continueProgram(flight);
							}else{
								output.printCanceledMessage();
							}
						}
					}
				}
			}		
				
		}while(continueProgram);	
		
	}
	
}
