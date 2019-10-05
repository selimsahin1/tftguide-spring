package com.example.tftguide.Repository;

import com.example.tftguide.Model.Deck;
import com.example.tftguide.Model.DeckSynergies;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckSynergiesRepository extends PagingAndSortingRepository<DeckSynergies, Long> {
}
