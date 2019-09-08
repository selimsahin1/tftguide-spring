package com.example.tftguide.Crawler;

import com.example.tftguide.Proxy.ProxyUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SynergiesCrawler {

    private final static String SYNERGIES_URL = "https://lolchess.gg/synergies";

    private final static String SYMERGIES_DIV = ".row-normal .col-lg-6";

    public void crawlSynergiesList() {

        try {
            String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(SYNERGIES_URL);
            Document document = Jsoup.parse(html, "https://lolchess.gg");
            Elements elements = document.select(SYMERGIES_DIV);

            for (Element e1 : elements
            ) {
                String synergyName = e1.select(".d-inline-block.align-middle span").text();
                String synergyIcon = e1.select(".d-inline-block.align-middle img").attr("src");

                Elements heroesBlockElements = e1.select(".guide-synergy__champions");
                Elements heroesElements = heroesBlockElements.get(0).select(".guide-synergy__champions .d-inline-block");

                for (Element heroesElement : heroesElements
                ) {
                    String heroName = heroesElement.select(".name").text();
                    String heroPic = heroesElement.select("img").attr("src");
                    System.out.println(heroName);
                }

                String description = e1.select(".guide-synergy__description").text();

                Elements statsElements = e1.select(".guide-synergy__stats .d-inline-block");
                for (Element statsElement : statsElements
                ) {
                    String statElement = statsElement.select(".d-inline-block").text();
                    System.out.println(statElement);
                }

                System.out.println(description);

                System.out.println(heroesElements);

                System.out.println(synergyName);
                System.out.println(synergyIcon);
                System.out.println("-----------------------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
