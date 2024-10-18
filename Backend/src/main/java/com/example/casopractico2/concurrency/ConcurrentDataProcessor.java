package com.example.casopractico2.concurrency;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@Component
public class ConcurrentDataProcessor {

    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    // Procesa los datos utilizando ForkJoin.
    public void processData(List<String> data) {
        ForkJoinTask task = new ForkJoinTask(data, 0, data.size());
        forkJoinPool.invoke(task);
    }

    private static class ForkJoinTask extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 2;  // Umbral para dividir las tareas
        private final List<String> data;
        private final int start;
        private final int end;

        ForkJoinTask(List<String> data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= THRESHOLD) {
                return processDirectly();
            } else {
                int mid = (start + end) / 2;
                ForkJoinTask leftTask = new ForkJoinTask(data, start, mid);
                ForkJoinTask rightTask = new ForkJoinTask(data, mid, end);
                invokeAll(leftTask, rightTask);
                return leftTask.join() + rightTask.join();
            }
        }


        private Integer processDirectly() {
            for (int i = start; i < end; i++) {
                System.out.println("Procesando: " + data.get(i));
            }
            return end - start;
        }
    }
}
