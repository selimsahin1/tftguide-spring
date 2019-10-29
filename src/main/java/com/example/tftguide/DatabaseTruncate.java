package com.example.tftguide;

import com.example.tftguide.teamfighttactics.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTruncate {

    @Autowired
    DeckBasicItemRepository deckBasicItemRepository;
    @Autowired
    DeckCostRepository deckCostRepository;
    @Autowired
    DeckHeroesRepository deckHeroesRepository;
    @Autowired
    DeckRepository deckRepository;
    @Autowired
    DeckSynergiesRepository deckSynergiesRepository;
    @Autowired
    HeroBaseStatsRepository heroBaseStatsRepository;
    @Autowired
    HeroRecomendedItemsRepository heroRecomendedItemsRepository;
    @Autowired
    HeroRepository heroRepository;
    @Autowired
    HeroStatsReporsitory heroStatsReporsitory;
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    SynergiesRepository synergiesRepository;
    @Autowired
    SynergyHeroesRepository synergyHeroesRepository;
    @Autowired
    SynergyStatsRepository synergyStatsRepository;

    public void truncator(){
        deckBasicItemRepository.deleteAll();
        deckCostRepository.deleteAll();
        deckHeroesRepository.deleteAll();
        deckRepository.deleteAll();
        deckSynergiesRepository.deleteAll();
        heroBaseStatsRepository.deleteAll();
        heroRecomendedItemsRepository.deleteAll();
        heroRepository.deleteAll();
        heroStatsReporsitory.deleteAll();
        itemsRepository.deleteAll();
        synergiesRepository.deleteAll();
        synergyHeroesRepository.deleteAll();
        synergyStatsRepository.deleteAll();
        System.out.println("-----------database temizlendi.-----------");
    }
}
