package com.example.tftguide.Repository;

import com.example.tftguide.Model.Synergies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SynergiesRepository extends PagingAndSortingRepository<Synergies, Long> {


    @Transactional
    List<Synergies> findAllByHero(String heroName);

    List<Synergies> findByHero(String s);

    Synergies findFirstBySynergyName(String s);

    List<Synergies> findAllBySynergyName(String s);

    @Transactional
    @Query(value = "select DISTINCT synergy_name from synergies", nativeQuery = true)
    List<String> findAllActiveUsers();

    @Transactional
    @Query(value = "select DISTINCT *  from synergies where hero= ?1", nativeQuery = true)
    List<Synergies> findAllSynergies(String s);

    @Transactional
    List<Synergies> findAll();

    @Override
    void deleteAll();

}
