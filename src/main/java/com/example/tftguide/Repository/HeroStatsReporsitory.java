package com.example.tftguide.Repository;

import com.example.tftguide.Model.Hero;
import com.example.tftguide.Model.HeroStats;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroStatsReporsitory extends PagingAndSortingRepository<HeroStats, Long> {

    List<HeroStats> findAllByHeroName(String heroName);

}
