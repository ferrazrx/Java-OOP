package Model;

public class Flight {
	private Seat[][] seats;
	private int rows;
	private int seatPerRow;

	
	//Constructor
	public Flight(int rows, int seatPerRow, int rowsInFirstClass){
		this.rows = rows;
		this.seatPerRow = seatPerRow;
		
		this.seats = new Seat[rows][seatPerRow];

		for(int i = 0; i<rows; i++){
			for(int j = 0; j<seatPerRow; j++){
				this.seats[i][j] = new Seat();
				int[] position = {i,j};
				this.seats[i][j].setPosition(position);
				if(j == 0 || j==(seatPerRow-1)){
					this.seats[i][j].setWindow(true);
				}
				if(i<rowsInFirstClass){
					this.seats[i][j].setFlighClass(1);
				}else{
					this.seats[i][j].setFlighClass(2);
				}
			}
		}
		
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getSeatPerRow() {
		return seatPerRow;
	}

	public void setSeatPerRow(int seatPerRow) {
		this.seatPerRow = seatPerRow;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}

	public Seat getSeat(int row, int column){
		return this.seats[row][column];
	}

}
