package com.example.casopractico2.concurrency;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

@Component
public class ConcurrentDataProcessor {

    // Logger para imprimir mensajes
    private static final Logger logger = Logger.getLogger(ConcurrentDataProcessor.class.getName());

    // Pool de hilos para ForkJoin.
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    // Procesa los datos utilizando ForkJoin . Utiliza un ForkJoinTask para dividir las tareas.
    public void processData(List<String> data) {
        ForkJoinTask task = new ForkJoinTask(data, 0, data.size());
        logger.info("Starting ForkJoin task with data size: " + data.size());
        forkJoinPool.invoke(task);
        logger.info("ForkJoin task completed");
    }
}
