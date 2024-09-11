package com.shrek.leetCode._001_ArraysStrings;

/**
 *
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank
 * and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index
 * if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique
 *
 *
 *
 * Example 1:
 *
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * Example 2:
 *
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 *
 *
 * Constraints:
 *
 * n == gas.length == cost.length
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 *
 * Hint: Use greedy Approach by calculating totalSurplus and surplus at each step by gas - cost
 *
 */

import java.util.Arrays;

public class _014M_GasStation {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        System.out.println(Arrays.toString(gas));
        int[] cost = {3,4,5,1,2};
        System.out.println(Arrays.toString(cost));
        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println("-------------- BREAK -----------------");
        gas = new int[]{2,3,4};
        System.out.println(Arrays.toString(gas));
        cost = new int[]{3,4,3};
        System.out.println(Arrays.toString(cost));
        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println("-------------- BREAK -----------------");
        gas = new int[]{5,1,2,3,4};
        System.out.println(Arrays.toString(gas));
        cost = new int[]{4,4,1,5,1};
        System.out.println(Arrays.toString(cost));
        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println("-------------- BREAK -----------------");
        /*nums = new int[]{0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{0,0,1,0,0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{3,0,6,1,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));
        System.out.println("-------------- BREAK -----------------");
        nums = new int[]{9,7,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(hIndex(nums));*/
    }

    // Optimal Approach: Greedy Approach by calculating surplus & extraSurplus and if totalSurplus is (-)ve return -1
    // otherwise return i where (+)ve total suplus starts from
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int extraFuel = 0;
        int totalExtraFuel = 0;
        int start = 0;
        for(int i = 0;i < n; i++){
            extraFuel += gas[i] - cost[i];
            totalExtraFuel += gas[i] - cost[i];
            if(extraFuel<0){
                extraFuel = 0;
                start = i+1;
            }
        }
        if(totalExtraFuel < 0){
            start = -1;
        }
        return start;
    }

    // Brute Force
    /*public static int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int startLocation;
        int gasAtCurrentLocation;
        int costToNextLocation;
        int k=0;
        int circuitCount;
        int tank = 0;
        for(int i = 0;i < n; i++){
            tank = 0;
            startLocation = i;
            circuitCount = 0;
            k=startLocation;
            for(int j = 0;j < n; j++){
                gasAtCurrentLocation = gas[k];
                costToNextLocation = cost[k];
                tank = tank+gasAtCurrentLocation;
                if(tank >= costToNextLocation){
                    tank = tank - costToNextLocation;
                    if(tank>=0){
                        if(k==n-1){
                            k = 0;
                        } else {
                            k++;
                        }
                        if(circuitCount==n-1){
                            return startLocation;
                        }
                        circuitCount++;
                    } else{
                        break;
                    }
                } else{
                    break;
                }
            }
        }
        return -1;
    }*/

}
