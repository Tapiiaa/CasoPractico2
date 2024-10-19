package com.example.casopractico2.concurrency;

import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class ForkJoinTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100;  // Umbral para dividir las tareas
    private final List<String> data;
    private final int start;
    private final int end;

    // Logger para imprimir mensajes
    private static final Logger logger = Logger.getLogger(ForkJoinTask.class.getName());

    public ForkJoinTask(List<String> data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    // Tarea que utiliza ForkJoin para dividir y conquistar.
    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            return processDirectly();
        } else {
            int mid = (start + end) / 2;
            ForkJoinTask leftTask = new ForkJoinTask(data, start, mid);
            ForkJoinTask rightTask = new ForkJoinTask(data, mid, end);
            logger.info("Forking tasks: Left(" + start + "-" + mid + "), Right(" + mid + "-" + end + ")");
            invokeAll(leftTask, rightTask);
            return leftTask.join() + rightTask.join();
        }
    }

   // Procesa los datos directamente si la tarea no es divisible.
    private Integer processDirectly() {
        for (int i = start; i < end; i++) {
            logger.info("Procesando directamente: " + data.get(i));
        }
        return end - start;
    }
}
