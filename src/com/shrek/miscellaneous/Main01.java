package com.shrek.miscellaneous;

public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] x[]={{1,2},{3,4,5},{6,7,8,9}};
		int [][]y;
		y=x;
		for(int i=0;i<3;i++){
			int len=y[i].length;
			for(int j=0;j<len;j++){
				System.out.println(y[i][j]);
			}
		}
		
		StringBuilder sb1=new StringBuilder("Shrek");
		StringBuilder sb2=new StringBuilder("Shredder");
		StringBuilder sb3;
		sb3=sb2;
		sb2=sb1;
		sb1.append("_D_beast");
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
		System.out.println(sb1==sb2);
		//System.out.println(y[1][1]);
		
	}

}
