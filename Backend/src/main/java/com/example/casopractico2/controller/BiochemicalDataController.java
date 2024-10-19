package com.example.casopractico2.controller;

import com.example.casopractico2.model.BiochemicalAttributes;
import com.example.casopractico2.service.impl.BiochemicalDataProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiochemicalDataController {
    private final BiochemicalDataProcessor biochemicalDataProcessor;

    public BiochemicalDataController(BiochemicalDataProcessor biochemicalDataProcessor) {
        this.biochemicalDataProcessor = biochemicalDataProcessor;
    }

    @GetMapping("/api/biochemical-data")
    public List<BiochemicalAttributes> getBiochemicalData(){
        return biochemicalDataProcessor.getProcessedData();
    }

    @PostMapping("api/biochemical-data")
    public String processBiochemicalData(@RequestBody BiochemicalAttributes biochemicalAttributes){
        biochemicalDataProcessor.processBiochemicalAtributtes(biochemicalAttributes);
        return "Datos bioquímicos procesados correctamente";
    }
}
