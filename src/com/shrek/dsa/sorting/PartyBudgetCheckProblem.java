package com.shrek.dsa.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PartyBudgetCheckProblem {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		while(N-->0){
			String[] inputLine1=br.readLine().split("\\s");
			int noOfFriends = Integer.parseInt(inputLine1[0]);
			int budget = Integer.parseInt(inputLine1[1]);
			int[] friendsCost=new int[noOfFriends];
			for(int i=0;i<noOfFriends;i++){
				friendsCost[i] = Integer.parseInt(br.readLine());
			}
			boolean answer = false;
			for(int i=0;i<noOfFriends;i++){
				int total=0;
				int j=i;
				while(j<noOfFriends){
					total=total+friendsCost[j];
					/*if(total>budget){						
						answer=false;
						break;
					}
					if(total==budget){						
						answer=true;
						break;
					}
					if(total<budget){						
						j++;
					}*/
					if(total!=budget){						
						j++;
						//System.out.println(total);
					}
					else{
						answer=true;
						break;
					}
				}
			}
			System.out.println(answer);
			/*for(int i=0;i<noOfFriends;i++){
				System.out.println(friendsCost[i]);
			}*/
		}
	}
}