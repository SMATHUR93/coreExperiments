package com.shrek.puzzles;

import java.util.Arrays;

public class RainWaterProblem {

	public static void main(String[] args) {
		int arr[] = {6,4,2,0,2,4,6};
		System.out.println("Maximum rain water accumulated is " + calculateRainWater(arr));
	}
	
	static int calculateRainWater(int[] input){
		int length = input.length;
		System.out.println("input ==== "+Arrays.toString(input));
		int[] leftMax = new int[length];
		int[] rightMax = new int[length];
		leftMax[0] = input[0];
		for(int i=1;i<length;i++) {
			leftMax[i] = Math.max(leftMax[i-1], input[i]);
		}
		System.out.println("left ==== "+Arrays.toString(leftMax));
		rightMax[length-1] = input[length-1];
		for(int i=(length-2);i>=0;i--) {
			rightMax[i] = Math.max(rightMax[i+1], input[i]);
		}
		System.out.println("right ==== "+Arrays.toString(rightMax));
		int water = 0;
		for (int i = 0; i < length; i++) {
			water += Math.min(leftMax[i],rightMax[i]) - input[i]; 
		}
		return water;
	}
	
}
