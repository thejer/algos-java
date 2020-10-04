package javaSolutions.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// Class to represent a graph
public class Graph
{

    // An array representing the graph as an adjacency list
    private final ArrayList<LinkedList<Integer>> adjacencyList;

    Graph(int nVertices)
    {
        adjacencyList = new ArrayList<>();
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            adjacencyList.add(vertexIndex,new LinkedList<>() );
        }
    }

    // function to add an edge to graph
    void addEdge(int startVertex, int endVertex)
    {
        adjacencyList.get(startVertex).add(endVertex);
    }

    private int getNoOfVertices()
    {
        return adjacencyList.size();
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int currentVertex, boolean[] visited,
                                     Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[currentVertex] = true;

        // Recur for all the vertices adjacent to this vertex
        for (int adjacentVertex : adjacencyList.get(currentVertex))
        {
            if (!visited[adjacentVertex])
            {
                topologicalSortUtil(adjacentVertex, visited, stack);
            }
        }

        // Push current vertex to stack which stores result
        stack.push(currentVertex);
    }

    // prints a Topological Sort of the complete graph
    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[getNoOfVertices()];
        for (int i = 0; i < getNoOfVertices(); i++)
        {
            visited[i] = false;
        }

        // Call the recursive helper function to store Topological
        // Sort starting from all vertices one by one
        for (int i = 0; i < getNoOfVertices(); i++)
        {
            if (!visited[i])
            {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        while (!stack.isEmpty())
        {
            System.out.print((char)('a' + stack.pop()) + " ");
        }
    }
}