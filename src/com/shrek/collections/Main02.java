package com.shrek.collections;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee1 e1=new Employee1("Shrek",45566,"Master of Evil");
		Employee1 e2=new Employee1("Shredder",2326,"King of Ninjas");
		Employee1 e3=new Employee1("Shrek_d_Beast",125200,"King in the North");
		
		Set<Employee1> empSet=new TreeSet<Employee1>();
		empSet.add(e1);
		empSet.add(e2);
		empSet.add(e3);
		
		Iterator<Employee1> itr=empSet.iterator();
		while(itr.hasNext()){
			Employee1 emp=itr.next();
			System.out.println(emp.getName());
			System.out.println(emp.getGrade());
			System.out.println(emp.getAge());
		}		
		System.out.println(empSet);	
		
	}
}

class Employee1 implements Comparable<Employee1>{
	
	private String name;
	private Integer age;
	private String grade;	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Employee1() {
		super();
	}
	public Employee1(String name, Integer age, String grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public int compareTo(Employee1 o) {		
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
}