package com.shrek.dsa.sorting;

public class MergeSort {
	
	public Employee[] empList;
	public Employee[] empTemp;
	public int arrayLength;
	
	public void sort(Employee[] values){
		this.empList=values;
		this.arrayLength=values.length;
		//System.out.println(arrayLength);
		this.empTemp=new Employee[arrayLength];
		mergeSort(0,arrayLength-1);
	}
	
	public void mergeSort(int start,int end){
		System.out.println("mergeSort(start "+start+",end "+end+")");
		if(start<end){
			//int middle = ( start + (( end - start )/2) );
			int middle = ( start + end )/2;
			//int middle = end/2;
			mergeSort(start,middle);
			mergeSort(middle+1,end);
			merge(start,middle,end);
			//System.out.println("");
		}
		//System.out.println("");
	}
	
	public void merge(int start,int middle,int end){
		
		System.out.println("merge(start "+start+",middle "+middle+",end "+end+")");
		
		for(int i=start;i<=end;i++){
			empTemp[i] = empList[i];
		}
		
		int i = start;
		int j = middle+1;
		int k = start;
		
		while(i<=middle&&j<=end){
			if(empTemp[i].id.compareTo(empTemp[j].id)<=0){  //empTemp[i].id<=empTemp[j].id  
				empList[k]=empTemp[i];
				i++;
			}
			else{
				empList[k]=empTemp[j];
				j++;
			}
			k++;
		}

		while(i<=middle){
			empList[k]=empTemp[i];
			k++;
			i++;
		}
		
		//System.out.println("merge ends");
		
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
		
		MergeSort mergeSortObj = new MergeSort();
		mergeSortObj.sort(employeeArray);
		
		System.out.println("HELLO WORLD AFTER SORT");
		for(int i=0;i<sizeOfArray;i++){
			System.out.println(employeeArray[i].toString());
		}
	}
}
