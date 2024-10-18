package com.example.casopractico2.controller;

import com.example.casopractico2.service.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSVController {

    private final DataProcessingService dataProcessingService;

    public CSVController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    @GetMapping("/process-biological-data")
    public String processBiologicalData(@RequestParam String filePath) {
        dataProcessingService.processBiologicalDataWithSemaphore(filePath);
        return "Data processing started for file: " + filePath;
    }
}
