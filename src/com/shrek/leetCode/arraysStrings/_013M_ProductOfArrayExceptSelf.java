package com.shrek.leetCode.arraysStrings;

import java.util.Arrays;

/**
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 *
 * Hint 1
 * Think how you can efficiently utilize prefix and suffix products to calculate the product of all elements except self for each index. Can you pre-compute the prefix and suffix products in linear time to avoid redundant calculations?
 *
 * Hint 2
 * Can you minimize additional space usage by reusing memory or modifying the input array to store intermediate results?
 *
 *
 */

public class _013M_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{-1,1,0,-3,3};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println("-------------- BREAK -----------------");
    }

    // Optimal approach
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] ansProd = new int[n];

        for(int i = 0;i < n;i++){
            ansProd[i] = 1;
        }

        int currentProd = 1;
        for(int i = 0;i < n;i++){
            ansProd[i] *= currentProd;
            currentProd *= arr[i];
        }

        currentProd = 1;
        for(int i = n-1;i >= 0;i--){
            ansProd[i] *= currentProd;
            currentProd *= arr[i];
        }

        return ansProd;
    }

    // Non division approach, but since it requires 2 array, less space efficient.
    // best solution above utilizes anwers array as the holding place for the profix and suffix multiplication
    /*public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] out = new int[n];

        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];

        prefixProd[0] = 1;
        suffixProd[n-1] = 1;

        for(int i = 1;i < n;i++){
            prefixProd[i] = prefixProd[i-1] * arr[i-1];
        }

        for(int i = n-2;i >= 0;i--){
            suffixProd[i] = suffixProd[i+1] * arr[i+1];
        }

        for(int i = 0;i < n;i++){
            out[i] = prefixProd[i] * suffixProd[i];
        }

        return out;
    }*/

    // Division Method, specified to be not used in the problem but is perfectly usable with booleans for tracking zero approach
    /*public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] out = new int[n];

        int product = 1;
        int zeroProduct = 0;
        boolean oneZero = false;
        boolean twoZero = false;
        for(int i = 0;i < n;i++){
            if(arr[i] == 0 && oneZero == true){
                twoZero = true;
            }
            if(arr[i] == 0){
                oneZero = true;
            } else if(twoZero == false){
                product *= arr[i];
            }
        }

        // System.out.println("oneZero = " + oneZero + " , twoZero = " + twoZero);

        for(int j = 0;j < n;j++){
            if(twoZero == true){
                out[j] = zeroProduct;
            } else if(oneZero == true){
                if(arr[j] == 0){
                    out[j] = product;
                } else{
                    out[j] = zeroProduct;
                }
            } else{
                out[j] = product / arr[j];
            }
        }

        return out;
    }*/

    // Pure brute force
    /*public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] out = new int[n];

        int product = 1;
        for(int i = 0;i < n;i++){
            product = 1;
            for(int j = 0;j < n;j++){
                if(j != i){
                    product *= arr[j];
                }
            }
            out[i] = product;
        }
        return out;
    }*/

}
