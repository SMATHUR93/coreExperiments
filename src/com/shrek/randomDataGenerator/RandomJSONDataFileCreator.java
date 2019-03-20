package com.shrek.randomDataGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.*;

public class RandomJSONDataFileCreator {

	public static void main(String[] args) {
		
		//JSONObject vikingObj = new JSONObject();		
		JSONArray peopleArray =new JSONArray();
		int count = 50;	
		
		for (int i = 0; i < count; i++) {	
			String fname = randomValues(firstNames);
			String lname = randomValues(lastNames);
			String color = randomValues(colors);
			String city = randomValues(cities);
			int Strength =(int)Math.floor(Math.random() * 10);
			int Speed	 =(int)Math.floor(Math.random() * 10);
			int Knowledge =(int)Math.floor(Math.random() * 10);
			int Stamina =(int)Math.floor(Math.random() * 10);
			int Size =(int)Math.floor(Math.random() * 10);
			int Overall =Strength+Speed+Knowledge+Stamina+Size;
			JSONObject peopleObj = new JSONObject();			
			peopleObj.put("Id", (i+1));
			peopleObj.put("First_Name", fname);
			peopleObj.put("Last_Name", lname);
			peopleObj.put("Full_Name", fname+" "+lname);
			peopleObj.put("Color", color );
			peopleObj.put("City", city );
			peopleObj.put("Strength", Strength );
			peopleObj.put("Speed", Speed );
			peopleObj.put("Knowledge", Knowledge );
			peopleObj.put("Stamina", Stamina );
			peopleObj.put("Size", Size );
			peopleObj.put("Overall", Overall );
			
			int armyStrength =(int)Math.floor(Math.random() * 10);
			JSONArray vikingArray =new JSONArray();
			for (int j = 0; j < armyStrength; j++) {	
				String vfname = randomValues(vikingsFirstNames);
				String vlname = randomValues(vikingsLastNames);	
				JSONObject vikingObj = new JSONObject();			
				//vikingObj.put("First_Name", fname);
				//vikingObj.put("Last_Name", lname);
				vikingObj.put("Full_Name", vfname+" "+vlname);
				vikingObj.put("Strength", (int)Math.floor(Math.random() * 10) );
				vikingObj.put("Speed", (int)Math.floor(Math.random() * 10) );
				vikingObj.put("Knowledge", (int)Math.floor(Math.random() * 10) );
				vikingObj.put("Stamina", (int)Math.floor(Math.random() * 10) );
				vikingObj.put("Size", (int)Math.floor(Math.random() * 10) );
				//vikingArray.put(vikingObj); 
				vikingArray.add(vikingObj);  
			}		
			peopleObj.put("ArmyStrength", armyStrength);
			peopleObj.put("Vikings", vikingArray);
			//peopleArray.put(peopleObj);
			peopleArray.add(peopleObj);  
		}		
		
		System.out.println("loop over");		
  
        /*try {  
        	SimpleDateFormat ft = 
  			      new SimpleDateFormat ("yyyy-MM-dd-hh-mm-ss");
        	String fileName = "E:\\VikingJSONFile"+ft.format(new Date())+".json";
            File file1=new File(fileName);  
            file1.createNewFile();  
            FileWriter fileWriter1 = new FileWriter(file1);  
            System.out.println("Writing JSON object to file");  
            System.out.println("-----------------------");  
            System.out.print(vikingArray); 
            fileWriter1.write(vikingArray.toJSONString());             
            fileWriter1.flush(); 
            fileWriter1.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  */
        
        try{
         	SimpleDateFormat ft = 
  			      new SimpleDateFormat ("yyyy-MM-dd-hh-mm-ss");
        	String fileName = "/Users/smathur/mockWorkGitRepos/CoreExperiments/shrekFolder/PeopleJSONFile"+ft.format(new Date())+".json";
        	File file2=new File(fileName);  
            file2.createNewFile();  
            FileWriter fileWriter2 = new FileWriter(file2);  
            System.out.println("Writing JSON object to file");  
            System.out.println("-----------------------");  
            System.out.print(peopleArray);  
            //fileWriter2.write(peopleArray.toJSONString()); 
            fileWriter2.write(peopleArray.toString());
            fileWriter2.flush(); 
            fileWriter2.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        }       
		
	}
	
	/*Date getRandomDate() {
		  SimpleDateFormat ft = 
			      new SimpleDateFormat ("yyyy-MM-dd");
		  Date from;	
		  try {
	         from = ft.parse("1900-00-01"); 
	         System.out.println(from); 
	      }catch (Exception e) { 
	         System.out.println("Unparseable using " + ft); 
	      }				  
		  Date to = new Date();
		  return new Date(from + Math.random() * (to - from));
	}*/
	
