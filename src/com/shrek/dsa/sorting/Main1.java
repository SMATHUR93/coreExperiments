package com.shrek.dsa.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		while(N-->0){
			char[] inp=br.readLine().toCharArray();	
			for(int i=0;i<inp.length;i++){				
				int k=0;
				int j=i+1;
				while(j<inp.length){
					if(inp[i]==inp[j]){
						j++;
						k++;
					}
					else{
						break;
					}
				}
				i=i+k;
				System.out.print(inp[i]);
			}
		}
	}
}