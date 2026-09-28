package ejecucion;

import algoritmos.BFS;
import algoritmos.Dijkstra;
import grafo.GeneradorGrafo;
import grafo.Grafo;
import medicion.Metricas;

import java.util.Arrays;

/**
 * Fecha de inicio: 26/09/2026
 * Última modificación: 28/09/2026
 *
 * Punto de entrada del proyecto.
 * Genera automáticamente los grafos requeridos y ejecuta los algoritmos
 * sin solicitar datos al usuario.
 *
 * Actualmente ejecuta BFS y Dijkstra sobre los tamaños definidos
 * por el proyecto.
 */
public class Main {

    /**
     * Ejecuta automáticamente BFS y Dijkstra sobre los tamaños establecidos.
     *
     * Cada tamaño se intenta de forma independiente. La generación del grafo
     * y la impresión de resultados se realizan fuera de la medición temporal
     * de los algoritmos.
     *
     * @param args argumentos de línea de comandos; no se utilizan.
     */
    public static void main(String[] args) {

        int[] tamanos = {10, 100, 500, 1000, 5000, 10000, 50000, 100000};
        int origen = 0;

        GeneradorGrafo generadorGrafo = new GeneradorGrafo();

        for (int cantidadVertices : tamanos) {

            System.out.println();
            System.out.println("==================================================");
            System.out.println("TAMAÑO DEL GRAFO: " + cantidadVertices);
            System.out.println("==================================================");
            System.out.println();

            try {
                Grafo grafo = generadorGrafo.generarGrafo(cantidadVertices);
                int[][] matrizAdyacencia = grafo.getMatrizAdyacencia();

                BFS bfs = new BFS();
                Dijkstra dijkstra = new Dijkstra();

                long inicioTiempoBfs = System.nanoTime();
                bfs.ejecutar(matrizAdyacencia, origen);
                long finTiempoBfs = System.nanoTime();
                long tiempoBfs = finTiempoBfs - inicioTiempoBfs;

                long inicioTiempoDijkstra = System.nanoTime();
                dijkstra.ejecutar(matrizAdyacencia, origen);
                long finTiempoDijkstra = System.nanoTime();
                long tiempoDijkstra = finTiempoDijkstra - inicioTiempoDijkstra;

                Metricas metricasBfs = new Metricas(
                        bfs.getAsignaciones(),
                        bfs.getComparaciones(),
                        bfs.getLineasEjecutadas(),
                        tiempoBfs
                );

                Metricas metricasDijkstra = new Metricas(
                        dijkstra.getAsignaciones(),
                        dijkstra.getComparaciones(),
                        dijkstra.getLineasEjecutadas(),
                        tiempoDijkstra
                );

                System.out.println("-------------------- BFS --------------------");

                if (cantidadVertices == 10) {
                    System.out.println("Recorrido: " + Arrays.toString(bfs.getRecorrido()));
                }

                System.out.println("Asignaciones:          " + metricasBfs.getAsignaciones());
                System.out.println("Comparaciones:         " + metricasBfs.getComparaciones());
                System.out.println("Líneas ejecutadas:     " + metricasBfs.getLineasEjecutadas());
                System.out.println("Tiempo ejecución (ns): " + metricasBfs.getTiempoNanosegundos());

                System.out.println();
                System.out.println("----------------- DIJKSTRA ------------------");

                if (cantidadVertices == 10) {
                    System.out.println("Distancias: " + Arrays.toString(dijkstra.getDistancias()));
                }

                System.out.println("Asignaciones:          " + metricasDijkstra.getAsignaciones());
                System.out.println("Comparaciones:         " + metricasDijkstra.getComparaciones());
                System.out.println("Líneas ejecutadas:     " + metricasDijkstra.getLineasEjecutadas());
                System.out.println("Tiempo ejecución (ns): " + metricasDijkstra.getTiempoNanosegundos());
            }

            catch (OutOfMemoryError error) {
                System.out.println("-------------------- BFS --------------------");
                System.out.println("No se obtuvo respuesta.");

                System.out.println();
                System.out.println("----------------- DIJKSTRA ------------------");
                System.out.println("No se obtuvo respuesta.");
            }
        }
    }
}