package com.example.casopractico2.concurrency;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class DataSynchronizationManager {

    private final CountDownLatch latch;

    public DataSynchronizationManager(int threadCount) {
        this.latch = new CountDownLatch(threadCount);
    }

    public void threadCompleted() {
        latch.countDown();  // Reduce el contador del latch
    }

    public void awaitCompletion() {
        try {
            latch.await();  // Espera a que todos los hilos terminen
            System.out.println("Todos los hilos han completado sus tareas.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
