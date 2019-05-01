package com.shrek.dsa.graph;

import java.util.Iterator;

//Java program to print DFS traversal from a given given graph 
public class DepthFirstSearch {

	static Graph g;
	
	static Graph getGraph(int noOfVertices) {
		return new Graph(noOfVertices);
	}
	
	// A function used by DFS 
	static void DFSUtil(int v,boolean visited[]) {
		// Mark the current node as visited and print it 
		visited[v] = true; 
		System.out.print(v+" "); 
		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = g.adj[v].listIterator(); 
		while (i.hasNext()) {
			int n = i.next(); 
			if (!visited[n]) {
				DFSUtil(n, visited); 
			}
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil() 
	static void DFS(int v) {
		// Mark all the vertices as not visited(set as 
		// false by default in java) 
		boolean visited[] = new boolean[g.V]; 
		// Call the recursive helper function to print DFS traversal 
		DFSUtil(v, visited); 
	}

	public static void main(String args[]) {
		int noOfVertices = 7;
		g = BreadhFirstSearch.getGraph(noOfVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 5);
		g.addEdge(1, 4);
		g.addEdge(2, 6);
		int startingVertex = 0;
		System.out.println("Following is Depth First Traversal (starting from vertex "+startingVertex+")"); 
		DFS(startingVertex);
	}
}