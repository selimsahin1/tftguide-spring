package com.example.tftguide.legendsOfRuneterra.Repository;

import com.example.tftguide.legendsOfRuneterra.Model.Card;
import com.example.tftguide.legendsOfRuneterra.Model.SimilarCards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SimilarCardsRepository extends PagingAndSortingRepository<SimilarCards, Long> {

    @Transactional
    @Query(value = "select * FROM lorsimilar_cards where card_name LIKE %?1%", nativeQuery = true)
    List<SimilarCards> findByCardName(String name);

}
