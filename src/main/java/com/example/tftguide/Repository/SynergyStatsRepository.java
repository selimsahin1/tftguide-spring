package com.example.tftguide.Repository;

import com.example.tftguide.Model.HeroStats;
import com.example.tftguide.Model.Synergies;
import com.example.tftguide.Model.SynergyStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
public interface SynergyStatsRepository extends PagingAndSortingRepository<SynergyStats, Long> {

    @Transactional
    List<SynergyStats> findAllBySynergyName(String s);



}
