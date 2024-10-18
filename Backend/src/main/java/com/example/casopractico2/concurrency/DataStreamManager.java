package com.example.casopractico2.concurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;

@Component
public class DataStreamManager {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Autowired
    private ConcurrentDataProcessor concurrentDataProcessor;

    // Iniciamos la gestión de los flujos de datos utilizando un ScheduledExecutorService para ejecutar la tarea cada 10 segundos.
    public void startDataStream() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                List<String> incomingData = fetchDataFromSource();
                CompletableFuture.runAsync(() -> concurrentDataProcessor.processData(incomingData), executorService)
                        .join();  // Espera la finalización del procesamiento concurrente
            } catch (Exception e) {
                System.err.println("Error al procesar datos: " + e.getMessage());
            }
        }, 0, 10, TimeUnit.SECONDS);  // Ejecuta la tarea cada 10 segundos
    }

    // Detenemos la gestión de los flujos de datos.
    public void stopDataStream() {
        scheduler.shutdown();
        executorService.shutdown();
    }

    private List<String> fetchDataFromSource() {
        // Falta completar este metodo
        return List.of("Muestra1", "Muestra2", "Muestra3");
    }
}
