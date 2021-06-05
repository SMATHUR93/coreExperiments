package com.shrek.miscellaneous;

import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] A;
        int[][] B;
        Scanner input = new Scanner(System.in);
        int m, n , x, y;
        do{
            System.out.println("Enter dimensions for Matrix 1");
            m = input.nextInt();
            n = input.nextInt();
            System.out.println("Enter dimensions for Matrix 2");
            x = input.nextInt();
            y = input.nextInt();
            if(x!=n){
                System.out.println("dimensions aren't compatible for multiplication");
            }
        }while(x!=n);
        System.out.println("m = "+m+" : "+"n = "+n+" : "+"x = "+x+" : "+"y = "+y);
        A = new int[m][n];
        B = new int[x][y];
        System.out.println("Enter values for Matrix A");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                A[i][j] = input.nextInt();
            }

        }
        System.out.println("Enter values for Matrix B");
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                B[i][j] = input.nextInt();
            }
        }
        int[][] C = new int[m][y];
        int z = n;
        System.out.println("Result of A*B is ");
        for(int i=0;i<m;i++){
            for(int j=0;j<y;j++){
                C[i][j] = 0;
                for(int k=0;k<z;k++){
                    C[i][j] = C[i][j] + (A[i][k]*B[k][j]);
                }
                System.out.print(C[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
