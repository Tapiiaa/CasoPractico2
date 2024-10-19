package com.example.casopractico2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.casopractico2.service.impl.DataProcessingService;

@RestController
public class CSVController {

    private final DataProcessingService dataProcessingService;

    public CSVController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    @GetMapping("/process-biological-data")
    public String processData(@RequestParam String filePath) {
        dataProcessingService.processDataWithSemaphore(filePath);
        return "Data processing started for file: " + filePath;
    }
}





