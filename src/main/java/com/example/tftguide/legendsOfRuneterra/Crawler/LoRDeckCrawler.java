package com.example.tftguide.legendsOfRuneterra.Crawler;

import com.example.tftguide.Proxy.ProxyUtil;
import com.example.tftguide.legendsOfRuneterra.Model.Deck;
import com.example.tftguide.legendsOfRuneterra.Repository.LoRDeckRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoRDeckCrawler {

    @Autowired
    LoRDeckRepository loRDeckRepository;

    private static final String DECKS_URL = "https://rankedboost.com/legends-of-runeterra/deck-builds/";

    private static final String DECK_BOX = ".wpb_wrapper";

    public void getAllDecks() {
        try {
            String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(DECKS_URL);
            Document document = Jsoup.parse(html, "https://rankedboost.com");
            Elements elements = document.select(DECK_BOX);
            elements.remove(0);
            for (Element e1 : elements
            ) {
                Deck deck = new Deck();
                String deckName = e1.select(".deck-name-title").text();
                if (!deckName.isEmpty()) {
                    deck.setDeckName(deckName);
                    String deckDesc = e1.select(".semi-subtitle").text();
                    deck.setDeckDesc(deckDesc);
                    Elements championsElements = e1.select(".li-deck-build-datz:nth-child(1)");
                    for (Element e2 : championsElements
                    ) {
                        String championIcon = e2.select("img").attr("src");
                        deck.setChampionIcon(championIcon);
                        String championPiece = e2.select("span").text();
                        deck.setChampionPiece(championPiece);
                    }

                    Elements unitsElements = e1.select(".li-deck-build-datz:nth-child(2)");
                    for (Element e2 : unitsElements
                    ) {
                        String unitsIcon = e2.select("img").attr("src");
                        deck.setUnitsIcon(unitsIcon);
                        String unitsPiece = e2.select("span").text();
                        deck.setUnitsPiece(unitsPiece);
                    }
                    Elements spellsElements = e1.select(".li-deck-build-datz:nth-child(3)");
                    for (Element e2 : spellsElements
                    ) {
                        String spellsIcon = e2.select("img").attr("src");
                        deck.setSpellsIcon(spellsIcon);
                        String spellsPiece = e2.select("span").text();
                        deck.setSpellsPiece(spellsPiece);
                    }
                    Elements deckShardCostElements = e1.select(".li-deck-build-datz:nth-child(4)");
                    for (Element e2 : deckShardCostElements
                    ) {
                        String deckShardCostIcon = e2.select("img").attr("src");
                        deck.setDeckShardCostIcon(deckShardCostIcon);
                        String deckShardCostPiece = e2.select("span").text();
                        deck.setDeckShardCostPiece(deckShardCostPiece);
                    }

                    String region1Icon = e1.select(".li-deck-build-datz:nth-child(5) .p-icon-lor:nth-child(1)").attr("src");
                    deck.setRegion1Icon(region1Icon);
                    String region1Name = e1.select(".li-deck-build-datz:nth-child(5) .p-icon-lor:nth-child(1)").attr("title");
                    deck.setRegion1Name(region1Name);
                    String region2Icon = e1.select(".p-icon-lor+ .p-icon-lor").attr("src");
                    deck.setRegion2Icon(region2Icon);
                    String region2Name = e1.select(".p-icon-lor+ .p-icon-lor").attr("title");
                    deck.setRegion2Name(region2Name);

                loRDeckRepository.save(deck);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
