package com.kelmorgan.msscbeerservice.api.v1.mappers;

import com.kelmorgan.msscbeerservice.api.v1.models.BeerDto;
import com.kelmorgan.msscbeerservice.domain.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
