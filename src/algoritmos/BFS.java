package algoritmos;

/**
 * Start date: 26/09/2026
 * Last modification date: 03/10/2026
 *
 * Implements the Breadth-First Search (BFS) algorithm iteratively
 * over an adjacency matrix.
 *
 * The traversal array is also used as the array-based FIFO queue,
 * avoiding a second array that would store the same vertex order.
 * The execution stops when every vertex has already been discovered,
 * because no later queue processing can add a new vertex to the traversal.
 *
 * Assignments, comparisons, and executed lines are recorded.
 */
public class BFS {

    private long asignaciones;
    private long comparaciones;
    private long lineasEjecutadas;

    private int[] recorrido;

    /**
     * Executes BFS from a source vertex.
     *
     * @param matrizAdyacencia matrix that represents the graph.
     * @param origen index of the vertex from which the traversal starts.
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

        // Create the structure used to mark visited vertices.
        boolean[] visitados = new boolean[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        /*
         * Allocate the traversal array. It also works as the BFS queue,
         * because FIFO insertion order is the same as BFS traversal order.
         */
        recorrido = new int[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        // Initialize the queue front index.
        int frente = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Initialize the queue insertion index.
        int fin = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Mark the source vertex as visited.
        visitados[origen] = true;
        asignaciones++;
        lineasEjecutadas++;

        // Insert the source vertex into the queue and traversal array.
        recorrido[fin] = origen;
        asignaciones++;
        lineasEjecutadas++;

        // Advance the next insertion position.
        fin++;
        asignaciones++;
        lineasEjecutadas++;

        // Continue while the queue contains vertices to process.
        while (frente < fin) {

            // Count the true evaluation of the loop condition.
            comparaciones++;
            lineasEjecutadas++;

            // Remove the next vertex from the front of the queue.
            int actual = recorrido[frente];
            asignaciones++;
            lineasEjecutadas++;

            // Advance the queue front.
            frente++;
            asignaciones++;
            lineasEjecutadas++;

            // Start examining possible neighbors from vertex zero.
            int vecino = 0;
            asignaciones++;
            lineasEjecutadas++;

            // Examine every possible neighbor in the adjacency matrix row.
            while (vecino < cantidadVertices) {

                // Count the true evaluation of the neighbor loop condition.
                comparaciones++;
                lineasEjecutadas++;

                // Check whether an edge exists between both vertices.
                comparaciones++;
                lineasEjecutadas++;

                if (matrizAdyacencia[actual][vecino] != 0) {

                    // Check whether the neighboring vertex has not been visited.
                    comparaciones++;
                    lineasEjecutadas++;

                    if (!visitados[vecino]) {

                        // Mark the newly discovered vertex as visited.
                        visitados[vecino] = true;
                        asignaciones++;
                        lineasEjecutadas++;

                        // Insert the vertex into the queue and traversal array.
                        recorrido[fin] = vecino;
                        asignaciones++;
                        lineasEjecutadas++;

                        // Advance the next insertion position.
                        fin++;
                        asignaciones++;
                        lineasEjecutadas++;
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

            /*
             * Stop when every vertex has already been discovered.
             * The traversal array already contains the complete BFS order.
             */
            comparaciones++;
            lineasEjecutadas++;

            if (fin == cantidadVertices) {
                lineasEjecutadas++;
                return;
            }
        }

        // Count the final false evaluation of the main BFS loop.
        comparaciones++;
        lineasEjecutadas++;
    }

    /**
     * Returns the traversal generated by the last BFS execution.
     *
     * @return array containing the vertices in traversal order.
     */
    public int[] getRecorrido() {
        // Return the traversal produced by the latest execution.
        return recorrido;
    }

    /**
     * Returns the number of assignments performed by BFS.
     *
     * @return number of assignments.
     */
    public long getAsignaciones() {
        // Return the assignment counter.
        return asignaciones;
    }

    /**
     * Returns the number of comparisons performed by BFS.
     *
     * @return number of comparisons.
     */
    public long getComparaciones() {
        // Return the comparison counter.
        return comparaciones;
    }

    /**
     * Returns the number of lines executed by BFS.
     *
     * @return number of executed lines.
     */
    public long getLineasEjecutadas() {
        // Return the executed-line counter.
        return lineasEjecutadas;
    }
}