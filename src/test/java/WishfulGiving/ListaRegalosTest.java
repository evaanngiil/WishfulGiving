package WishfulGiving;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ListaRegalosTest {
    
    private static final int REGALOS_DENTRO_PRESUPUESTO = 2;
    private static final List<Regalo> REGALOS_ESPERADOS = List.of(
            new Regalo("Enter de peluche", "Un enter de peluche enorme para desahogarme cuando me estreso haciendo código", 20.0, 5),
            new Regalo("Monopoly 64 peones", "Monopoly con destacados de oro y plata y con hasta 64 peones", 70.0, 4)
    );

    private static final List<Regalo> REGALOS_COSTO_MINIMO_ESPERADOS = List.of(
            new Regalo("Enter de peluche", "Un enter de peluche enorme para desahogarme cuando me estreso haciendo código", 20.0, 5),
            new Regalo("Regalo económico", "Un regalo pequeño y económico", 10.0, 1)
    );

    private static final double COSTO_TOTAL_ESPERADO = 40.0;
    private static final String TEST_DATA_PATH = "data/test_regalos.txt";

   @Test
    void minimizarCosto() {
        List<ListaRegalos> listas = ListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);
        ListaRegalos lista = listas.get(0);

        List<Regalo> regalosSeleccionados = lista.obtenerRegalosPorCostoMinimo();

        assertTrue(regalosSeleccionados.stream()
                .mapToDouble(Regalo::getPrecio)
                .sum() <= lista.getPresupuesto(), "Se excede el presupuesto");
        assertEquals(COSTO_TOTAL_ESPERADO, regalosSeleccionados.stream()
                .mapToDouble(Regalo::getPrecio)
                .sum(), "El costo total no es correcto");
    }


    @Test
    void maximizarSatisfaccion() {
        List<ListaRegalos> listas = ListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);
        ListaRegalos lista = listas.get(0);

        List<Regalo> regalosSeleccionados = lista.obtenerRegalosDentroPresupuesto();

        assertTrue(regalosSeleccionados.stream()
                .mapToDouble(Regalo::getPrecio)
                .sum() <= lista.getPresupuesto(), "Se excede el presupuesto");
        assertEquals(9, regalosSeleccionados.stream()
                .mapToInt(Regalo::getPrioridad)
                .sum(), "La prioridad total no es correcta");
    }
    
    @Test
    void calcularPresupuestoRestante() {
        List<ListaRegalos> listas = ListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);
        ListaRegalos listaAna = listas.get(1);

        double presupuestoRestante = listaAna.calcularPresupuestoRestante();
        assertEquals(10.0, presupuestoRestante,
                "El presupuesto restante calculado no es el esperado.");
    }

    @Test
    void compararSatisfaccionYCosto() {
        List<ListaRegalos> listas = ListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);
        ListaRegalos lista = listas.get(0);

        List<Regalo> regalosMaxSatisfaccion = lista.obtenerRegalosDentroPresupuesto();
        List<Regalo> regalosCostoMinimo = lista.obtenerRegalosPorCostoMinimo();

        int prioridadMax = regalosMaxSatisfaccion.stream().mapToInt(Regalo::getPrioridad).sum();
        int prioridadMin = regalosCostoMinimo.stream().mapToInt(Regalo::getPrioridad).sum();

        double costoMax = regalosMaxSatisfaccion.stream().mapToDouble(Regalo::getPrecio).sum();
        double costoMin = regalosCostoMinimo.stream().mapToDouble(Regalo::getPrecio).sum();

        assertTrue(prioridadMax > prioridadMin, "La maximización de satisfacción no es mayor");
        assertTrue(costoMin < costoMax, "La minimización de costo no es menor");
    }

}
