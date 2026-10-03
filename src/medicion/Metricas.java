package medicion;

/**
 * Start date: 25/09/2026
 * Last modification date: 02/10/2026
 *
 * Stores the metrics obtained after executing an algorithm.
 *
 * This class is part of the measurement infrastructure and not of the
 * analyzed algorithms. Therefore, creating a Metricas object is not
 * included in the algorithm counters or in its execution time.
 */
public class Metricas {

    private final long asignaciones;
    private final long comparaciones;
    private final long lineasEjecutadas;
    private final long tiempoNanosegundos;

    /**
     * Creates the set of metrics for one execution.
     *
     * @param asignaciones number of assignments
     * @param comparaciones number of comparisons
     * @param lineasEjecutadas number of executed lines
     * @param tiempoNanosegundos execution time in nanoseconds
     */
    public Metricas(
            long asignaciones,
            long comparaciones,
            long lineasEjecutadas,
            long tiempoNanosegundos
    ) {

        // Store the assignment measurement produced by the algorithm.
        this.asignaciones = asignaciones;

        // Store the comparison measurement produced by the algorithm.
        this.comparaciones = comparaciones;

        // Store the executed-line measurement produced by the algorithm.
        this.lineasEjecutadas = lineasEjecutadas;

        // Store the measured wall-clock execution time.
        this.tiempoNanosegundos = tiempoNanosegundos;
    }

    /**
     * Returns the number of assignments recorded during the execution.
     *
     * @return number of assignments
     */
    public long getAsignaciones() {

        // Return the stored assignment measurement.
        return asignaciones;
    }

    /**
     * Returns the number of comparisons recorded during the execution.
     *
     * @return number of comparisons
     */
    public long getComparaciones() {

        // Return the stored comparison measurement.
        return comparaciones;
    }

    /**
     * Returns the number of executed lines recorded during the execution.
     *
     * @return number of executed lines
     */
    public long getLineasEjecutadas() {

        // Return the stored executed-line measurement.
        return lineasEjecutadas;
    }

    /**
     * Returns the execution time recorded in nanoseconds.
     *
     * @return execution time in nanoseconds
     */
    public long getTiempoNanosegundos() {

        // Return the stored execution-time measurement.
        return tiempoNanosegundos;
    }
}