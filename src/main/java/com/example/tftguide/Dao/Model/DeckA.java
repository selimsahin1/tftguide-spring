package com.example.tftguide.Dao.Model;

import com.example.tftguide.Model.DeckBasicItems;
import com.example.tftguide.Model.DeckCost;

public class DeckA {

    private String name;
    private String costIcon;
    private String totalCost;
    private ItemsA itemsA;
    private DeckCost deckCost;
    private SynergiesA synergiesA;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCostIcon() {
        return costIcon;
    }

    public void setCostIcon(String costIcon) {
        this.costIcon = costIcon;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public ItemsA getItemsA() {
        return itemsA;
    }

    public void setItemsA(ItemsA itemsA) {
        this.itemsA = itemsA;
    }

    public DeckCost getDeckCost() {
        return deckCost;
    }

    public void setDeckCost(DeckCost deckCost) {
        this.deckCost = deckCost;
    }

    public SynergiesA getSynergiesA() {
        return synergiesA;
    }

    public void setSynergiesA(SynergiesA synergiesA) {
        this.synergiesA = synergiesA;
    }
}
