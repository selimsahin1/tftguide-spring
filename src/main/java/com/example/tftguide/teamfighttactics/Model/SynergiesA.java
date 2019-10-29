package com.example.tftguide.teamfighttactics.Model;

import java.util.List;

public class SynergiesA {

    private String synergy;

    private String synergyIcon;

    private String synergyDescription;

    private List<HeroStats> heroStatsList;

    public String getSynergy() {
        return synergy;
    }

    public void setSynergy(String synergy) {
        this.synergy = synergy;
    }

    public String getSynergyIcon() {
        return synergyIcon;
    }

    public void setSynergyIcon(String synergyIcon) {
        this.synergyIcon = synergyIcon;
    }

    public String getSynergyDescription() {
        return synergyDescription;
    }

    public void setSynergyDescription(String synergyDescription) {
        this.synergyDescription = synergyDescription;
    }

    public List<HeroStats> getHeroStatsList() {
        return heroStatsList;
    }

    public void setHeroStatsList(List<HeroStats> heroStatsList) {
        this.heroStatsList = heroStatsList;
    }
}
