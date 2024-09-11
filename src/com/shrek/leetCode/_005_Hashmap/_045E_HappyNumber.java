package com.shrek.leetCode._005_Hashmap;

/**
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer,
 * replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 *
 */

import java.util.HashMap;
import java.util.Map;

public class _045E_HappyNumber {

    public static void main(String[] args) {
        int num = 19;
        System.out.println("twoSum for num = " + num +" is " + isHappy(num) );
        // true
        System.out.println("-------------- BREAK -----------------");

        num = 2;
        System.out.println("twoSum for num = " + num +" is " + isHappy(num) );
        // false
        System.out.println("-------------- BREAK -----------------");

        num = 100;
        System.out.println("twoSum for num = " + num +" is " + isHappy(num) );
        // true
        System.out.println("-------------- BREAK -----------------");

        num = 123;
        System.out.println("twoSum for num = " + num +" is " + isHappy(num) );
        // false
        System.out.println("-------------- BREAK -----------------");
    }

    // Trick is to create a map which maps every subsequent sum to next,
    // this way when a key already present in map is found
    // break and return false,
    // otherwise let it run and find 1 and break and return true
    public static boolean isHappy(int n) {
        String num = Integer.toString(n);
        Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
        int sum = 0;
        char[] arr;
        int key;
        // int k=0;
        do {
            key = Integer.parseInt(num);
            arr = num.toCharArray();
            // System.out.println("num = "+num);
            sum=0;
            for(int i=0 ;i<arr.length;i++){
                String s = Character.toString(arr[i]);
                double d = Double.valueOf(s);
                sum+= (int) Math.pow(d, 2.0);
                // System.out.println("Map in digits , d = "+d+", sum = "+sum);
            }
            if(sum==1){
                // System.out.println("Exiting TRUE");
                return true;
            }

            if(map.containsKey(sum)){
                // System.out.println("Exiting FALSE");
                return false;
            }
            map.put(key, sum);
            // System.out.println("Map in while = "+map);
            num=Integer.toString(sum);
            // k++;
        } while(sum!=1);//  && k<10);
        return true;
    }

}
