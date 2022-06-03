package com.kelmorgan.msscbeerservice.services;

import com.kelmorgan.msscbeerservice.api.v1.models.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID id);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
