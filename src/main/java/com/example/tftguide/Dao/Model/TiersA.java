package com.example.tftguide.Dao.Model;

import java.util.List;

public class TiersA {

    private String tier;
    private List<DeckA> deckAS;

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public List<DeckA> getDeckAS() {
        return deckAS;
    }

    public void setDeckAS(List<DeckA> deckAS) {
        this.deckAS = deckAS;
    }
}