	/*List<String> createFakeData(int count){
		List<String> data = new ArrayList<String>();
		  for (int i = 0; i < count; i++) {		    
		    data.add(randomVikingsName());
		  }
		  return data;		
	}*/
	
	static String randomValues(String[] list){   //randomVikingsName
		double Id = Math.floor(Math.random() * list.length); //vikingsFirstNames
	    //double lastNameId = Math.floor(Math.random() * vikingsLastNames.length);
	    //String completeName = vikingsFirstNames[(int)firstNameId]+" "+vikingsLastNames[(int)lastNameId];
	    return list[(int)Id];//completeName;
	}
	
	static String[] vikingsFirstNames = {"Aesir","Axe", "Bear", "Berg", "Biscuit", "Blade", "Blood", "Blue"
	, "Boar", "Board", "Bone", "Cage", "Cave", "Cheese", "Code", "Coffee"
	, "Death", "Dragon", "Dwarf", "Eel", "Elk", "Fjord", "Flame", "Flour"
	, "Forge", "Fork", "Fox", "Frost", "Furnace", "Goat", "God", "Gold"
	, "Granite", "Griffon", "Grim", "Haggis", "Hall", "Hamarr", "Helm", "Horn"
	, "Horse", "House", "Huskarl", "Ice", "Iceberg", "Jarl", "Kelp", "Kettle"
	, "Kraken", "Lake", "Long", "Mace", "Maelstrom", "Mail", "Mammoth", "Man"
	, "Many", "Mead", "Mountain", "Noun", "Oath", "Owl", "Pain", "Peak", "Pot"
	, "Rat", "Raven", "Red", "Refreshingbeverage", "Ring", "Rock", "Root", "Rune"
	, "Salmon", "Sap", "Sea", "Shield", "Ship", "Sky", "Slush", "Smoke", "Snow"
	, "Spear", "Squid", "Steam", "Stone", "Swine", "Three", "Tongue", "Torch"
	, "Tree", "Troll", "Ulfsark", "Unsightly", "Valkyrie", "Wave", "White"
	, "Woman", "Worm", "Wyvern"};
	
	static String[] vikingsLastNames =
	  {"Admirer", "Arm", "Back", "Baker", "Basher", "Beard", "Bearer", "Bender"
	 , "Blade", "Blender", "Blood", "Boiler", "Bone", "Boot", "Borer", "Born"
	 , "Bow", "Breaker", "Breeder", "Bringer", "Brow", "Builder", "Chaser"
	 , "Chiller", "Collar", "Counter", "Clubber", "Curser", "Dancer", "Dottir"
	 , "Dreamer", "Drinker", "Drowner", "Ear", "Eater", "Face", "Fearer"
	 , "Foot", "Friend", "Fury", "Gorer", "Grim", "Grinder", "Grower", "Growth"
	 , "Hacker", "Hall", "Ham", "Hammer", "Hand", "Hands", "Head", "Hilt"
	 , "Hunter", "Killer", "Leg", "Licker", "Liker", "Lost", "Lover", "Masher"
	 , "Mender" , "Minder", "Miner", "Mocker", "Monger", "Neck", "Rage"
	 , "Rhyme", "Rider", "Ringer", "Roarer", "Roller", "Sailor", "Screamer"
	 , "Sequel", "Server", "Shield", "Shoe", "Singer", "Skinner", "Slinger"
	 , "Slugger", "Smasher", "Sniffer", "Stinker", "Sucker", "Sword", "Tail"
	 , "Tamer", "Taster", "Thigh", "Tongue", "Tracker", "Washer"
	 , "Wielder", "Wing", "Wisher", "Wrath"};
	
	static String[] firstNames = {"Edard", "John", "Abraham", "Brandon", "Tyrion", "James", "Peter", "Bruce", "Clark", "Charles"};
	static String[] lastNames = {"Stark", "Targeryon", "Lannistor", "Baratheon", "Wayne", "Lincoln", "Smith", "Parker", "Roy", "Armstrong"};
	static String[] colors = {"Red", "blue", "green", "Yellow", "Orange", "Purple", "White", "Black", "Grey"};
	static String[] cities = {"London", "New York", "Tokyo", "Paris", "Rio De Janerio", "Moscow", "Hong Kong", "Los Angeles", "Bombay", "Sydney"};
}