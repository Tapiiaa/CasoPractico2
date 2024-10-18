package com.example.casopractico2.service;

import com.example.casopractico2.model.BiologicalSample;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CSVService {

    @Async("taskExecutor")
    public CompletableFuture<List<BiologicalSample>> importCSVAsync(String filePath) {
        List<BiologicalSample> samples = new ArrayList<>();
        String line;

        System.out.println("Thread started: " + Thread.currentThread().getName());

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Saltar la cabecera si existe
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Crear un nuevo objeto de muestra biológica
                BiologicalSample sample = new BiologicalSample();
                sample.setSampleId(Integer.parseInt(values[0]));
                sample.setSpecies(values[1]);
                sample.setWeight(Double.parseDouble(values[2]));
                sample.setHeight(Double.parseDouble(values[3]));
                sample.setAge(Integer.parseInt(values[4]));
                sample.setGender(values[5]);
                sample.setLocation(values[6]);

                samples.add(sample);

                // Log para ver el progreso del hilo
                System.out.println("Processed Sample ID: " + sample.getSampleId() + " on Thread: " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thread finished: " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(samples);
    }
}
