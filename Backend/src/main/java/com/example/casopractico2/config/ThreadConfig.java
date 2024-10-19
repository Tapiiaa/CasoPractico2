package com.example.casopractico2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThreadConfig {

    @Bean(name = "customExecutorService")
    @Primary

    public ExecutorService taskExecutor() {
        return Executors.newFixedThreadPool(8);  // Pool de hilos fijo
    }

    // Definir un bean de tipo int para inyectar en DataSynchronizationManager
    @Bean
    public int threadCount() {
        return 8;  // Número de hilos que quieres usar para sincronización
    }
}
