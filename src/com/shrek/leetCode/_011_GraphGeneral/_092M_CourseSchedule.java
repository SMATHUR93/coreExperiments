package com.shrek.leetCode._011_GraphGeneral;

import java.util.*;

/**
 *
 * There are a total of numCourses courses you have to take,
 * labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 *
 * Hint 1
 * This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 *
 * Hint 2
 * Topological Sort via DFS - A great tutorial explaining the basic concepts of Topological Sort.
 *
 * Hint 3
 * Topological sort could also be done via BFS.
 *
 */

public class _092M_CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println("canFinish for prerequisites = "+prerequisites.toString()+" , equals "+ canFinish(numCourses, prerequisites));
        // true
        System.out.println();

        numCourses = 2;
        prerequisites = new int[][]{
                {1,0},
                {0,1}
        };
        System.out.println("canFinish for prerequisites = "+prerequisites.toString()+" , equals "+ canFinish(numCourses, prerequisites));
        // false
        System.out.println();

        numCourses = 4;
        prerequisites = new int[][]{
                {1,0},
                {2,1},
                {3,2}
        };
        System.out.println("canFinish for prerequisites = "+prerequisites.toString()+" , equals "+ canFinish(numCourses, prerequisites));
        // false
        System.out.println();

        numCourses = 5;
        prerequisites = new int[][]{
                {1,2},
                {4,3},
                {2,4},
                {4,1}
        };
        System.out.println("canFinish for prerequisites = "+prerequisites.toString()+" , equals "+ canFinish(numCourses, prerequisites));
        // false
        System.out.println();

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int nodesVisited = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            nodesVisited++;
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return numCourses==nodesVisited?true:false;
    }

}
