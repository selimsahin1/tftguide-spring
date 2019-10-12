package com.example.tftguide.Model;

import javax.persistence.*;

@Entity
@Table(name = "DeckCost")
public class DeckCost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String costName;
    private String costIcon;
    private String costCount;
    private String deckName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostIcon() {
        return costIcon;
    }

    public void setCostIcon(String costIcon) {
        this.costIcon = costIcon;
    }

    public String getCostCount() {
        return costCount;
    }

    public void setCostCount(String costCount) {
        this.costCount = costCount;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
