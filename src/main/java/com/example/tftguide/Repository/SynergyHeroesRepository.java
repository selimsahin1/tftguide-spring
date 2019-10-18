package com.example.tftguide.Repository;

import com.example.tftguide.Model.Synergies;
import com.example.tftguide.Model.SynergyHeroes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SynergyHeroesRepository extends PagingAndSortingRepository<SynergyHeroes, Long> {

    @Transactional
    List<SynergyHeroes> findAllByHero(String heroName);

    @Override
    void deleteAll();
}
