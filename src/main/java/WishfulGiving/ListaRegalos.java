package WishfulGiving;

import java.util.ArrayList;
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
    
    /**
     * Obtiene la lista de regalos que maximiza la satisfacción dentro del presupuesto disponible.
     * @return Lista de regalos seleccionados para maximizar la satisfacción.
     */
    public List<Regalo> obtenerRegalosDentroPresupuesto() {
        int n = regalos.size();
        int capacidad = (int) presupuesto;

        int [][] dp = new int [n + 1][capacidad + 1];
        
        for (int i = 1; i<= n; i++) {
            Regalo regalo = regalos.get(i-1);
            int peso = (int) regalo.getPrecio();
            int valor = regalo.getPrioridad();

            for (int j = 0; j <= capacidad; j++) {
                if (peso <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-peso] + valor);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        List<Regalo> regalosSeleccionados = new ArrayList<>();
        int w = capacidad;

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i-1][w]) {
                Regalo regalo = regalos.get(i-1);
                regalosSeleccionados.add(regalo);
                w -= regalo.getPrecio();
            }
        }

        return regalosSeleccionados;
    }
    
    /**
     * Calcula el presupuesto restante después de considerar los regalos dentro del presupuesto.
     * @return Presupuesto restante.
     */
    public double calcularPresupuestoRestante() {
        double totalGastado = obtenerRegalosDentroPresupuesto()
                .stream()
                .mapToDouble(Regalo::getPrecio)
                .sum();
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

            // Ignorar líneas vacías o comentarios
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }

            // Procesar nueva lista de regalos
            if (line.split(";").length == 2) {
                String[] partesLista = line.split(";");
                listaActual = new ListaRegalos(partesLista[0], Float.parseFloat(partesLista[1]), new ArrayList<>());
                listas.add(listaActual);
            } else if (listaActual != null) {
                // Procesar regalo
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

    public String getDestinatario() {
        return destinatario;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public List<Regalo> getRegalos() {
        return regalos;
    }
}
