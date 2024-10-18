package com.example.casopractico2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

@Service
public class DataProcessingService {

    private final ExecutorService executorService;
    private final Semaphore semaphore = new Semaphore(3);  // Limitar a 3 hilos simultáneamente

    public DataProcessingService(@Qualifier("customExecutorService") ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void processBiologicalDataWithSemaphore() {
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executorService.submit(() -> {
                try {
                    semaphore.acquire();  // Solicita permiso para acceder
                    System.out.println("Processing task " + taskId + " on thread " + Thread.currentThread().getName());
                    processData();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();  // Libera el permiso al finalizar
                }
            });
        }
    }

    private void processData() {
        try {
            Thread.sleep(1000);  // Simula procesamiento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

