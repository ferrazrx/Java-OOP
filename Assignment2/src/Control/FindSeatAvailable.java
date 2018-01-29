package Control;

import Model.Flight;
import Model.Seat;

public class FindSeatAvailable {

	public static Seat findSeatAvailable(int flightclass, boolean windows, Flight flight){
		
		Seat seatFound = null;
		
		for(int i=0; i<flight.getRows();i++){
			for(int j=0; j<flight.getSeatPerRow();j++){
				Seat[][] seat = flight.getSeats();
				if(!seat[i][j].isOccupied()){
					if(seat[i][j].isWindow() == windows){
						if(seat[i][j].getFlighClass() == flightclass){
							seatFound = seat[i][j];
							System.out.println(seatFound.toString());
						}
					}
				}
			}
		}
		return seatFound;
	}
}
