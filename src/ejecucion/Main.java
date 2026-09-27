package ejecucion;

import algoritmos.BFS;
import grafo.GeneradorGrafo;
import grafo.Grafo;
import medicion.Metricas;

import java.util.Arrays;

/**
 * Fecha de inicio: 26/09/2026
 * Última modificación: 26/09/2026
 *
 * Punto de entrada del proyecto.
 * Genera automáticamente los grafos requeridos y ejecuta los algoritmos
 * sin solicitar datos al usuario.
 *
 * Actualmente ejecuta BFS sobre los tamaños definidos por el proyecto.
 */
public class Main {

    /**
     * Ejecuta automáticamente BFS sobre los tamaños establecidos.
     *
     * La generación del grafo y la impresión de resultados se realizan
     * fuera de la medición temporal del algoritmo.
     *
     * @param args argumentos de línea de comandos; no se utilizan.
     */
    public static void main(String[] args) {

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

        int origen = 0;

        GeneradorGrafo generadorGrafo = new GeneradorGrafo();

        boolean sinRespuesta = false;

        for (int cantidadVertices : tamanos) {

            System.out.println("----------------------------------------");
            System.out.println("BFS");
            System.out.println("Tamaño del grafo: " + cantidadVertices);

            if (sinRespuesta) {
                System.out.println("No se obtuvo respuesta.");
                continue;
            }

            try {
                Grafo grafo =
                        generadorGrafo.generarGrafo(cantidadVertices);

                int[][] matrizAdyacencia =
                        grafo.getMatrizAdyacencia();

                BFS bfs = new BFS();

                long inicioTiempo = System.nanoTime();

                bfs.ejecutar(matrizAdyacencia, origen);

                long finTiempo = System.nanoTime();

                long tiempoNanosegundos =
                        finTiempo - inicioTiempo;

                Metricas metricas = new Metricas(
                        bfs.getAsignaciones(),
                        bfs.getComparaciones(),
                        bfs.getLineasEjecutadas(),
                        tiempoNanosegundos
                );

                if (cantidadVertices == 10) {
                    System.out.println(
                            "Recorrido: "
                                    + Arrays.toString(bfs.getRecorrido())
                    );
                }

                System.out.println(
                        "Asignaciones: "
                                + metricas.getAsignaciones()
                );

                System.out.println(
                        "Comparaciones: "
                                + metricas.getComparaciones()
                );

                System.out.println(
                        "Líneas ejecutadas: "
                                + metricas.getLineasEjecutadas()
                );

                System.out.println(
                        "Tiempo de ejecución (ns): "
                                + metricas.getTiempoNanosegundos()
                );

            } catch (OutOfMemoryError error) {
                sinRespuesta = true;
                System.out.println("No se obtuvo respuesta.");
            }
        }
    }
}