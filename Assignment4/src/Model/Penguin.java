package Model;

public class Penguin extends Animal {
	private double bloodPresure;
	
	public Penguin(String type, String specie, String sex, double weight, GPS gpsCordinate, double bloodPresure) {
		super(type, specie, sex, weight, gpsCordinate);
		this.bloodPresure = bloodPresure;
		// TODO Auto-generated constructor stub
	}

	public double getBloodPresure() {
		return bloodPresure;
	}


	public void setBloodPresure(double bloodPresure) {
		this.bloodPresure = bloodPresure;
	}

	@Override
	public String toString() {
		return this.type +":[ specie= " + this.specie + ", sex= " + this.sex + ", weight= " + this.weight + ", gpsCordinate= " + this.gpsCordinate.getFirstCoordinate()
		+", bloodPresure= "+ bloodPresure + "] end ";
	}
}
