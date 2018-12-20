package com.shrek.dsa.sorting;

public class QuickSort {	
		
	public void quickSort(Employee[] empList,int start,int end){
		System.out.println("quickSort(start "+start+",end "+end+")");
		if(start<end){
			int pivot = partition(empList,start,end);
			quickSort(empList,start,pivot-1);
			quickSort(empList,pivot+1,end);
		}
		//System.out.println("");
	}
	
	public int partition(Employee[] empList,int start,int end){		
		int i=start+1;
		Employee temp;
		//int pivot=empList[start].getId();
		Employee pivot = empList[start];
		//int pivot=empList[((start+end)/2)].getId();
		for(int j=start+1;j<=end;j++){
			if(empList[j].getId().compareTo(pivot.getId())<0){
				temp = empList[j];
				empList[j] = empList[i];
				empList[i] = temp;
				i+=1;
			}
		}
		
		temp = empList[start];
		empList[start] = empList[i-1];
		empList[i-1] = temp;
		
		return i-1;
	}
	
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
		
		QuickSort obj=new QuickSort();
		obj.quickSort(employeeArray,0,employeeArray.length-1);
		
		System.out.println("HELLO WORLD AFTER SORT");
		for(int i=0;i<sizeOfArray;i++){
			System.out.println(employeeArray[i].toString());
		}
	}
}
