package com.example.casopractico2.service.impl;

import com.example.casopractico2.model.BiologicalSample;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

@Service
public class DataProcessingService {

    private final ExecutorService executorService;
    private final Semaphore semaphore = new Semaphore(3);  // Limitar a 3 hilos simultáneamente
    private final CSVService csvService;  // Servicio para leer el CSV

    public DataProcessingService(ExecutorService executorService, CSVService csvService) {
        this.executorService = executorService;
        this.csvService = csvService;
    }

    public void processBiologicalDataWithSemaphore(String filePath) {
        // Leer los datos del CSV
        List<BiologicalSample> samples = csvService.importCSVAsync(filePath).join();  // Esperamos que termine la tarea asíncrona

        for (BiologicalSample sample : samples) {
            executorService.submit(() -> {
                long startTime = System.currentTimeMillis();  // Tiempo inicial
                try {
                    semaphore.acquire();  // Solicita permiso para acceder
                    System.out.println("Processing Sample ID " + sample.getSampleId() + " on thread " + Thread.currentThread().getName());
                    processSample(sample);  // Procesar la muestra
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();  // Libera el permiso al finalizar
                    long endTime = System.currentTimeMillis();  // Tiempo final
                    System.out.println("Sample " + sample.getSampleId() + " completed in " + (endTime - startTime) + " ms.");
                }
            });
        }
    }

    private void processSample(BiologicalSample sample) {
        // Aquí podrías realizar el procesamiento real de la muestra, por ejemplo, análisis de datos
        System.out.println("Processing biological sample: " + sample.toString());
        try {
            Thread.sleep(1000);  // Simula tiempo de procesamiento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
