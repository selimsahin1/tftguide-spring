package com.example.tftguide;

import com.example.tftguide.Crawler.DeckCrawler;
import com.example.tftguide.Crawler.HeroCrawler;
import com.example.tftguide.Crawler.SynergiesCrawler;
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

    @Scheduled(fixedRate = 2140000000)
    public void runit() throws InterruptedException, ExecutionException {
         heroCrawler.crawlHeroList();
        //deckCrawler.crawlDeckList();
        //synergiesCrawler.crawlSynergiesList();
    }

}
