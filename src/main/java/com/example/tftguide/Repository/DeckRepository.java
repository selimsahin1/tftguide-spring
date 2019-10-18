package com.example.tftguide.Repository;

import com.example.tftguide.Model.Deck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DeckRepository extends PagingAndSortingRepository<Deck, Long> {

    String FIND_ALL_TIERS = "select DISTINCT (name) FROM deck;";
    String FIND_BY_TIERS = "select * FROM deck where name LIKE ;";

    List<Deck> findAll();

    @Transactional
    @Query(value = "select * FROM deck where name LIKE %?1%", nativeQuery = true)
    List<Deck> findByTiers(String name);

    @Query(value = FIND_ALL_TIERS, nativeQuery = true)
    List<String> getAllTierName();

    @Override
    void deleteAll();
}
