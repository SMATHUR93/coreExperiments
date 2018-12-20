package com.shrek.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

class Person{
	String firstName;
	String lastName;
	Person(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public int hashCode(){
		return 420;
	}
}

class Hero{
	String name;
	int powerLevel;
	int skillLevel;
	int intelligenceLevel;
	int equipmentLevel;
	public Hero(String name,int powerLevel,int skillLevel,int intelligenceLevel,int equipmentLevel){
		this.name=name;
		this.powerLevel=powerLevel;
		this.skillLevel=skillLevel;
		this.intelligenceLevel=intelligenceLevel;
		this.equipmentLevel=equipmentLevel;
	}	
}

public class Main08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		/*List<Hero> heroList=new ArrayList<Hero>();
		heroList.add(new Hero("BATMAN",2,100,89,67));
		heroList.add(new Hero("SUPERMAN",100,1,45,56));
		for(Hero hero:heroList){
			System.out.println(hero.name+"   ");
		}*/
		/*Set<String> heroList=new HashSet<String>();
		heroList.add(new String("BATMAN"));
		heroList.add(new String("SUPERMAN"));
		for(String hero:heroList){
			System.out.println(hero+"   ");
		}*/
		
		Map<Person,Hero> heroMap=new HashMap<Person,Hero>();
		Person person1=new Person("BRUCE","WAYNE");
		Person person2=new Person("CLARK","KENT");
		heroMap.put(person1,new Hero("BATMAN",2,100,89,67));
		heroMap.put(person2,new Hero("SUPERMAN",100,1,45,56));
		Set personSet=heroMap.keySet();
		for(Object personObj:personSet){
			Person person=(Person)personObj;
			System.out.println(person.firstName+"   "+person.lastName);
			System.out.println("Loop Cycle Ends");
		}
		//System.out.println(heroMap);
		Hero heroName=heroMap.get(person1);
		System.out.println(heroName.name);
	}

}
