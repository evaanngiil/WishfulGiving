package WishfulGiving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ListaRegalos {
    private String destinatario;
    private float presupuesto;
    private List<Regalo> regalos;
    
    public ListaRegalos() {}
    
    public ListaRegalos(
            String destinatario,
            float presupuesto,
            List<Regalo> regalos) {
        if (destinatario == null || destinatario.isEmpty()) {
            throw new IllegalArgumentException("El nombre del destinatario no puede estar vacío.");
        }
        if (presupuesto <= 0) {
            throw new IllegalArgumentException("El presupuesto debe ser mayor que cero.");
        }
        this.destinatario = destinatario;
        this.presupuesto = presupuesto;
        this.regalos = regalos != null ? new ArrayList<>(regalos) : new ArrayList<>();
    }
    
    public float getPresupuesto() {
        return presupuesto;
    }

    public List<Regalo> getRegalos() {
        return regalos;
    }

    /**
     * Obtiene la lista de regalos que maximiza la satisfacción dentro del presupuesto disponible.
     * @return Lista de regalos seleccionados para maximizar la satisfacción.
     */
    public List<Regalo> obtenerRegalosDentroPresupuesto() {
        int numRegalos = regalos.size();
        int capacidadPresupuesto = (int) presupuesto;

        int [][] matrizDinamica = new int [numRegalos + 1][capacidadPresupuesto + 1];
        
        for (int i = 1; i<= numRegalos; i++) {
            Regalo regalo = regalos.get(i-1);
            int precioRegalo = (int) regalo.getPrecio();
            int prioridadRegalo = regalo.getPrioridad();

            for (int j = 0; j <= capacidadPresupuesto; j++) {
                if (precioRegalo <= j) {
                    matrizDinamica[i][j] = Math.max(matrizDinamica[i-1][j], matrizDinamica[i-1][j-precioRegalo] + prioridadRegalo);
                } else {
                    matrizDinamica[i][j] = matrizDinamica[i-1][j];
                }
            }
        }

        List<Regalo> regalosSeleccionados = new ArrayList<>();
        int presupuestoRestante = capacidadPresupuesto;

        for (int i = numRegalos; i > 0 && presupuestoRestante > 0; i--) {
            if (matrizDinamica[i][presupuestoRestante] != matrizDinamica[i-1][presupuestoRestante]) {
                Regalo regalo = regalos.get(i-1);
                regalosSeleccionados.add(regalo);
                presupuestoRestante -= regalo.getPrecio();
            }
        }

        return regalosSeleccionados;
    }
    
    /**
     * Calcula el presupuesto restante después de considerar los regalos dentro del presupuesto.
     * @return Presupuesto restante.
     */
    public double calcularPresupuestoRestante() {
        double totalGastado = 0;
        for (Regalo regalo : obtenerRegalosDentroPresupuesto()) {
            totalGastado += regalo.getPrecio();
        }
        return presupuesto - totalGastado;
    }

    public static List<ListaRegalos> cargarListasDeTexto(String filePath) {
        List<ListaRegalos> listas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(
                ListaRegalos.class.getClassLoader().getResource(filePath).getFile()))) {
            String line;
            ListaRegalos listaActual = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.split(";").length == 2) {
                    String[] partesLista = line.split(";");
                    listaActual = new ListaRegalos(partesLista[0], Float.parseFloat(partesLista[1]), new ArrayList<>());
                    listas.add(listaActual);
                } else if (listaActual != null) {
                    String[] partesRegalo = line.split(";");
                    String titulo = partesRegalo[0];
                    int prioridad = Integer.parseInt(partesRegalo[1]);
                    double precio = Double.parseDouble(partesRegalo[2]);

                    Regalo regalo = new Regalo(titulo, "Descripción no proporcionada", precio, prioridad);
                    listaActual.regalos.add(regalo);
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Error al leer el archivo de texto: " + filePath + " - " + e.getMessage(), e);
        }

        return listas;
}

/**
     * Obtiene la lista de regalos basándose en el costo mínimo sin optimización de satisfacción.
     * @return Lista de regalos seleccionados por costo mínimo.
     */
    public List<Regalo> obtenerRegalosPorCostoMinimo() {
        List<Regalo> regalosOrdenados = new ArrayList<>(regalos);
        regalosOrdenados.sort(Comparator.comparingDouble(Regalo::getPrecio));

        List<Regalo> regalosSeleccionados = new ArrayList<>();
        double presupuestoRestante = presupuesto;

        for (Regalo regalo : regalosOrdenados) {
            if (regalo.getPrecio() <= presupuestoRestante) {
                regalosSeleccionados.add(regalo);
                presupuestoRestante -= regalo.getPrecio();
            }
        }

        return regalosSeleccionados;
    }


}
