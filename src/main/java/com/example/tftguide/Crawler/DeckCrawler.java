package com.example.tftguide.Crawler;

import com.example.tftguide.Proxy.ProxyUtil;
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
    private final static String DECK_URL = "https://lolchess.gg/meta";

    private final static String DECK_BOX = ".guide-meta__deck-box";

    public void crawlDeckList() {

        try {
            String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(DECK_URL);
            Document document = Jsoup.parse(html, "https://lolchess.gg");
            Elements elements = document.select(DECK_BOX);

            for (Element e1 : elements
            ) {
                String deckName = e1.select(".name").text();
                System.out.println(deckName);

                Elements traitElements = e1.select(".tft-hexagon--24");
                for (Element traitElement : traitElements
                ) {
                    String traitPic = String.valueOf(traitElement.select("img").attr("src"));
                    String traitName = String.valueOf(traitElement.select("img").attr("alt"));
                    System.out.println(traitPic);
                    System.out.println(traitName);

                }
                Elements heroesElements = e1.select(".tft-champion-box");
                for (Element heroElement : heroesElements
                ) {
                    String heroPic = String.valueOf(heroElement.select("img").attr("src"));
                    String heroName = String.valueOf(heroElement.select("img").attr("alt"));
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
                }
                String cost = e1.select(".d-block").text();
                String costImage = e1.select(".cost img").attr("src");
                System.out.println(cost);
                System.out.println(costImage);
                //guide-meta__deck__column name mr-3

                //Required Basic Items
                Elements basicItemElements = e1.select(".mb-1");
                for (Element basicItemElement : basicItemElements
                ) {
                    String itemPic = String.valueOf(basicItemElement.select("img").attr("src"));
                    String itemName = String.valueOf(basicItemElement.select("img").attr("alt"));
                    System.out.println(itemPic);
                    System.out.println(itemName);
                }

                Elements costElements = e1.select(".guide-meta__champion-costs");
                for (Element costElement : costElements
                ) {
                    String costPic = String.valueOf(costElement.select("img").attr("src"));
                    String costName = String.valueOf(costElement.select("img").attr("alt"));
                    System.out.println(costPic);
                    System.out.println(costName);
                    String costCount = costElement.select(".guide-meta__champion-costs__content").text();
                    System.out.println(costCount);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
