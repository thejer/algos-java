package javaSolutions.src.old.graph;// Kosaraju's algorithm to find strongly connected components in Java

import java.util.*;
import java.util.LinkedList;

class SCCGraph {
	private final int V;
	private final LinkedList<Integer>[] adj;

	// Create a graph
	SCCGraph(int s) {
		V = s;
		adj = new LinkedList[s];
		for (int i = 0; i < s; ++i)
			adj[i] = new LinkedList<>();
	}

  // Add edge
	void addEdge(int s, int d) {
		adj[s].add(d);
	}

	void fillOrder(int s, boolean[] visitedVertices, Stack<Integer> stack) {
		visitedVertices[s] = true;

		for (int n : adj[s]) {
			if (!visitedVertices[n])
				fillOrder(n, visitedVertices, stack);
		}
		stack.push(s);
	}

	// Transpose the graph
	SCCGraph Transpose() {
		SCCGraph g = new SCCGraph(V);
		for (int s = 0; s < V; s++) {
			for (Integer integer : adj[s]) {
				g.adj[integer].add(s);
			}
		}
		return g;
	}

	// DFS
	void DFSUtil(int s, boolean[] visitedVertices) {
		visitedVertices[s] = true;
		System.out.print(s + " ");

		for (Integer integer : adj[s]) {
			if (!visitedVertices[integer])
				DFSUtil(integer, visitedVertices);
		}
	}


	// Print strongly connected component
	void printSCC() {
		Stack<Integer> stack = new Stack<>();

		boolean[] visitedVertices = new boolean[V];

		for (int i = 0; i < V; i++)
			if (!visitedVertices[i])
				fillOrder(i, visitedVertices, stack);

		SCCGraph gr = Transpose();
		visitedVertices = new boolean[V];

		while (!stack.empty()) {
			int s = stack.pop();

			if (!visitedVertices[s]) {
				gr.DFSUtil(s, visitedVertices);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		SCCGraph g = new SCCGraph(8);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 0);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);
		g.addEdge(6, 7);

		System.out.println("Strongly Connected Components:");
		g.printSCC();
	}

}
