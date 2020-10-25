package chand.springframework.msscbeerservice.web.mappers;

import chand.springframework.msscbeerservice.domain.Beer;
import chand.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto bearToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
