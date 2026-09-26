package grafo;

/**
 * Fecha de inicio: 25/09/2026
 * Fecha de última modificación: 25/09/2026
 *
 * Representa un grafo completo, ponderado y no dirigido mediante una
 * matriz de adyacencia. La clase almacena la cantidad de vértices y
 * los pesos de las aristas del grafo.
 *
 * Esta clase es utilizada por los algoritmos BFS, DFS, Dijkstra y
 * Bellman-Ford como representación común de los datos de entrada.
 */
public class Grafo {

    private final int cantidadVertices;
    private final int[][] matrizAdyacencia;

    /**
     * Crea un grafo con la cantidad de vértices indicada e inicializa
     * su matriz de adyacencia.
     *
     * @param cantidadVertices cantidad de vértices que tendrá el grafo
     */
    public Grafo(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;

        // Se crea la matriz que almacenará los pesos entre los vértices.
        this.matrizAdyacencia = new int[cantidadVertices][cantidadVertices];
    }

    /**
     * Obtiene la cantidad de vértices del grafo.
     *
     * @return cantidad de vértices del grafo
     */
    public int getCantidadVertices() {
        return cantidadVertices;
    }

    /**
     * Obtiene la matriz de adyacencia utilizada para representar el grafo.
     *
     * @return matriz de adyacencia con los pesos de las aristas
     */
    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    /**
     * Establece una arista entre dos vértices y asigna su peso.
     * Debido a que el grafo es no dirigido, el mismo peso se almacena
     * en ambas direcciones de la matriz.
     *
     * @param origen vértice de origen
     * @param destino vértice de destino
     * @param peso peso de la arista
     */
    void establecerArista(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
        matrizAdyacencia[destino][origen] = peso;
    }
}