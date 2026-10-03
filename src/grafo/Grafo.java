package grafo;

/**
 * Start date: 25/09/2026
 * Last modification date: 03/10/2026
 *
 * Represents a complete, weighted, undirected graph using an adjacency
 * matrix. The class stores the number of vertices and the weights of
 * the graph edges.
 *
 * Edge weights are stored as bytes because the project limits them to
 * values from 5 to 55. This reduces the memory required by the matrix
 * while preserving direct access to every adjacency position.
 *
 * This class is used by BFS, DFS, Dijkstra, and Bellman-Ford as the
 * common representation of the input data.
 */
public class Grafo {

    private final int cantidadVertices;
    private final byte[][] matrizAdyacencia;

    /**
     * Creates a graph with the specified number of vertices and initializes
     * its adjacency matrix.
     *
     * @param cantidadVertices number of vertices in the graph
     */
    public Grafo(int cantidadVertices) {

        // Store the number of vertices represented by the graph.
        this.cantidadVertices = cantidadVertices;

        // Create the square matrix that stores edge weights.
        this.matrizAdyacencia =
                new byte[cantidadVertices][cantidadVertices];
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return number of vertices in the graph
     */
    public int getCantidadVertices() {

        // Return the graph size.
        return cantidadVertices;
    }

    /**
     * Returns the adjacency matrix used to represent the graph.
     *
     * @return adjacency matrix containing the edge weights
     */
    public byte[][] getMatrizAdyacencia() {

        // Return the matrix used by the graph algorithms.
        return matrizAdyacencia;
    }

    /**
     * Sets an edge between two vertices and assigns its weight.
     * Because the graph is undirected, the same weight is stored
     * in both directions of the matrix.
     *
     * @param origen source vertex
     * @param destino destination vertex
     * @param peso edge weight
     */
    void establecerArista(int origen, int destino, int peso) {

        // Store the edge from the source vertex to the destination vertex.
        matrizAdyacencia[origen][destino] = (byte) peso;

        // Store the same edge in the opposite direction.
        matrizAdyacencia[destino][origen] = (byte) peso;
    }
}