package com.example.tftguide.Repository;

import com.example.tftguide.Model.HeroBaseStats;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroBaseStatsRepository extends PagingAndSortingRepository<HeroBaseStats, Long> {

    List<HeroBaseStats> findAllByHeroName(String heroName);

    @Override
    void deleteAll();
}
