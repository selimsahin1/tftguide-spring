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
                    Elements baseStatElements = document.select(".guide-champion-detail__base-stat");
                    for (Element baseStatElement : baseStatElements) {
                        String baseStatName = baseStatElement.select(".guide-champion-detail__base-stat__name").text();
                        String baseStatValue = baseStatElement.select(".guide-champion-detail__base-stat__value").text();
                        if (baseStatValue.isEmpty()) {
                            baseStatValue = String.valueOf(baseStatElement.select("img").attr("src"));
                        }
                        System.out.println(baseStatName);
                        System.out.println(baseStatValue);
                    }
                    Elements skillElements = document.select(".guide-champion-detail__skill");
                    for (Element skillElement : skillElements) {
                        String skillImage = String.valueOf(skillElement.select("img").attr("src"));
                        String skillName = String.valueOf(skillElement.select("img").attr("alt"));
                        Elements manaElements = skillElements.select(".text-gray");
                        String str = null;
                        for (Element manaElement : manaElements) {
                            String mana = String.valueOf(manaElement.select("span").text());
                            str = String.join(",", mana);
                            System.out.println(mana);
                        }
                        System.out.println(str);
                        String skillInfo = skillElement.select(".d-block").text();
                        System.out.println(skillInfo);
                        String str2 = null;
                        Elements damageElements = skillElements.select(".guide-champion-detail__skill__stats");
                        for (Element damageElement : damageElements) {
                            String damage = String.valueOf(damageElement.select("span").text());
                            str2 = String.join(",", damage);
                        }
                        System.out.println(str2);
                        System.out.println(manaElements);
                        System.out.println(skillImage);
                        System.out.println(skillName);

                    }
                    Elements itemsElements = document.select(".guide-champion-detail__recommend-items__content");
                    Elements itemElements = itemsElements.select(".d-inline-block");
                    for (Element itemElement : itemElements) {
                        String itemName = itemElement.select("img").attr("alt");
                        String itemPic = itemElement.select("img").attr("src");
                        System.out.println(itemPic);
                        System.out.println(itemName);
                    }
                    System.out.println(itemElements);


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
