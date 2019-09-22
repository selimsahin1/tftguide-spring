package com.example.tftguide.Crawler;

import com.example.tftguide.Model.Synergies;
import com.example.tftguide.Model.SynergyHeroes;
import com.example.tftguide.Model.SynergyStats;
import com.example.tftguide.Proxy.ProxyUtil;
import com.example.tftguide.Repository.SynergiesRepository;
import com.example.tftguide.Repository.SynergyHeroesRepository;
import com.example.tftguide.Repository.SynergyStatsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class SynergiesCrawler {

    @Autowired
    SynergiesRepository synergiesRepository;

    @Autowired
    SynergyHeroesRepository synergyHeroesRepository;

    @Autowired
    SynergyStatsRepository synergyStatsRepository;

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


                String description = e1.select(".guide-synergy__description").text();

                Elements statsElements = e1.select(".guide-synergy__stats .d-inline-block");
                for (Element statsElement : statsElements
                ) {
                    SynergyStats synergyStats = new SynergyStats();
                    String statElement = statsElement.select(".d-inline-block").text();
                    synergyStats.setSynergyName(synergyName);
                    synergyStats.setStat(statElement);
                    System.out.println(statElement);
                    synergyStatsRepository.save(synergyStats);
                }

                System.out.println(description);

                System.out.println(heroesElements);

                System.out.println(synergyName);
                System.out.println(synergyIcon);
                System.out.println("-----------------------------------------------------------------");

                for (Element heroesElement : heroesElements
                ) {
                    Synergies synergies = new Synergies();

                    SynergyHeroes synergyHeroes = new SynergyHeroes();
                    synergies.setSynergyName(synergyName);
                    synergies.setSynergyIcon("http:" + synergyIcon);
                    synergies.setSynergyDescription(description);
                    synergies.setSynergyDescription(description);
                    String heroName = heroesElement.select(".name").text();
                    synergyHeroes.setHero(heroName);
                    synergyHeroes.setSynergy(synergyName);
                    String heroPic = heroesElement.select("img").attr("src");
                    System.out.println(heroName);
                    synergyHeroesRepository.save(synergyHeroes);
                    synergies.setHero(heroName);
                    synergiesRepository.save(synergies);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
