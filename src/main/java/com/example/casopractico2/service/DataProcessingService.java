package com.example.casopractico2.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;

@Service
public class DataProcessingService {

    private final ExecutorService executorService;
    private final Semaphore semaphore = new Semaphore(3);  // Limitar a 3 hilos simultáneamente
    private final int totalTasks = 10;  // Número total de tareas

    public DataProcessingService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void processBiologicalDataWithSemaphore() {
        CountDownLatch latch = new CountDownLatch(totalTasks);  // Sincronización con CountDownLatch
        long startTime = System.currentTimeMillis();  // Tiempo inicial para todo el procesamiento

        for (int i = 0; i < totalTasks; i++) {
            int taskId = i;
            executorService.submit(() -> {
                long taskStartTime = System.currentTimeMillis();  // Tiempo inicial para cada tarea
                try {
                    semaphore.acquire();  // Solicita permiso para acceder
                    System.out.println("Processing task " + taskId + " on thread " + Thread.currentThread().getName());
                    processData();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();  // Libera el permiso al finalizar
                    long taskEndTime = System.currentTimeMillis();  // Tiempo final para cada tarea
                    System.out.println("Task " + taskId + " completed in " + (taskEndTime - taskStartTime) + " ms.");
                    latch.countDown();  // Marca la tarea como completada
                }
            });
        }

        try {
            latch.await();  // Esperar a que todas las tareas se completen
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();  // Tiempo final para todo el procesamiento
        long totalTime = endTime - startTime;
        double tasksPerSecond = (double) totalTasks / (totalTime / 1000.0);

        System.out.println("All tasks completed in " + totalTime + " ms.");
        System.out.println("Processing rate: " + tasksPerSecond + " tasks per second.");
    }

    private void processData() {
        try {
            Thread.sleep(1000);  // Simula procesamiento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
