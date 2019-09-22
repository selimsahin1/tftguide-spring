package com.example.tftguide.Repository;

import com.example.tftguide.Model.Items;
import com.example.tftguide.Model.Synergies;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends PagingAndSortingRepository<Items, Long> {

    Items findByItemName(String s);

    List<Items> findAll();

}
