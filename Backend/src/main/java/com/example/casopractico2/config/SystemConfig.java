package com.example.casopractico2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

@Configuration
@Async  // Habilitamos el uso de hilos en la app
public class SystemConfig implements AsyncConfigurer {

    // Definimos un logger para la clase.
    private static final Logger logger = Logger.getLogger(SystemConfig.class.getName());

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        int corePoolSize = Runtime.getRuntime().availableProcessors();  //Definimos el número de hilos disponibles a usar.
        int maxPoolSize = corePoolSize * 2; //Multiplicamos el pool para tener un máximo de hilos.
        long keepAlive = 60;    //Tiempo que los hilos pueden quedar en espera.

        // Mostramos un mensaje mediante un log para saber que se ha inicializado el pool de hilos.
        logger.info("Inicializando el pool de hilos con " + corePoolSize + " hilos y maxPoolSize: " + maxPoolSize);

        // Devolvemos un pool de hilos con el número de hilos disponibles.
        return (ThreadPoolExecutor) Executors.newFixedThreadPool(corePoolSize);
    }

}
