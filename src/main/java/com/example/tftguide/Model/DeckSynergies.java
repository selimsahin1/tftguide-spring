package com.example.tftguide.Model;

import javax.persistence.*;

@Entity
@Table(name = "DeckSynergies")
public class DeckSynergies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deckSynergy;
    private String synergyIcon;
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
