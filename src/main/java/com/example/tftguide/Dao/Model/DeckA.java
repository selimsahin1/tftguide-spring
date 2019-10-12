package com.example.tftguide.Dao.Model;

import com.example.tftguide.Model.DeckBasicItems;
import com.example.tftguide.Model.DeckCost;
import com.example.tftguide.Model.Hero;
import com.example.tftguide.Model.Synergies;

import java.util.List;

public class DeckA {

    private String name;
    private String costIcon;
    private String totalCost;
    private List<ItemsA> itemsA;
    private List<DeckCost> deckCost;
    private List<Synergies> synergies;
    private List<Hero> heroList;


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

    public List<ItemsA> getItemsA() {
        return itemsA;
    }

    public void setItemsA(List<ItemsA> itemsA) {
        this.itemsA = itemsA;
    }

    public List<DeckCost> getDeckCost() {
        return deckCost;
    }

    public void setDeckCost(List<DeckCost> deckCost) {
        this.deckCost = deckCost;
    }

    public List<Synergies> getSynergies() {
        return synergies;
    }

    public void setSynergies(List<Synergies> synergies) {
        this.synergies = synergies;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }
}
