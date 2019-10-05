package com.example.tftguide.Controller;


import com.example.tftguide.Dao.Model.DeckA;
import com.example.tftguide.Model.Deck;
import com.example.tftguide.Model.DeckBasicItems;
import com.example.tftguide.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeckController {

    @Autowired
    DeckRepository deckRepository;
    @Autowired
    DeckBasicItemRepository deckBasicItemRepository;
    @Autowired
    DeckHeroesRepository deckHeroesRepository;
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    HeroRepository heroRepository;
    @Autowired
    ItemsController itemsController;

    @RequestMapping(value = "/getAllDecks", method = RequestMethod.GET)
    public List<DeckA> getAllDecks() {

        List<DeckA> deckAList = new ArrayList<>();
        List<Deck> deckList = deckRepository.findAll();

        for (Deck deck : deckList
        ) {
            DeckA deckA = new DeckA();
            deckA.setName(deck.getName());
            deckA.setCostIcon(deck.getCostIcon());
            deckA.setTotalCost(deck.getTotalCost());
            deckBasicItemRepository.get
            itemsController.getItem(deck)
            deckA.setItemsA();

        }

    }
}
