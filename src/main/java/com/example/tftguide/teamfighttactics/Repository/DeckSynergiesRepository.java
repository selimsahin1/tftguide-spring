package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.DeckSynergies;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckSynergiesRepository extends PagingAndSortingRepository<DeckSynergies, Long> {

    List<DeckSynergies> findAllByDeckName(String s);

    @Override
    void deleteAll();
}
