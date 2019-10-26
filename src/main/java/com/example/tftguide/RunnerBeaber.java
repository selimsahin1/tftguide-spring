package com.example.tftguide;

import com.example.tftguide.Crawler.DeckCrawler;
import com.example.tftguide.Crawler.HeroCrawler;
import com.example.tftguide.Crawler.ItemsCrawler;
import com.example.tftguide.Crawler.SynergiesCrawler;
import com.example.tftguide.Repository.SynergiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class RunnerBeaber {

    @Autowired
    HeroCrawler heroCrawler;

    @Autowired
    DeckCrawler deckCrawler;

    @Autowired
    SynergiesCrawler synergiesCrawler;

    @Autowired
    ItemsCrawler itemsCrawler;

    @Autowired
    SynergiesRepository synergiesRepository;

    @Autowired
    DatabaseTruncate databaseTruncate;

//    @Scheduled(fixedRate = 2140000000)
    @Scheduled(cron = "0 0 1 ? * *")
    public void runit() throws InterruptedException, ExecutionException {
        System.out.println("--------------------------DATABASE YENILENIYOR---------------------");
        databaseTruncate.truncator();
        heroCrawler.crawlHeroList();
        deckCrawler.crawlDeckList();
        synergiesCrawler.crawlSynergiesList();
        itemsCrawler.crawlItemsTR();
        System.out.println("--------------------------DATABASE YENILEME BITTI---------------------");
    }

}
