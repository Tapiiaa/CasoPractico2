package com.example.casopractico2.model;

public class ThreadMetrics {
    private String threadName;
    private String state;
    private long processingTime;

    public ThreadMetrics(String threadName, String state, long processingTime) {
        this.threadName = threadName;
        this.state = state;
        this.processingTime = processingTime;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getState() {
        return state;
    }

    public long getProcessingTime() {
        return processingTime;
    }
}
