package com.example.tftguide.Model;

import javax.persistence.*;

@Entity
@Table(name = "Hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;
    private String backgroundPic;
    private String skillName;
    private String skillImage;
    private String skillInfo;
    private String damageValue;

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
}
