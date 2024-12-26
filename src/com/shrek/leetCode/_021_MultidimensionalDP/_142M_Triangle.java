package com.shrek.leetCode._021_MultidimensionalDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row,
 * you may move to either index i or index i + 1 on the next row.
 *
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 *
 * Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 *
 * Constraints:
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 *
 */

public class _142M_Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle;

        triangle = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(2)),
                new ArrayList<Integer>(Arrays.asList(3,4)),
                new ArrayList<Integer>(Arrays.asList(6,5,7)),
                new ArrayList<Integer>(Arrays.asList(4,1,8,3))
        ));
        System.out.println("minimumTotal for triangle = "+ triangle.toString()+" , equals "+minimumTotal(triangle));
        // 11
        System.out.println();


        triangle = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(-10))
        ));
        System.out.println("minimumTotal for triangle = "+ triangle.toString()+" , equals "+minimumTotal(triangle));
        // -10
        System.out.println();


        triangle = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(-1)),
                new ArrayList<Integer>(Arrays.asList(3,2)),
                new ArrayList<Integer>(Arrays.asList(1,-2,-1))
        ));
        System.out.println("minimumTotal for triangle = "+ triangle.toString()+" , equals "+minimumTotal(triangle));
        // -1
        System.out.println();

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        if(n==1){
            return triangle.get(0).get(0);
        }

        List<List<Integer>> dp =  new ArrayList<>();
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<Integer>(triangle.get(i)));
        }

        int firstEl = dp.get(0).get(0);
        List<Integer> secondRow = dp.get(1);
        secondRow.set(0, secondRow.get(0) + firstEl);
        secondRow.set(1, secondRow.get(1) + firstEl);

        for(int i=2;i<n;i++){
            List<Integer> prev = dp.get(i-1);
            List<Integer> curr = dp.get(i);
            System.out.println("index i = "+i+" , prev = "+prev.toString()+ " , curr = "+curr.toString());
            for(int j=0;j<=i;j++){
                int left  = ( j<=0 ? Integer.MAX_VALUE : (prev.get(j-1) + curr.get(j)) );
                int right = ( j>=i ? Integer.MAX_VALUE : (prev.get(j) + curr.get(j)) );
                System.out.println("      index j = "+j+" , left = "+left+ " , right = "+right);
                curr.set(j, Math.min(left, right));
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(dp.get(i));
        }

        List<Integer> last = dp.get(n-1);
        int op=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            op = Math.min(op, last.get(i));
        }
        return op;
    }

}
