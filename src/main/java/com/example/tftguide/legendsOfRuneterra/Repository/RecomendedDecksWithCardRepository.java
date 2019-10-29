package com.example.tftguide.legendsOfRuneterra.Repository;

import com.example.tftguide.legendsOfRuneterra.Model.Deck;
import com.example.tftguide.legendsOfRuneterra.Model.RecomendedDecksWithCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RecomendedDecksWithCardRepository extends PagingAndSortingRepository<RecomendedDecksWithCard, Long> {
    @Transactional
    @Query(value = "select * FROM lorrecomended_decks_with_card where card_name LIKE %?1%", nativeQuery = true)
    List<RecomendedDecksWithCard> findByCardName(String name);
}
