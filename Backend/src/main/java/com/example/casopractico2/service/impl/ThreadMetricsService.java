package com.example.casopractico2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.stereotype.Service;

import com.example.casopractico2.model.*;

@Service
public class ThreadMetricsService {

    private ThreadPoolExecutor executor;

    public ThreadMetricsService(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public List<ThreadMetrics> getAllMetrics() {
        List<ThreadMetrics> metrics = new ArrayList<>();
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().startsWith("pool")) { // Filtrar solo hilos del pool
                ThreadMetrics metric = new ThreadMetrics(
                    thread.getName(),
                    thread.getState().toString(),
                    // Puedes ajustar para obtener tiempos de procesamiento reales si los tienes
                    0L 
                );
                metrics.add(metric);
            }
        }
        return metrics;
    }
}



