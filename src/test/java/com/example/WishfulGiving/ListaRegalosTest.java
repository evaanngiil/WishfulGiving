package com.example.WishfulGiving;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ListaRegalosTest {
    
    @Test
    void testObtenerRegalosDentroDelPresupuesto() {
        var listas = JsonLoader.cargarListasDeRegalos("data/test_regalos.json");
        ListaRegalos listaJuan = listas.get(0);

        List<Regalo> regalosSeleccionados = listaJuan.obtenerRegalosDentroPresupuesto();
        assertEquals(3, listaJuan.totalRegalos());
        assertEquals(2, regalosSeleccionados.size());
        assertEquals("Enter de peluche", regalosSeleccionados.get(0).getTitulo());
        assertEquals("Monopoly 64 peones", regalosSeleccionados.get(1).getTitulo());
    }
    
    @Test
    void testCalcularPresupuestoRestante() {
        var listas = ListaRegalos.cargarListasDeRegalos("data/test_regalos.json");
        
        ListaRegalos listaAna = listas.get(1);

        double presupuestoRestante = listaAna.calcularPresupuestoRestante();
        assertEquals(10.0, presupuestoRestante);
    }
    
    
    @Test
    void testExcepcionesConstructor() {
        assertThrows(IllegalArgumentException.class, 
                () -> new ListaRegalos("", -50.0f, null));
    }

    @Test
    void testEliminarRegalo() {
        List<ListaRegalos> listas = ListaRegalos.cargarListasDeRegalos("data/test_regalos.json");
        ListaRegalos listaJuan = listas.get(0);

        boolean eliminado = listaJuan.eliminarRegalo("Monopoly 64 peones");
        assertTrue(eliminado);
        assertEquals(2, listaJuan.totalRegalos());
    }
    
}
