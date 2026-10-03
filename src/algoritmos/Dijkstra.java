package algoritmos;

/**
 * Start date: 28/09/2026
 * Last modification date: 02/10/2026
 *
 * Implements Dijkstra's algorithm over an adjacency matrix.
 *
 * The algorithm computes the minimum distance from a source vertex
 * to all other vertices in the graph. The selection of the unvisited
 * vertex with the smallest tentative distance is performed by linear search.
 *
 * Assignments, comparisons, and executed lines are recorded.
 */
public class Dijkstra {

    private long asignaciones;
    private long comparaciones;
    private long lineasEjecutadas;

    private int[] distancias;

    /**
     * Executes Dijkstra's algorithm from a source vertex.
     *
     * @param matrizAdyacencia weighted matrix that represents the graph.
     * @param origen index of the vertex from which the algorithm starts.
     */
    public void ejecutar(int[][] matrizAdyacencia, int origen) {

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

        // Create the structure used to mark vertices whose distance is final.
        boolean[] visitados = new boolean[cantidadVertices];
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

        // Initialize the number of completed Dijkstra iterations.
        int iteracion = 0;
        asignaciones++;
        lineasEjecutadas++;

        /*
         * In each iteration, the unvisited vertex with the smallest
         * tentative distance is selected and then the distances of
         * its neighbors are updated.
         */
        while (iteracion < cantidadVertices) {
            comparaciones++;
            lineasEjecutadas++;

            // No current vertex has been selected yet.
            int actual = -1;
            asignaciones++;
            lineasEjecutadas++;

            // Start the search using infinity as the smallest known distance.
            int menorDistancia = infinito;
            asignaciones++;
            lineasEjecutadas++;

            // Begin the linear search from the first vertex.
            int candidato = 0;
            asignaciones++;
            lineasEjecutadas++;

            /*
             * Linearly search for the unvisited vertex
             * with the smallest tentative distance.
             */
            while (candidato < cantidadVertices) {
                comparaciones++;
                lineasEjecutadas++;

                // Check whether the candidate has not been finalized.
                comparaciones++;
                lineasEjecutadas++;

                if (!visitados[candidato]) {

                    // Compare its distance with the smallest one found so far.
                    comparaciones++;
                    lineasEjecutadas++;

                    if (distancias[candidato] < menorDistancia) {

                        // Store the new smallest tentative distance.
                        menorDistancia = distancias[candidato];
                        asignaciones++;
                        lineasEjecutadas++;

                        // Store the corresponding vertex.
                        actual = candidato;
                        asignaciones++;
                        lineasEjecutadas++;
                    }
                }

                // Continue with the next candidate vertex.
                candidato++;
                asignaciones++;
                lineasEjecutadas++;
            }

            // Count the final false evaluation of the candidate search loop.
            comparaciones++;
            lineasEjecutadas++;

            // Mark the selected vertex as finalized.
            visitados[actual] = true;
            asignaciones++;
            lineasEjecutadas++;

            // Begin examining possible neighbors from vertex zero.
            int vecino = 0;
            asignaciones++;
            lineasEjecutadas++;

            /*
             * Traverse the possible neighbors of the selected vertex
             * and perform distance relaxation when applicable.
             */
            while (vecino < cantidadVertices) {
                comparaciones++;
                lineasEjecutadas++;

                // Ignore vertices whose shortest distance is already final.
                comparaciones++;
                lineasEjecutadas++;

                if (!visitados[vecino]) {

                    // Check whether an edge exists to the possible neighbor.
                    comparaciones++;
                    lineasEjecutadas++;

                    if (matrizAdyacencia[actual][vecino] != 0) {

                        // Ensure that the selected vertex is reachable.
                        comparaciones++;
                        lineasEjecutadas++;

                        if (distancias[actual] != infinito) {

                            // Calculate the distance obtained through the current vertex.
                            int nuevaDistancia =
                                    distancias[actual]
                                            + matrizAdyacencia[actual][vecino];

                            asignaciones++;
                            lineasEjecutadas++;

                            // Check whether the new route improves the known distance.
                            comparaciones++;
                            lineasEjecutadas++;

                            if (nuevaDistancia < distancias[vecino]) {

                                // Update the tentative shortest distance.
                                distancias[vecino] = nuevaDistancia;
                                asignaciones++;
                                lineasEjecutadas++;
                            }
                        }
                    }
                }

                // Continue with the next possible neighbor.
                vecino++;
                asignaciones++;
                lineasEjecutadas++;
            }

            // Count the final false evaluation of the neighbor loop.
            comparaciones++;
            lineasEjecutadas++;

            // Advance to the next main iteration.
            iteracion++;
            asignaciones++;
            lineasEjecutadas++;
        }

        // Count the final false evaluation of the main Dijkstra loop.
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
     * Returns the number of assignments performed by Dijkstra's algorithm.
     *
     * @return number of assignments.
     */
    public long getAsignaciones() {
        // Return the assignment counter.
        return asignaciones;
    }

    /**
     * Returns the number of comparisons performed by Dijkstra's algorithm.
     *
     * @return number of comparisons.
     */
    public long getComparaciones() {
        // Return the comparison counter.
        return comparaciones;
    }

    /**
     * Returns the number of lines executed by Dijkstra's algorithm.
     *
     * @return number of executed lines.
     */
    public long getLineasEjecutadas() {
        // Return the executed-line counter.
        return lineasEjecutadas;
    }
}