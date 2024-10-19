package com.example.casopractico2.concurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

@Component
public class DataStreamManager {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Autowired
    private ConcurrentDataProcessor concurrentDataProcessor;

    // Logger para imprimir mensajes
    private static final Logger logger = Logger.getLogger(DataStreamManager.class.getName());

    // Iniciamos la gestión de los flujos de datos utilizando un ScheduledExecutorService para ejecutar la tarea cada 10 segundos.
    public void startDataStream() {
        logger.info("Starting data stream...");
        scheduler.scheduleAtFixedRate(() -> {
            try {
                List<String> incomingData = fetchDataFromSource();
                CompletableFuture.runAsync(() -> {
                    logger.info("Thread " + Thread.currentThread().getName() + " está procesando el flujo de datos.");
                    concurrentDataProcessor.processData(incomingData);
                }, executorService).join();
                logger.info("Data stream processing completed");
            } catch (Exception e) {
                logger.severe("Error al procesar datos: " + e.getMessage());
            }
        }, 0, 10, TimeUnit.SECONDS);  // Ejecuta la tarea cada 10 segundos
    }

    // Detenemos la gestión de los flujos de datos.
    public void stopDataStream() {
        logger.info("Stopping data stream...");
        scheduler.shutdown();
        executorService.shutdown();
    }

    private List<String> fetchDataFromSource() {
        // Simulación de datos entrantes
        return List.of("Muestra1", "Muestra2", "Muestra3");
    }
}
