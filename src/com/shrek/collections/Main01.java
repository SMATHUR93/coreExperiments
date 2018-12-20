package com.shrek.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main01 {
	
	public void add(List<? super String> list){
		list.add("SHREDDER");
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] myObjects={
			new Integer(5),new Integer(4),new Integer(3),new Integer(2),new Integer("1"),	
		};
		Arrays.sort(myObjects);
		for(Object obj:myObjects){
			System.out.println(obj+" ");
		}
		
		List<StrClass> strList=new ArrayList<StrClass>();

		StrClass<String> t=new StrClass<String>();
		
		t.setVar("beast");
		
		strList.add(t);
		System.out.println("------------");
		for(StrClass<String> str:strList){
			System.out.println(str.getVar()+" ");
		}
		//System.out.println(strList);
		t.setVar("Mordor");
		System.out.println("------------");
		for(StrClass str:strList){
			System.out.println(str.getVar()+" ");
		}
		//System.out.println(strList);
		
		//strList.add(new StrClass<String>().setVar("Shrek"));
		
	}

}

class StrClass<T extends String>{
	T var;
	void setVar(T var){
		this.var=var;
	}
	T getVar(){
		return var;
	}
	static String appendString(List<StrClass> myList){
		return null;
	}
	
}