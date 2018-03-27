package Model;

public class SeaLion extends Animal {
	
	private int spots;
	
	public SeaLion(String type, String specie, String sex, double weight, GPS gpsCordinate, int spots) {
		super(type, specie, sex, weight, gpsCordinate);
		this.setSpots(spots);
		// TODO Auto-generated constructor stub
	}

	public int getSpots() {
		return spots;
	}

	public void setSpots(int spots) {
		this.spots = spots;
	}

	@Override
	public String toString() {
		return this.type +":[ specie=" + this.specie + ", sex=" + this.sex + ", weight=" + this.weight + ", gpsCordinate=" + this.gpsCordinate.getFirstCoordinate()
				+", spots=" + spots + "] end ";
	}


}
