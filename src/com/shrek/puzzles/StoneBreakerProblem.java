package com.shrek.puzzles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoneBreakerProblem {

	static int remainingStones = -1;
	public static void calculateRemainingStones(List<Integer> stones) {
		Iterator<Integer> itr = stones.iterator();
        int[] ip = new int[stones.size()];
        int a = 0;
        while (itr.hasNext()) {
            ip[a] = itr.next();
            a++;
        }
        int max = 0, maxIndex = 0, secMax = 0, secMaxIndex = 0;
        for(int i=0;i<ip.length;i++) {
        	if(ip[i]>max) {
        		max  =ip[i];
        		maxIndex = i;
        	}
        }
        for(int i=0;i<ip.length;i++) {
        	if(ip[i]>secMax && i!=maxIndex) {
        		secMax  =ip[i];
        		secMaxIndex = i;
        	}
        }
//        System.out.println("MAX  = "+max);
//        System.out.println("SEC MAX   = "+secMax);
        int diff = max - secMax;
        List<Integer> stoneList = new ArrayList<Integer>();
        if(diff == 0) {
        	for(int i=0;i<ip.length;i++) {
        		if(!(i==maxIndex||i==secMaxIndex)) {
        			stoneList.add(ip[i]);
        		}
        	}
        } else {
        	for(int i=0;i<ip.length;i++) {
        		if(!(i==maxIndex||i==secMaxIndex)) {
        			stoneList.add(ip[i]);
        		}
        	}
        	stoneList.add(diff);
        }
        if(stoneList.size()>1) {
//        	System.out.println(stoneList);
        	calculateRemainingStones(stoneList);
        } else {
        	remainingStones = Math.abs(max-secMax);
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int money = 5;
		List<Integer> stones = new ArrayList<Integer>();
		stones.add(2);
		stones.add(4);
		stones.add(5);
		 
		/*
		 * stones.add(1); stones.add(2); stones.add(3); stones.add(6); stones.add(7);
		 * stones.add(7);
		 */
		calculateRemainingStones(stones);
		System.out.println(remainingStones);
	}
	
}
