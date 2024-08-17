package com.shrek.string;

public class Program1 {

	public static void main(String args[]){

		String s = "abcdef"; // create a new String object, with
		// value "abcdef", refer s to it
		String sc = s; // create a 2nd reference variable
		// referring to the same String
// create a new String object, with value "abcdef more stuff",
// refer s to it. (Change s's reference from the old String
// to the new String.) (Remember s2 is still referring to
// the original "abcdef" String.)
		s = s.concat(" more stuff");
		System.out.println(s);
		System.out.println(sc);

		System.out.println("-----------------------------------------------------------");


		String s1="shrek";
		String s2="shrek";
		String s3=new String("shrek");
		String s4=new String("shrek");		
		String s5=s1.intern();
		String s6=s2.intern();
		String s7=s3;
		String s8=s4;
		System.out.println("TEST 01 s1==s2 :: "+s1==s2);
		System.out.println("TEST 02 s1.hashCode() :: "+s1.hashCode());
		System.out.println("TEST 03 s2.hashCode() :: "+s2.hashCode());
		System.out.println("TEST 04 s1.equals(s2) :: "+s1.equals(s2));
		System.out.println("TEST 05 s1==s3 :: "+s1==s3);
		System.out.println("TEST 06 s1.equals(s3) :: "+s1.equals(s3));
		System.out.println("TEST 07 s3==s4 :: "+s3==s4);
		System.out.println("TEST 08 s3.equals(s4) :: "+s3.equals(s4));
		System.out.println("TEST 09 s5.hashCode() :: "+s5.hashCode());
		System.out.println("TEST 11 s6.hashCode() :: "+s6.hashCode());
		System.out.println("TEST 12 s1==s5 :: "+s1==s5);
		System.out.println("TEST 13 s2==s6 :: "+s2==s6);
		System.out.println("TEST 14 s3.hashCode() :: "+s3.hashCode());
		System.out.println("TEST 15 s3.intern() :: "+s3.intern());
		System.out.println("TEST 16 s4.hashCode() :: "+s4.hashCode());
		System.out.println("TEST 17 s4.intern() :: "+s4.intern());
		System.out.println("TEST 18 s5.hashCode() :: "+s5.hashCode());
		System.out.println("TEST 19 s6.hashCode() :: "+s6.hashCode());
		System.out.println("TEST 20 s7.hashCode() :: "+s7.hashCode());
		System.out.println("TEST 21 s8.hashCode() :: "+s8.hashCode());
		System.out.println("TEST 22 s3==s7 :: "+s3==s7);
		System.out.println("TEST 23 s4==s8 :: "+s4==s8);
		
		System.out.println("-----------------------------------------------------------");
		
		StringBuffer sb=new StringBuffer("Shrek_D_beast");
		sb.delete(0, 5).replace(0, 5, "Shredder");
		System.out.println(sb);
		
	}
}
