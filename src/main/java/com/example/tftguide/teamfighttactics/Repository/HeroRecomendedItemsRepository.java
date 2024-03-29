package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.HeroRecomendedItems;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRecomendedItemsRepository extends PagingAndSortingRepository<HeroRecomendedItems, Long> {

    List<HeroRecomendedItems> findAllByHeroName(String heroName);

    List<HeroRecomendedItems> findAllByItemName(String s);

    @Override
    void deleteAll();
}
