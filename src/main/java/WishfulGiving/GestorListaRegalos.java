package WishfulGiving;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorListaRegalos {
    private final HashMap<String, List<ListaRegalos>> listasPorPropietario;

    public GestorListaRegalos() {
        this.listasPorPropietario = new HashMap<>();
    }

    public void agregarLista(String propietario, ListaRegalos lista) {
        listasPorPropietario.computeIfAbsent(propietario, k -> new ArrayList<>()).add(lista);
    }

    public List<ListaRegalos> obtenerListasPorPropietario(String propietario) {
        return listasPorPropietario.getOrDefault(propietario, new ArrayList<>());
    }

    public static GestorListaRegalos cargarListasDeTexto(String filePath) {
        GestorListaRegalos gestor = new GestorListaRegalos();

        try (BufferedReader reader = new BufferedReader(new FileReader(
                GestorListaRegalos.class.getClassLoader().getResource(filePath).getFile()))) {
            String propietario = null;
            ListaRegalos listaActual = null;

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] partes = line.split(";");

                if (partes.length == 1) {
                    propietario = partes[0];
                } else if (partes.length == 2) {
                    listaActual = new ListaRegalos(partes[0], Float.parseFloat(partes[1]), new ArrayList<>());
                    if (propietario != null) {
                        gestor.agregarLista(propietario, listaActual);
                    }
                } else if (partes.length == 3 && listaActual != null) {
                    String titulo = partes[0];
                    int prioridad = Integer.parseInt(partes[1]);
                    double precio = Double.parseDouble(partes[2]);

                    Regalo regalo = new Regalo(titulo, "Descripción no proporcionada", precio, prioridad);
                    listaActual.getRegalos().add(regalo);
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Error al leer el archivo de texto: " + filePath + " - " + e.getMessage(), e);
        }

        return gestor;
    }
}
