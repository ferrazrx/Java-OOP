package Model;

public class Walrus extends Animal {
	
	@Override
	public String toString() {
		return this.type +":[ specie=" + this.specie + ", sex=" + this.sex + ", weight=" + this.weight + ", gpsCordinate=" + this.gpsCordinate.getFirstCoordinate()
				+", dentalStatus=" + dentalStatus + "] end ";
	}

	private String dentalStatus;
	
	public Walrus(String type, String specie, String sex, double weight, GPS gpsCordinate, String dentalStatus) {
		super(type, specie, sex, weight, gpsCordinate);
		this.setDentalStatus(dentalStatus);
		// TODO Auto-generated constructor stub
	}

	public String getDentalStatus() {
		return dentalStatus;
	}

	public void setDentalStatus(String dentalStatus) {
		this.dentalStatus = dentalStatus;
	}
}
