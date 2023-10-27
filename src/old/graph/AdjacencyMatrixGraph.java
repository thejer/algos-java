package javaSolutions.src.old.graph;

public class AdjacencyMatrixGraph {
	private final boolean[][] adjMatrix;
	private final int numVertices;

	// Initialize the matrix
	public AdjacencyMatrixGraph(int numVertices) {
		this.numVertices = numVertices;
		adjMatrix = new boolean[numVertices][numVertices];
	}

	// Add edges
	public void addEdge(int i, int j) {
		adjMatrix[i][j] = true;
		adjMatrix[j][i] = true;
	}

	// Remove edges
	public void removeEdge(int i, int j) {
		adjMatrix[i][j] = false;
		adjMatrix[j][i] = false;
	}

	// Print the matrix
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < numVertices; i++) {
			s.append(i).append(": ");
			for (boolean j : adjMatrix[i]) {
				s.append(j ? 1 : 0).append(" ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);

		System.out.print(g);
	}
}