package com.example.casopractico2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Vamos a poner que 5 sea el mín. de hilos
        executor.setMaxPoolSize(10); // Máx. de hilos
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("BiologicalDataThread-");
        executor.initialize();
        return executor;
    }
}
