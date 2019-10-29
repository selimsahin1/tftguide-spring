package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.SynergyStats;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SynergyStatsRepository extends PagingAndSortingRepository<SynergyStats, Long> {

    @Transactional
    List<SynergyStats> findAllBySynergyName(String s);

    @Override
    void deleteAll();
}
