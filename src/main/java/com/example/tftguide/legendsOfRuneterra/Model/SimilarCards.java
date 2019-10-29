package com.example.tftguide.legendsOfRuneterra.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LoRSimilarCards")
public class SimilarCards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    @Column(columnDefinition = "TEXT")
    private String cardName;
    @Column(columnDefinition = "TEXT")
    private String similarCardName;

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

    public String getSimilarCardName() {
        return similarCardName;
    }

    public void setSimilarCardName(String similarCardName) {
        this.similarCardName = similarCardName;
    }
}
