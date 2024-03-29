package com.example.tftguide.teamfighttactics.Controller;

import com.example.tftguide.teamfighttactics.Model.*;
import com.example.tftguide.teamfighttactics.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    SynergiesRepository synergiesRepository;

    @Autowired
    SynergyStatsRepository synergyStatsRepository;

    @Autowired
    SynergyHeroesRepository synergyHeroesRepository;

    @Autowired
    SynergyHeroesController synergyHeroesController;

    @RequestMapping(value = "/hero", method = RequestMethod.GET)
    @ResponseBody
    public HeroA getHero(@RequestParam(required = false) String name) {

        List<HeroBaseStats> heroBaseStats = heroBaseStatsRepository.findAllByHeroName(name);
        List<HeroRecomendedItems> heroRecomendedItems = heroRecomendedItemsRepository.findAllByHeroName(name);
        List<HeroStats> heroStats = heroStatsReporsitory.findAllByHeroName(name);
        List<Synergies> synergies = synergiesRepository.findAllByHero(name);
        List<SynergyHeroes> synergyHeroes = synergyHeroesRepository.findAllByHero(name);

        List<SynergyHeroesA> synergyHeroesA = new ArrayList<>();
        for (SynergyHeroes synergyHeroes1 : synergyHeroes
        ) {
            synergyHeroesA.add(synergyHeroesController.getSynergyHeroes(synergyHeroes1.getSynergy(), synergyHeroes1.getHero()));
        }


        Hero hero = heroRepository.findByName(name);
        HeroA heroA = new HeroA();
        heroA.setName(hero.getName());
        heroA.setBackgroundPic(hero.getBackgroundPic());
        heroA.setDamageValue(hero.getDamageValue());
        heroA.setImage(hero.getImage());
        heroA.setSkillName(hero.getSkillName());
        heroA.setSkillImage(hero.getSkillImage());
        heroA.setSkillInfo(hero.getSkillInfo());
        heroA.setMana(hero.getMana());
        heroA.setStartingMana(hero.getStartingMana());
        heroA.setHeroStats(heroStats);
        heroA.setHeroBaseStats(heroBaseStats);
        heroA.setHeroRecomendedItems(heroRecomendedItems);
        heroA.setSynergyHeroesAS(synergyHeroesA);

        return heroA;
    }

    @RequestMapping(value = "/heroList", method = RequestMethod.GET)
    public List<HeroA> getAllHeroes() {

        List<HeroA> heroAList = new ArrayList<>();

        List<Hero> heroList = heroRepository.findAll();

        for (Hero hero : heroList
        ) {
            HeroA heroA = new HeroA();
            heroA.setName(hero.getName());
            heroA.setImage(hero.getImage());

            List<HeroStats> heroStats = heroStatsReporsitory.findAllByHeroName(hero.getName());
            List<SynergyHeroes> synergyHeroes = synergyHeroesRepository.findAllByHero(hero.getName());

            List<SynergyHeroesA> synergyHeroesA = new ArrayList<>();
            for (SynergyHeroes synergyHeroes1 : synergyHeroes
            ) {
                synergyHeroesA.add(synergyHeroesController.getSynergyHeroes(synergyHeroes1.getSynergy(), synergyHeroes1.getHero()));
            }
            heroA.setHeroStats(heroStats);
            heroAList.add(heroA);
        }


        return heroAList;
    }

}
