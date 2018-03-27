package Control;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Animal;
import Model.GPS;
import Model.Penguin;
import Model.SeaLion;
import Model.Walrus;

public class Controller {
	private ArrayList<Animal> animals;
	private FileIO file;
	
	public Controller(){
		animals = new ArrayList<Animal>();
		file = new FileIO();
	}
	
	public String[] validadeMainInfo(String type, String specie, String sex, String weight, String gps){
		  String[] validator = new String[4];
		//Validator for type
		  String patternType = "^[A-Za-z]+[\\s?[A-Za-z]+]*$";
	      Pattern r = Pattern.compile(patternType);

	    // Now create matcher object.
	      Matcher m = r.matcher(specie);
	      if (!m.find()) {
	    	  validator[0] = "Invalid specie name! Please try letters ans space only.";
	      }else{
	    	  validator[0] = "0";
	      }
	    // Validator for sex
	      patternType ="^[M|F]";
	      r = Pattern.compile(patternType);
	      m = r.matcher(sex);
	      if (!m.find()) {
	    	  validator[1] = "Invalid sex option! Please try 'Masculine' or 'Feminine' only.";
	      }else{
	    	  validator[1] = "0";
	      }
	   // Validator for weight
	      patternType ="^[0-9]+\\.?[0-9]*?$";
	      r = Pattern.compile(patternType);
	      m = r.matcher(weight);
	      if (!m.find()) {
	    	  validator[2] = "Invalid weight number! Please try an interger or a float number.";
	      }else{
	    	  validator[2] = "0";
	      }
	   // Validator for GPS
	      validator[3] = GPS.gpsValidator(gps);
		return validator;
	      
	}
	public String validatePenguinAditionalInfo(String bloodPresure){
		String message ="";
		//Validator for bloodPresure
		  String patternType = "^[0-9]+\\.?[0-9]*?$";
	      Pattern r = Pattern.compile(patternType);

	    // Now create matcher object.
	      Matcher m = r.matcher(bloodPresure);
	      if (!m.find()) {
	    	  message = "Invalid blood presure! Please try 0.0 format";
	      }else{
	    	  message = "0";
	      }
	      return message;
		
	}
	public String validateWalrusAditionalInfo(String dentalCondition){
		String message ="";
		//Validator for dentalCondition
		  String patternType = "^(Good|Average|Poor)$";
	      Pattern r = Pattern.compile(patternType);

	    // Now create matcher object.
	      Matcher m = r.matcher(dentalCondition);
	      if (!m.find()) {
	    	  message = "Invalid dental condition option! Please try Good|Average|Poor.";
	      }else{
	    	  message = "0";
	      }
	      return message;
	}
	public String validateSeaLionAditionalInfo(String spots){
		String message ="";
		//Validator for spots
		  String patternType = "^[0-9]+$";
	      Pattern r = Pattern.compile(patternType);

	    // Now create matcher object.
	      Matcher m = r.matcher(spots);
	      if (!m.find()) {
	    	  message = "Invalid spots number! Please try an integer number.";
	      }else{
	    	  message = "0";
	      }
	      return message;
	}
	
	public Animal createPenguin(String animalTypeName, String animalSpecieName, String animalSexValue,
			String animalWeightValue, String animalGpsValue, String bloodPresure) throws IOException {
			GPS gps = new GPS();
			gps.addCoordinate(animalGpsValue);
			Animal penguin = new Penguin(animalTypeName, animalSpecieName, animalSexValue, Double.parseDouble(animalWeightValue), gps, Double.parseDouble(bloodPresure));
			file.saveStringIntoFile("report", penguin.toString());
			return penguin;
	}
	public Animal createSeaLion(String animalTypeName, String animalSpecieName, String animalSexValue,
			String animalWeightValue, String animalGpsValue, String spots) throws IOException {
			GPS gps = new GPS();
			gps.addCoordinate(animalGpsValue);
			Animal seaLion = new SeaLion(animalTypeName, animalSpecieName, animalSexValue, Double.parseDouble(animalWeightValue), gps, Integer.parseInt(spots));
			file.saveStringIntoFile("report", seaLion.toString());
			return seaLion;
	}
	public Animal createWalrus(String animalTypeName, String animalSpecieName, String animalSexValue,
			String animalWeightValue, String animalGpsValue, String dentalCondition) throws IOException {
			GPS gps = new GPS();
			gps.addCoordinate(animalGpsValue);
			Animal walrus = new Walrus(animalTypeName, animalSpecieName, animalSexValue, Double.parseDouble(animalWeightValue), gps, dentalCondition);
			file.saveStringIntoFile("report", walrus.toString());
			return walrus;
	}

	public String showReport(){
		return file.getStringFromFile("report");
	}
}
