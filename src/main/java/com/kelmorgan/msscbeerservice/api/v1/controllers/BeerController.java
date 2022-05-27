package com.kelmorgan.msscbeerservice.api.v1.controllers;

import com.kelmorgan.msscbeerservice.api.v1.models.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(BeerController.API_V_1_BEER)
public class BeerController {
    public static final String API_V_1_BEER = "api/v1/beer";

    @GetMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.OK)
    public BeerDto getBeerById(@PathVariable UUID beerId) {
        return BeerDto.builder().id(beerId).build();
    }

    @PostMapping
    public ResponseEntity<Void> saveNewBeer(@Validated @RequestBody BeerDto beerDto) {

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location",
                API_V_1_BEER + "/" + BeerDto.builder().id(UUID.randomUUID()).build().getId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {

    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId) {

    }
}
