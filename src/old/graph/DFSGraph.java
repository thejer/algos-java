package javaSolutions.src.old.graph;// DFS algorithm in Java

import java.util.*;

class DFSGraph {
  private final LinkedList<Integer>[] adjLists;
  private final boolean[] visited;

  // Graph creation
  DFSGraph(int vertices) {
    adjLists = new LinkedList[vertices];
    visited = new boolean[vertices];

    for (int i = 0; i < vertices; i++)
      adjLists[i] = new LinkedList<>();
  }

  // Add edges
  void addEdge(int src, int dest) {
    adjLists[src].add(dest);
  }

  // DFS algorithm
  void DFS(int vertex) {
    visited[vertex] = true;
    System.out.print(vertex + " ");

    for (int adj : adjLists[vertex]) {
      if (!visited[adj])
        DFS(adj);
    }
  }

  public static void main(String[] args) {
    DFSGraph g = new DFSGraph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 3);

    System.out.println("Following is Depth First Traversal");

    g.DFS(2);
  }
}