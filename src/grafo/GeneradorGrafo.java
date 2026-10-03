package grafo;

import java.util.Random;

/**
 * Start date: 25/09/2026
 * Last modification date: 02/10/2026
 *
 * Generates the graphs used as input data for BFS, DFS, Dijkstra,
 * and Bellman-Ford.
 *
 * For a size of 10 vertices, fixed weights defined in the code are used.
 * For the remaining sizes, pseudorandom weights between 5 and 55 are
 * generated automatically. The generated graphs are complete, weighted,
 * and undirected.
 */
public class GeneradorGrafo {

    private static final int pesoMinimo = 5;
    private static final int pesoMaximo = 55;
    private static final long semilla = 3002L;

    /**
     * Generates a complete graph with the specified number of vertices.
     * For 10 vertices, fixed weights are used; for the remaining sizes,
     * pseudorandom weights are used.
     *
     * @param cantidadVertices number of vertices in the graph
     * @return generated complete graph
     */
    public Grafo generarGrafo(int cantidadVertices) {

        // Use the fixed graph required for the smallest test size.
        if (cantidadVertices == 10) {
            return generarGrafoFijo();
        }

        // Generate the remaining test graphs pseudorandomly.
        return generarGrafoAleatorio(cantidadVertices);
    }

    /**
     * Generates the fixed graph of 10 vertices required for the smallest
     * test size.
     *
     * @return complete graph of 10 vertices with fixed weights
     */
    private Grafo generarGrafoFijo() {

        // Define the fixed symmetric weight matrix used for the test.
        int[][] pesosFijos = {
                {0, 12, 27, 35, 18, 44, 23, 51, 16, 39},
                {12, 0, 31, 14, 48, 25, 37, 19, 53, 28},
                {27, 31, 0, 46, 11, 34, 55, 22, 41, 17},
                {35, 14, 46, 0, 29, 52, 20, 38, 15, 43},
                {18, 48, 11, 29, 0, 24, 36, 50, 13, 32},
                {44, 25, 34, 52, 24, 0, 47, 10, 30, 54},
                {23, 37, 55, 20, 36, 47, 0, 26, 49, 9},
                {51, 19, 22, 38, 50, 10, 26, 0, 33, 45},
                {16, 53, 41, 15, 13, 30, 49, 33, 0, 21},
                {39, 28, 17, 43, 32, 54, 9, 45, 21, 0}
        };

        // Create the graph that will receive the fixed weights.
        Grafo grafo = new Grafo(10);

        /*
         * Traverse only the upper half of the matrix because
         * establecerArista stores every edge in both directions.
         */
        for (int origen = 0; origen < 10; origen++) {
            for (int destino = origen + 1; destino < 10; destino++) {

                // Copy the predefined weight into the graph.
                grafo.establecerArista(
                        origen,
                        destino,
                        pesosFijos[origen][destino]
                );
            }
        }

        // Return the completed fixed graph.
        return grafo;
    }

    /**
     * Generates a complete graph whose weights are between 5 and 55,
     * inclusive.
     *
     * A fixed seed is used to obtain the same input data when a test
     * is repeated.
     *
     * @param cantidadVertices number of vertices in the graph
     * @return complete graph with pseudorandom weights
     */
    private Grafo generarGrafoAleatorio(int cantidadVertices) {

        // Create an empty graph of the requested size.
        Grafo grafo = new Grafo(cantidadVertices);

        // Initialize the generator with a fixed seed for reproducibility.
        Random random = new Random(semilla);

        /*
         * Generate each undirected edge only once by traversing
         * the upper triangular portion of the adjacency matrix.
         */
        for (int origen = 0; origen < cantidadVertices; origen++) {
            for (int destino = origen + 1;
                 destino < cantidadVertices;
                 destino++) {

                // Generate a weight in the inclusive range [5, 55].
                int peso = random.nextInt(
                        pesoMaximo - pesoMinimo + 1
                ) + pesoMinimo;

                // Store the generated edge in both graph directions.
                grafo.establecerArista(origen, destino, peso);
            }
        }

        // Return the completed pseudorandom graph.
        return grafo;
    }
}