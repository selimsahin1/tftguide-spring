package com.example.tftguide.legendsOfRuneterra.Controller;

import com.example.tftguide.legendsOfRuneterra.ApiModels.CardA;
import com.example.tftguide.legendsOfRuneterra.Model.Card;
import com.example.tftguide.legendsOfRuneterra.Model.Deck;
import com.example.tftguide.legendsOfRuneterra.Model.RecomendedDecksWithCard;
import com.example.tftguide.legendsOfRuneterra.Model.SimilarCards;
import com.example.tftguide.legendsOfRuneterra.Repository.LoRCardRepository;
import com.example.tftguide.legendsOfRuneterra.Repository.LoRDeckRepository;
import com.example.tftguide.legendsOfRuneterra.Repository.RecomendedDecksWithCardRepository;
import com.example.tftguide.legendsOfRuneterra.Repository.SimilarCardsRepository;
import com.example.tftguide.legendsOfRuneterra.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoRCardController {

    @Autowired
    LoRCardRepository loRCardRepository;

    @Autowired
    LoRDeckRepository loRDeckRepository;

    @Autowired
    RecomendedDecksWithCardRepository recomendedDecksWithCardRepository;

    @Autowired
    SimilarCardsRepository similarCardsRepository;

    @Autowired
    CardService cardService;

    @RequestMapping(value = "/getAllCards", method = RequestMethod.GET)
    public List<Card> getAllCards(@RequestParam("pageNumber") int pageNumber, @RequestParam("itemSize") int itemSize) {
        Page<Card> resultPage = cardService.getPaginatedCharacters(pageNumber, itemSize);
        return resultPage.getContent();
    }

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    @ResponseBody
    public CardA getCard(@RequestParam(required = false) String name) {
        List<Card> card = loRCardRepository.findByCardName(name);
        List<SimilarCards> similarCards = similarCardsRepository.findByCardName(name);
        List<Card> similarCardList = new ArrayList<>();
        for (SimilarCards similarCards1 : similarCards
        ) {
            System.out.println(similarCards1.getSimilarCardName());
            List<Card> similarCard = loRCardRepository.findByCardName(similarCards1.getSimilarCardName());
            similarCardList.add(similarCard.get(0));
        }
        List<RecomendedDecksWithCard> recomendedDecksWithCards = recomendedDecksWithCardRepository.findByCardName(name);
        List<Deck> deckList = new ArrayList<>();
        for (RecomendedDecksWithCard recomendedDecksWithCard : recomendedDecksWithCards
        ) {
            Deck deck = loRDeckRepository.findByDeckName(recomendedDecksWithCard.getDeckName());
            deckList.add(deck);
        }
        CardA cardA = new CardA();
        cardA.setCard(card.get(0));
        cardA.setSimilarCards(similarCardList);
        cardA.setRecomendedDecks(deckList);
        return cardA;
    }
}
