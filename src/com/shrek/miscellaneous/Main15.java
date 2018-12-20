package com.shrek.miscellaneous;

class Doubler{
	public static int DoubleIt(int value){
		return 2*value;
	}
}

public class Main15 {

	private int amount=14;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main15 obj=new Main15();
		obj.getDouble();
		
	}

	public void getDouble(){
		amount=Doubler.DoubleIt(new Main15().getAmount());
		System.out.println(amount);
	}
	
	public int getAmount(){
		return amount;
	}
	
}
