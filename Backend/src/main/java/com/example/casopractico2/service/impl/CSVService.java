package com.example.casopractico2.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

@Service
public class CSVService {

    // Logger para imprimir mensajes
    private static final Logger logger = Logger.getLogger(CSVService.class.getName());

    @Async("taskExecutor")
    public CompletableFuture<List<String[]>> importCSVAsync(String filePath) {
        List<String[]> samples = new ArrayList<>();
        String line;

        logger.info("Thread started: " + Thread.currentThread().getName());

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Saltar la cabecera si existe
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                samples.add(values);  // Agregar la fila leída a la lista de muestras

                // Log para ver el progreso del hilo
                logger.info("Processed Sample ID: " + values[0] + " on Thread: " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            logger.severe("Error al procesar el archivo CSV: " + e.getMessage());
        }

        logger.info("Thread finished: " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(samples);
    }
}
