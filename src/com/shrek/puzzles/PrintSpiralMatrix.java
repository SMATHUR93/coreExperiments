package com.shrek.puzzles;

public class PrintSpiralMatrix {

	static void printMatrix(int[][] mat, int rows, int columns) {
		
		System.out.println("Printing a "+rows+"X"+columns+" Matrix");
		
		for(int i=0;i<mat.length;i++) {
			int[] row = mat[i];
			for(int j=0;j< row.length;j++) {
				System.out.print(row[j]+" ");
			}
			System.out.println();
		}
	}
	
	static void printSpiralMatrix(int[][] mat, int rows, int columns) {
		
		System.out.println("Printing a "+rows+"X"+columns+" Matrix in spiral");
		
		int noOfRotations;
		int m = rows;
		int n = columns;
		int x = 0;
		int y = 0;
		
		if(rows%2==0) {
			// ends in left
			noOfRotations = (rows/2)-1;
			if(noOfRotations>0) {
				for(int i=0;i<noOfRotations;i++) {
					//System.out.println("moving from ("+(x)+","+(y)+") to ("+(x)+","+(y+n-1)+")");
					for(int a=y;a<y+n-1;a++) {
						System.out.print(mat[x][a]+" ");
					}
					//System.out.println("moving from ("+(x)+","+(y+n-1)+") to ("+(x+m-1)+","+(y+n-1)+")");
					for(int b=x;b<x+m-1;b++) {
						System.out.print(mat[b][y+n-1]+" ");
					}
					//System.out.println("moving from ("+(x+m-1)+","+(y+n-1)+") to ("+(x+m-1)+","+(y)+")");
					for(int c=y+n-1;c>y;c--) {
						System.out.print(mat[x+m-1][c]+" ");
					}
					//System.out.println("moving from ("+(x+m-1)+","+(y)+") to ("+(x)+","+(y)+")");
					for(int d=x+m-1;d>x;d--) {
						System.out.print(mat[d][y]+" ");
					}
					x = x+1;
					y = y+1;
					m = m-2;
					n = n-2;
				}
			}
			//System.out.println("moving from ("+(x)+","+(y)+") to ("+(x)+","+(y+n-1)+")");
			for(int a=y;a<y+n-1;a++) {
				System.out.print(mat[x][a]+" ");
			}
			//System.out.println("moving from ("+(x)+","+(y+n-1)+") to ("+(x+m-1)+","+(y+n-1)+")");
			for(int b=x;b<x+m-1;b++) {
				System.out.print(mat[b][y+n-1]+" ");
			}
			//System.out.println("moving from ("+(x+m-1)+","+(y+n-1)+") to ("+(x+m-1)+","+(y)+")");
			for(int c=y+n-1;c>=y;c--) {
				System.out.print(mat[x+m-1][c]+" ");
			}
		} else {
			noOfRotations = (rows/2);
			// ends in right
			for(int i=0;i<noOfRotations;i++) {
				//System.out.println("moving from ("+(x)+","+(y)+") to ("+(x)+","+(y+n-1)+")");
				for(int a=y;a<y+n-1;a++) {
					System.out.print(mat[x][a]+" ");
				}
				//System.out.println("moving from ("+(x)+","+(y+n-1)+") to ("+(x+m-1)+","+(y+n-1)+")");
				for(int b=x;b<x+m-1;b++) {
					System.out.print(mat[b][y+n-1]+" ");
				}
				//System.out.println("moving from ("+(x+m-1)+","+(y+n-1)+") to ("+(x+m-1)+","+(y)+")");
				for(int c=y+n-1;c>y;c--) {
					System.out.print(mat[x+m-1][c]+" ");
				}
				//System.out.println("moving from ("+(x+m-1)+","+(y)+") to ("+(x)+","+(y)+")");
				for(int d=x+m-1;d>x;d--) {
					System.out.print(mat[d][y]+" ");
				}
				x = x+1;
				y = y+1;
				m = m-2;
				n = n-2;
			}
			//System.out.println("moving from ("+(x)+","+(y)+") to ("+(x)+","+(y+n-1)+")");
			for(int a=y;a<=y+n-1;a++) {
				System.out.print(mat[x][a]+" ");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mat1 = {{
			1,2,3,4,5
		},{
			14,15,16,17,6
		},{
			13,20,19,18,7
		},{
			12,11,10,9,8
		}};
		
		int[][] mat2 = {{
			 1,  2,  3,  4,  5,  6
		},{
			18, 19, 20, 21, 22,  7
		},{
			17, 28, 29, 30, 23,  8
		},{
			16, 27, 26, 25, 24,  9
		},{
			15, 14, 13, 12, 11, 10
		}};
		
		int[][] mat3 = {{
			 1,  2,  3,  4,  5,  6,	 7,  8
		},{
			20, 21, 22, 23, 24, 25, 26,  9
		},{
			19, 32, 31, 30, 29, 28, 27, 10
		},{
			18, 17, 16, 15, 14, 13, 12, 11
		}};
		
		int[][] mat4 = {{
			1,2,3
		},{
			6,5,4
		}};
		
		int[][] mat5 = {{1,2,3}};
		
		int mat[][] = mat3;
		
		int rows = mat.length;
		int columns = mat[0].length;
		
		printMatrix(mat, rows, columns);
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		printSpiralMatrix(mat, rows, columns);
		
	}

}
