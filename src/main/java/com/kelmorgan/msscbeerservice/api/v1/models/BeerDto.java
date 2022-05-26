package com.kelmorgan.msscbeerservice.api.v1.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class BeerDto {

    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private String beerName;
    private BeerStyle beerStyle;
    private Integer quantityOnHand;
    private BigDecimal price;
    private Long upc;

}
