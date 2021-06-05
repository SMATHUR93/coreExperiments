package com.shrek.puzzles;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int n = coins.length;
        int total = 6;
        System.out.println(countWays(coins, n, total));
    }

    static long countWays(int[] coins, int n, int total){
        long[] table = new long[total+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=total;j++){
                table[j]+=table[j-coins[i]];
                System.out.print(table[j]+"  ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
        return table[total];
    }

}
