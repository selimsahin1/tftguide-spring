package com.example.tftguide.teamfighttactics.Controller;


import com.example.tftguide.teamfighttactics.Model.*;
import com.example.tftguide.teamfighttactics.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
public class DeckController {

    @Autowired
    DeckRepository deckRepository;
    @Autowired
    DeckBasicItemRepository deckBasicItemRepository;
    @Autowired
    DeckHeroesRepository deckHeroesRepository;
    @Autowired
    DeckSynergiesRepository deckSynergiesRepository;
    @Autowired
    DeckCostRepository deckCostRepository;
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    HeroRepository heroRepository;
    @Autowired
    ItemsController itemsController;
    @Autowired
    SynergyHeroesController synergyHeroesController;

    @RequestMapping(value = "/getAllDecks", method = RequestMethod.GET)
    public List<TiersA> getAllDecks() {

        List<String> tiersList = deckRepository.getAllTierName();
        List<String> tiers = new ArrayList<>();
        for (String s : tiersList
        ) {
            s = s.substring(0, s.indexOf(" #"));
            if (!tiers.contains(s))
                tiers.add(s);
        }

        System.out.println(tiersList);
        System.out.println(tiers);
        List<TiersA> tiersAList = new ArrayList<>();
        for (String tier : tiers
        ) {
            List<DeckA> deckAList = new ArrayList<>();
            List<Deck> deckList = deckRepository.findByTiers(tier);
            for (Deck deck : deckList
            ) {
                DeckA deckA = new DeckA();
                deckA.setName(deck.getName());
                deckA.setCostIcon(deck.getCostIcon());
                deckA.setTotalCost(deck.getTotalCost());
                List<DeckSynergies> deckSynergiesList = deckSynergiesRepository.findAllByDeckName(deck.getName());
                List<Synergies> synergiesList = new ArrayList<>();
                for (DeckSynergies deckSynergies : deckSynergiesList
                ) {
                    Synergies synergies = synergyHeroesController.getSynergies(deckSynergies.getDeckSynergy());
                    synergiesList.add(synergies);
                }
                List<DeckBasicItems> deckBasicItemsList = deckBasicItemRepository.findAllByDeckName(deck.getName());
                List<ItemsA> itemsAList = new ArrayList<>();
                for (DeckBasicItems deckBasicItems : deckBasicItemsList
                ) {
                    ItemsA itemsA = itemsController.getItem(deckBasicItems.getBasicItemName());
                    itemsAList.add(itemsA);
                }
                deckA.setItemsA(itemsAList);
                deckA.setSynergies(synergiesList);
                deckA.setDeckCost(deckCostRepository.findAllByDeckName(deck.getName()));

                List<DeckHeroes> heroesList = deckHeroesRepository.findAllByDeckName(deck.getName());
                List<Hero> heroList = new ArrayList<>();
                for (DeckHeroes deckHeroes : heroesList
                ) {
                    Hero hero = heroRepository.findByName(deckHeroes.getHeroName());
                    heroList.add(hero);
                }
                deckA.setHeroList(heroList);
                deckAList.add(deckA);

            }
            TiersA tiersA = new TiersA();
            tiersA.setTier(tier);
            tiersA.setDeckAS(deckAList);
            tiersAList.add(tiersA);
        }
        return tiersAList;
    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();

        // Add the elements to set
        set.addAll(list);

        // Clear the list
        list.clear();

        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);

        // return the list
        return list;
    }
}
