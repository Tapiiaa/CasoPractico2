package com.example.casopractico2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThreadConfig {

    @Bean(name = "customExecutorService")  // Cambiamos el nombre para evitar conflicto
    public ExecutorService taskExecutor() {
        return Executors.newFixedThreadPool(5);  // Pool de hilos fijo
    }
}
