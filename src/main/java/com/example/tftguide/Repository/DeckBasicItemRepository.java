package com.example.tftguide.Repository;

import com.example.tftguide.Model.DeckBasicItems;
import com.example.tftguide.Model.DeckHeroes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckBasicItemRepository extends PagingAndSortingRepository<DeckBasicItems, Long> {

    @Override
    void deleteAll();

    List<DeckBasicItems> findAllByDeckName(String name);

}
