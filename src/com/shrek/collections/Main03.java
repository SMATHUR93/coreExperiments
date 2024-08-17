package com.shrek.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee2 e1=new Employee2(333,"Shrek",45566,"Master of Evil");
		Employee2 e2=new Employee2(222,"Shredder",2326,"King of Ninjas");
		Employee2 e3=new Employee2(111,"Shrek_d_Beast",125200,"King in the North");
		
		Set<Employee2> empSet=new TreeSet<Employee2>();
		empSet.add(e1);
		empSet.add(e2);
		empSet.add(e3);
		
	/*	TRYING USING SET
	    Iterator<Employee2> itr=empSet.iterator();
		while(itr.hasNext()){
			Employee2 emp=itr.next();
			System.out.println("-------------------------");
			System.out.println(emp.getId());
			System.out.println(emp.getName());
			System.out.println(emp.getGrade());
			System.out.println(emp.getAge());
			System.out.println("-------------------------");
		}				*/
		//System.out.println(empSet);
		
		
		List<Employee2> empList =new ArrayList<Employee2>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		// Collections.sort(empList);
		Collections.sort(empList, new AgeComparator());
		//Collections.sort(empList, new NameComparator());
		//Collections.sort(empList, new GradeComparator());
		Iterator<Employee2> itr=empList.iterator();
		while(itr.hasNext()){
			Employee2 emp=itr.next();
			System.out.println("-------------------------");
			System.out.println(emp.getId());
			System.out.println(emp.getName());
			System.out.println(emp.getGrade());
			System.out.println(emp.getAge());
			System.out.println("-------------------------");
		}	
		
	}

}

class Employee2 implements Comparable<Employee2>{  //,Comparator<Employee2>
	 
	private Integer id;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Employee2() {
		super();
	}
	public Employee2(Integer id, String name, Integer age, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	/*@Override
	public int compare(Employee2 o1, Employee2 o2) {
		// TODO Auto-generated method stub
		return o1.getId().compareTo(o2.getId());
	}*/
	@Override
	public int compareTo(Employee2 o) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(o.getId());
	}
}

class AgeComparator implements Comparator<Employee2>{	
	@Override
	public int compare(Employee2 o1, Employee2 o2) {
		// TODO Auto-generated method stub
		Integer age1=o1.getAge();
		Integer age2=o2.getAge();
		return age1.compareTo(age2);
	}	
}
class NameComparator implements Comparator<Employee2>{	
	@Override
	public int compare(Employee2 o1, Employee2 o2) {
		// TODO Auto-generated method stub
		String name1=o1.getName();
		String name2=o2.getName();
		return name1.compareTo(name2);
	}	
}
class GradeComparator implements Comparator<Employee2>{	
	@Override
	public int compare(Employee2 o1, Employee2 o2) {
		// TODO Auto-generated method stub
		String grade1=o1.getGrade();
		String grade2=o2.getGrade();
		return grade1.compareTo(grade2);
	}	
}