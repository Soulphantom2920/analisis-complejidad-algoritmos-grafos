package ejecucion;

import algoritmos.BFS;
import algoritmos.Dijkstra;
import grafo.GeneradorGrafo;
import grafo.Grafo;
import medicion.Metricas;

import java.util.Arrays;

/**
 * Start date: 26/09/2026
 * Last modification date: 02/10/2026
 *
 * Entry point of the project.
 * Automatically generates the required graphs and executes the algorithms
 * without requesting data from the user.
 *
 * Currently executes BFS and Dijkstra for the sizes defined by the project.
 */
public class Main {

    /**
     * Automatically executes BFS and Dijkstra for the established sizes.
     *
     * The complete algorithm response is displayed for the fixed graph
     * of 10 vertices. For the remaining executable sizes, the required
     * measurement variables are displayed.
     *
     * Graph generation and result printing are performed outside the
     * execution-time measurement of the algorithms.
     *
     * @param args command-line arguments; they are not used.
     */
    public static void main(String[] args) {

        // Define the exact graph sizes required by the project.
        int[] tamanos = {
                10,
                100,
                500,
                1000,
                5000,
                10000,
                50000,
                100000
        };

        // Use vertex zero as the common source for both algorithms.
        int origen = 0;

        // Create the component responsible for generating all input graphs.
        GeneradorGrafo generadorGrafo = new GeneradorGrafo();

        // Execute the complete experiment independently for every graph size.
        for (int cantidadVertices : tamanos) {

            // Print the size associated with the current experiment.
            System.out.println();
            System.out.println("==================================================");
            System.out.println("TAMAÑO DEL GRAFO: " + cantidadVertices);
            System.out.println("==================================================");
            System.out.println();

            Grafo grafo;

            try {

                /*
                 * Generate the input graph before measuring either algorithm
                 * so graph construction is excluded from their execution time.
                 */
                grafo =
                        generadorGrafo.generarGrafo(cantidadVertices);
            }
            catch (OutOfMemoryError error) {

                /*
                 * If the graph itself cannot be created, neither algorithm
                 * can receive valid input for this size.
                 */
                System.out.println("-------------------- BFS --------------------");
                System.out.println("No se obtuvo respuesta.");

                System.out.println();
                System.out.println("----------------- DIJKSTRA ------------------");
                System.out.println("No se obtuvo respuesta.");

                // Continue with the next required graph size.
                continue;
            }

            // Obtain the common adjacency matrix used by both algorithms.
            int[][] matrizAdyacencia =
                    grafo.getMatrizAdyacencia();

            System.out.println("-------------------- BFS --------------------");

            try {

                // Create a new BFS instance for the current execution.
                BFS bfs = new BFS();

                /*
                 * Measure only the execution of BFS.
                 * Graph generation and console output remain outside
                 * the measured interval.
                 */
                long inicioTiempoBfs = System.nanoTime();
                bfs.ejecutar(matrizAdyacencia, origen);
                long finTiempoBfs = System.nanoTime();

                // Calculate the elapsed wall-clock time in nanoseconds.
                long tiempoBfs =
                        finTiempoBfs - inicioTiempoBfs;

                /*
                 * Store all measurements after the timed execution
                 * has already finished.
                 */
                Metricas metricasBfs = new Metricas(
                        bfs.getAsignaciones(),
                        bfs.getComparaciones(),
                        bfs.getLineasEjecutadas(),
                        tiempoBfs
                );

                /*
                 * Display the complete BFS response only for the fixed
                 * 10-vertex graph, where the result can be inspected directly.
                 */
                if (cantidadVertices == 10) {
                    System.out.println(
                            "Recorrido: "
                                    + Arrays.toString(
                                    bfs.getRecorrido()
                            )
                    );
                }

                // Print the empirical measurements required for BFS.
                System.out.println(
                        "Asignaciones:          "
                                + metricasBfs.getAsignaciones()
                );

                System.out.println(
                        "Comparaciones:         "
                                + metricasBfs.getComparaciones()
                );

                System.out.println(
                        "Líneas ejecutadas:     "
                                + metricasBfs.getLineasEjecutadas()
                );

                System.out.println(
                        "Tiempo ejecución (ns): "
                                + metricasBfs.getTiempoNanosegundos()
                );

                // Print the physical NCLOC previously determined for BFS.
                System.out.println(
                        "Líneas código:          103"
                );
            }
            catch (OutOfMemoryError error) {

                /*
                 * Report failure only for BFS if the graph exists
                 * but BFS cannot complete because of memory exhaustion.
                 */
                System.out.println("No se obtuvo respuesta.");
            }

            System.out.println();
            System.out.println("----------------- DIJKSTRA ------------------");

            try {

                // Create a new Dijkstra instance for the current execution.
                Dijkstra dijkstra = new Dijkstra();

                /*
                 * Measure only the execution of Dijkstra.
                 * Input generation and result printing remain outside
                 * the measured interval.
                 */
                long inicioTiempoDijkstra =
                        System.nanoTime();

                dijkstra.ejecutar(
                        matrizAdyacencia,
                        origen
                );

                long finTiempoDijkstra =
                        System.nanoTime();

                // Calculate the elapsed wall-clock time in nanoseconds.
                long tiempoDijkstra =
                        finTiempoDijkstra
                                - inicioTiempoDijkstra;

                /*
                 * Store all measurements after the timed execution
                 * has already finished.
                 */
                Metricas metricasDijkstra =
                        new Metricas(
                                dijkstra.getAsignaciones(),
                                dijkstra.getComparaciones(),
                                dijkstra.getLineasEjecutadas(),
                                tiempoDijkstra
                        );

                /*
                 * Display the complete shortest-distance result only for
                 * the fixed 10-vertex graph, where it can be inspected directly.
                 */
                if (cantidadVertices == 10) {
                    System.out.println(
                            "Distancias: "
                                    + Arrays.toString(
                                    dijkstra.getDistancias()
                            )
                    );
                }

                // Print the empirical measurements required for Dijkstra.
                System.out.println(
                        "Asignaciones:          "
                                + metricasDijkstra.getAsignaciones()
                );

                System.out.println(
                        "Comparaciones:         "
                                + metricasDijkstra.getComparaciones()
                );

                System.out.println(
                        "Líneas ejecutadas:     "
                                + metricasDijkstra.getLineasEjecutadas()
                );

                System.out.println(
                        "Tiempo ejecución (ns): "
                                + metricasDijkstra.getTiempoNanosegundos()
                );

                // Print the physical NCLOC previously determined for Dijkstra.
                System.out.println(
                        "Líneas código:          139"
                );
            }
            catch (OutOfMemoryError error) {

                /*
                 * Report failure only for Dijkstra if the graph exists
                 * but Dijkstra cannot complete because of memory exhaustion.
                 */
                System.out.println("No se obtuvo respuesta.");
            }
        }
    }
}