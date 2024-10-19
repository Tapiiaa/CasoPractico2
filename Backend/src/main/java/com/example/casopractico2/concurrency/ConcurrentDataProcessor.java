package com.example.casopractico2.concurrency;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@Component
public class ConcurrentDataProcessor {

    // Pool de hilos para ForkJoin.
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    // Procesa los datos utilizando ForkJoin . Utiliza un ForkJoinTask para dividir las tareas.
    public void processData(List<String> data) {
        ForkJoinTask task = new ForkJoinTask(data, 0, data.size());
        forkJoinPool.invoke(task);
    }
}
