package com.example.tftguide.Model;

import javax.persistence.*;

@Entity
@Table(name = "Items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private String itemImage;
    private String itemDescription;
    private String itemDescription2;
    private String itemCombination1;
    private String itemCombination2;
    private String itemCombImg1;
    private String itemCombImg2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription2() {
        return itemDescription2;
    }

    public void setItemDescription2(String itemDescription2) {
        this.itemDescription2 = itemDescription2;
    }

    public String getItemCombination1() {
        return itemCombination1;
    }

    public void setItemCombination1(String itemCombination1) {
        this.itemCombination1 = itemCombination1;
    }

    public String getItemCombination2() {
        return itemCombination2;
    }

    public void setItemCombination2(String itemCombination2) {
        this.itemCombination2 = itemCombination2;
    }

    public String getItemCombImg1() {
        return itemCombImg1;
    }

    public void setItemCombImg1(String itemCombImg1) {
        this.itemCombImg1 = itemCombImg1;
    }

    public String getItemCombImg2() {
        return itemCombImg2;
    }

    public void setItemCombImg2(String itemCombImg2) {
        this.itemCombImg2 = itemCombImg2;
    }
}
