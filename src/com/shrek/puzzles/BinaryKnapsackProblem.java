package com.shrek.puzzles;

public class BinaryKnapsackProblem {

    public static void main(String[] args) {
        int capacity= 8;
        int n=4;
        int[] prices = {0, 1, 2, 5, 6};
        int[] weights = {0, 2, 3, 4, 5};
        int[][] table;
        table = getTabularData(n, capacity, prices, weights);
        System.out.println("--------------------------");
        for(int i=0;i<=n;i++){
            for(int w=0;w<=capacity;w++){
                System.out.print(table[i][w] + "  ");
            }
            System.out.println();
        }
        // System.out.println(table);
        System.out.println("--------------------------");
        System.out.println(table[n][capacity]);
        showSelectedWeights(table, n, capacity, prices, weights);
    }

    static int[][] getTabularData(int n, int capacity, int[] prices, int[] weights ){
        int[][] table = new int[n+1][capacity+1];
        for(int i=0;i<=n;i++){
            for(int w=0;w<=capacity;w++){
                int checkedWeight = w;
                if(i==0 || w==0){
                    table[i][w] = 0;
                } else if(weights[i]<=checkedWeight){
                    int val1 = prices[i] + table[i-1][checkedWeight - weights[i]];
                    int val2 = table[i-1][checkedWeight];
                    table[i][checkedWeight] = Math.max(val1, val2);
                } else{
                    table[i][checkedWeight] = table[i-1][checkedWeight];
                }
            }
        }
        return table;
    }

    static void showSelectedWeights(int[][] table,int n, int capacity, int[] prices, int[] weights ){
            int i=n, j=capacity;
        while(i>0 && j>0){
            System.out.println(i+" :: "+j);
            if(table[i][j]==table[i-1][j]){
                System.out.println(weights[i] + " = 0 ");
                i--;
                //System.out.println("Equals " + i + " :: "+ j);
            } else {
                System.out.println(weights[i] + " = 1 ");
                i--;
                j=(j-weights[i]-1);
                //System.out.println("Not Equals " + i + " :: "+ j);
            }
        }
    }

}
