package com.example.tftguide.teamfighttactics.Model;

import java.util.List;

public class SynergyHeroesA {

    private String hero;
    private String synergyName;
    private String synergyDescription;
    private String synergyIcon;
    private List<SynergyStats> synergyStats;

    public SynergyHeroesA() {
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

    public String getSynergyIcon() {
        return synergyIcon;
    }

    public void setSynergyIcon(String synergyIcon) {
        this.synergyIcon = synergyIcon;
    }

    public List<SynergyStats> getSynergyStats() {
        return synergyStats;
    }

    public void setSynergyStats(List<SynergyStats> synergyStats) {
        this.synergyStats = synergyStats;
    }
}
