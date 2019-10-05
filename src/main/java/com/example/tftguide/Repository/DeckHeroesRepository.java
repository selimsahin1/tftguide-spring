package com.example.tftguide.Repository;

import com.example.tftguide.Model.DeckHeroes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckHeroesRepository extends PagingAndSortingRepository<DeckHeroes, Long> {
}
