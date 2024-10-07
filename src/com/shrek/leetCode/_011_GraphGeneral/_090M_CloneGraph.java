package com.shrek.leetCode._011_GraphGeneral;

/**
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed).
 * For example, the first node with val == 1, the second node with val == 2, and so on.
 * The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph.
 * Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1.
 * You must return the copy of the given node as a reference to the cloned graph.
 *
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 *
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *
 *
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]
 *
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 *
 * Example 3:
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 * Constraints:
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _090M_CloneGraph {

    public static void main(String[] args) {
        int[][] adjList = new int[][]{
                {2,4},
                {1,3},
                {2,4},
                {1,3}
        };
        Node node = generateGraph(adjList);
        printGraph(node);
        System.out.println("cloneGraph for grid = "+adjList+" is equal to ");
        printGraph(cloneGraph(node));
        // [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        System.out.println();

    }

    public static Map<Integer, Node> map = new HashMap<Integer, Node>();
    public static Node generateGraph(int[][] adjList){
        map.clear();
        Node newNode = new Node();
        for(int i=0;i<adjList.length;i++){
            newNode = new Node(i+1, new ArrayList<>());
            map.put(i+1, newNode);
        }
        Node tempNode;
        for(int i=0;i<adjList.length;i++){
            tempNode = map.get(i+1);
            for(int j=0;j<adjList[i].length;j++){
                tempNode.neighbors.add(map.get(adjList[i][j]));
            }
        }

        /*System.out.println(" GENERATING GRAPH TEST START ");

        for(int i=0;i<adjList.length;i++){
            tempNode = map.get(i+1);
            System.out.println("node = "+tempNode+", node.val = "+tempNode.val+", ");
            for(Node j:tempNode.neighbors){
                System.out.print("neighbors = "+j+", neighbors.val = "+j.val+", ");
            }
            System.out.println();
        }

        System.out.println(" GENERATING GRAPH TEST FINISH ");*/

        return map.get(1);
    }

    public static void printGraph(Node node) {
        boolean[] visited = new boolean[101];
        System.out.println("Start: printing graph");
        DFS(node, visited);
        System.out.println();
        System.out.println("End: printing graph");
    }

    public static void DFS(Node node, boolean[] visited){
        visited[node.val] = true;
        System.out.println("node.val = "+node.val+", ");
        for(Node i:node.neighbors){
            if(!visited[i.val]){
                DFS(i, visited);
            }
        }
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // trick in this solution is to create a Map for node and its copy
    // that way during traversal you create copy of node and add them in adjacency List as well.
    public static Map<Node, Node> visited = new HashMap<Node, Node>();
    public static Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node cp = new Node(node.val, new ArrayList<>());
        visited.put(node, cp);
        for(Node i:node.neighbors){
            cp.neighbors.add( cloneGraph(i) );
        }
        return cp;
    }

    // This one does DFS traversal and creation of nodes BUT since it doesn't returns proper nodes for reference
    // it fails to clone adjanceny list properly
    /*public static Node cloneGraph(Node node) {
        boolean[] visited = new boolean[101];
        return DFS(node, visited);
    }

    public static Node DFS(Node node, boolean[] visited){
        visited[node.val] = true;
        Node cp = new Node(node.val);
        List<Node> adjL = new ArrayList<>();
        for(Node i:node.neighbors){
            if(!visited[i.val]){
                adjL.add(i);
                DFS(i, visited);
            }
        }
        return cp;
    }*/

}
