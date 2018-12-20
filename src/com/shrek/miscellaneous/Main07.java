package com.shrek.miscellaneous;

class Animal{
	
	int weight=0;
	
	public void sound(){
		System.out.println("Sound !!!!!!");
	}	
}

class Lion extends Animal{
	
	int weight=100;
	
	public void sound(){
		System.out.println("Roar !!!!!!");
	}	
}

class Wolf extends Animal{
	
	int weight=25;
	
	public void sound(){
		System.out.println("Howl !!!!!!");
	}	
}

public class Main07 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal1=new Lion();
		Animal animal2=new Wolf();
		animal1.sound();
		animal2.sound();
		System.out.println(animal1.weight);
		System.out.println(animal2.weight);
//		/Animal animal3=new Animal();
		Wolf wolf=(Wolf)animal2;
		wolf.sound();
		System.out.println(wolf.weight);
	}
}
