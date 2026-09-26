package grafo;

import java.util.Random;

/**
 * Fecha de inicio: 25/09/2026
 * Fecha de última modificación: 25/09/2026
 *
 * Genera los grafos utilizados como datos de entrada para los algoritmos
 * BFS, DFS, Dijkstra y Bellman-Ford.
 *
 * Para un tamaño de 10 vértices utiliza pesos fijos definidos en el código.
 * Para los demás tamaños genera automáticamente pesos pseudoaleatorios
 * entre 5 y 55. Los grafos generados son completos, ponderados y no dirigidos.
 */
public class GeneradorGrafo {

    private static final int pesoMinimo = 5;
    private static final int pesoMaximo = 55;
    private static final long semilla = 3002L;

    /**
     * Genera un grafo completo con la cantidad de vértices indicada.
     * Para 10 vértices utiliza pesos fijos; para los demás tamaños
     * utiliza pesos pseudoaleatorios.
     *
     * @param cantidadVertices cantidad de vértices del grafo
     * @return grafo completo generado
     */
    public Grafo generarGrafo(int cantidadVertices) {
        if (cantidadVertices == 10) {
            return generarGrafoFijo();
        }

        return generarGrafoAleatorio(cantidadVertices);
    }

    /**
     * Genera el grafo fijo de 10 vértices requerido para el tamaño
     * más pequeño de las pruebas.
     *
     * @return grafo completo de 10 vértices con pesos fijos
     */
    private Grafo generarGrafoFijo() {
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

        Grafo grafo = new Grafo(10);

        // Solo se recorre la mitad superior porque establecerArista
        // almacena automáticamente el peso en ambas direcciones.
        for (int origen = 0; origen < 10; origen++) {
            for (int destino = origen + 1; destino < 10; destino++) {
                grafo.establecerArista(
                        origen,
                        destino,
                        pesosFijos[origen][destino]
                );
            }
        }

        return grafo;
    }

    /**
     * Genera un grafo completo cuyos pesos se encuentran entre
     * 5 y 55 inclusive.
     *
     * Se utiliza una semilla fija para obtener los mismos datos de
     * entrada al repetir una prueba.
     *
     * @param cantidadVertices cantidad de vértices del grafo
     * @return grafo completo con pesos pseudoaleatorios
     */
    private Grafo generarGrafoAleatorio(int cantidadVertices) {
        Grafo grafo = new Grafo(cantidadVertices);
        Random random = new Random(semilla);

        // Se genera una sola vez cada arista del grafo no dirigido.
        for (int origen = 0; origen < cantidadVertices; origen++) {
            for (int destino = origen + 1;
                 destino < cantidadVertices;
                 destino++) {

                int peso = random.nextInt(
                        pesoMaximo - pesoMinimo + 1
                ) + pesoMinimo;

                grafo.establecerArista(origen, destino, peso);
            }
        }

        return grafo;
    }
}