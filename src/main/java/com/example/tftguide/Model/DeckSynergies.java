package com.example.tftguide.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "DeckSynergies")
public class DeckSynergies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String deckSynergy;
    @Column(columnDefinition = "TEXT")
    private String synergyIcon;
    @Column(columnDefinition = "TEXT")
    private String deckName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeckSynergy() {
        return deckSynergy;
    }

    public void setDeckSynergy(String deckSynergy) {
        this.deckSynergy = deckSynergy;
    }

    public String getSynergyIcon() {
        return synergyIcon;
    }

    public void setSynergyIcon(String synergyIcon) {
        this.synergyIcon = synergyIcon;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
