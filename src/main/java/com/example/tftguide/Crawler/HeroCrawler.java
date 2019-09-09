package com.example.tftguide.Crawler;

import com.example.tftguide.Model.Hero;
import com.example.tftguide.Model.HeroBaseStats;
import com.example.tftguide.Model.HeroRecomendedItems;
import com.example.tftguide.Model.HeroStats;
import com.example.tftguide.Proxy.ProxyUtil;
import com.example.tftguide.Repository.HeroBaseStatsRepository;
import com.example.tftguide.Repository.HeroRecomendedItemsRepository;
import com.example.tftguide.Repository.HeroRepository;
import com.example.tftguide.Repository.HeroStatsReporsitory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class HeroCrawler {

    private final static String HEROS_URL = "https://lolchess.gg/champions/aurelionsol";
    private final static String HERO_SELECTOR = ".guide-champion-list__content a";
    private final static String HERO_HEADER = ".guide-champion-detail";

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    HeroStatsReporsitory heroStatsReporsitory;

    @Autowired
    HeroBaseStatsRepository heroBaseStatsRepository;

    @Autowired
    HeroRecomendedItemsRepository heroRecomendedItemsRepository;

    Logger logger = LoggerFactory.getLogger(HeroCrawler.class);

    public void crawlHeroList() {

        try {
            String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(HEROS_URL);
            Document document = Jsoup.parse(html, "https://lolchess.gg");
            Elements elements = document.select(HERO_SELECTOR);

            for (Element e1 : elements) {

                Hero hero = new Hero();

                String heroURL = e1.select("a").get(0).absUrl("href");
                String heroName = e1.select(".guide-champion-list__item__name").get(0).text();
                hero.setName(heroName);
                String imgSrc = String.valueOf(e1.select("img").attr("src"));
                hero.setImage(imgSrc);
                html = new ProxyUtil().getHtmlPageFromUrlViaProxy(heroURL);
                document = Jsoup.parse(html, "https://lolchess.gg");
                Elements heroElements = document.select(HERO_HEADER);
                for (Element heroElement : heroElements) {
                    String heroHeader = heroElement.select(".guide-champion-detail__header__background").attr("style");
                    hero.setBackgroundPic(heroHeader);
                    System.out.println(heroHeader);
                    Elements statsElements = document.select(".guide-champion-detail__stats__row");
                    for (Element statsElement : statsElements) {
                        HeroStats heroStats = new HeroStats();
                        heroStats.setHeroName(heroName);
                        String statName = statsElement.select(".guide-champion-detail__stats__name").text();
                        heroStats.setStatName(statName);
                        String statValue = statsElement.select(".guide-champion-detail__stats__value").text();
                        heroStats.setStatValue(statValue);
                        System.out.println(statName);
                        System.out.println(statValue);
                        heroStatsReporsitory.save(heroStats);
                    }
                    Elements baseStatElements = document.select(".guide-champion-detail__base-stat");
                    for (Element baseStatElement : baseStatElements) {
                        HeroBaseStats heroBaseStats = new HeroBaseStats();
                        String baseStatName = baseStatElement.select(".guide-champion-detail__base-stat__name").text();
                        heroBaseStats.setHeroName(heroName);
                        heroBaseStats.setBaseStatName(baseStatName);
                        String baseStatValue = baseStatElement.select(".guide-champion-detail__base-stat__value").text();
                        if (baseStatValue.isEmpty()) {
                            baseStatValue = String.valueOf(baseStatElement.select("img").attr("src"));
                        }
                        heroBaseStats.setBaseStatValue(baseStatValue);
                        System.out.println(baseStatName);
                        System.out.println(baseStatValue);
                        heroBaseStatsRepository.save(heroBaseStats);
                    }
                    Elements skillElements = document.select(".guide-champion-detail__skill");
                    for (Element skillElement : skillElements) {
                        String skillImage = String.valueOf(skillElement.select("img").attr("src"));
                        hero.setSkillImage(skillImage);
                        String skillName = String.valueOf(skillElement.select("img").attr("alt"));
                        hero.setSkillName(skillName);
                        Elements manaElements = skillElements.select(".text-gray");
                        String str = null;
                        for (Element manaElement : manaElements) {
                            String mana = String.valueOf(manaElement.select("span").text());
                            str = String.join(",", mana);
                            System.out.println(mana);
                        }
                        System.out.println(str);
                        String skillInfo = skillElement.select(".d-block").text();
                        hero.setSkillInfo(skillInfo);
                        System.out.println(skillInfo);
                        String str2 = null;
                        Elements damageElements = skillElements.select(".guide-champion-detail__skill__stats");
                        for (Element damageElement : damageElements) {
                            String damage = String.valueOf(damageElement.select("span").text());
                            str2 = String.join(",", damage);
                        }
                        hero.setDamageValue(str2);
                        System.out.println(str2);
                        System.out.println(manaElements);
                        System.out.println(skillImage);
                        System.out.println(skillName);

                    }
                    Elements itemsElements = document.select(".guide-champion-detail__recommend-items__content");
                    Elements itemElements = itemsElements.select(".d-inline-block");
                    for (Element itemElement : itemElements) {
                        HeroRecomendedItems heroRecomendedItems = new HeroRecomendedItems();
                        String itemName = itemElement.select("img").attr("alt");
                        heroRecomendedItems.setHeroName(heroName);
                        heroRecomendedItems.setItemName(itemName);
                        String itemPic = itemElement.select("img").attr("src");
                        heroRecomendedItems.setItemPic(itemPic);
                        System.out.println(itemPic);
                        System.out.println(itemName);
                        heroRecomendedItemsRepository.save(heroRecomendedItems);
                    }
                    System.out.println(itemElements);


                }
                heroRepository.save(hero);
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
