package com.kelmorgan.msscbeerservice.services.impl;

import com.kelmorgan.msscbeerservice.api.v1.mappers.BeerMapper;
import com.kelmorgan.msscbeerservice.api.v1.models.BeerDto;
import com.kelmorgan.msscbeerservice.domain.Beer;
import com.kelmorgan.msscbeerservice.exceptions.NotFoundException;
import com.kelmorgan.msscbeerservice.repositories.BeerRepository;
import com.kelmorgan.msscbeerservice.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository repository;

    private final BeerMapper mapper;

    @Override
    public BeerDto getBeerById(UUID id) {
        return mapper.beerToBeerDto(
                repository.findById(id).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return mapper.beerToBeerDto(repository.save(mapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        BeerDto beerDto1 = getBeerById(beerId);

        beerDto1.setBeerName(beerDto.getBeerName());
        beerDto1.setBeerStyle(beerDto.getBeerStyle());
        beerDto1.setPrice(beerDto.getPrice());


        return mapper.beerToBeerDto(repository.save(mapper.beerDtoToBeer(beerDto1)));

    }

    @Override
    public void deleteBeer(UUID beerId) {

    }
}
