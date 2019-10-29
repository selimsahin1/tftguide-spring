package com.example.tftguide.teamfighttactics.Controller;

import com.example.tftguide.teamfighttactics.Model.*;
import com.example.tftguide.teamfighttactics.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(method = RequestMethod.GET)
@ResponseBody
@RestController
public class SynergyHeroesController {

    @Autowired
    SynergiesRepository synergiesRepository;

    @Autowired
    SynergyStatsRepository synergyStatsRepository;

    @Autowired
    SynergyHeroesRepository synergyHeroesRepository;

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    HeroStatsReporsitory heroStatsReporsitory;

    public SynergyHeroesA getSynergyHeroes(@RequestParam(required = false) String s, String h) {

        List<SynergyStats> synergyStats = synergyStatsRepository.findAllBySynergyName(s);
        List<Synergies> synergies = synergiesRepository.findByHero(h);

        int i = 0;
        String desc = null;
        String icon = null;
        for (Synergies synergies1 : synergies
        ) {
            if (s.equals(synergies1.getSynergyName())) {
                desc = synergies1.getSynergyDescription();
                icon = synergies1.getSynergyIcon();
            }
        }

        SynergyHeroesA synergyHeroesA = new SynergyHeroesA();
        synergyHeroesA.setHero(h);
        synergyHeroesA.setSynergyName(s);
        synergyHeroesA.setSynergyDescription(desc);
        synergyHeroesA.setSynergyIcon(icon);

        synergyHeroesA.setSynergyStats(synergyStats);

        return synergyHeroesA;
    }

    @RequestMapping(value = "/synergyList", method = RequestMethod.GET)
    public List<SynergiesA> getAllHeroes() {
        List<String> synergies = synergiesRepository.findAllActiveUsers();
        List<SynergiesA> synergiesAList = new ArrayList<>();
        for (String synergy : synergies
        ) {
            Synergies synergie = synergiesRepository.findFirstBySynergyName(synergy);

            List<HeroStats> synergyStatsList = heroStatsReporsitory.getHeroesByOrigin(synergie.getSynergyName());

            SynergiesA synergiesA = new SynergiesA();
            synergiesA.setSynergy(synergy);
            synergiesA.setSynergyDescription(synergie.getSynergyDescription());
            synergiesA.setSynergyIcon(synergie.getSynergyIcon());
            synergiesA.setHeroStatsList(synergyStatsList);
            synergiesAList.add(synergiesA);
        }
        return synergiesAList;

    }

    @RequestMapping(value = "/synergy", method = RequestMethod.GET)
    public Synergies getSynergies(@RequestParam(required = false) String name) {

        return synergiesRepository.findFirstBySynergyName(name);

    }


}
