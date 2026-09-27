package algoritmos;

/**
 * Fecha de inicio: 26/09/2026
 * Última modificación: 26/09/2026
 *
 * Implementa el algoritmo Breadth-First Search (BFS) de forma iterativa
 * sobre una matriz de adyacencia.
 *
 * La cola utilizada por BFS se implementa mediante un arreglo y dos
 * índices para que todas las operaciones realizadas por el algoritmo
 * sean explícitas y puedan medirse según la metodología del curso.
 *
 * Se registran asignaciones, comparaciones y líneas ejecutadas.
 */
public class BFS {

    private long asignaciones;
    private long comparaciones;
    private long lineasEjecutadas;

    private int[] recorrido;

    /**
     * Ejecuta BFS desde un vértice de origen.
     *
     * @param matrizAdyacencia matriz que representa el grafo.
     * @param origen índice del vértice desde el cual inicia el recorrido.
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

        boolean[] visitados = new boolean[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        int[] cola = new int[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        recorrido = new int[cantidadVertices];
        asignaciones++;
        lineasEjecutadas++;

        int frente = 0;
        asignaciones++;
        lineasEjecutadas++;

        int fin = 0;
        asignaciones++;
        lineasEjecutadas++;

        int indiceRecorrido = 0;
        asignaciones++;
        lineasEjecutadas++;

        visitados[origen] = true;
        asignaciones++;
        lineasEjecutadas++;

        cola[fin] = origen;
        asignaciones++;
        lineasEjecutadas++;

        fin++;
        asignaciones++;
        lineasEjecutadas++;

        while (frente < fin) {

            // Evaluación verdadera de la condición del ciclo.
            comparaciones++;
            lineasEjecutadas++;

            int actual = cola[frente];
            asignaciones++;
            lineasEjecutadas++;

            frente++;
            asignaciones++;
            lineasEjecutadas++;

            recorrido[indiceRecorrido] = actual;
            asignaciones++;
            lineasEjecutadas++;

            indiceRecorrido++;
            asignaciones++;
            lineasEjecutadas++;

            int vecino = 0;
            asignaciones++;
            lineasEjecutadas++;

            while (vecino < cantidadVertices) {

                // Evaluación verdadera del ciclo de vecinos.
                comparaciones++;
                lineasEjecutadas++;

                // Determina si existe una arista.
                comparaciones++;
                lineasEjecutadas++;

                if (matrizAdyacencia[actual][vecino] != 0) {

                    // Determina si el vértice todavía no ha sido visitado.
                    comparaciones++;
                    lineasEjecutadas++;

                    if (!visitados[vecino]) {

                        visitados[vecino] = true;
                        asignaciones++;
                        lineasEjecutadas++;

                        cola[fin] = vecino;
                        asignaciones++;
                        lineasEjecutadas++;

                        fin++;
                        asignaciones++;
                        lineasEjecutadas++;
                    }
                }

                vecino++;
                asignaciones++;
                lineasEjecutadas++;
            }

            // Evaluación falsa final del ciclo de vecinos.
            comparaciones++;
            lineasEjecutadas++;
        }

        // Evaluación falsa final del ciclo principal.
        comparaciones++;
        lineasEjecutadas++;
    }

    /**
     * Obtiene el recorrido generado por la última ejecución de BFS.
     *
     * @return arreglo con los vértices en orden de recorrido.
     */
    public int[] getRecorrido() {
        return recorrido;
    }

    /**
     * Obtiene la cantidad de asignaciones realizadas por BFS.
     *
     * @return cantidad de asignaciones.
     */
    public long getAsignaciones() {
        return asignaciones;
    }

    /**
     * Obtiene la cantidad de comparaciones realizadas por BFS.
     *
     * @return cantidad de comparaciones.
     */
    public long getComparaciones() {
        return comparaciones;
    }

    /**
     * Obtiene la cantidad de líneas ejecutadas por BFS.
     *
     * @return cantidad de líneas ejecutadas.
     */
    public long getLineasEjecutadas() {
        return lineasEjecutadas;
    }
}