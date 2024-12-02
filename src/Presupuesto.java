public class Presupuesto {
    private final double presupuestoTotal; 
    private double presupuestoRestante; 

    public Presupuesto(double presupuestoTotal) {
        if (presupuestoTotal < 0) {
            throw new IllegalArgumentException("El presupuesto debe ser un valor positivo.");
        }
        this.presupuestoTotal = presupuestoTotal;
        this.presupuestoRestante = presupuestoTotal;
    }

}
