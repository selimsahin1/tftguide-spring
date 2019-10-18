package com.example.tftguide.Model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String image;
    @Column(columnDefinition = "TEXT")
    private String backgroundPic;
    @Column(columnDefinition = "TEXT")
    private String skillName;
    @Column(columnDefinition = "TEXT")
    private String skillImage;
    @Column(columnDefinition = "TEXT")
    private String skillInfo;
    @Column(columnDefinition = "TEXT")
    private String damageValue;
    @Column(columnDefinition = "TEXT")
    private String mana;
    @Column(columnDefinition = "TEXT")
    private String startingMana;

    public Hero() {
    }

    public Hero(String name, String image, String backgroundPic, String skillName, String skillImage, String skillInfo, String damageValue) {
        this.name = name;
        this.image = image;
        this.backgroundPic = backgroundPic;
        this.skillName = skillName;
        this.skillImage = skillImage;
        this.skillInfo = skillInfo;
        this.damageValue = damageValue;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", backgroundPic='" + backgroundPic + '\'' +
                ", skillName='" + skillName + '\'' +
                ", skillImage='" + skillImage + '\'' +
                ", skillInfo='" + skillInfo + '\'' +
                ", damageValue='" + damageValue + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
