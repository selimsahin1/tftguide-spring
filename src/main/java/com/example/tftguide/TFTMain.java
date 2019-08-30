package com.example.tftguide;

import com.example.tftguide.Crawler.HeroCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@EnableScheduling
public class TFTMain {

    @Autowired
    HeroCrawler heroCrawler;

    public void run() throws InterruptedException, ExecutionException {
        heroCrawler.crawlHeroList();
    }

}
