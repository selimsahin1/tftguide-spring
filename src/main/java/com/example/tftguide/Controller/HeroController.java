package com.example.tftguide.Controller;

import com.example.tftguide.Dao.Model.HeroA;
import com.example.tftguide.Model.Hero;
import com.example.tftguide.Model.HeroBaseStats;
import com.example.tftguide.Model.HeroRecomendedItems;
import com.example.tftguide.Model.HeroStats;
import com.example.tftguide.Repository.HeroBaseStatsRepository;
import com.example.tftguide.Repository.HeroRecomendedItemsRepository;
import com.example.tftguide.Repository.HeroRepository;
import com.example.tftguide.Repository.HeroStatsReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    HeroBaseStatsRepository heroBaseStatsRepository;

    @Autowired
    HeroRecomendedItemsRepository heroRecomendedItemsRepository;

    @Autowired
    HeroStatsReporsitory heroStatsReporsitory;

    @RequestMapping(value = "/hero", method = RequestMethod.GET)
    @ResponseBody
    public HeroA getHero(@RequestParam(required = false) String name) {

        List<HeroBaseStats> heroBaseStats = heroBaseStatsRepository.findAllByHeroName(name);
        List<HeroRecomendedItems> heroRecomendedItems = heroRecomendedItemsRepository.findAllByHeroName(name);
        List<HeroStats> heroStats = heroStatsReporsitory.findAllByHeroName(name);

        Hero hero = heroRepository.findByName(name);
        HeroA heroA = new HeroA();
        heroA.setName(hero.getName());
        heroA.setBackgroundPic(hero.getBackgroundPic());
        heroA.setDamageValue(hero.getDamageValue());
        heroA.setImage(hero.getImage());
        heroA.setSkillName(hero.getSkillName());
        heroA.setSkillImage(hero.getSkillImage());
        heroA.setSkillInfo(hero.getSkillInfo());
        heroA.setHeroStats(heroStats);
        heroA.setHeroBaseStats(heroBaseStats);
        heroA.setHeroRecomendedItems(heroRecomendedItems);

        return heroA;
    }

    @RequestMapping(value = "/heroList", method = RequestMethod.GET)
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

}
