package com.example.WishfulGiving;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ListaRegalosTest {
    
    private static final int TOTAL_REGALOS_ESPERADOS = 3;
    private static final int REGALOS_DENTRO_PRESUPUESTO = 2;
    private static final String TEST_JSON_PATH = "data/test_regalos.json";
    
    @Test
    void testTotalRegalos() {
        var listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos listaJuan = listas.get(0);

        assertEquals(TOTAL_REGALOS_ESPERADOS, listaJuan.totalRegalos(),
                "El total de regalos no coincide con el esperado.");
    }

    @Test
    void testRegalosDentroDelPresupuesto() {
        var listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos listaJuan = listas.get(0);

        List<Regalo> regalosSeleccionados = listaJuan.obtenerRegalosDentroPresupuesto();
        assertEquals(REGALOS_DENTRO_PRESUPUESTO, regalosSeleccionados.size(),
                "El número de regalos dentro del presupuesto no coincide con el esperado.");
    }
    
    @Test
    void testCalcularPresupuestoRestante() {
        var listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        
        ListaRegalos listaAna = listas.get(1);

        double presupuestoRestante = listaAna.calcularPresupuestoRestante();
        assertEquals(10.0, presupuestoRestante,
                "El presupuesto restante calculado no es el esperado.");
    }
    
    @Test
    void testCalcularPresupuestoRestanteSinRegalos() {
        ListaRegalos lista = new ListaRegalos("Carlos", 50.0f, null);

        double presupuestoRestante = lista.calcularPresupuestoRestante();
        
        assertEquals(50.0, presupuestoRestante, "El presupuesto restante no coincide con el presupuesto total.");
    }

    @Test
    void testEliminarRegaloExistente() {
        List<ListaRegalos> listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos listaJuan = listas.get(0);

        boolean eliminado = listaJuan.eliminarRegalo("Monopoly 64 peones");
        assertTrue(eliminado,
                "No se ha eliminado el regalo como se esperaba");
    }
    
    @Test
    void testEliminarRegaloInexistente() {
        List<ListaRegalos> listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos lista = listas.get(0);
        
        boolean eliminado = lista.eliminarRegalo("Regalo Inexistente");
        
        assertFalse(eliminado, "Se devolvió true al intentar eliminar un regalo inexistente.");
    }
    
    @Test
    void testAgregarRegalo() {
        List<ListaRegalos> listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos lista = listas.get(0);
        var nuevoRegalo = new Regalo("Iphone muy viejo", "Quiero el Iphone más viejo y a la vez resistente que exista para ponerlo a prueba"
                , 15.0, 3);

        lista.agregarRegalo(nuevoRegalo);
        
        assertEquals(4, lista.totalRegalos(), "El total de regalos no es el esperado después de agregar un regalo.");
    }

    @Test
    void testAgregarRegaloNuloLanzaExcepcion() {
        List<ListaRegalos> listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos lista = listas.get(0);

        assertThrows(IllegalArgumentException.class, 
            () -> lista.agregarRegalo(null), 
            "No se lanzó una excepción al intentar agregar un regalo nulo.");
    }
    
}
