package Model;

public abstract class Animal {
	protected String type;
	protected String specie;
	protected String sex;
	protected double weight;
	protected GPS gpsCordinate;
	
	public abstract String toString();
	
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GPS getGpsCordinate() {
		return gpsCordinate;
	}
	public void setGpsCordinate(GPS gpsCordinate) {
		this.gpsCordinate = gpsCordinate;
	}
	public Animal(String type, String specie, String sex, double weight, GPS gpsCordinate) {
		super();
		this.type = type;
		this.specie = specie;
		this.sex = sex;
		this.weight = weight;
		this.gpsCordinate = gpsCordinate;
	}
}
