package com.shrek.leetCode._011_GraphGeneral;

/**
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites
 * where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 *
 * Hint 1
 * This problem is equivalent to finding the topological order in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 *
 * Hint 2
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 *
 * Hint 3
 * Topological sort could also be done via BFS.
 *
 */

import java.util.*;

public class _093M_CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println("findOrder for prerequisites = "+prerequisites.toString()+" , equals "+ Arrays.toString(findOrder(numCourses, prerequisites)));
        // [0,1]
        System.out.println();

        numCourses = 4;
        prerequisites = new int[][]{
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        System.out.println("findOrder for prerequisites = "+prerequisites.toString()+" , equals "+ Arrays.toString(findOrder(numCourses, prerequisites)));
        // [0,2,1,3]
        System.out.println();

        numCourses = 1;
        prerequisites = new int[][]{};
        System.out.println("findOrder for prerequisites = "+prerequisites.toString()+" , equals "+ Arrays.toString(findOrder(numCourses, prerequisites)));
        // [0]
        System.out.println();

        numCourses = 2;
        prerequisites = new int[][]{
                {0,1},
                {1,0}
        };
        System.out.println("findOrder for prerequisites = "+prerequisites.toString()+" , equals "+ Arrays.toString(findOrder(numCourses, prerequisites)));
        // []
        System.out.println();

        numCourses = 3;
        prerequisites = new int[][]{
                {1,0},
                {1,2},
                {0,1}
        };
        System.out.println("findOrder for prerequisites = "+prerequisites.toString()+" , equals "+ Arrays.toString(findOrder(numCourses, prerequisites)));
        // []
        System.out.println();

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean topologicalSortingPossible = false;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                System.out.println("This is starting node = "+i);
                queue.add(i);
                topologicalSortingPossible = true;
            }
        }

        int[] ts = new int[numCourses];

        int k=0;
        while(!queue.isEmpty()){
            int el = queue.poll();
            ts[k] = el;
            k++;
            for(int neighbour:adj.get(el)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }

        if (k == numCourses) {
            return ts;
        }

        return new int[0];

    }

}
