package com.example.tftguide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class RunnerBeaber {

    @Autowired
    TFTMain tftMain;

    @Scheduled(fixedRate = 2140000000)
    public void runit() throws InterruptedException, ExecutionException {
        tftMain.run();
    }

}
