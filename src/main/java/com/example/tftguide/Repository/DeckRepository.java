package com.example.tftguide.Repository;

import com.example.tftguide.Model.Deck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckRepository extends PagingAndSortingRepository<Deck, Long> {

    List<Deck> findAll();

}
