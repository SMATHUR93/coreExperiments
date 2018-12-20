package com.shrek.clones;

class Main1 implements Cloneable{  
	int rollno;  
	String name;  

	Main1(int rollno,String name){  
		this.rollno=rollno;  
		this.name=name;  
	}  

	public Object cloneFactory()throws CloneNotSupportedException{  
		return this.clone();  
	}  

	public static void main(String args[]){  
		try{  
			Main1 s1=new Main1(101,"shrek");  

			Main1 s2=(Main1)s1.clone();  

			System.out.println(s1.rollno+" "+s1.name);  
			System.out.println(s2.rollno+" "+s2.name);  

		}catch(CloneNotSupportedException c){}  

	}  
}  