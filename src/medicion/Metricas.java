package medicion;

/**
 * Fecha de inicio: 25/09/2026
 * Última modificación: 26/09/2026
 *
 * Almacena las métricas obtenidas después de ejecutar un algoritmo.
 *
 * Esta clase forma parte de la infraestructura de medición y no de los
 * algoritmos analizados. Por tanto, la creación de un objeto Metricas
 * no se incluye dentro de los contadores del algoritmo ni dentro de su
 * tiempo de ejecución.
 */
public class Metricas {

    private final long asignaciones;
    private final long comparaciones;
    private final long lineasEjecutadas;
    private final long tiempoNanosegundos;

    /**
     * Construye el conjunto de métricas de una ejecución.
     *
     * @param asignaciones cantidad de asignaciones.
     * @param comparaciones cantidad de comparaciones.
     * @param lineasEjecutadas cantidad de líneas ejecutadas.
     * @param tiempoNanosegundos tiempo de ejecución en nanosegundos.
     */
    public Metricas(
            long asignaciones,
            long comparaciones,
            long lineasEjecutadas,
            long tiempoNanosegundos
    ) {
        this.asignaciones = asignaciones;
        this.comparaciones = comparaciones;
        this.lineasEjecutadas = lineasEjecutadas;
        this.tiempoNanosegundos = tiempoNanosegundos;
    }

    public long getAsignaciones() {
        return asignaciones;
    }

    public long getComparaciones() {
        return comparaciones;
    }

    public long getLineasEjecutadas() {
        return lineasEjecutadas;
    }

    public long getTiempoNanosegundos() {
        return tiempoNanosegundos;
    }
}