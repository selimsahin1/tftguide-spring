package com.example.tftguide.Repository;

import com.example.tftguide.Model.DeckBasicItems;
import com.example.tftguide.Model.DeckCost;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckCostRepository extends PagingAndSortingRepository<DeckCost, Long> {

    List<DeckCost> findAllByDeckName(String s);

}
