package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.HeroBaseStats;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroBaseStatsRepository extends PagingAndSortingRepository<HeroBaseStats, Long> {

    List<HeroBaseStats> findAllByHeroName(String heroName);

    @Override
    void deleteAll();
}
