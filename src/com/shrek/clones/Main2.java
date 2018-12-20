package com.shrek.clones;

class Student{
	int age;
	
	Student(){
		
	}
	
	Student(int age){
		this.age=age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Main2 extends Student implements Cloneable{  
	int rollno;  
	String name;  

	Main2(){
		
	}
	
	Main2(int rollno,String name,int age){  
		super(age);
		this.rollno=rollno;  
		this.name=name;  
	}  

	public Object cloneFactory()throws CloneNotSupportedException{  
		return super.clone();  
	}  

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String args[]){  
		try{  
			Main2 s1=new Main2(101,"shrek",22);  

			Main2 s2=(Main2)s1.cloneFactory();  

			Main2 s3=new Main2();		
			
			s3.setAge(257677);
			s3.setName("King in the North");
			s3.setRollno(313);
			
			Main2 s4=(Main2)s3.cloneFactory();
			
			System.out.println(s1.rollno+" "+s1.name+" "+s1.age);  
			System.out.println(s2.rollno+" "+s2.name+" "+s2.age);  
			System.out.println(s3.rollno+" "+s3.name+" "+s3.age);  
			System.out.println(s4.rollno+" "+s4.name+" "+s4.age);  

		}catch(CloneNotSupportedException c){}  

	}  
}  