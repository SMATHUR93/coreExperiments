package com.shrek.leetCode._002_TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums,
 * return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * Hint 1
 * So, we essentially need to find three numbers x, y, and z
 * such that they add up to the given value.
 * If we fix one of the numbers say x,
 * we are left with the two-sum problem at hand!
 *
 * Hint 2
 * For the two-sum problem,
 * if we fix one of the numbers, say x,
 * we have to scan the entire array to find the next number y,
 * which is value - x where value is the input parameter.
 * Can we change our array somehow so that this search becomes faster?
 *
 * Hint 3
 * The second train of thought for two-sum is,
 * without changing the array,
 * can we use additional space somehow?
 * Like maybe a hash map to speed up the search?
 *
 */

public class _029M_3Sum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        System.out.println("threeSum for numbers = " + Arrays.toString(nums) + " , target = " + target + " , = "+ threeSum(nums) );
        // [[-1,-1,2],[-1,0,1]]
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0, 1, 1};
        target = 0;
        System.out.println("threeSum for numbers = " + Arrays.toString(nums) + " , target = " + target + " , = "+ threeSum(nums) );
        // []
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0, 0, 0};
        target = 0;
        System.out.println("threeSum for numbers = " + Arrays.toString(nums) + " , target = " + target + " , = "+ threeSum(nums) );
        // [[0,0,0]]
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0, 0, 0, 0};
        target = 0;
        System.out.println("threeSum for numbers = " + Arrays.toString(nums) + " , target = " + target + " , = "+ threeSum(nums) );
        // [[0,0,0]]
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{1, -1, -1, 0};
        target = 0;
        System.out.println("threeSum for numbers = " + Arrays.toString(nums) + " , target = " + target + " , = "+ threeSum(nums) );
        // [[-1,0,1]]
        System.out.println("-------------- BREAK -----------------");
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        int target = 0;

        List<List<Integer>> lol = new ArrayList<>();

        if(n<=2){
            return lol;
        }
        if(n==3){
            if(nums[0]+nums[1]+nums[2] == target){
                lol.add(Arrays.asList(nums[0], nums[1], nums[2]));
            }
            return lol;
        }

        int i, j, k;
        int x, y, z;
        int total;
        Arrays.sort(nums);
        for(i = 0;i < n;i++){
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            x = nums[i];
            j=i+1;
            k=n-1;
            while(j<k){
                y = nums[j];
                z = nums[k];
                total = x + y + z;
                System.out.println("Debugging, i = "+ i + ", j = "+j+", k = "+k+" , x = "+x+" , y = "+y+" , z = "+z);
                if(total > target){
                    k--;
                }else if(total < target){
                    j++;
                } else {
                    lol.add(Arrays.asList(x, y, z));
                    j++;
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }

        return lol;

    }


}
