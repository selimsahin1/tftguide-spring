package com.example.tftguide.Controller;

import com.example.tftguide.Dao.Model.ItemsA;
import com.example.tftguide.Model.Items;
import com.example.tftguide.Repository.HeroRecomendedItemsRepository;
import com.example.tftguide.Repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    HeroRecomendedItemsRepository heroRecomendedItemsRepository;

    @RequestMapping(value = "/getAllItems", method = RequestMethod.GET)
    public List<ItemsA> getAllItems() {

        List<ItemsA> itemsAList = new ArrayList<>();
        List<Items> items = itemsRepository.findAll();

        for (Items item : items
        ) {
            ItemsA itemsA = new ItemsA();
            itemsA.setItemName(item.getItemName());
            itemsA.setItemCombImg1(item.getItemCombImg1());
            itemsA.setItemCombImg2(item.getItemCombImg2());
            itemsA.setItemCombination1(item.getItemCombination1());
            itemsA.setItemCombination2(item.getItemCombination2());
            itemsA.setItemDescription(item.getItemDescription());
            itemsA.setItemDescription2(item.getItemDescription2());
            itemsA.setItemImage(item.getItemImage());
            String itemName = item.getItemName();
            itemsA.setHeroRecomendedItems(heroRecomendedItemsRepository.findAllByItemName(itemName));
            itemsAList.add(itemsA);
        }
        return itemsAList;
    }
}
