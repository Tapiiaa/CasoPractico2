package com.example.casopractico2.service.interfaces;

import java.util.List;

public interface DataStream<T>{
    void startStream();
    boolean processDataBatch(List<T> dataBatch);
    void stopStream();
}
