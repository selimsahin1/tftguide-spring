package com.example.tftguide.legendsOfRuneterra.Repository;

import com.example.tftguide.legendsOfRuneterra.Model.Deck;
import com.example.tftguide.legendsOfRuneterra.Model.SimilarCards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LoRDeckRepository extends PagingAndSortingRepository<Deck, Long> {

    @Transactional
    @Query(value = "select * FROM lordeck where deck_name LIKE %?1%", nativeQuery = true)
    List<Deck> findByDeckName(String name);

}
