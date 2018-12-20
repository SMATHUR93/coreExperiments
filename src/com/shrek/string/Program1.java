package com.shrek.string;

public class Program1 {

	public static void main(String args[]){
		
		String s1="shrek";
		String s2="shrek";
		String s3=new String("shrek");
		String s4=new String("shrek");		
		String s5=s1.intern();
		String s6=s2.intern();
		String s7=s3;
		String s8=s4;
		System.out.println(s1==s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1.equals(s2));
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		System.out.println(s5.hashCode());
		System.out.println(s6.hashCode());
		System.out.println(s1==s5);
		System.out.println(s2==s6);
		System.out.println(s3.hashCode());
		System.out.println(s3.intern());
		System.out.println(s4.hashCode());
		System.out.println(s4.intern());
		System.out.println(s5.hashCode());
		System.out.println(s6.hashCode());
		System.out.println(s7.hashCode());
		System.out.println(s8.hashCode());
		System.out.println(s3==s7);
		System.out.println(s4==s8);
		
		System.out.println("-----------------------------------------------------------");
		
		StringBuffer sb=new StringBuffer("Shrek_D_beast");
		sb.delete(0, 5).replace(0, 5, "Shredder");
		System.out.println(sb);
		
	}
}
