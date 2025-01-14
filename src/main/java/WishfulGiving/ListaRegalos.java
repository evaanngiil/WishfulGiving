package WishfulGiving;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ListaRegalos {
    private String destinatario;
    private float presupuesto;
    private List<Regalo> regalos;
    
    public ListaRegalos() {}
    
    @JsonCreator
    public ListaRegalos(
            @JsonProperty("destinatario") String destinatario,
            @JsonProperty("presupuesto") float presupuesto,
            @JsonProperty("regalos") List<Regalo> regalos) {
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
     * Elimina un regalo de la lista de regalos
     * @param titulo El título del regalo que se desea eliminar.
     * @return true si eliminó el regalo, falso si no se encontró.
     */
    public boolean eliminarRegalo (String titulo){
        return regalos.removeIf(regalo -> regalo.getTitulo().equalsIgnoreCase(titulo));
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
     * Devuelve el total de regalos en la lista.
     * @return Cantidad de regalos en la lista.
     */
    public int totalRegalos(){
        return regalos.size();
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
}

