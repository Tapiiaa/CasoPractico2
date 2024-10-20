package com.example.casopractico2.controller;

import com.example.casopractico2.model.BiologicalAttributes;
import com.example.casopractico2.service.impl.BiologicalDataProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiologicalDataController {
    private final BiologicalDataProcessor biologicalDataProcessor;  
    public BiologicalDataController(BiologicalDataProcessor biologicalDataProcessor) {
        this.biologicalDataProcessor = biologicalDataProcessor;
    }

    @GetMapping("/api/biological-data")
    public List<BiologicalAttributes> getBiologicalData(){
        return biologicalDataProcessor.getProcessedData();
    }

    @PostMapping("/api/biological-data")
    public String processBiologicalData(@RequestBody BiologicalAttributes biologicalAttributes){
        biologicalDataProcessor.processBiologicalAtributtes(biologicalAttributes);
        return "Datos biológicos procesados correctamente";
    }

}
