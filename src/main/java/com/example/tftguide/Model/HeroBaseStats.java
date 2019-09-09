package com.example.tftguide.Model;

import javax.persistence.*;

@Entity
@Table(name = "HeroBaseStats")
public class HeroBaseStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heroName;
    private String baseStatName;
    private String baseStatValue;

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

    public String getBaseStatName() {
        return baseStatName;
    }

    public void setBaseStatName(String baseStatName) {
        this.baseStatName = baseStatName;
    }

    public String getBaseStatValue() {
        return baseStatValue;
    }

    public void setBaseStatValue(String baseStatValue) {
        this.baseStatValue = baseStatValue;
    }
}
