package com.example.casopractico2.controller;

import com.example.casopractico2.service.DataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSVController {

    private final DataProcessingService dataProcessingService;

    public CSVController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    // Este es el mapeo que debes verificar
    @GetMapping("/process-biological-data")
    public String processBiologicalData() {
        dataProcessingService.processBiologicalDataWithSemaphore();
        return "Data processing started";
    }
}
