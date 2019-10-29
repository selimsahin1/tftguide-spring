package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.DeckHeroes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckHeroesRepository extends PagingAndSortingRepository<DeckHeroes, Long> {

    @Override
    void deleteAll();

    List<DeckHeroes> findAllByDeckName(String s);

}
