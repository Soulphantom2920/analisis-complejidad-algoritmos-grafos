package medicion;

/**
 * Fecha de inicio: 25/09/2026
 * Fecha de última modificación: 25/09/2026
 *
 * Almacena los resultados de la medición empírica obtenidos durante
 * la ejecución de un algoritmo.
 *
 * Esta clase conserva la cantidad de asignaciones, comparaciones,
 * líneas ejecutadas y el tiempo de ejecución medido en nanosegundos.
 */
public class Metricas {

    private final long asignaciones;
    private final long comparaciones;
    private final long lineasEjecutadas;
    private final long tiempoNanosegundos;

    /**
     * Crea un objeto con los resultados obtenidos durante la medición
     * de un algoritmo.
     *
     * @param asignaciones cantidad de asignaciones ejecutadas
     * @param comparaciones cantidad de comparaciones ejecutadas
     * @param lineasEjecutadas cantidad de líneas ejecutadas
     * @param tiempoNanosegundos tiempo de ejecución en nanosegundos
     */
    public Metricas(long asignaciones,
                    long comparaciones,
                    long lineasEjecutadas,
                    long tiempoNanosegundos) {

        this.asignaciones = asignaciones;
        this.comparaciones = comparaciones;
        this.lineasEjecutadas = lineasEjecutadas;
        this.tiempoNanosegundos = tiempoNanosegundos;
    }

    /**
     * Obtiene la cantidad de asignaciones ejecutadas.
     *
     * @return cantidad de asignaciones
     */
    public long getAsignaciones() {
        return asignaciones;
    }

    /**
     * Obtiene la cantidad de comparaciones ejecutadas.
     *
     * @return cantidad de comparaciones
     */
    public long getComparaciones() {
        return comparaciones;
    }

    /**
     * Obtiene la cantidad de líneas ejecutadas.
     *
     * @return cantidad de líneas ejecutadas
     */
    public long getLineasEjecutadas() {
        return lineasEjecutadas;
    }

    /**
     * Obtiene el tiempo de ejecución medido en nanosegundos.
     *
     * @return tiempo de ejecución en nanosegundos
     */
    public long getTiempoNanosegundos() {
        return tiempoNanosegundos;
    }
}