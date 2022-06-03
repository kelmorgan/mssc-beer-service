package com.kelmorgan.msscbeerservice.api.v1.controllers;

import com.kelmorgan.msscbeerservice.api.v1.models.BeerDto;
import com.kelmorgan.msscbeerservice.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(BeerController.API_V_1_BEER)
public class BeerController {
    private final BeerService beerService;
    public static final String API_V_1_BEER = "api/v1/beer";

    @GetMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.OK)
    public BeerDto getBeerById(@PathVariable UUID beerId) {
        return beerService.getBeerById(beerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDto saveNewBeer(@Validated @RequestBody BeerDto beerDto) {
        return beerService.saveNewBeer(beerDto);
    }

    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BeerDto updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
        return beerService.updateBeer(beerId,beerDto);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId) {
         beerService.deleteBeer(beerId);
    }
}
