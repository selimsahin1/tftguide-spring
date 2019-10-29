package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.DeckBasicItems;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckBasicItemRepository extends PagingAndSortingRepository<DeckBasicItems, Long> {

    @Override
    void deleteAll();

    List<DeckBasicItems> findAllByDeckName(String name);

}
