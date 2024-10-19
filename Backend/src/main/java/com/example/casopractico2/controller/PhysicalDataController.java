package com.example.casopractico2.controller;

import com.example.casopractico2.model.PhysicalAttributes;
import com.example.casopractico2.service.impl.PhysicalDataProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhysicalDataController {
    private final PhysicalDataProcessor physicalDataProcessor;

    public PhysicalDataController(PhysicalDataProcessor physicalDataProcessor) {
        this.physicalDataProcessor = physicalDataProcessor;
    }

    @GetMapping("/api/physical-data")
    public List<PhysicalAttributes> getPhysicalData(){
        return physicalDataProcessor.getProcessedData();
    }

    @PostMapping("/api/physical-data")
    public String processPhysicalData(@RequestBody PhysicalAttributes physicalAttributes){
        physicalDataProcessor.processPhysicalAtributtes(physicalAttributes);
        return "Datos físicos procesados correctamente";
    }
}
