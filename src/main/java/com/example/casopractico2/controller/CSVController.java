package com.example.casopractico2.controller;

import com.example.casopractico2.model.BiologicalSample;
import com.example.casopractico2.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class CSVController {

    @Autowired
    private CSVService csvService;

    @GetMapping("/import-async")
    public CompletableFuture<List<BiologicalSample>> importDataAsync() {
        return csvService.importCSVAsync("src/main/resources/biological_data.csv");
    }
}
