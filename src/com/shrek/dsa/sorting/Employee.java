package com.shrek.dsa.sorting;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	
	public Integer id;
	public String firstName;
	public String lastName;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee() {
		super();
	}

	public Employee(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee id ="+id+", Employee Name = " +firstName+" "+lastName;
	}
	
	@Override
	public int compareTo(Employee e){
		return this.getId().compareTo(e.getId());
	}
	
}

class NameComparator implements Comparator<Employee>{	
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		String name1=o1.getFirstName()+o1.getLastName();
		String name2=o2.getFirstName()+o2.getLastName();
		return name1.compareTo(name2);
	}	
}