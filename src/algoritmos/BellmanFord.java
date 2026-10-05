package algoritmos;

/**
 * Start date: 05/10/2026
 * Last modification date: 05/10/2026
 *
 * Implements the Bellman-Ford shortest-path algorithm over an adjacency
 * matrix. The algorithm calculates the minimum distance from a source
 * vertex to all other vertices and can identify a reachable negative cycle.
 *
 * Because the project graph is stored as a matrix, every relaxation pass
 * examines all possible ordered vertex pairs. An early-termination test
 * stops the algorithm when a complete pass produces no distance update.
 *
 * Assignments, comparisons, and executed lines are recorded.
 */
public class BellmanFord {

    private long asignaciones;
    private long comparaciones;
    private long lineasEjecutadas;

    private int[] distancias;
    private boolean cicloNegativo;

    /**
     * Executes Bellman-Ford from a source vertex.
     *
     * @param matrizAdyacencia weighted matrix that represents the graph.
     * @param origen index of the vertex from which the algorithm starts.
     */
    public void ejecutar(byte[][] matrizAdyacencia, int origen) {

        // Reset measurement instruments before starting a new execution.
        asignaciones = 0;
        comparaciones = 0;
        lineasEjecutadas = 0;

        // Count the assignment produced by passing both parameters by value.
        asignaciones += 2;

        // Count the execution of the method header.
        lineasEjecutadas++;

        // Obtain the number of vertices represented by the adjacency matrix.
        int cantidadVertices = matrizAdyacencia.length;
        asignaciones++;
        lineasEjecutadas++;

        // Allocate the array that stores tentative minimum distances.
        distancias = new int[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        // Initially, no reachable negative cycle has been detected.
        cicloNegativo = false;
        asignaciones++;
        lineasEjecutadas++;

        // Define the value used to represent an initially unreachable vertex.
        int infinito = Integer.MAX_VALUE;
        asignaciones++;
        lineasEjecutadas++;

        // Start initialization from the first vertex.
        int vertice = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Initialize every distance with the value representing infinity.
        while (vertice < cantidadVertices) {
            comparaciones++;
            lineasEjecutadas++;

            distancias[vertice] = infinito;
            asignaciones++;
            lineasEjecutadas++;

            vertice++;
            asignaciones++;
            lineasEjecutadas++;
        }

        // Count the final false evaluation of the initialization loop.
        comparaciones++;
        lineasEjecutadas++;

        // The distance from the source vertex to itself is zero.
        distancias[origen] = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Initialize the number of completed relaxation passes.
        int iteracion = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Perform at most n - 1 complete relaxation passes.
        while (iteracion < cantidadVertices - 1) {
            comparaciones++;
            lineasEjecutadas++;

            // Assume that the current pass will not improve any distance.
            boolean huboCambios = false;
            asignaciones++;
            lineasEjecutadas++;

            // Begin examining possible edge origins from vertex zero.
            int origenArista = 0;
            asignaciones++;
            lineasEjecutadas++;

            // Examine every matrix row as a possible edge origin.
            while (origenArista < cantidadVertices) {
                comparaciones++;
                lineasEjecutadas++;

                /*
                 * Only vertices already reachable from the source can
                 * produce a valid relaxation.
                 */
                comparaciones++;
                lineasEjecutadas++;

                if (distancias[origenArista] != infinito) {

                    // Begin examining possible destinations from vertex zero.
                    int destino = 0;
                    asignaciones++;
                    lineasEjecutadas++;

                    // Examine every possible destination in the matrix row.
                    while (destino < cantidadVertices) {
                        comparaciones++;
                        lineasEjecutadas++;

                        // Check whether the ordered pair represents an edge.
                        comparaciones++;
                        lineasEjecutadas++;

                        if (matrizAdyacencia[origenArista][destino] != 0) {

                            // Calculate the route obtained through this edge.
                            int nuevaDistancia =
                                    distancias[origenArista]
                                            + matrizAdyacencia[origenArista][destino];

                            asignaciones++;
                            lineasEjecutadas++;

                            // Check whether the route improves the known distance.
                            comparaciones++;
                            lineasEjecutadas++;

                            if (nuevaDistancia < distancias[destino]) {

                                // Store the improved tentative minimum distance.
                                distancias[destino] = nuevaDistancia;
                                asignaciones++;
                                lineasEjecutadas++;

                                // Record that another relaxation pass may be needed.
                                huboCambios = true;
                                asignaciones++;
                                lineasEjecutadas++;
                            }
                        }

                        // Continue with the next possible edge destination.
                        destino++;
                        asignaciones++;
                        lineasEjecutadas++;
                    }

                    // Count the final false evaluation of the destination loop.
                    comparaciones++;
                    lineasEjecutadas++;
                }

                // Continue with the next possible edge origin.
                origenArista++;
                asignaciones++;
                lineasEjecutadas++;
            }

            // Count the final false evaluation of the origin loop.
            comparaciones++;
            lineasEjecutadas++;

            /*
             * If no distance changed, all reachable minimum distances are
             * already stable and no negative cycle is reachable.
             */
            comparaciones++;
            lineasEjecutadas++;

            if (!huboCambios) {
                lineasEjecutadas++;
                return;
            }

            // Advance to the next Bellman-Ford relaxation pass.
            iteracion++;
            asignaciones++;
            lineasEjecutadas++;
        }

        // Count the final false evaluation of the relaxation-pass loop.
        comparaciones++;
        lineasEjecutadas++;

        // Begin the additional pass used to detect a reachable negative cycle.
        int origenArista = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Examine every possible edge origin for one more relaxation.
        while (origenArista < cantidadVertices) {
            comparaciones++;
            lineasEjecutadas++;

            // Ignore origins that remain unreachable from the source vertex.
            comparaciones++;
            lineasEjecutadas++;

            if (distancias[origenArista] != infinito) {

                // Begin examining possible edge destinations from vertex zero.
                int destino = 0;
                asignaciones++;
                lineasEjecutadas++;

                // Examine the complete adjacency-matrix row.
                while (destino < cantidadVertices) {
                    comparaciones++;
                    lineasEjecutadas++;

                    // Check whether an edge exists between both vertices.
                    comparaciones++;
                    lineasEjecutadas++;

                    if (matrizAdyacencia[origenArista][destino] != 0) {

                        // Calculate the distance that another relaxation would obtain.
                        int nuevaDistancia =
                                distancias[origenArista]
                                        + matrizAdyacencia[origenArista][destino];

                        asignaciones++;
                        lineasEjecutadas++;

                        /*
                         * A further improvement after n - 1 passes proves
                         * the existence of a reachable negative cycle.
                         */
                        comparaciones++;
                        lineasEjecutadas++;

                        if (nuevaDistancia < distancias[destino]) {
                            cicloNegativo = true;
                            asignaciones++;
                            lineasEjecutadas++;
                            return;
                        }
                    }

                    // Continue with the next possible edge destination.
                    destino++;
                    asignaciones++;
                    lineasEjecutadas++;
                }

                // Count the final false evaluation of the destination loop.
                comparaciones++;
                lineasEjecutadas++;
            }

            // Continue with the next possible edge origin.
            origenArista++;
            asignaciones++;
            lineasEjecutadas++;
        }

        // Count the final false evaluation of the negative-cycle origin loop.
        comparaciones++;
        lineasEjecutadas++;
    }

    /**
     * Returns the minimum distances calculated from the source vertex.
     *
     * @return array containing the minimum distances.
     */
    public int[] getDistancias() {
        // Return the distances produced by the latest execution.
        return distancias;
    }

    /**
     * Indicates whether the last execution detected a reachable negative cycle.
     *
     * @return true when a reachable negative cycle was detected.
     */
    public boolean tieneCicloNegativo() {
        // Return the result of the negative-cycle verification.
        return cicloNegativo;
    }

    /**
     * Returns the number of assignments performed by Bellman-Ford.
     *
     * @return number of assignments.
     */
    public long getAsignaciones() {
        // Return the assignment counter.
        return asignaciones;
    }

    /**
     * Returns the number of comparisons performed by Bellman-Ford.
     *
     * @return number of comparisons.
     */
    public long getComparaciones() {
        // Return the comparison counter.
        return comparaciones;
    }

    /**
     * Returns the number of lines executed by Bellman-Ford.
     *
     * @return number of executed lines.
     */
    public long getLineasEjecutadas() {
        // Return the executed-line counter.
        return lineasEjecutadas;
    }
}
