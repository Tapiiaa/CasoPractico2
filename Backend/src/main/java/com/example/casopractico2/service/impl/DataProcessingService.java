package com.example.casopractico2.service.impl;

import com.example.casopractico2.model.AllAttributes;
import com.example.casopractico2.model.BiologicalAttributes;
import com.example.casopractico2.model.PhysicalAttributes;
import com.example.casopractico2.model.BiochemicalAttributes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

@Service
public class DataProcessingService {

    private final ExecutorService executorService;
    private final Semaphore semaphore = new Semaphore(3);  // Limitar a 3 hilos simultáneamente
    private final CSVService csvService;  // Servicio para leer el CSV

    public DataProcessingService(ExecutorService executorService, CSVService csvService) {
        this.executorService = executorService;
        this.csvService = csvService;
    }

    public void processDataWithSemaphore(String filePath) {
        // Leer los datos del CSV
        List<String[]> samples = csvService.importCSVAsync(filePath).join();  // Obtener listas de arreglos de strings

        System.out.println("CSV loaded. Number of samples: " + samples.size());

        for (String[] csvRow : samples) {
            executorService.submit(() -> {
                long startTime = System.currentTimeMillis();  // Tiempo inicial
                try {
                    semaphore.acquire();  // Solicita permiso para acceder
                    String threadName = Thread.currentThread().getName();  // Obtener nombre del hilo actual
                    System.out.println("Processing Sample ID " + csvRow[0] + " on thread " + threadName);

                    // Procesar la fila del CSV y crear objetos de atributos
                    PhysicalAttributes physical = new PhysicalAttributes(Double.parseDouble(csvRow[2]), csvRow[3]);  // Altura y ubicación
                    BiologicalAttributes biological = new BiologicalAttributes(csvRow[1], csvRow[4], csvRow[5], csvRow[6]);  // Especie, tipo de hoja, color de flor, hábito de crecimiento
                    BiochemicalAttributes biochemical = new BiochemicalAttributes(csvRow[7], Integer.parseInt(csvRow[8]), csvRow[9]);  // Resistencia a la sequía, frecuencia de riego, zona climática ideal

                    // Crear un objeto AllAttributes
                    AllAttributes allData = new AllAttributes(physical, biological, biochemical);

                    // Imprimir todos los datos juntos
                    System.out.println("Thread " + threadName + " processed data: " + allData);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();  // Libera el permiso al finalizar
                    long endTime = System.currentTimeMillis();  // Tiempo final
                    System.out.println("Sample ID " + csvRow[0] + " completed by thread " + Thread.currentThread().getName() 
                        + " in " + (endTime - startTime) + " ms.");
                }
            });
        }
    }
}
