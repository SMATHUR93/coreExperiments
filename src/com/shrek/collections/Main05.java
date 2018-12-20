package com.shrek.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main05 {

	public static void main(String[] args) {
		Set<String> shrek=new HashSet<String>();
		String s1="Shrek";
		String s2="King";
		String s3="Beast";
		shrek.add(s1);
		shrek.add(s2);
		shrek.add(s3);
		System.out.println("TRY A "+shrek);
		System.out.println("TRY A "+shrek.size());
		shrek.remove(s1);
		System.out.println("TRY B "+shrek);
		System.out.println("TRY B "+shrek.size());
		s2="Darth Shrek";
		shrek.remove(s2);
		System.out.println("TRY B "+shrek);
		System.out.println("TRY B "+shrek.size());
		
		System.out.println("----------------------------------------");
		

		List<String> shredder=new ArrayList<String>();
		String s4="Shredder";
		String s5="King in the North";
		String s6="Beast of Angnamar";
		String s7="Beast of Angnamar";
		shredder.add(s4);
		shredder.add(s5);
		shredder.add(s6);
		shredder.add(s7);
		System.out.println("TRY A "+shredder);
		System.out.println("TRY A "+shredder.size());
		shredder.remove("Beast of Angnamar");
		System.out.println("TRY B "+shredder);
		System.out.println("TRY B "+shredder.size());
	}	
}
