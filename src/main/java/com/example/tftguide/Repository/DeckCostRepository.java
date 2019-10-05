package com.example.tftguide.Repository;

import com.example.tftguide.Model.DeckBasicItems;
import com.example.tftguide.Model.DeckCost;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckCostRepository extends PagingAndSortingRepository<DeckCost, Long> {
}
