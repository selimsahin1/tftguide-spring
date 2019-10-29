package com.example.tftguide.legendsOfRuneterra.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "LoRCard")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    @Column(columnDefinition = "TEXT")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String img;
    @Column(columnDefinition = "TEXT")
    private String region;
    @Column(columnDefinition = "TEXT")
    private String regionImg;
    @Column(columnDefinition = "TEXT")
    private String type;
    @Column(columnDefinition = "TEXT")
    private String typeImg;
    @Column(columnDefinition = "TEXT")
    private String rarity;
    @Column(columnDefinition = "TEXT")
    private String rarityImg;
    @Column(columnDefinition = "TEXT")
    private String cost;
    @Column(columnDefinition = "TEXT")
    private String health;
    @Column(columnDefinition = "TEXT")
    private String power;
    @Column(columnDefinition = "TEXT")
    private String desc1;
    @Column(columnDefinition = "TEXT")
    private String desc2;
    @Column(columnDefinition = "TEXT")
    private String desc3;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionImg() {
        return regionImg;
    }

    public void setRegionImg(String regionImg) {
        this.regionImg = regionImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public String getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(String typeImg) {
        this.typeImg = typeImg;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRarityImg() {
        return rarityImg;
    }

    public void setRarityImg(String rarityImg) {
        this.rarityImg = rarityImg;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }
}
