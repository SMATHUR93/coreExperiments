package com.shrek.dsa.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Employee e1=new Employee(1,"SHREY1","MATHUR1");
		Employee e2=new Employee(2,"SHREY2","MATHUR2");
		Employee e3=new Employee(3,"SHREY3","MATHUR3");
		Employee e4=new Employee(4,"SHREY4","MATHUR4");
		Employee e5=new Employee(5,"SHREY5","MATHUR5");
		Employee e6=new Employee(6,"SHREY6","MATHUR6");
		Employee e7=new Employee(7,"SHREY7","MATHUR7");
		Employee e8=new Employee(8,"SHREY8","MATHUR8");
		Employee e9=new Employee(9,"SHREY9","MATHUR9");
		Employee e10=new Employee(3,"SHREY33","MATHUR33");

		int sizeOfArray=10;
		Employee[] employeeArray =  new Employee[sizeOfArray];

		employeeArray[0]=e9;
		employeeArray[1]=e1;
		employeeArray[2]=e4;
		employeeArray[3]=e3;
		employeeArray[4]=e8;
		employeeArray[5]=e6;
		employeeArray[6]=e2;
		employeeArray[7]=e5;
		employeeArray[8]=e7;
		employeeArray[9]=e10;
		// 9,1,4,3,8,6,2,5,7,3
		
		
		System.out.println("HELLO WORLD BEFORE SORT");
		for(int i=0;i<sizeOfArray;i++){
			System.out.println(employeeArray[i].toString());
		}
		
		//number of passes == sizeofArray -1
		// 
		
		for(int pass=1;pass<sizeOfArray;pass++){
			//System.out.println("in Outer Loop "+pass);
			for(int c=0;c<pass;c++){
				//System.out.println("Printing in Inner Loop "+c);
				if(employeeArray[pass].getId().compareTo(employeeArray[c].getId())<0){
					System.out.println("Swapping these ! "+employeeArray[pass].getId()+" "+employeeArray[c].getId());
					Employee temp;					
					temp = employeeArray[pass];
					employeeArray[pass] = employeeArray[c];
					employeeArray[c] = temp;
				}
			}
			//System.out.println("out Outer Loop "+pass);
		}
		
		System.out.println("HELLO WORLD AFTER SORT");
		for(int i=0;i<sizeOfArray;i++){
			System.out.println(employeeArray[i].toString());
		}
			

	}

}
