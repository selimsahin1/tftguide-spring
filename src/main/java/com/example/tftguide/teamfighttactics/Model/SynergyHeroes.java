package com.example.tftguide.teamfighttactics.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "SynergyHeroes")
public class SynergyHeroes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String synergy;
    @Column(columnDefinition = "TEXT")
    private String hero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSynergy() {
        return synergy;
    }

    public void setSynergy(String synergy) {
        this.synergy = synergy;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
