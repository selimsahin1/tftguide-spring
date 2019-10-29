package com.example.tftguide.teamfighttactics.Repository;

import com.example.tftguide.teamfighttactics.Model.Items;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends PagingAndSortingRepository<Items, Long> {

    @Override
    void deleteAll();

    Items findByItemName(String s);

    List<Items> findAll();

}
