package com.kelmorgan.msscbeerservice.api.v1.models;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class BeerDto {

    @Null
    private UUID id;
    @Null
    private Integer version;
    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModifiedDate;
    @NotBlank
    private String beerName;

    @NotNull
    private BeerStyle beerStyle;

    private Integer quantityOnHand;
    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Positive
    private Long upc;

}
