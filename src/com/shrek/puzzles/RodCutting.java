package com.shrek.puzzles;

public class RodCutting {

    static int cutRod(int price[], int n){

        // Recursive Solution
        /*System.out.println("In DEPTH  = "+n);
        if (n <= 0){
            System.out.println("RETURN IN ZERO IN DEPTH  = "+n);
            return 0;
        }

        int max_val = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++){
            System.out.println("IN ITERATION = "+i );
            max_val = Math.max(max_val, price[i] + cutRod(price, n-i-1));
            System.out.println("n = "+ n +" :: price["+i+"] = "+price[i] + " :: max_val = "+ max_val);
        }

        System.out.println("RETURN NON ZERO IN DEPTH  = "+n);
        return max_val;*/

        // DYNAMIC PROGRAMMING
        int val[] = new int[n+1];
        val[0] = 0;
        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++){
                max_val = Math.max(max_val, price[j] + val[i-j-1]);
            }
            val[i]  = max_val;
        }
        return val[n];

    }

    public static void main(String args[]){
        int arr[] = new int[] {2,4,5};//{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+
                cutRod(arr, size));

    }

}
