package com.example.casopractico2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casopractico2.service.impl.*;
import com.example.casopractico2.model.*;

@RestController
public class ThreadMetricsController {

    private final ThreadMetricsService threadMetricsService;

    @Autowired
    public ThreadMetricsController(ThreadMetricsService threadMetricsService) {
        this.threadMetricsService = threadMetricsService;
    }

    @GetMapping("/api/thread-metrics")
    public List<ThreadMetrics> getThreadMetrics() {
        return threadMetricsService.getAllMetrics();
    }
}
