package com.example.tftguide.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Synergies")
public class Synergies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String hero;
    @Column(columnDefinition = "TEXT")
    private String synergyName;
    @Column(columnDefinition = "TEXT")
    private String synergyDescription;
    @Column(columnDefinition = "TEXT")
    @JsonIgnore
    private String synergyStats;
    @Column(columnDefinition = "TEXT")
    private String synergyIcon;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getSynergyName() {
        return synergyName;
    }

    public void setSynergyName(String synergyName) {
        this.synergyName = synergyName;
    }

    public String getSynergyDescription() {
        return synergyDescription;
    }

    public void setSynergyDescription(String synergyDescription) {
        this.synergyDescription = synergyDescription;
    }

    public String getSynergyStats() {
        return synergyStats;
    }

    public void setSynergyStats(String synergyStats) {
        this.synergyStats = synergyStats;
    }

    public String getSynergyIcon() {
        return synergyIcon;
    }

    public void setSynergyIcon(String synergyIcon) {
        this.synergyIcon = synergyIcon;
    }
}
