package com.example.tftguide.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "DeckBasicItems")
public class DeckBasicItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String basicItemName;
    @Column(columnDefinition = "TEXT")
    private String basicItemIcon;
    @Column(columnDefinition = "TEXT")
    private String deckName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBasicItemName() {
        return basicItemName;
    }

    public void setBasicItemName(String basicItemName) {
        this.basicItemName = basicItemName;
    }

    public String getBasicItemIcon() {
        return basicItemIcon;
    }

    public void setBasicItemIcon(String basicItemIcon) {
        this.basicItemIcon = basicItemIcon;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
