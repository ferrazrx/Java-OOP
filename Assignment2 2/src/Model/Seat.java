package Model;

import java.util.Arrays;

public class Seat {
	
	private int[] position;
	private boolean occupied = false;
	private int flighClass;
	private boolean isWindow;
	private String passangerName;
	
	public int[] getPosition() {
		return position;
	}
	public void setPosition(int[] position) {
		this.position = position;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public boolean isWindow() {
		return isWindow;
	}
	public void setWindow(boolean isWindow) {
		this.isWindow = isWindow;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public int getFlighClass() {
		return flighClass;
	}
	public void setFlighClass(int flighClass) {
		this.flighClass = flighClass;
	}
	
	@Override
	public String toString() {
		return "Seat [position=" + Arrays.toString(position) + ", occupied=" + occupied + ", flighClass=" + flighClass
				+ ", isWindow=" + isWindow + ", passanger=" + passangerName + "]";
	}
}
