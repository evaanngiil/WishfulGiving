package com.example.WishfulGiving;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class JsonLoader {

    public static List<ListaRegalos> cargarListasDeRegalos(String rutaArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = JsonLoader.class.getClassLoader().getResourceAsStream(rutaArchivo)) {
            if (inputStream == null) {
                throw new RuntimeException("Archivo no encontrado: " + rutaArchivo);
            }
            return List.of(mapper.readValue(inputStream, ListaRegalos[].class));
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo JSON: " + e.getMessage(), e);
        }
    }
}
