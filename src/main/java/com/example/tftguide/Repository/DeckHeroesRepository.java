package com.example.tftguide.Repository;

import com.example.tftguide.Model.DeckHeroes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckHeroesRepository extends PagingAndSortingRepository<DeckHeroes, Long> {

    List<DeckHeroes> findAllByDeckName(String s);

}
