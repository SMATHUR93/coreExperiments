package com.shrek.miscellaneous;
//import java.io.File;

public class Main03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String shrek="SHREK.IS.THE.KING.IN.THE.NORTH AND ANGNAMAR";
		String[] shrekArr= shrek.split("(\\.)|(\\s)");
		for(String word:shrekArr){
			System.out.println(word);
		}
	}
}