package com.example.tftguide.Repository;

import com.example.tftguide.Model.Hero;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HeroRepository extends PagingAndSortingRepository<Hero, Long> {

    @Override
    void deleteAll();

    @Transactional
    Hero findByName(String name);

    @Transactional
    List<Hero> findAll();

}
