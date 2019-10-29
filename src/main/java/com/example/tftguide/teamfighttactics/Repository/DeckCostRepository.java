package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.DeckCost;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckCostRepository extends PagingAndSortingRepository<DeckCost, Long> {

    @Override
    void deleteAll();

    List<DeckCost> findAllByDeckName(String s);

}
