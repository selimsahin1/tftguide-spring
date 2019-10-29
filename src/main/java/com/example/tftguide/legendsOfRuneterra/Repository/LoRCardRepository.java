package com.example.tftguide.legendsOfRuneterra.Repository;

import com.example.tftguide.legendsOfRuneterra.Model.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LoRCardRepository extends PagingAndSortingRepository<Card, Long> {

    Page<Card> findAll(Pageable pageable);

    @Transactional
    @Query(value = "select * FROM lorcard where name LIKE %?1%", nativeQuery = true)
    List<Card> findByCardName(String name);

}
