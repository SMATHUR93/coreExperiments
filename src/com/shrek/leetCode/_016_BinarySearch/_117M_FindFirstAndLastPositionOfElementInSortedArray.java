package com.shrek.leetCode._016_BinarySearch;

import java.util.Arrays;

/**
 *
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 *
 */

public class _117M_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums;
        int target;

        nums = new int[]{5,7,7,8,8,10};
        target = 8;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+Arrays.toString(searchRange(nums, target)));
        // [3,4]
        System.out.println();

        nums = new int[]{5,7,7,8,8,8,8,8,8,8,10};
        target = 8;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+Arrays.toString(searchRange(nums, target)));
        // [3,4]
        System.out.println();

        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+Arrays.toString(searchRange(nums, target)));
        // [-1,-1]
        System.out.println();

        nums = new int[]{};
        target = 0;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+Arrays.toString(searchRange(nums, target)));
        // [-1,-1]
        System.out.println();

        nums = new int[]{1};
        target = 1;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+Arrays.toString(searchRange(nums, target)));
        // [0,0]
        System.out.println();

        nums = new int[]{2,2};
        target = 2;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+Arrays.toString(searchRange(nums, target)));
        // [0,1]
        System.out.println();

        nums = new int[]{1,3};
        target = 1;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+Arrays.toString(searchRange(nums, target)));
        // [0,0]
        System.out.println();

        nums = new int[]{1,4};
        target = 4;
        System.out.println("searchRange for nums = "+ Arrays.toString(nums) +" , target = "+target+" , equals "+Arrays.toString(searchRange(nums, target)));
        // [1,1]
        System.out.println();

    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n==1){
            if(nums[0]==target){
                return new int[]{0,0};
            } else{
                return new int[]{-1,-1};
            }
        }
        int[] op = new int[2];
        op[0] = -1;
        op[1] = -1;
        int left=0;
        int right=n-1;
        int mid = 0;
        boolean found=false;
        while(left<=right){
            mid = left + (right-left) / 2;
            System.out.println("Running BS :: left = "+left+" , right = "+right+" and mid = "+mid);
            if(target==nums[mid]){
                found=true;
                break;
            }
            if(target < nums[mid]){
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        if(found==true){
            System.out.println("Result of Binary search = "+mid);
            left = mid;
            right = mid;
            op[0]=left;
            op[1]=right;
            // System.out.println("Checking left-right traversal = "+ Arrays.toString(op));
            while(left>=0 && nums[left]==target){
                // System.out.println("Checking left traversal =  :: left = "+left);
                left--;
            }
            op[0]=left+1;
            while(right<=n-1 && nums[right]==target){
                // System.out.println("Checking right traversal =  :: right = "+right);
                right++;
            }
            op[1]=right-1;
        }
        /*for(int i=0;i<nums.length;i++){
            if(nums[i]==target && op[0]==-1){
                op[0] = i;
                op[1] = i;
            } else if(nums[i]==target && op[0]!=-1){
                op[1] = i;
            }
        }*/
        return op;
    }

}
