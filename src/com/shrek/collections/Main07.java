package com.shrek.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

class A1{
	public String val;
	A1(String val){
		this.val=val;
	}
}

public class Main07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Object> hs=new HashSet<Object>();
		A1 obj1=new A1("shrek");
		A1 obj2=new A1("shrek");
		String obj3=new String("shrek");
		String obj4=new String("shrek");
		System.out.println(hs);
		hs.add(obj1);
		System.out.println(hs);
		hs.add(obj2);
		System.out.println(hs);
		hs.add(obj3);
		System.out.println(hs);
		hs.add(obj4);
		System.out.println(hs);
		System.out.println(hs.size());
	}

}
