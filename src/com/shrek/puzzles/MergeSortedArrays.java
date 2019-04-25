package com.shrek.puzzles;

public class MergeSortedArrays {

	public static void main(String[] args) {
		MergeSortedArrays.mergeArr();
	}
	
	static void mergeArr(){
		int[] arr1 = {1,2,5,20};
		int[] arr2 = {2,5,7,10,14,16};
		int lenSum = arr1.length + arr2.length;
		//System.out.println(lenSum + " " + arr1Len + " " + arr2Len  );
		int[] output = new int[lenSum];
		int[] large, small;
		int arr2Len = arr2.length;
		int arr1Len = arr1.length;
		if(arr1[0]>arr2[0]) {
			large = arr1;
			small  =arr2;
		} else{
			large = arr2;
			small = arr1;
		}
		int j=0,k=0;
		for(int i = 0;i < lenSum;i++) {
			if( j>small.length-1 ) {
				output[i] = large[k];
				k++;
			}else {
				if( k>large.length-1 ) {
					output[i] = small[j];
					j++;
				} else {
					// System.out.println(j+"   "+k+ "   " +i+ "   " );
					if(large[k]>small[j]) {
						output[i] = small[j];
						j++;
					} else {
						output[i] = large[k];
						k++;
					}
				}
			}
		}
		
		for(int i = 0;i < lenSum;i++) {
			System.out.println(output[i]);
		}
		
	}

}
