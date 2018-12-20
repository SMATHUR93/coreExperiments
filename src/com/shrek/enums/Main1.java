package com.shrek.enums;

enum Position{
	EMPEROR("emperor"),KING("king"),GENERAL("general"),COLONEL("colonel"),LIEUTENANT("lieutenant"),MAJOR("major"),CAPTAIN("captain"),PRIVATE("private");
	private final String position;
	private Position(String position){
		this.position = position;
	}
	public String toString(String...strings){
		String name=new String();
		for(String val:strings){
			name=name+val+" ";
		}
		return "WELCOME TO EARTH "+position+" "+name;
	}
}

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TRIAL 1
		System.out.println(Position.EMPEROR.toString("PALAPTINE"));
		
		//TRIAL 2
		Position position=Position.EMPEROR;
		switch(position){
			case EMPEROR:
				System.out.println("HAil EMPEROR Palaptine");
				//break;
			case GENERAL:
				System.out.println("HAil GENERAL Zod");
				break;
			case KING:
				System.out.println("HAil KING Bradley");
				//break;
		}
	}

}
