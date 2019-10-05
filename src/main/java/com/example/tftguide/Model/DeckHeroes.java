package com.example.tftguide.Model;

import javax.persistence.*;

@Entity
@Table(name = "DeckHeroes")
public class DeckHeroes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heroName;
    private String heroIcon;
    private String deckName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroIcon() {
        return heroIcon;
    }

    public void setHeroIcon(String heroIcon) {
        this.heroIcon = heroIcon;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
