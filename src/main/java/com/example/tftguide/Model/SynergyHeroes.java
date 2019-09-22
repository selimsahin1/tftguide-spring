package com.example.tftguide.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "SynergyHeroes")
public class SynergyHeroes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String synergy;
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
