package com.example.tftguide.Model;

import javax.persistence.*;

@Entity
@Table(name = "HeroStats")
public class HeroStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heroName;
    private String statName;
    private String statValue;

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

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public String getStatValue() {
        return statValue;
    }

    public void setStatValue(String statValue) {
        this.statValue = statValue;
    }
}
