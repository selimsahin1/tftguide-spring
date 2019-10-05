package com.example.tftguide.Crawler;

import com.example.tftguide.Model.*;
import com.example.tftguide.Proxy.ProxyUtil;
import com.example.tftguide.Repository.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class DeckCrawler {

    @Autowired
    DeckRepository deckRepository;
    @Autowired
    DeckHeroesRepository deckHeroesRepository;
    @Autowired
    DeckSynergiesRepository deckSynergiesRepository;
    @Autowired
    DeckBasicItemRepository deckBasicItemRepository;
    @Autowired
    DeckCostRepository deckCostRepository;

    private final static String DECK_URL = "https://lolchess.gg/meta";

    private final static String DECK_BOX = ".guide-meta__deck-box";

    public void crawlDeckList() {

        try {
            String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(DECK_URL);
            Document document = Jsoup.parse(html, "https://lolchess.gg");
            Elements elements = document.select(DECK_BOX);

            for (Element e1 : elements
            ) {
                Deck deck = new Deck();
                String deckName = e1.select(".name").text();
                deck.setName(deckName);
                System.out.println(deckName);

                Elements traitElements = e1.select(".tft-hexagon--24");
                for (Element traitElement : traitElements
                ) {
                    DeckSynergies deckSynergies = new DeckSynergies();
                    String traitPic = String.valueOf(traitElement.select("img").attr("src"));
                    deckSynergies.setSynergyIcon(traitPic);
                    String traitName = String.valueOf(traitElement.select("img").attr("alt"));
                    deckSynergies.setDeckSynergy(traitName);
                    deckSynergies.setDeckName(deckName);
                    System.out.println(traitPic);
                    System.out.println(traitName);
                    deckSynergiesRepository.save(deckSynergies);

                }
                Elements heroesElements = e1.select(".tft-champion-box");
                for (Element heroElement : heroesElements
                ) {
                    DeckHeroes deckHeroes = new DeckHeroes();
                    String heroPic = String.valueOf(heroElement.select("img").attr("src"));
                    deckHeroes.setHeroIcon(heroPic);
                    String heroName = String.valueOf(heroElement.select("img").attr("alt"));
                    deckHeroes.setHeroName(heroName);
                    deckHeroes.setDeckName(deckName);
                    System.out.println(heroPic);
                    System.out.println(heroName);
                    Elements itemsDivElements = heroElement.select(".tft-items");
                    Elements itemsElements = itemsDivElements.select("img");
                    for (Element itemElement : itemsElements
                    ) {
                        String itemPic = String.valueOf(itemElement.select("img").attr("src"));
                        String itemName = String.valueOf(itemElement.select("img").attr("alt"));
                        System.out.println(itemName);
                        System.out.println(itemPic);
                    }
                    deckHeroesRepository.save(deckHeroes);
                }
                String cost = e1.select(".d-block").text();
                String costImage = e1.select(".cost img").attr("src");
                deck.setCostIcon(costImage);
                deck.setTotalCost(cost);
                System.out.println(cost);
                System.out.println(costImage);
                //guide-meta__deck__column name mr-3

                //Required Basic Items
                Elements basicItemElements = e1.select(".mb-1");
                for (Element basicItemElement : basicItemElements
                ) {
                    DeckBasicItems deckBasicItems = new DeckBasicItems();
                    String itemPic = String.valueOf(basicItemElement.select("img").attr("src"));
                    deckBasicItems.setBasicItemIcon(itemPic);
                    String itemName = String.valueOf(basicItemElement.select("img").attr("alt"));
                    deckBasicItems.setDeckName(deckName);
                    deckBasicItems.setBasicItemName(itemName);
                    System.out.println(itemPic);
                    System.out.println(itemName);
                    deckBasicItemRepository.save(deckBasicItems);
                }

                Elements costElements = e1.select(".guide-meta__champion-costs");
                for (Element costElement : costElements
                ) {
                    DeckCost deckCost = new DeckCost();
                    String costPic = String.valueOf(costElement.select("img").attr("src"));
                    deckCost.setCostIcon(costPic);
                    String costName = String.valueOf(costElement.select("img").attr("alt"));
                    deckCost.setCostName(costName);
                    System.out.println(costPic);
                    System.out.println(costName);
                    String costCount = costElement.select(".guide-meta__champion-costs__content").text();
                    deckCost.setCostCount(costCount);
                    deckCostRepository.save(deckCost);
                    System.out.println(costCount);
                }
                deckRepository.save(deck);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
