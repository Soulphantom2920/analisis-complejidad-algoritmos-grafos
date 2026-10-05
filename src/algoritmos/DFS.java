package algoritmos;

/**
 * Start date: 05/10/2026
 * Last modification date: 05/10/2026
 *
 * Implements the Depth-First Search (DFS) algorithm iteratively
 * over an adjacency matrix.
 *
 * An array-based stack is used instead of recursion to avoid depending
 * on the Java call stack for large graphs. Each stack position also keeps
 * the next neighbor that must be examined for its corresponding vertex,
 * reproducing the behavior of a recursive depth-first traversal.
 *
 * The execution stops when every vertex has already been discovered,
 * because the traversal array already contains the complete DFS result.
 *
 * Assignments, comparisons, and executed lines are recorded.
 */
public class DFS {

    private long asignaciones;
    private long comparaciones;
    private long lineasEjecutadas;

    private int[] recorrido;

    /**
     * Executes DFS from a source vertex.
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

        // Allocate the array that stores the DFS traversal order.
        recorrido = new int[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        // Allocate the explicit stack used by the iterative DFS.
        int[] pila = new int[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        /*
         * Store, for every stack level, the next neighbor that must be
         * examined when execution returns to that vertex.
         */
        int[] siguienteVecino = new int[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        // Initialize the top of the stack with the source position.
        int tope = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Initialize the number of vertices already stored in the traversal.
        int indiceRecorrido = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Place the source vertex on the explicit DFS stack.
        pila[tope] = origen;
        asignaciones++;
        lineasEjecutadas++;

        // Start the source vertex neighbor search from position zero.
        siguienteVecino[tope] = 0;
        asignaciones++;
        lineasEjecutadas++;

        // Mark the source vertex as visited.
        visitados[origen] = true;
        asignaciones++;
        lineasEjecutadas++;

        // Store the source vertex as the first element of the traversal.
        recorrido[indiceRecorrido] = origen;
        asignaciones++;
        lineasEjecutadas++;

        // Advance the next traversal insertion position.
        indiceRecorrido++;
        asignaciones++;
        lineasEjecutadas++;

        // Continue while at least one vertex remains on the DFS stack.
        while (tope >= 0) {

            // Count the true evaluation of the main DFS loop condition.
            comparaciones++;
            lineasEjecutadas++;

            // Obtain the vertex currently located at the top of the stack.
            int actual = pila[tope];
            asignaciones++;
            lineasEjecutadas++;

            // Resume its neighbor search from the previously stored position.
            int vecino = siguienteVecino[tope];
            asignaciones++;
            lineasEjecutadas++;

            // No deeper unvisited neighbor has been found in this iteration yet.
            boolean encontrado = false;
            asignaciones++;
            lineasEjecutadas++;

            // Search for the next unvisited neighbor of the current vertex.
            while (vecino < cantidadVertices) {

                // Count the true evaluation of the neighbor loop condition.
                comparaciones++;
                lineasEjecutadas++;

                /*
                 * Save the next position before possibly descending to a
                 * neighboring vertex. This replaces the return point of
                 * a recursive DFS call.
                 */
                siguienteVecino[tope] = vecino + 1;
                asignaciones++;
                lineasEjecutadas++;

                // Check whether an edge exists between both vertices.
                comparaciones++;
                lineasEjecutadas++;

                if (matrizAdyacencia[actual][vecino] != 0) {

                    // Check whether the neighboring vertex is still unvisited.
                    comparaciones++;
                    lineasEjecutadas++;

                    if (!visitados[vecino]) {

                        // Mark the neighboring vertex immediately as visited.
                        visitados[vecino] = true;
                        asignaciones++;
                        lineasEjecutadas++;

                        // Store the vertex in DFS discovery order.
                        recorrido[indiceRecorrido] = vecino;
                        asignaciones++;
                        lineasEjecutadas++;

                        // Advance the next traversal insertion position.
                        indiceRecorrido++;
                        asignaciones++;
                        lineasEjecutadas++;

                        // Descend one level in the explicit DFS stack.
                        tope++;
                        asignaciones++;
                        lineasEjecutadas++;

                        // Push the newly discovered vertex onto the stack.
                        pila[tope] = vecino;
                        asignaciones++;
                        lineasEjecutadas++;

                        // Its neighbor search must begin from vertex zero.
                        siguienteVecino[tope] = 0;
                        asignaciones++;
                        lineasEjecutadas++;

                        // Record that the traversal descended to a new vertex.
                        encontrado = true;
                        asignaciones++;
                        lineasEjecutadas++;

                        /*
                         * Stop immediately when every vertex is discovered.
                         * No further backtracking can modify the traversal.
                         */
                        comparaciones++;
                        lineasEjecutadas++;

                        if (indiceRecorrido == cantidadVertices) {
                            lineasEjecutadas++;
                            return;
                        }

                        // Stop this search so DFS continues from the new top.
                        lineasEjecutadas++;
                        break;
                    }
                }

                // Continue with the next possible neighbor.
                vecino++;
                asignaciones++;
                lineasEjecutadas++;
            }

            // Check whether the current vertex has no remaining DFS child.
            comparaciones++;
            lineasEjecutadas++;

            if (!encontrado) {

                /*
                 * Since the row was exhausted naturally, count the final
                 * false evaluation of the neighbor loop condition.
                 */
                comparaciones++;
                lineasEjecutadas++;

                // Backtrack by removing the current vertex from the stack.
                tope--;
                asignaciones++;
                lineasEjecutadas++;
            }
        }

        // Count the final false evaluation of the main DFS loop.
        comparaciones++;
        lineasEjecutadas++;
    }

    /**
     * Returns the traversal generated by the last DFS execution.
     *
     * @return array containing the vertices in traversal order.
     */
    public int[] getRecorrido() {
        // Return the traversal produced by the latest execution.
        return recorrido;
    }

    /**
     * Returns the number of assignments performed by DFS.
     *
     * @return number of assignments.
     */
    public long getAsignaciones() {
        // Return the assignment counter.
        return asignaciones;
    }

    /**
     * Returns the number of comparisons performed by DFS.
     *
     * @return number of comparisons.
     */
    public long getComparaciones() {
        // Return the comparison counter.
        return comparaciones;
    }

    /**
     * Returns the number of lines executed by DFS.
     *
     * @return number of executed lines.
     */
    public long getLineasEjecutadas() {
        // Return the executed-line counter.
        return lineasEjecutadas;
    }
}
