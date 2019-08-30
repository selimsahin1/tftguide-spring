package com.example.tftguide.Crawler;

import com.example.tftguide.Proxy.ProxyUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeroCrawler {

    private final static String HEROS_URL = "https://lolchess.gg/champions/aurelionsol";
    private final static String HERO_SELECTOR = ".guide-champion-list__content a";
    private final static String HERO_HEADER = ".guide-champion-detail";

    Logger logger = LoggerFactory.getLogger(HeroCrawler.class);

    @Autowired
    public void crawlHeroList() {

        try {
            String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(HEROS_URL);
            Document document = Jsoup.parse(html, "https://lolchess.gg");
            Elements elements = document.select(HERO_SELECTOR);

            for (Element e1 : elements) {
                String heroURL = e1.select("a").get(0).absUrl("href");
                String heroName = e1.select(".guide-champion-list__item__name").get(0).text();
                String imgSrc = String.valueOf(e1.select("img").attr("src"));
                html = new ProxyUtil().getHtmlPageFromUrlViaProxy(heroURL);
                document = Jsoup.parse(html, "https://lolchess.gg");
                Elements heroElements = document.select(HERO_HEADER);
                for (Element heroElement : heroElements) {
                    String heroHeader = heroElement.select(".guide-champion-detail__header__background").attr("style");
                    System.out.println(heroHeader);
                    Elements statsElements = document.select(".guide-champion-detail__stats__row");
                    for (Element statsElement : statsElements) {
                        String statName = statsElement.select(".guide-champion-detail__stats__name").text();
                        String statValue = statsElement.select(".guide-champion-detail__stats__value").text();
                        System.out.println(statName);
                        System.out.println(statValue);
                    }

                }
                System.out.println(heroURL);
                System.out.println(heroName);
                System.out.println(imgSrc);
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
