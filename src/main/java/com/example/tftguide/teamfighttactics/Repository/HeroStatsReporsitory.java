package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.HeroStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroStatsReporsitory extends PagingAndSortingRepository<HeroStats, Long> {

    @Override
    void deleteAll();

    List<HeroStats> findAllByHeroName(String heroName);

    @Query(value = "select * from hero_stats WHERE stat_value= :stat_value",
            nativeQuery = true)
    List<HeroStats> getHeroesByOrigin(@Param("stat_value") String stat_value);
}
