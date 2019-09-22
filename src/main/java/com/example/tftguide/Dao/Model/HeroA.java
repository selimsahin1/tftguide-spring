package com.example.tftguide.Dao.Model;

import com.example.tftguide.Model.*;

import java.util.List;

public class HeroA {

    private String name;
    private String image;
    private String backgroundPic;
    private String skillName;
    private String skillImage;
    private String skillInfo;
    private String damageValue;
    private String mana;
    private String startingMana;
    private List<HeroBaseStats> heroBaseStats;
    private List<HeroRecomendedItems> heroRecomendedItems;
    private List<HeroStats> heroStats;
    private List<SynergyHeroesA> synergyHeroesAS;

    public HeroA() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBackgroundPic() {
        return backgroundPic;
    }

    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillImage() {
        return skillImage;
    }

    public void setSkillImage(String skillImage) {
        this.skillImage = skillImage;
    }

    public String getSkillInfo() {
        return skillInfo;
    }

    public void setSkillInfo(String skillInfo) {
        this.skillInfo = skillInfo;
    }

    public String getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(String damageValue) {
        this.damageValue = damageValue;
    }

    public List<HeroBaseStats> getHeroBaseStats() {
        return heroBaseStats;
    }

    public void setHeroBaseStats(List<HeroBaseStats> heroBaseStats) {
        this.heroBaseStats = heroBaseStats;
    }

    public List<HeroRecomendedItems> getHeroRecomendedItems() {
        return heroRecomendedItems;
    }

    public void setHeroRecomendedItems(List<HeroRecomendedItems> heroRecomendedItems) {
        this.heroRecomendedItems = heroRecomendedItems;
    }

    public List<HeroStats> getHeroStats() {
        return heroStats;
    }

    public void setHeroStats(List<HeroStats> heroStats) {
        this.heroStats = heroStats;
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public String getStartingMana() {
        return startingMana;
    }

    public void setStartingMana(String startingMana) {
        this.startingMana = startingMana;
    }

    public List<SynergyHeroesA> getSynergyHeroesAS() {
        return synergyHeroesAS;
    }

    public void setSynergyHeroesAS(List<SynergyHeroesA> synergyHeroesAS) {
        this.synergyHeroesAS = synergyHeroesAS;
    }
}
