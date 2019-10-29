package com.example.tftguide.legendsOfRuneterra.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LoRRecomendedDecksWithCard")
public class RecomendedDecksWithCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    @Column(columnDefinition = "TEXT")
    private String cardName;
    @Column(columnDefinition = "TEXT")
    private String deckName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
