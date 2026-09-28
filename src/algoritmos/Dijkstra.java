package algoritmos;

/**
 * Fecha de inicio: 28/09/2026
 * Última modificación: 28/09/2026
 *
 * Implementa el algoritmo de Dijkstra sobre una matriz de adyacencia.
 *
 * El algoritmo calcula la distancia mínima desde un vértice de origen
 * hacia todos los demás vértices del grafo. La selección del vértice
 * no visitado con menor distancia se realiza mediante búsqueda lineal.
 *
 * Se registran asignaciones, comparaciones y líneas ejecutadas.
 */
public class Dijkstra {

    private long asignaciones;
    private long comparaciones;
    private long lineasEjecutadas;

    private int[] distancias;

    /**
     * Ejecuta el algoritmo de Dijkstra desde un vértice de origen.
     *
     * @param matrizAdyacencia matriz ponderada que representa el grafo.
     * @param origen índice del vértice desde el cual inicia el algoritmo.
     */
    public void ejecutar(int[][] matrizAdyacencia, int origen) {

        // Reinicio de instrumentos de medición.
        asignaciones = 0;
        comparaciones = 0;
        lineasEjecutadas = 0;

        // Paso de los dos parámetros por valor.
        asignaciones += 2;

        // Ejecución de la cabecera del método.
        lineasEjecutadas++;

        int cantidadVertices = matrizAdyacencia.length;
        asignaciones++;
        lineasEjecutadas++;

        distancias = new int[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        boolean[] visitados = new boolean[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        int infinito = Integer.MAX_VALUE;
        asignaciones++;
        lineasEjecutadas++;

        // Inicializa todas las distancias con un valor equivalente a infinito.
        int vertice = 0;
        asignaciones++;
        lineasEjecutadas++;

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

        comparaciones++;
        lineasEjecutadas++;

        distancias[origen] = 0;
        asignaciones++;
        lineasEjecutadas++;

        int iteracion = 0;
        asignaciones++;
        lineasEjecutadas++;

        /*
         * En cada iteración se selecciona el vértice no visitado
         * con la menor distancia tentativa y posteriormente
         * se actualizan las distancias de sus vecinos.
         */
        while (iteracion < cantidadVertices) {
            comparaciones++;
            lineasEjecutadas++;

            int actual = -1;
            asignaciones++;
            lineasEjecutadas++;

            int menorDistancia = infinito;
            asignaciones++;
            lineasEjecutadas++;

            int candidato = 0;
            asignaciones++;
            lineasEjecutadas++;

            /*
             * Busca linealmente el vértice no visitado
             * con menor distancia tentativa.
             */
            while (candidato < cantidadVertices) {
                comparaciones++;
                lineasEjecutadas++;

                comparaciones++;
                lineasEjecutadas++;

                if (!visitados[candidato]) {
                    comparaciones++;
                    lineasEjecutadas++;

                    if (distancias[candidato] < menorDistancia) {
                        menorDistancia = distancias[candidato];
                        asignaciones++;
                        lineasEjecutadas++;

                        actual = candidato;
                        asignaciones++;
                        lineasEjecutadas++;
                    }
                }

                candidato++;
                asignaciones++;
                lineasEjecutadas++;
            }

            comparaciones++;
            lineasEjecutadas++;

            visitados[actual] = true;
            asignaciones++;
            lineasEjecutadas++;

            int vecino = 0;
            asignaciones++;
            lineasEjecutadas++;

            /*
             * Recorre los posibles vecinos del vértice seleccionado
             * y realiza la relajación de las distancias.
             */
            while (vecino < cantidadVertices) {
                comparaciones++;
                lineasEjecutadas++;

                comparaciones++;
                lineasEjecutadas++;

                if (!visitados[vecino]) {
                    comparaciones++;
                    lineasEjecutadas++;

                    if (matrizAdyacencia[actual][vecino] != 0) {
                        comparaciones++;
                        lineasEjecutadas++;

                        if (distancias[actual] != infinito) {
                            int nuevaDistancia =
                                    distancias[actual]
                                            + matrizAdyacencia[actual][vecino];

                            asignaciones++;
                            lineasEjecutadas++;

                            comparaciones++;
                            lineasEjecutadas++;

                            if (nuevaDistancia < distancias[vecino]) {
                                distancias[vecino] = nuevaDistancia;
                                asignaciones++;
                                lineasEjecutadas++;
                            }
                        }
                    }
                }

                vecino++;
                asignaciones++;
                lineasEjecutadas++;
            }

            comparaciones++;
            lineasEjecutadas++;

            iteracion++;
            asignaciones++;
            lineasEjecutadas++;
        }

        comparaciones++;
        lineasEjecutadas++;
    }

    /**
     * Devuelve las distancias mínimas calculadas desde el vértice de origen.
     *
     * @return arreglo con las distancias mínimas.
     */
    public int[] getDistancias() {
        return distancias;
    }

    /**
     * Devuelve la cantidad de asignaciones realizadas.
     *
     * @return cantidad de asignaciones.
     */
    public long getAsignaciones() {
        return asignaciones;
    }

    /**
     * Devuelve la cantidad de comparaciones realizadas.
     *
     * @return cantidad de comparaciones.
     */
    public long getComparaciones() {
        return comparaciones;
    }

    /**
     * Devuelve la cantidad de líneas ejecutadas.
     *
     * @return cantidad de líneas ejecutadas.
     */
    public long getLineasEjecutadas() {
        return lineasEjecutadas;
    }
}