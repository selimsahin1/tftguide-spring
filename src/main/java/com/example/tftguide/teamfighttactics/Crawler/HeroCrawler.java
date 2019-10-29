package com.example.tftguide.teamfighttactics.Crawler;

import com.example.tftguide.teamfighttactics.Model.Hero;
import com.example.tftguide.teamfighttactics.Model.HeroBaseStats;
import com.example.tftguide.teamfighttactics.Model.HeroRecomendedItems;
import com.example.tftguide.teamfighttactics.Model.HeroStats;
import com.example.tftguide.Proxy.ProxyUtil;
import com.example.tftguide.teamfighttactics.Repository.HeroBaseStatsRepository;
import com.example.tftguide.teamfighttactics.Repository.HeroRecomendedItemsRepository;
import com.example.tftguide.teamfighttactics.Repository.HeroRepository;
import com.example.tftguide.teamfighttactics.Repository.HeroStatsReporsitory;
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
                String img = "http:" + imgSrc;
                hero.setImage(img);
                html = new ProxyUtil().getHtmlPageFromUrlViaProxy(heroURL);
                document = Jsoup.parse(html, "https://lolchess.gg");
                Elements heroElements = document.select(HERO_HEADER);
                for (Element heroElement : heroElements) {
                    String heroHeader = heroElement.select(".guide-champion-detail__header__background").attr("style");

                    heroHeader = heroHeader.substring(heroHeader.indexOf("(") + 1);
                    heroHeader = heroHeader.substring(0, heroHeader.indexOf(")"));

                    hero.setBackgroundPic("http:" + heroHeader);
                    System.out.println(heroHeader);
                    Elements statsElements = document.select(".guide-champion-detail__stats__row");
                    for (Element statsElement : statsElements) {
                        Elements statElements = statsElement.select(".guide-champion-detail__stats__value");
                        for (Element element : statElements
                        ) {
                            String statValue = element.text();
                            String[] cost = statValue.split(" ");
                            String imgs = String.valueOf(statsElement.select("img").attr("src"));

                            boolean b = false;
                            for (String s : cost
                            ) {
                                if ((cost.length == 1)) {
                                    HeroStats heroStats = new HeroStats();
                                    heroStats.setHeroName(heroName);
                                    heroStats.setImgSource("http:" + imgs);
                                    heroStats.setHeroImg(img);
                                    String statName = statsElement.select(".guide-champion-detail__stats__name").text();
                                    heroStats.setStatName(statName);
                                    heroStats.setStatValue(s);
                                    heroStatsReporsitory.save(heroStats);

                                } else {
                                    if (!b) {
                                        HeroStats heroStats = new HeroStats();
                                        heroStats.setHeroName(heroName);
                                        String statName = statsElement.select(".guide-champion-detail__stats__name").text();
                                        heroStats.setStatName(statName);
                                        heroStats.setImgSource("http:" + imgs);
                                        heroStats.setStatName(statName);
                                        heroStats.setStatValue(s);
                                        b = true;
                                        heroStatsReporsitory.save(heroStats);
                                    } else {
                                        HeroStats heroStats = new HeroStats();
                                        heroStats.setHeroName(heroName);
                                        String statName = statsElement.select(".guide-champion-detail__stats__name").text();
                                        heroStats.setStatName(statName);
                                        heroStats.setImgSource("http:" + imgs);
                                        heroStats.setStatName("SellingCost");
                                        heroStats.setStatValue(s);
                                        heroStatsReporsitory.save(heroStats);
                                    }
                                }
                            }
                            System.out.println(statValue);

                        }

                    }
                    Elements baseStatElements = document.select(".guide-champion-detail__base-stat");
                    for (Element baseStatElement : baseStatElements) {
                        HeroBaseStats heroBaseStats = new HeroBaseStats();
                        String baseStatName = baseStatElement.select(".guide-champion-detail__base-stat__name").text();
                        heroBaseStats.setHeroName(heroName);
                        heroBaseStats.setBaseStatName(baseStatName);
                        String baseStatValue = baseStatElement.select(".guide-champion-detail__base-stat__value").text();

                        if (!baseStatValue.equals("")) {
                            String[] s = baseStatValue.split(" ");
                            String value = s[0];
                            if (s.length > 3)
                                for (int i = 1; i <= 4; i++) {
                                    value = value + s[i];
                                }
                            heroBaseStats.setBaseStatValue(value);
                        } else {
                            baseStatValue = String.valueOf(baseStatElement.select("img").attr("src"));
                            heroBaseStats.setBaseStatValue("http:" + baseStatValue);
                        }


                        System.out.println(baseStatName);
                        System.out.println(baseStatValue);
                        heroBaseStatsRepository.save(heroBaseStats);
                    }
                    Elements skillElements = document.select(".guide-champion-detail__skill");
                    for (Element skillElement : skillElements) {
                        String skillImage = String.valueOf(skillElement.select("img").attr("src"));
                        String sImage = "http:" + skillImage;
                        hero.setSkillImage(sImage);
                        String skillName = String.valueOf(skillElement.select("img").attr("alt"));
                        hero.setSkillName(skillName);
                        Elements manaElements = skillElements.select(".text-gray");
                        String str = null;
                        for (Element manaElement : manaElements) {
                            String mana = String.valueOf(manaElement.select("span").text());
                            str = String.join(",", mana);
                            String[] s = mana.split(" ");
                            String[] manas = s[s.length - 1].split("/");
                            try {
                                hero.setMana(manas[1]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            hero.setStartingMana(manas[0]);
                            System.out.println(manas);
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
                        heroRecomendedItems.setItemPic("http:" + itemPic);
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
