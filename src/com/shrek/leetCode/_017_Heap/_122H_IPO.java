package com.shrek.leetCode._017_Heap;

import java.util.*;

/**
 *
 * Suppose LeetCode will start its IPO soon.
 * In order to sell a good price of its shares to Venture Capital,
 * LeetCode would like to work on some projects to increase its capital before the IPO.
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given n projects where the ith project
 * has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 *
 * Initially, you have w capital.
 * When you finish a project,
 * you will obtain its pure profit
 * and the profit will be added to your total capital.
 * Pick a list of at most k distinct projects from given projects
 * to maximize your final capital, and return the final maximized capital.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 *
 * Example 1:
 * Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * Output: 4
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 *
 * Example 2:
 * Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * Output: 6
 *
 *
 * Constraints:
 * 1 <= k <= 105
 * 0 <= w <= 109
 * n == profits.length
 * n == capital.length
 * 1 <= n <= 105
 * 0 <= profits[i] <= 104
 * 0 <= capital[i] <= 109
 *
 */

public class _122H_IPO {

    public static void main(String[] args) {
        int k;
        int w;
        int[] profits;
        int[] capital;

        k = 2;
        w = 0;
        profits = new int[]{1,2,3};
        capital = new int[]{0,1,1};
        System.out.println("searchRange for k = "+k+" , w = "+w+" , profits = "+Arrays.toString(profits)+" and capital = "+ Arrays.toString(capital) + " , equals "+findMaximizedCapital(k, w, profits, capital));
        // 4
        System.out.println();

        k = 3;
        w = 0;
        profits = new int[]{1,2,3};
        capital = new int[]{0,1,2};
        System.out.println("searchRange for k = "+k+" , w = "+w+" , profits = "+Arrays.toString(profits)+" and capital = "+ Arrays.toString(capital) + " , equals "+findMaximizedCapital(k, w, profits, capital));
        // 6
        System.out.println();

        k = 10;
        w = 0;
        profits = new int[]{1,2,3};
        capital = new int[]{0,1,2};
        System.out.println("searchRange for k = "+k+" , w = "+w+" , profits = "+Arrays.toString(profits)+" and capital = "+ Arrays.toString(capital) + " , equals "+findMaximizedCapital(k, w, profits, capital));
        // 6
        System.out.println();

        k = 2;
        w = 0;
        profits = new int[]{1,2,3};
        capital = new int[]{0,9,10};
        System.out.println("searchRange for k = "+k+" , w = "+w+" , profits = "+Arrays.toString(profits)+" and capital = "+ Arrays.toString(capital) + " , equals "+findMaximizedCapital(k, w, profits, capital));
        // 1
        System.out.println();

        k = 2;
        w = 0;
        profits = new int[]{1,3,2};
        capital = new int[]{0,10,9};
        System.out.println("searchRange for k = "+k+" , w = "+w+" , profits = "+Arrays.toString(profits)+" and capital = "+ Arrays.toString(capital) + " , equals "+findMaximizedCapital(k, w, profits, capital));
        // 1
        System.out.println();

    }

    public static class Project implements Comparable<Project>{
        int profit;
        int capital;

        public Project() {
        }

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public int compareTo(Project o) {
            return this.capital == o.capital ? 0 : (this.capital > o.capital ? 1 : -1);
        }
    }

    public static int findMaximizedCapital(int noOfProjects, int capitalAvailable, int[] profits, int[] capital) {
        int n = capital.length;
        Project[] projects = new Project[n];
        for(int i=0;i<n;i++){
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects);
        /*for(int i=0;i<n;i++){
            System.out.println(projects[i].capital+" , "+ projects[i].profit);
        }*/

        // PriorityQueue is a min heap, but we need a max heap, so we use Collections.reverseOrder()
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        int j=0;
        for(int i=0;i<noOfProjects;i++){
            while(j<n && projects[j].capital<=capitalAvailable){
                queue.add(projects[j++].profit);
            }
            // System.out.println("Checking project no  = "+i+" , and all queue = "+queue.toString());
            if(queue.isEmpty()){
                break;
            }
            capitalAvailable+= queue.poll();
        }
        return capitalAvailable;
    }

    // Naive solution, failed cases
    /*public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = capital.length;
        for(int i=0;i<n;i++){
            if(map.get(capital[i])==null){
                map.put(capital[i], profits[i]);
            } else if(map.get(capital[i])<profits[i]){
                map.put(capital[i], profits[i]);
            }
        }
        System.out.println("Debugging map = "+map.toString());
        double curr=w;
        double maxCapital=curr;
        for(int i=0;i<k && i<n;i++){
            curr = maxCapital;
            System.out.println("Debugging , k = "+k+" , curr = "+curr);
            int bestProject = 0;
            for(int j:map.keySet()){
                if(j>curr){
                    break;
                }
                System.out.println("    Debugging , j = "+j+" ,maxCapital = "+maxCapital+" , curr+map.get(j) = "+(curr+map.get(j)));
                if(maxCapital < curr+map.get(j)){
                    maxCapital = curr+map.get(j);
                    bestProject = j;
                }
                // maxCapital = Integer.max(maxCapital, curr+map.get(j));
            }
            map.remove(bestProject);
        }
        return (int) maxCapital;
    }*/

}
