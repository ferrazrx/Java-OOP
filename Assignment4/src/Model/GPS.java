package Model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GPS {
	private ArrayList<String> coordinates;
	
	public GPS(){
		coordinates = new ArrayList<String>();
	}

	public ArrayList<String> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<String> coordinates) {
		this.coordinates = coordinates;
	}
	public void addCoordinate(String coordinate){
		coordinates.add(coordinate);
	}
	public static String gpsValidator(String coordinate){
		String patternType ="^(\\-?\\d+(\\.\\d+)?),\\s*(\\-?\\d+(\\.\\d+)?)$";
		Pattern r = Pattern.compile(patternType);
		Matcher m = r.matcher(coordinate);
		String validator;
	      if (!m.find()) {
	    	  validator = "Invalid GPS coordinate! Please try this pattern 0.0000, -0.00000";
	      }else{
	    	  validator = "0";
	      }
	    return validator; 
	}
	public String getFirstCoordinate(){
		
		return coordinates.get(0);
		
	}
}
