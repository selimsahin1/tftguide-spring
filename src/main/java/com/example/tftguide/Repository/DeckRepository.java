package com.example.tftguide.Repository;

import com.example.tftguide.Model.Deck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends PagingAndSortingRepository<Deck, Long> {



}
