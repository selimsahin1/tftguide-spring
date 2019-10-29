package com.example.tftguide.legendsOfRuneterra.Service;

import com.example.tftguide.Exception.ResourceNotFoundException;
import com.example.tftguide.legendsOfRuneterra.Model.Card;
import com.example.tftguide.legendsOfRuneterra.Repository.LoRCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    LoRCardRepository loRCardRepository;

    public Page<Card> getPaginatedCharacters(int pageNumber, int itemSize) {
        PageRequest pageable = PageRequest.of(pageNumber - 1, itemSize - 1);
        Page<Card> resultPage = loRCardRepository.findAll(pageable);
        if (pageNumber > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException("Not Found Page Number:" + pageNumber);
        }
        return resultPage;
    }

}
