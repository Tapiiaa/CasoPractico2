package com.example.casopractico2.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.casopractico2.service.impl.DataProcessingService;

import java.io.File;
import java.io.IOException;

@RestController
public class CSVController {

    private final DataProcessingService dataProcessingService;

    public CSVController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    @GetMapping("/process-biological-data")
    public String processData(@RequestParam String filePath) {
        try {
            File csvFile = new ClassPathResource(filePath).getFile();  // Acceso al archivo en resources
            dataProcessingService.processDataWithSemaphore(csvFile.getPath());
            return "Data processing started for file: " + filePath;
        } catch (IOException e) {
            return "Error: Unable to find or access the file.";
        }
    }
}
