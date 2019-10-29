package com.example.tftguide.legendsOfRuneterra.ApiModels;

import com.example.tftguide.legendsOfRuneterra.Model.Card;
import com.example.tftguide.legendsOfRuneterra.Model.Deck;

import java.util.List;

public class CardA {

    private Card card;
    private List<Card> similarCards;
    private List<Deck> recomendedDecks;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Card> getSimilarCards() {
        return similarCards;
    }

    public void setSimilarCards(List<Card> similarCards) {
        this.similarCards = similarCards;
    }

    public List<Deck> getRecomendedDecks() {
        return recomendedDecks;
    }

    public void setRecomendedDecks(List<Deck> recomendedDecks) {
        this.recomendedDecks = recomendedDecks;
    }
}
