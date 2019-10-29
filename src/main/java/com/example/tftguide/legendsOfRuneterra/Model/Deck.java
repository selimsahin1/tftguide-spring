package com.example.tftguide.legendsOfRuneterra.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "LoRDeck")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    @Column(columnDefinition = "TEXT")
    private String deckName;
    @Column(columnDefinition = "TEXT")
    private String deckDesc;
    @Column(columnDefinition = "TEXT")
    private String championIcon;
    @Column(columnDefinition = "TEXT")
    private String championPiece;
    @Column(columnDefinition = "TEXT")
    private String unitsIcon;
    @Column(columnDefinition = "TEXT")
    private String unitsPiece;
    @Column(columnDefinition = "TEXT")
    private String spellsIcon;
    @Column(columnDefinition = "TEXT")
    private String spellsPiece;
    @Column(columnDefinition = "TEXT")
    private String deckShardCostIcon;
    @Column(columnDefinition = "TEXT")
    private String deckShardCostPiece;
    @Column(columnDefinition = "TEXT")
    private String region1Icon;
    @Column(columnDefinition = "TEXT")
    private String region1Name;
    @Column(columnDefinition = "TEXT")
    private String region2Icon;
    @Column(columnDefinition = "TEXT")
    private String region2Name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getDeckDesc() {
        return deckDesc;
    }

    public void setDeckDesc(String deckDesc) {
        this.deckDesc = deckDesc;
    }

    public String getChampionIcon() {
        return championIcon;
    }

    public void setChampionIcon(String championIcon) {
        this.championIcon = championIcon;
    }

    public String getChampionPiece() {
        return championPiece;
    }

    public void setChampionPiece(String championPiece) {
        this.championPiece = championPiece;
    }

    public String getUnitsIcon() {
        return unitsIcon;
    }

    public void setUnitsIcon(String unitsIcon) {
        this.unitsIcon = unitsIcon;
    }

    public String getUnitsPiece() {
        return unitsPiece;
    }

    public void setUnitsPiece(String unitsPiece) {
        this.unitsPiece = unitsPiece;
    }

    public String getSpellsIcon() {
        return spellsIcon;
    }

    public void setSpellsIcon(String spellsIcon) {
        this.spellsIcon = spellsIcon;
    }

    public String getSpellsPiece() {
        return spellsPiece;
    }

    public void setSpellsPiece(String spellsPiece) {
        this.spellsPiece = spellsPiece;
    }

    public String getDeckShardCostIcon() {
        return deckShardCostIcon;
    }

    public void setDeckShardCostIcon(String deckShardCostIcon) {
        this.deckShardCostIcon = deckShardCostIcon;
    }

    public String getDeckShardCostPiece() {
        return deckShardCostPiece;
    }

    public void setDeckShardCostPiece(String deckShardCostPiece) {
        this.deckShardCostPiece = deckShardCostPiece;
    }

    public String getRegion1Icon() {
        return region1Icon;
    }

    public void setRegion1Icon(String region1Icon) {
        this.region1Icon = region1Icon;
    }

    public String getRegion1Name() {
        return region1Name;
    }

    public void setRegion1Name(String region1Name) {
        this.region1Name = region1Name;
    }

    public String getRegion2Icon() {
        return region2Icon;
    }

    public void setRegion2Icon(String region2Icon) {
        this.region2Icon = region2Icon;
    }

    public String getRegion2Name() {
        return region2Name;
    }

    public void setRegion2Name(String region2Name) {
        this.region2Name = region2Name;
    }
}
