package com.example.tftguide.teamfighttactics.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "HeroBaseStats")
public class HeroBaseStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String heroName;
    @Column(columnDefinition = "TEXT")
    private String baseStatName;
    @Column(columnDefinition = "TEXT")
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
